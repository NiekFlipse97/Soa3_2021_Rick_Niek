import domain.Movie;
import domain.MovieScreening;
import domain.MovieTicket;
import domain.Order;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void studentTicketPriceForFourSeats() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,9), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, false, 3, 6);
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7);
        MovieTicket ticket2 = new MovieTicket(movieScreening, false, 3, 8);
        MovieTicket ticket3 = new MovieTicket(movieScreening, true, 3, 9);
        Order order = new Order(1, true);

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(24, calculatedPrice, 2);
    }

    @Test
    public void studentTicketPremiumPriceForThreeSeats() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,9), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6);
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7);
        MovieTicket ticket2 = new MovieTicket(movieScreening, true, 3, 8);
        Order order = new Order(1, true);

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(28, calculatedPrice, 2);
    }

    /**
     * Test id 2
     */
    @Test
    public void nonStudentWeekendTicketFourSeatsFullPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,9), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 15
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7); // 15
        MovieTicket ticket2 = new MovieTicket(movieScreening, true, 3, 8); // 15
        MovieTicket ticket3 = new MovieTicket(movieScreening, true, 3, 9); // 15
        Order order = new Order(1, false);

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(60, calculatedPrice, 2);
    }

    /**
     * test id 3
     */
    @Test
    public void nonStudentNonWeekendFourSeatsFullPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 15
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7); // free
        MovieTicket ticket2 = new MovieTicket(movieScreening, true, 3, 8); // 15
        MovieTicket ticket3 = new MovieTicket(movieScreening, true, 3, 9); // free
        Order order = new Order(1, false);

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(30, calculatedPrice, 2);
    }

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
        Order order = new Order(1, true);

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
        Order order = new Order(1, true);

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
        Order order = new Order(1, true);

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
        Order order = new Order(1, true);

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
        Order order = new Order(1, true);

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(26, calculatedPrice, 2);
    }

    /**
     * Test id NS1
     */
    @Test
    public void nonStudentNonWeekendTwoSeatsNonPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, false, 3, 6); // 12
        MovieTicket ticket1 = new MovieTicket(movieScreening, false, 3, 7); // free
        Order order = new Order(1, false);

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(12, calculatedPrice, 2);
    }

    /**
     * Test id NS2
     */
    @Test
    public void nonStudentNonWeekendTwoSeatsPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 12
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7); // free
        Order order = new Order(1, false);

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(15, calculatedPrice, 2);
    }

    /**
     * Test id NS3
     */
    @Test
    public void nonStudentNonWeekendThreeSeatsNonPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, false, 3, 6); // 12
        MovieTicket ticket1 = new MovieTicket(movieScreening, false, 3, 7); // free
        MovieTicket ticket2 = new MovieTicket(movieScreening, false, 3, 7); // 12
        Order order = new Order(1, false);

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(24, calculatedPrice, 2);
    }

    /**
     * Test id NS4
     */
    @Test
    public void nonStudentNonWeekendThreeSeatsPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 15
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7); // free
        MovieTicket ticket2 = new MovieTicket(movieScreening, true, 3, 7); // 15
        Order order = new Order(1, false);

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(30, calculatedPrice, 2);
    }

    /**
     * Test id NS5
     */
    @Test
    public void nonStudentNonWeekendFourSeatsMixedPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 15
        MovieTicket ticket1 = new MovieTicket(movieScreening, false, 3, 7); // free
        MovieTicket ticket2 = new MovieTicket(movieScreening, false, 3, 7); // 12
        MovieTicket ticket3 = new MovieTicket(movieScreening, true, 3, 7); // free
        Order order = new Order(1, false);

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(27, calculatedPrice, 2);
    }

    /**
     * Test id NSW1
     */
    @Test
    public void nonStudentWeekendSixSeatsPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,15), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 13.5
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7); // 13.5
        MovieTicket ticket2 = new MovieTicket(movieScreening, true, 3, 7); // 13.5
        MovieTicket ticket3 = new MovieTicket(movieScreening, true, 3, 7); // 13.5
        MovieTicket ticket4 = new MovieTicket(movieScreening, true, 3, 7); // 13.5
        MovieTicket ticket5 = new MovieTicket(movieScreening, true, 3, 7); // 13.5
        Order order = new Order(1, false);

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);
        order.addSeatReservation(ticket4);
        order.addSeatReservation(ticket5);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(81, calculatedPrice, 2);
    }

    /**
     * Test id NSW2
     */
    @Test
    public void nonStudentWeekendSixSeatsNonPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,15), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, false, 3, 6); // 10.80
        MovieTicket ticket1 = new MovieTicket(movieScreening, false, 3, 7); // 10.80
        MovieTicket ticket2 = new MovieTicket(movieScreening, false, 3, 7); // 10.80
        MovieTicket ticket3 = new MovieTicket(movieScreening, false, 3, 7); // 10.80
        MovieTicket ticket4 = new MovieTicket(movieScreening, false, 3, 7); // 10.80
        MovieTicket ticket5 = new MovieTicket(movieScreening, false, 3, 7); // 10.80
        Order order = new Order(1, false);

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);
        order.addSeatReservation(ticket4);
        order.addSeatReservation(ticket5);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(64.80, calculatedPrice, 2);
    }

    /**
     * Edited this file to test git
     *
     * Test id NSW3
     */
    @Test
    public void nonStudentWeekendFiveSeatsPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,15), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 15
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7); // 15
        MovieTicket ticket2 = new MovieTicket(movieScreening, true, 3, 7); // 15
        MovieTicket ticket3 = new MovieTicket(movieScreening, true, 3, 7); // 15
        MovieTicket ticket4 = new MovieTicket(movieScreening, true, 3, 7); // 15
        Order order = new Order(1, false);

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);
        order.addSeatReservation(ticket4);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(75, calculatedPrice, 2);
    }

    /**
     * Test id NSW4
     */
    @Test
    public void nonStudentWeekendFiveSeatNonPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,15), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, false, 3, 6); // 12
        MovieTicket ticket1 = new MovieTicket(movieScreening, false, 3, 7); // 12
        MovieTicket ticket2 = new MovieTicket(movieScreening, false, 3, 7); // 12
        MovieTicket ticket3 = new MovieTicket(movieScreening, false, 3, 7); // 12
        MovieTicket ticket4 = new MovieTicket(movieScreening, false, 3, 7); // 12
        Order order = new Order(1, false);

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);
        order.addSeatReservation(ticket4);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(60, calculatedPrice, 2);
    }
}
