import domain.Movie;
import domain.MovieScreening;
import domain.MovieTicket;
import domain.Order;
import domain.calculation.audience.NormalPerson;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class NormalPersonOrderTest {

    /**
     * Test id 2
     */
    @Test
    public void weekendTicketFourSeatsFullPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,9), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 15
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7); // 15
        MovieTicket ticket2 = new MovieTicket(movieScreening, true, 3, 8); // 15
        MovieTicket ticket3 = new MovieTicket(movieScreening, true, 3, 9); // 15
        Order order = new Order(1, new NormalPerson());

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
     * Test id NSW1
     */
    @Test
    public void weekendSixSeatsPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,15), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 13.5
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7); // 13.5
        MovieTicket ticket2 = new MovieTicket(movieScreening, true, 3, 7); // 13.5
        MovieTicket ticket3 = new MovieTicket(movieScreening, true, 3, 7); // 13.5
        MovieTicket ticket4 = new MovieTicket(movieScreening, true, 3, 7); // 13.5
        MovieTicket ticket5 = new MovieTicket(movieScreening, true, 3, 7); // 13.5
        Order order = new Order(1, new NormalPerson());

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
    public void weekendSixSeatsNonPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,15), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, false, 3, 6); // 10.80
        MovieTicket ticket1 = new MovieTicket(movieScreening, false, 3, 7); // 10.80
        MovieTicket ticket2 = new MovieTicket(movieScreening, false, 3, 7); // 10.80
        MovieTicket ticket3 = new MovieTicket(movieScreening, false, 3, 7); // 10.80
        MovieTicket ticket4 = new MovieTicket(movieScreening, false, 3, 7); // 10.80
        MovieTicket ticket5 = new MovieTicket(movieScreening, false, 3, 7); // 10.80
        Order order = new Order(1, new NormalPerson());

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
     * Test id NSW3
     */
    @Test
    public void weekendFiveSeatsPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,15), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 15
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7); // 15
        MovieTicket ticket2 = new MovieTicket(movieScreening, true, 3, 7); // 15
        MovieTicket ticket3 = new MovieTicket(movieScreening, true, 3, 7); // 15
        MovieTicket ticket4 = new MovieTicket(movieScreening, true, 3, 7); // 15
        Order order = new Order(1, new NormalPerson());

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
    public void weekendFiveSeatNonPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,15), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, false, 3, 6); // 12
        MovieTicket ticket1 = new MovieTicket(movieScreening, false, 3, 7); // 12
        MovieTicket ticket2 = new MovieTicket(movieScreening, false, 3, 7); // 12
        MovieTicket ticket3 = new MovieTicket(movieScreening, false, 3, 7); // 12
        MovieTicket ticket4 = new MovieTicket(movieScreening, false, 3, 7); // 12
        Order order = new Order(1, new NormalPerson());

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


    /**
     * test id 3
     */
    @Test
    public void nonWeekendFourSeatsFullPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 15
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7); // free
        MovieTicket ticket2 = new MovieTicket(movieScreening, true, 3, 8); // 15
        MovieTicket ticket3 = new MovieTicket(movieScreening, true, 3, 9); // free
        Order order = new Order(1, new NormalPerson());

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
     * Test id NS1
     */
    @Test
    public void nonWeekendTwoSeatsNonPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, false, 3, 6); // 12
        MovieTicket ticket1 = new MovieTicket(movieScreening, false, 3, 7); // free
        Order order = new Order(1, new NormalPerson());

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
    public void nonWeekendTwoSeatsPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 12
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7); // free
        Order order = new Order(1, new NormalPerson());

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
    public void nonWeekendThreeSeatsNonPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, false, 3, 6); // 12
        MovieTicket ticket1 = new MovieTicket(movieScreening, false, 3, 7); // free
        MovieTicket ticket2 = new MovieTicket(movieScreening, false, 3, 7); // 12
        Order order = new Order(1, new NormalPerson());

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
    public void nonWeekendThreeSeatsPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 15
        MovieTicket ticket1 = new MovieTicket(movieScreening, true, 3, 7); // free
        MovieTicket ticket2 = new MovieTicket(movieScreening, true, 3, 7); // 15
        Order order = new Order(1, new NormalPerson());

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
    public void nonWeekendFourSeatsMixedPremium() {
        // Arrange
        Movie hangover = new Movie("The Hangover");
        MovieScreening movieScreening = new MovieScreening(hangover, LocalDateTime.of(LocalDate.of(2020, 2,4), LocalTime.now()), 12.0);
        MovieTicket ticket0 = new MovieTicket(movieScreening, true, 3, 6); // 15
        MovieTicket ticket1 = new MovieTicket(movieScreening, false, 3, 7); // free
        MovieTicket ticket2 = new MovieTicket(movieScreening, false, 3, 7); // 12
        MovieTicket ticket3 = new MovieTicket(movieScreening, true, 3, 7); // free
        Order order = new Order(1, new NormalPerson());

        // Act
        order.addSeatReservation(ticket0);
        order.addSeatReservation(ticket1);
        order.addSeatReservation(ticket2);
        order.addSeatReservation(ticket3);
        double calculatedPrice = order.calculatePrice();

        // Assert
        assertEquals(27, calculatedPrice, 2);
    }

}
