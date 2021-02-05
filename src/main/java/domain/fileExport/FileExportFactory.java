package domain.fileExport;

import domain.fileExport.exportFileTypes.ToJsonFile;
import domain.fileExport.exportFileTypes.ToTextFile;

public class FileExportFactory {

    public IFileExporter getFileExporter(TicketExportFormat ticketExportFormat) {
        if (ticketExportFormat == null)
            return null;

        if (ticketExportFormat.equals(TicketExportFormat.JSON)) {
            return new ToJsonFile();
        } else if (ticketExportFormat.equals(TicketExportFormat.PLAINTEXT)) {
            return new ToTextFile();
        }

        return null;
    }

}
