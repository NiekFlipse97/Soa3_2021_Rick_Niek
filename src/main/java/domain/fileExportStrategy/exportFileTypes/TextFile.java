package domain.fileExportStrategy.exportFileTypes;

import domain.MovieTicket;
import domain.fileExportStrategy.IFileBehaviour;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TextFile implements IFileBehaviour {
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
