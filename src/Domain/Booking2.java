package Domain;

import java.util.Objects;

public class Booking2 extends Entity {

    private int movieId, cardId, points;
    private String date, hour;
    private double ticketPrice;

    public Booking2(int id, int movieId, int cardId, String date, String hour, double ticketPrice, int points) {
        super(id);
        this.movieId = movieId;
        this.cardId = cardId;
        this.date = date;
        this.hour = hour;
        this.ticketPrice = ticketPrice;
        this.points = points;
    }
    /**
     * Custom getter for the points.
     * @return the points from ticket price
     */
    public double getPointsValue() {
        return ticketPrice * points;
    }

    @Override
    public  String toString() {
        return "Booking{" +
                "id='" + getId() + '\'' +
                ", movieId='" + movieId + '\'' +
                ", cardId='" + cardId + '\'' +
                ", date='" + date + '\'' +
                ", hour='" + hour + '\'' +
                ", ticketPrice='" + ticketPrice + '\'' +
                ", points='" + points + '\'' +
                '}';
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
