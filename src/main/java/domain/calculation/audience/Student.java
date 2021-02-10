package domain.calculation.audience;


import domain.MovieTicket;
import domain.Order;

import java.util.ArrayList;

public class Student implements ITargetAudience {

    @Override
    public double calculatePrice(Order order) {
        double totalPrice = 0;

        ArrayList<MovieTicket> tickets = order.getTickets();

        for(int i = 0; i < tickets.size(); i++) {
            if (i % 2 == 0)
                totalPrice += sumPrice(tickets.get(i));
        }

        return totalPrice;
    }

    public double sumPrice(MovieTicket ticket) {
        return (ticket.getPrice() + (ticket.isPremiumTicket() ? 2 : 0));
    }
}
