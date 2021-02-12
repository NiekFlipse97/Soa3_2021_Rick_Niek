package domain.calculation;

import domain.MovieTicket;

import java.util.List;

public interface IDiscount {

    double groupDiscount(List<MovieTicket> tickets, double totalPrice);

    double weekendTicketDiscount(MovieTicket ticket, double totalPrice, int i);

}
