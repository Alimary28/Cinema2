package Tests;

import Domain.Movie2;
import Domain.MovieValidator2;
import Domain.IValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Repository.InMemoryRepoException;
import Service.MovieService2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class MovieService2Test {

    private IValidator<Movie2> movie2Validator = new MovieValidator2();
    private IRepository<Movie2> movie2Repository = new InMemoryRepository<>(movie2Validator);
    private MovieService2 movieService2 = new MovieService2(movie2Repository);

    private Movie2 movie2 = new Movie2(1,2017,"Captain America",14.0,true);
    private Movie2 otherMovie = new Movie2(1,2017,"Captain America",14.0,true);


    @Test
    public void addOrUpdate() {
        movieService2.addOrUpdate(1,2018,"Hitmann",14.0,true);
        assertEquals(1, movieService2.getAll().size());

    }

    @Test
    public void remove() {
        movieService2.addOrUpdate(2,2019,"Legendary",30.0,true);
        movieService2.remove(2);

        assertEquals(0, movieService2.getAll().size());
    }

    @Test
    public void getAll() {
        movieService2.addOrUpdate(3,2019,"Sherlock Holmes",45.0,true);
        assertEquals(1, movieService2.getAll().size());
    }

    @Test
    void fullTextSearch() {

        movie2Repository.upsert(movie2);
        movieService2.addOrUpdate(1,2017,"X-Men",25.8,true);
        String text = "19";

        assertEquals(1, movieService2.fullTextSearch(text).size());
    }
}
