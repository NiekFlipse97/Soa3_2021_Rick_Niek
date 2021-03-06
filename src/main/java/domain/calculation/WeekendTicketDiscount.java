package domain.calculation;

import domain.MovieTicket;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public class WeekendTicketDiscount implements IDiscount {
    @Override
    public double groupDiscount(List<MovieTicket> tickets, double totalPrice) {
        return 0;
    }

    @Override
    public double weekendTicketDiscount(MovieTicket ticket, double totalPrice, int i) {
        if (!isWeekend(ticket) && i % 2 == 0) {
            // Door de week
            // Hier 2e ticket gratis
            return totalPrice;
        }

        // Dit is weekend ticket. Dus betalen G.
        return (totalPrice + sumPrice(ticket));
    }

    public boolean isWeekend(MovieTicket ticket) {
        LocalDateTime screeningDate = ticket.getMovieScreeningDate();
        DayOfWeek day = screeningDate.getDayOfWeek();

        return day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

    public double sumPrice(MovieTicket ticket) {
        return (ticket.getPrice() + (ticket.isPremiumTicket() ? 3 : 0));
    }
}
