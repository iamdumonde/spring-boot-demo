package bj.highfive.springbootdemo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // signife que cette classe est un controller
@RequestMapping(path = "/api") // signifie que l'URL commence par /api (après l'URL de l'application)
public class AlbumController {

    @Autowired // Ceci demande à Java d'injecter le "bean" AlbumRepository
    AlbumRepository albumRepository;

	@GetMapping(path = "/albums")
	public Iterable<Album> getAlbums(){
        //localhost:3636/api/albums
        return this.albumRepository.findAll();
    
	}

	/**
	 * @return
	 */
	private List<Album> generateAlbums(){
		Album album1 = new Album(
		 "Zook",
		 "Les Rouages de l'amour",
		 "Mr. Love",
		 "...",
		 3000,
		 "true",
		 "https://love.com/album1",
		 Arrays.asList("love", "good"),
		 "like");

		Album album2 = new Album(
		 "Zinli",
		 "Bénin to tché wè",
		 "Mr. Alèkpéhanhou",
		 "...",
		 3000,
		 "false",
		 "https://love.com/album2",
		 Arrays.asList("pays", "patrie"),
		 "dislike");

		Album album3 = new Album(
		 "Agbadja",
		 "Les frères Guèdèhounguè",
		 "Gbèvivi",
		 "...",
		 2000,
		 "true",
		 "https://love.com/album3",
		 Arrays.asList("friend", "dougbè"),
		"like");

		Album album4 = new Album(
		 "Jazz",
		 "Les Soeurs Guèdèhounguè",
		 "Gbèmangnonmè",
		 "...",
		 2500,
		 "false",
		 "https://love.com/album3",
		 Arrays.asList("sister", "boyfriend"),
		"like");
		
		System.out.println(album3 == album4);
		// Pour la simplicité on retourne un tableau vide ou une liste vide
		return Arrays.asList(album1, album2, album3, album4);
	}
}
