package bj.highfive.springbootdemo;

import org.springframework.data.repository.CrudRepository;
public interface AlbumRepository extends CrudRepository<Album, Long>{
    /**
     * Java va automatiquement créé un Java "Bean" 
     * C'est comme ci une classe Java a été créée avec toutes les méthodes CRUD déjà implémenter
     * (save, find, findById, findAll, ...)
     */
}
