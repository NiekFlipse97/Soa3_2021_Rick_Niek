package domain.fileExportStrategy.exportFileTypes;

import domain.MovieTicket;
import domain.fileExportStrategy.IFileBehaviour;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonFile implements IFileBehaviour {
    @Override
    public void export(int orderNr, ArrayList<MovieTicket> tickets) {
        JSONArray ticketArray = new JSONArray();

        for (MovieTicket ticket : tickets) {
            JSONObject ticketObject = new JSONObject();
            ticketObject.put("ticket", ticket.toString());
            ticketArray.add(ticketObject);
        }

        String directory = System.getProperty("user.dir");
        String filename = String.format("Order_%s.json", orderNr);

        try (FileWriter file = new FileWriter(new File(directory + "\\exportedFiles\\", filename))) {
            file.write(ticketArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
