package domain.fileExport;

import domain.MovieTicket;

import java.util.ArrayList;

public interface IFileExporter {

    void export(int orderNr, ArrayList<MovieTicket> tickets);

}
