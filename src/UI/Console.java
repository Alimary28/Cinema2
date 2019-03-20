package UI;

import Domain.Movie2;
import Domain.ClientCard2;
import Domain.Booking2;
import Service.MovieService2;
import Service.ClientCardService2;
import Service.BookingService2;

import java.util.Scanner;

public class Console {

    private MovieService2 movieService2;
    private ClientCardService2 clientCardService2;
    private BookingService2 bookingService2;

    private Scanner scanner;

    public Console(MovieService2 movieService2, ClientCardService2 clientCardService2, BookingService2 bookingService2) {
        this.movieService2 = movieService2;
        this.clientCardService2 = clientCardService2;
        this.bookingService2 = bookingService2;

        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Movie CRUD");
        System.out.println("2. ClientCard CRUD");
        System.out.println("3. Booking CRUD");
        System.out.println("4. Search Clients");
        System.out.println("x. Exit");
    }

    public void run() {
        while (true) {
            showMenu();
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runMovieCrud();
                    break;
                case "2":
                    runClientCardCrud();
                    break;
                case "3":
                    runBookingCrud();
                    break;
                case "4":
                    runClientSearch();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }
    private void runClientSearch(){
        System.out.println("Search by: ");
        String search = scanner.nextLine();
        System.out.println("Search results are: ");
        for(ClientCard2 clientCard2 : clientCardService2.fullTextSearch(search)){
            System.out.println(clientCard2);
        }
    }

    private void runBookingCrud() {
        while (true) {
            System.out.println("1. Add/update booking");
            System.out.println("2. Remove a booking");
            System.out.println("3. View all bookings");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateBooking();
                    break;
                case "2":
                    handleRemoveBooking();
                    break;
                case "3":
                    handleViewBookings();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewBookings() {
        for (Booking2 booking2 : bookingService2.getAll()) {
            System.out.println(booking2);
        }
    }

    private void handleRemoveBooking() {
        try {
            System.out.print("Enter the id to remove:");
            int id = scanner.nextInt();
            bookingService2.remove(id);

            System.out.println("Transaction removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateBooking() {
        try {
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            System.out.print("Enter movie id (empty to not change for update): ");
            int movieId = scanner.nextInt();
            System.out.print("Enter client card (empty to not change for update): ");
            int cardId = scanner.nextInt();
            System.out.print("Enter date (empty to not change for update): ");
            scanner.nextLine();
            String date = scanner.nextLine();
            System.out.print("Enter time (empty to not change for update): ");
            String time = scanner.nextLine();
            System.out.println("Enter ticket price");
            double ticketPrice = scanner.nextDouble();

            Booking2 booking2 = bookingService2.addOrUpdate(id, movieId, cardId, date, time, ticketPrice);
            System.out.println(String.format("Added booking id=%s, ticket price=%f, points=%d", booking2.getId(), booking2.getTicketPrice(), booking2.getPointsValue()));
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runClientCardCrud() {
        while (true) {
            System.out.println("1. Add or update a client card");
            System.out.println("2. Remove a client card");
            System.out.println("3. View all clients");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateClientCard();
                    break;
                case "2":
                    handleRemoveClientCard();
                    break;
                case "3":
                    handleViewClients();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewClients() {
        for (ClientCard2 clientCard2 : clientCardService2.getAll()) {
            System.out.println(clientCard2);
        }
    }

    private void handleRemoveClientCard() {
        try {
            System.out.print("Enter the card id to remove:");
            int id = scanner.nextInt();
            clientCardService2.remove(id);

            System.out.println("Client card removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateClientCard() {
        try {
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            System.out.print("Enter last name (empty to not change for update): ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Enter first name (empty to not change for update): ");
            String firstName = scanner.nextLine();
            System.out.print("Enter CNP (empty to not change for update): ");
            String cnp = scanner.nextLine();
            System.out.print("Enter date of birth (empty to not change for update): ");
            String birthDate = scanner.nextLine();
            System.out.print("Enter date of registration (empty to not change for update): ");
            String registrationDate = scanner.nextLine();
            clientCardService2.addOrUpdate(id, name, firstName, cnp, birthDate, registrationDate);

            System.out.println("Client card added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runMovieCrud() {
        while (true) {
            System.out.println("1. Add or update a movie");
            System.out.println("2. Remove a movie");
            System.out.println("3. View all movies");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateMovie();
                    break;
                case "2":
                    handleRemoveMovie();
                    break;
                case "3":
                    handleViewMovies();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewMovies() {
        for (Movie2 movie2 : movieService2.getAll()) {
            System.out.println(movie2);
        }
    }

    private void handleRemoveMovie() {
        try {
            System.out.print("Enter the movie id to remove:");
            int id = scanner.nextInt();
            movieService2.remove(id);

            System.out.println("Movie removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateMovie() {

        try {
            System.out.print("Enter id: ");
            int id = scanner.nextInt();
            System.out.print("Enter year: ");
            int year = scanner.nextInt();
            System.out.print("Enter title (empty to not change for update): ");
            scanner.nextLine();
            String title = scanner.nextLine();
            System.out.print("Enter price (0 to not change for update): ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter in Cinema (true / false): ");
            boolean inCinema = Boolean.parseBoolean(scanner.nextLine());

            movieService2.addOrUpdate(id, year, title, price, inCinema);

            System.out.println("Movie added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

}
