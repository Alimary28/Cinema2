package Service;

import Domain.ClientCard2;
import Domain.Movie2;
import Domain.Booking2;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class BookingService2 {

    private IRepository<Booking2> booking2Repository;
    private IRepository<Movie2> movie2Repository;

    public BookingService2(IRepository<Booking2> booking2Repository, IRepository<Movie2> movie2Repository) {
        this.booking2Repository = booking2Repository;
        this.movie2Repository = movie2Repository;
    }
    public Booking2 addOrUpdate(int id, int movieId, int clientCardId, String date, String hour, double ticketPrice) {
        Booking2 existing = booking2Repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (movieId == 0) {
                movieId = existing.getMovieId();
            }
            if (clientCardId == 0) {
                clientCardId = existing.getCardId();
            }
            if (date.isEmpty()) {
                date = existing.getDate();
            }
            if (hour.isEmpty()) {
                hour = existing.getHour();
            }
            if (ticketPrice == 0) {
                ticketPrice = existing.getTicketPrice();
            }
        }

        Movie2 movieSold = movie2Repository.findById(movieId);
        if (movieSold == null) {
            throw new BookingServiceException("There is no movie with the given id!");
        }
        if (!movieSold.isInCinema()){
            throw new BookingServiceException("The movie is not in Cinema!");
        }
        double price = movieSold.getPrice();
        double ticketPoints = 0.0;
        if (clientCardId != 0 && movieSold.isInCinema()) {
            ticketPoints = ticketPrice * 0.1; // 10% points from price of the ticket
        }

        Booking2 booking2 = new Booking2(id, movieId, clientCardId, date, hour, price, (int)ticketPoints);
        booking2Repository.upsert(booking2);
        return booking2;
    }
    public List<Booking2> fullTextSearch(String text) {
        List<Booking2> found = new ArrayList<>();
        for (Booking2 booking : booking2Repository.getAll()) {
            // Might return false positives
            if (booking.toString().contains(text)) {
                found.add(booking);
            }
        }

        return found;
    }
    public void remove(int id){
        booking2Repository.remove(id);
    }
    public List<Booking2> getAll(){
        return booking2Repository.getAll();
    }
}
