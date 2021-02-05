package domain.calculation;

import domain.MovieTicket;
import domain.Tuple;

import java.util.ArrayList;

public class Discounts {

    private ArrayList<MovieTicket> tickets;

    public Discounts(ArrayList<MovieTicket> tickets) {
        this.tickets = tickets;
    }

    public double studentTickets() {
        double price = 0;

        for (int i = 0; i < tickets.size(); i++) {
            MovieTicket ticket = tickets.get(i);

            if (i % 2 == 0) { // A
                if (ticket.isPremiumTicket()) { // B
                    price += ticket.getPremiumPriceStudent();
                } else { // C
                    price += ticket.getPrice();
                }
            }
        }

        return price;
    }

    public double ticketsNonStudentWeekend() {
        double price = 0;

        for (int i = 0; i < tickets.size(); i++) {
            MovieTicket ticket = tickets.get(i);
            Tuple tuple = new Tuple(ticket.isPremiumTicket(), tickets.size());

            if (tuple.getIsPremium() && tuple.getSixOrMore()) {
                price += ticket.getPremiumPrice() * 0.90;
            } else if (!tuple.getIsPremium() && tuple.getSixOrMore()) {
                price += ticket.getPrice() * 0.90;
            } else if (tuple.getIsPremium() && !tuple.getSixOrMore()) {
                price += ticket.getPremiumPrice();
            } else {
                price += ticket.getPrice();
            }
        }

        return price;
    }

    public double ticketsNonStudent() {
        double price = 0;

        for (int i = 0; i < tickets.size(); i++) {
            MovieTicket ticket = tickets.get(i);

            if (i % 2 == 0) { // A
                if (ticket.isPremiumTicket()) { // B
                    price += ticket.getPremiumPrice();
                } else { // C
                    price += ticket.getPrice();
                }
            }
        }

        return price;
    }

}
