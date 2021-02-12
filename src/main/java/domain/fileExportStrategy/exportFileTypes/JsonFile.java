package domain.fileExportStrategy;

import domain.MovieTicket;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonFile implements IFileBehaviour{
    @Override
    public void export(int orderNr, ArrayList<MovieTicket> tickets) {
        JSONArray ticketArray = new JSONArray();

        for (MovieTicket ticket : tickets) {
            JSONObject ticketObject = new JSONObject();
            ticketObject.put("ticket", ticket.toString());
            ticketArray.add(ticketObject);
        }

        try (FileWriter file = new FileWriter("Order_" + orderNr + ".json")) {
            file.write(ticketArray.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
