package domain.fileExportStrategy;

import domain.MovieTicket;

import java.util.ArrayList;

public interface IFileBehaviour {

    void export(int orderNr, ArrayList<MovieTicket> tickets);

}
