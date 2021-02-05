package domain;

import domain.calculation.Discounts;
import domain.fileExport.FileExportFactory;
import domain.fileExport.TicketExportFormat;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private int orderNr;
    private boolean isStudentOrder;

    private ArrayList<MovieTicket> tickets;

    public Order(int orderNr, boolean isStudentOrder) {
        this.orderNr = orderNr;
        this.isStudentOrder = isStudentOrder;

        tickets = new ArrayList<MovieTicket>();
    }

    public int getOrderNr() {
        return orderNr;
    }

    public void addSeatReservation(MovieTicket ticket) {
        tickets.add(ticket);
    }

    public boolean isWeekend() {
        LocalDateTime screeningDate = tickets.get(0).getMovieScreeningDate();
        DayOfWeek day = screeningDate.getDayOfWeek();

        return day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }

    public double calculatePrice() {
        Discounts discounts = new Discounts(tickets); // 1

        if (isStudentOrder) { // A
            // 2th ticket free for students every day of week.
            return discounts.studentTickets(); // 2
        }

        // Non students here.
        if (isWeekend()) { // B
            return discounts.ticketsNonStudentWeekend(); // 3
        }

        return discounts.ticketsNonStudent(); // 4
    }

    public void export(TicketExportFormat exportFormat) {
        // Bases on the string respresentations of the tickets (toString), write
        // the ticket to a file with naming convention Order_<orderNr>.txt of
        // Order_<orderNr>.json
        FileExportFactory fileExportFactory = new FileExportFactory();
        fileExportFactory.getFileExporter(exportFormat).export(orderNr, tickets);
    }
}
