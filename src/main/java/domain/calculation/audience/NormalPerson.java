package domain.calculation.audience;

import domain.MovieTicket;
import domain.Order;
import domain.calculation.GroupDiscount;
import domain.calculation.IDiscount;
import domain.calculation.WeekendTicketDiscount;

import java.util.List;

public class NormalPerson implements ITargetAudience {
    @Override
    public double calculatePrice(Order order) {
        double totalPrice = 0;

        List<MovieTicket> tickets = order.getTickets();

        IDiscount weekendTicketDiscount = new WeekendTicketDiscount();
        for (int i = 1; i <= tickets.size(); i++) {
            totalPrice = weekendTicketDiscount.weekendTicketDiscount(tickets.get(i-1), totalPrice, i);
        }

        IDiscount groupDiscount = new GroupDiscount();
        totalPrice = groupDiscount.groupDiscount(tickets, totalPrice);

        return totalPrice;
    }
}
