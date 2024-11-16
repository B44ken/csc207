package data_access;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Date;

import entity.Expense;
import entity.Income;
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
            var entry = new Income(
                parts[1],
                Double.parseDouble(parts[0]),
                "category",
                LocalDate.parse(parts[2])
            );
            history.add(entry);
        }

        return history;
    }

    public static void exportData(TransactionHistory history, String path) {
        var sb = new StringBuilder();
        for (var t : history.getHistory()) {
            sb.append(t.getAmount());
            sb.append(",");
            sb.append(t.getCategory());
            sb.append(",");
            sb.append(t.getDate());
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

    // cursed
    static LocalDate makeDate(int year, int month, int day) {
        return LocalDate.of(year, month, day);
    }
}