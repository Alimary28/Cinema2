import Domain.*;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.MovieService2;
import Service.ClientCardService2;
import Service.BookingService2;
import UI.Console;


public class Main {

    public static void main(String[] args) {
        IValidator<Movie2> movieValidator = new MovieValidator2();
        IValidator<ClientCard2> clientCardValidator = new ClientCardValidator2();
        IValidator<Booking2> bookingValidator = new BookingValidator2();

        IRepository<Movie2> movieRepository = new InMemoryRepository<>(movieValidator);
        IRepository<ClientCard2> clientCardRepository = new InMemoryRepository<>(clientCardValidator);
        IRepository<Booking2> bookingRepository = new InMemoryRepository<>(bookingValidator);

        MovieService2 movieService2 = new MovieService2(movieRepository);
        ClientCardService2 clientCardService2 = new ClientCardService2(clientCardRepository);
        BookingService2 bookingService2 = new BookingService2(bookingRepository, movieRepository);

        Console console = new Console(movieService2, clientCardService2, bookingService2);
        console.run();
    }
}
