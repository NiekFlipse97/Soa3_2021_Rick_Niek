import domain.Movie;
import domain.MovieScreening;
import domain.MovieTicket;
import domain.Order;
import domain.calculation.audience.Student;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class StudentOrderTest {

    /**
     * Test id S1
     */
    @Test
    public void studentTwoSeatsNoPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, false, 3, 6); // 12
        MovieTicket ticket1 = new MovieTicket(movieScreening, false, 3, 7); // free
        Order order = new Order(1, new Student());

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(12, calculatedPrice, 2);
    }

    /**
     * Test id S2
     */
    @Test
    public void studentTwoSeatsPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 14
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7); // free
        Order order = new Order(1, new Student());

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(14, calculatedPrice, 2);
    }

    /**
     * Test id S3
     */
    @Test
    public void studentThreeSeatsNonPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, false, 3, 6); // 12
        MovieTicket ticket1 = new MovieTicket(movieScreening, false, 3, 7); // free
        MovieTicket ticket2 = new MovieTicket(movieScreening, false, 3, 7); // 12
        Order order = new Order(1, new Student());

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(24, calculatedPrice, 2);
    }

    /**
     * Test id S4
     */
    @Test
    public void studentThreeSeatsPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 14
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7); // free
        MovieTicket ticket2 = new MovieTicket(movieScreening, true, 3, 7); // 14
        Order order = new Order(1, new Student());

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(28, calculatedPrice, 2);
    }

    /**
     * Test id S5
     */
    @Test
    public void studentFourSeatsMixedPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 14
        MovieTicket ticket1 = new MovieTicket(movieScreening, false, 3, 7); // free
        MovieTicket ticket2 = new MovieTicket(movieScreening, false, 3, 7); // 12
        MovieTicket ticket3 = new MovieTicket(movieScreening, true, 3, 7); // free
        Order order = new Order(1, new Student());

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(26, calculatedPrice, 2);
    }

}
