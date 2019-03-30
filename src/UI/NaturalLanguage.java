package UI;
import Domain.Movie2;
import Domain.ClientCard2;
import Domain.Booking2;
import Service.MovieService2;
import Service.ClientCardService2;
import Service.BookingService2;
import java.util.Scanner;

public class NaturalLanguage {

    private MovieService2 movieService;
    private ClientCardService2 clientCardService;
    private BookingService2 bookingService;

    private Scanner scanner;

    public NaturalLanguage(MovieService2 movieService, ClientCardService2 clientCardService, BookingService2 bookingService) {
        this.movieService = movieService;
        this.clientCardService = clientCardService;
        this.bookingService = bookingService;

        this.scanner = new Scanner(System.in);
    }

    public void run2() {
        while (true) {
            String option = scanner.nextLine();
            String[] Opt = option.split(",");
            switch (Opt[0]) {
                case "add movie":
                    handleAddUpdateMovie(Integer.parseInt(Opt[1]), Integer.parseInt(Opt[2]), Opt[3], Double.parseDouble(Opt[4]), Boolean.parseBoolean(Opt[5]));
                    break;
                case "remove movie":
                    handleRemoveMovie(Integer.parseInt(Opt[1]));
                    break;
                case "view all movies":
                    handleViewMovies();
                    break;
                case "add client card":
                    handleAddUpdateClientCard(Integer.parseInt(Opt[1]), Opt[2], Opt[3], Opt[4], Opt[5], Opt[6]);
                    break;
                case "remove client card":
                    handleRemoveClientCard(Integer.parseInt(Opt[1]));
                    break;
                case "view clients":
                    handleViewClients();
                    break;
                case "add booking":
                    handleAddUpdateBooking(Integer.parseInt(Opt[1]), Integer.parseInt(Opt[2]), Integer.parseInt(Opt[3]), Opt[3], Opt[4], Double.parseDouble(Opt[5]));
                    break;
                case "remove booking":
                    handleRemoveBooking(Integer.parseInt(Opt[1]));
                    break;
                case "view bookings":
                    handleViewBookings();
                    break;
                case "back":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewBookings() {
        for (Booking2 booking : bookingService.getAll()) {
            System.out.println(booking);
        }
    }

    private void handleRemoveBooking(int id) {
        try {
            bookingService.remove(id);

            System.out.println("Booking removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateBooking(int id, int movieId, int cardId, String date, String time, double ticketPrice) {
        try {
            Booking2 booking = bookingService.addOrUpdate(id, movieId, cardId, date, time, ticketPrice);
            System.out.println(String.format("Added booking id=%s, ticket price=%f, points=%s", booking.getId(), booking.getTicketPrice(), booking.getPoints()));
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleViewClients() {
        for (ClientCard2 clientCard : clientCardService.getAll()) {
            System.out.println(clientCard);
        }
    }

    private void handleRemoveClientCard(int id) {
        try {
            clientCardService.remove(id);

            System.out.println("Client card removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateClientCard(int id, String name, String firstname, String cnp, String birthDate, String registrationDate) {
        try {
            clientCardService.addOrUpdate(id, name, firstname, cnp, birthDate, registrationDate);

            System.out.println("Client card added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleViewMovies() {
        for (Movie2 movie : movieService.getAll()) {
            System.out.println(movie);
        }
    }

    private void handleRemoveMovie(int id) {
        try {
            movieService.remove(id);

            System.out.println("Movie removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateMovie(int id, int year, String title, double price, boolean inCinema) {

        try {
            movieService.addOrUpdate(id, year, title, price, inCinema);

            System.out.println("Movie added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }


}
