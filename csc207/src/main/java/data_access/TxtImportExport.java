package data_access;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.Date;

import entity.Transaction;
import entity.TransactionHistory;

public class TxtImportExport {
    public static TransactionHistory importData(String path) {
        var history = new TransactionHistory();
        String fileContent;
        try {
            fileContent = Files.readString(Path.of(path));
        } catch (Exception err) {
            throw new RuntimeException("File not found");
        }

        var lines = fileContent.split("\n");
        for (var line : lines) {
            var parts = line.split(",");
            var entry = new Transaction(
                "Transaction",
                0.0,
                "Category",
                new Date(2024, 1, 1)
            );
            history.add(entry);
        }

        return history;
    }

    public static void exportData(TransactionHistory history, String path) {
        var sb = new StringBuilder();
        for (var t : history.history) {
            sb.append(t.amount);
            sb.append(",");
            sb.append(t.category);
            sb.append(",");
            sb.append(t.date);
            sb.append("\n");
        }
        var data = sb.toString();
        try {
            var file = new FileWriter(new File(path));
            file.write(data);
            file.close();
        } catch (Exception err) {
            throw new RuntimeException("File not found");
        }
    }
}