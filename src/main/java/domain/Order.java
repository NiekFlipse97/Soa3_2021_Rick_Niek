package domain;

import domain.calculation.audience.ITargetAudience;
import domain.fileExport.FileExportFactory;
import domain.fileExport.TicketExportFormat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Order {
    private int orderNr;
    private ITargetAudience audience;

    private ArrayList<MovieTicket> tickets;

    public Order(int orderNr, ITargetAudience audience) {
        this.orderNr = orderNr;
        this.audience = audience;

        tickets = new ArrayList<MovieTicket>();
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void addSeatReservation(MovieTicket ticket) {
        tickets.add(ticket);
    }

    public double calculatePrice() {
        return round(audience.calculatePrice(this));
    }

    private double round(double value) {
        BigDecimal bigDecimal = BigDecimal.valueOf(value);
        bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }

    public ArrayList<MovieTicket> getTickets() {
        return this.tickets;
    }

    public void export(TicketExportFormat exportFormat) {
        // Bases on the string respresentations of the tickets (toString), write
        // the ticket to a file with naming convention Order_<orderNr>.txt of
        // Order_<orderNr>.json
        FileExportFactory fileExportFactory = new FileExportFactory();
        fileExportFactory.getFileExporter(exportFormat).export(orderNr, tickets);
    }
}
