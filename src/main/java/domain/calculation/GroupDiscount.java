package domain.calculation;

import domain.MovieTicket;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

public class GroupDiscount implements IDiscount {

    @Override
    public double groupDiscount(List<MovieTicket> tickets, double totalPrice) {

        for (MovieTicket ticket : tickets) {
            if (isWeekend(ticket) && tickets.size() > 5) {
                // Weekend en 6 of meer tickets
                return totalPrice * 0.90;
            }
        }

        return totalPrice;
    }

    @Override
    public double weekendTicketDiscount(List<MovieTicket> tickets) {
        return 0;
    }

    public boolean isWeekend(MovieTicket ticket) {
        LocalDateTime screeningDate = ticket.getMovieScreeningDate();
        DayOfWeek day = screeningDate.getDayOfWeek();

        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
}
