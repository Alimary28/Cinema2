package Tests;

import Service.BookingService2;
import org.junit.jupiter.api.Test;
import Domain.Movie2;
import Domain.MovieValidator2;
import Domain.ClientCard2;
import Domain.ClientCardValidator2;
import Domain.Booking2;
import Domain.BookingValidator2;
import Domain.Entity;
import Domain.IValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryRepositoryTest {


    private IValidator<Movie2> movie2Validator = new MovieValidator2();
    private IValidator<ClientCard2> clientCard2Validator = new ClientCardValidator2();
    private IValidator<Booking2> booking2Validator = new BookingValidator2();

    private IRepository<Movie2> movie2Repository = new InMemoryRepository<>(movie2Validator);
    private IRepository<ClientCard2> clientCard2Repository = new InMemoryRepository<>(clientCard2Validator);
    private IRepository<Booking2> booking2Repository = new InMemoryRepository<>(booking2Validator);

    private Movie2 movie2 = new Movie2(1,2005,"Shrek",18.0,true);

    private ClientCard2 clientCard2 = new ClientCard2(3,"Pop","Ioana","123456789","21.07.1992","14.01.2013");
    private ClientCard2 newClient = new ClientCard2(5,"Anton","Maria","190071212","12.07.1958","09.04.2015");

    private Booking2 booking2 = new Booking2(1,1, 3, "10.09.2015", "12:15", 18.0, 5);

    @Test
    public void findById() {
        movie2Repository.upsert(movie2);
        booking2Repository.upsert(booking2);

        assertEquals(movie2, movie2Repository.findById(booking2.getMovieId()));
    }

    @Test
    void upsert() {

        movie2Repository.upsert(movie2);
        List<Movie2> movie2List = movie2Repository.getAll();

        clientCard2Repository.upsert(clientCard2);
        List<ClientCard2> clientCard2List = clientCard2Repository.getAll();

        booking2Repository.upsert(booking2);
        List<Booking2> booking2List = booking2Repository.getAll();

        assertEquals(1, movie2List.size());
        assertEquals(movie2, movie2List.get(0));

        assertEquals(1, clientCard2List.size());
        assertEquals(clientCard2, clientCard2List.get(0));

        assertEquals(1, booking2List.size());
        assertEquals(booking2, booking2List.get(0));

    }

    @Test
    void remove() {

        clientCard2Repository.upsert(clientCard2);
        clientCard2Repository.remove(3);
        assertEquals(0, clientCard2Repository.getAll().size());
    }

    @Test
    void getAll() {


        movie2Repository.upsert(movie2);
        assertEquals(1, movie2Repository.getAll().size());
    }
}