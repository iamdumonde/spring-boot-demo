package bj.highfive.springbootdemo;

// import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // signife que cette classe est un controller
@CrossOrigin(origins = "http://localhost:4200/albums")
@RequestMapping(path = "/api") // signifie que l'URL commence par /api (après l'URL de l'application)
public class AlbumController {

    @Autowired // Ceci demande à Java d'injecter le "bean" AlbumRepository
    AlbumRepository albumRepository;

	// Create ou save
	@PostMapping(path = "/album")
	public @ResponseBody Album createAlbum(@RequestBody Album album){
		return this.albumRepository.save(album);
	}
	
	@PostMapping(path = "/albums")
	public @ResponseBody Iterable<Album> creatAlbums(@RequestBody List<Album> albums){
		return this.albumRepository.saveAll(albums);
	}

	// Que des "reads", récupérer des données depuis la base de donnée
	@GetMapping(path = "/albums")
	public @ResponseBody Iterable<Album> getAlbums(){
        //localhost:3636/api/albums
        return this.albumRepository.findAll();
	}

	/**
	 * RequestParameter : monsite.fr?id=1
	 * PathVariable: monsite.fr/1
	 * RequestBody
	 * ResponseBody
	 */
	@GetMapping(path = "/albums/{id}")
	public @ResponseBody Album getAlbumById(@PathVariable Long id){
		return this.albumRepository.findById(id).orElse(null);
	}

	// Update
	@PutMapping(path = "/albums")
	public @ResponseBody Album upAlbum(@RequestBody Album album){
		//récupérer l'album en question
		Album existingAlbum = this.albumRepository.findById(album.getId()).orElse(null);

		existingAlbum.setRef(album.getRef());
		existingAlbum.setName(album.getName());
		existingAlbum.setTitle(album.getTitle());
		existingAlbum.setDescription(album.getDescription());
		existingAlbum.setDuration(album.getDuration());
		existingAlbum.setStatus(album.getStatus());
		existingAlbum.setUrl(album.getUrl());
		existingAlbum.setTags(album.getTags());
		existingAlbum.setLike(album.getLike());

		return this.albumRepository.save(existingAlbum);
	}

	// Delete
	@DeleteMapping(path = "/albums/{id}")
	public @ResponseBody String deleteAlbum(@PathVariable Long id){
		this.albumRepository.deleteById(id);
		return "Album supprimé : " + id;
	}
	// private List<Album> generateAlbums(){
	// 	Album album1 = new Album(
	// 	 "Zook",
	// 	 "Les Rouages de l'amour",
	// 	 "Mr. Love",
	// 	 "...",
	// 	 3000,
	// 	 "true",
	// 	 "https://love.com/album1",
	// 	 Arrays.asList("love", "good"),
	// 	 "like");

	// 	Album album2 = new Album(
	// 	 "Zinli",
	// 	 "Bénin to tché wè",
	// 	 "Mr. Alèkpéhanhou",
	// 	 "...",
	// 	 3000,
	// 	 "false",
	// 	 "https://love.com/album2",
	// 	 Arrays.asList("pays", "patrie"),
	// 	 "dislike");

	// 	Album album3 = new Album(
	// 	 "Agbadja",
	// 	 "Les frères Guèdèhounguè",
	// 	 "Gbèvivi",
	// 	 "...",
	// 	 2000,
	// 	 "true",
	// 	 "https://love.com/album3",
	// 	 Arrays.asList("friend", "dougbè"),
	// 	"like");

	// 	Album album4 = new Album(
	// 	 "Jazz",
	// 	 "Les Soeurs Guèdèhounguè",
	// 	 "Gbèmangnonmè",
	// 	 "...",
	// 	 2500,
	// 	 "false",
	// 	 "https://love.com/album3",
	// 	 Arrays.asList("sister", "boyfriend"),
	// 	"like");
		
	// 	System.out.println(album3 == album4);
	// 	// Pour la simplicité on retourne un tableau vide ou une liste vide
	// 	return Arrays.asList(album1, album2, album3, album4);
	// }
}
