package Tests;

import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.BookingService2;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookingService2Test {

    private IValidator<Movie2> movie2Validator = new MovieValidator2();
    private IValidator<ClientCard2> clientCard2Validator = new ClientCardValidator2();
    private IValidator<Booking2> booking2Validator = new BookingValidator2();

    private IRepository<Movie2> movie2Repository = new InMemoryRepository<>(movie2Validator);
    private IRepository<ClientCard2> clientCard2Repository = new InMemoryRepository<>(clientCard2Validator);
    private IRepository<Booking2> booking2Repository = new InMemoryRepository<>(booking2Validator);

    private BookingService2 bookingService2 = new BookingService2(booking2Repository, movie2Repository);
    private Movie2 movie2 = new Movie2(1,2015,"Hitmann",14.0,true);
    private Movie2  identically= new Movie2(1,2015,"Hitmann",14.0,true);
    private ClientCard2 clientCard2 = new ClientCard2(1,"Andreica","Anda","191090912","04.02.1981","19.08.2012");

    @Test
    void addOrUpdate() {
        movie2Repository.upsert(movie2);
        clientCard2Repository.upsert(clientCard2);
        bookingService2.addOrUpdate(1,1,1,"22.12.2017","19:45", 25.5);

        assertEquals(1, bookingService2.getAll().size());


    }

    @Test
    void remove() {

        movie2Repository.upsert(movie2);
        clientCard2Repository.upsert(clientCard2);
        bookingService2.addOrUpdate(1,1,1,"22.12.2017","19:45", 25.5);
        bookingService2.remove(1);

        assertEquals(0, bookingService2.getAll().size());
    }


    @Test
    void getAll() {

        movie2Repository.upsert(movie2);
        clientCard2Repository.upsert(clientCard2);
        bookingService2.addOrUpdate(1,1,1,"22.12.2017","19:45", 25.5);

        assertEquals(1, bookingService2.getAll().size());

    }
}