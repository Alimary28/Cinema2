package Service;

import Domain.ClientCard2;
import Domain.Movie2;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class MovieService2 {

    private IRepository<Movie2> repository;

    public MovieService2(IRepository<Movie2> repository){
        this.repository = repository;
    }
    public void addOrUpdate(int id, int year, String title, double price, boolean inCinema) {
        Movie2 existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (year == 0) {
                year = existing.getYear();
            }
            if (title.isEmpty()) {
                title = existing.getTitle();
            }
            if (price == 0) {
                price = existing.getPrice();
            }
        }
        Movie2 movie2 = new Movie2(id, year, title, price, inCinema);
        repository.upsert(movie2);
    }

    public List<Movie2> fullTextSearch(String text) {
        List<Movie2> found = new ArrayList<>();
        for (Movie2 movie : repository.getAll()) {
            // Might return false positives
            if (movie.toString().contains(text)) {
                found.add(movie);
            }
        }

        return found;
    }

    public void remove(int id) {
        repository.remove(id);
    }

    public List<Movie2> getAll() {
        return repository.getAll();
    }

}
