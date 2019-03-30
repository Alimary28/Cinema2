package Domain;

public class BookingValidator2 implements IValidator<Booking2> {

    public void validate2(Booking2 booking2){
        if(booking2.getMovieId() <= 0 || booking2.getDate() == null){
            throw new BookingException("Movie can not exists!");
        }
        if(booking2.getTicketPrice() <= 0){
            throw new BookingException("The points can not be calculated!");
        }
    }
}
