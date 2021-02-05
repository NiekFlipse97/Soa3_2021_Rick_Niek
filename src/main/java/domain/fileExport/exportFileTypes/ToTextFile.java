package domain.fileExport.exportFileTypes;

import domain.MovieTicket;
import domain.fileExport.IFileExporter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ToTextFile implements IFileExporter {
    @Override
    public void export(int orderNr, ArrayList<MovieTicket> tickets) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("Order_" + orderNr + ".txt"), StandardCharsets.UTF_8))) {
            for (MovieTicket ticket : tickets) {
                writer.write(ticket.toString() + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
