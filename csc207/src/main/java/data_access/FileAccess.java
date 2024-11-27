package data_access;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

import entity.Expense;
import entity.Income;
import entity.Transaction;
import entity.TransactionHistory;

public class FileAccess {
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
            if (line.equals(lines[0]))
                continue;

            var parts = line.split(",");

            var amount = Double.parseDouble(parts[0]);
            var name = parts[1];
            var category = parts[2];
            var date = LocalDate.parse(parts[3]);
            var type = parts[4];

            if (type.equals("income")) {
                var entry = new Income(name, amount, category, date);
                history.add(entry);
            } else if (type.equals("expense")) {
                var entry = new Expense(name, amount, category, date);
                history.add(entry);
            } else if (type.equals("transaction")) {
                var entry = new Transaction(name, amount, category, date);
                history.add(entry);
            } else {
                throw new RuntimeException("Invalid type");
            }
        }
        return history;
    }

    public static void exportData(TransactionHistory history, String path) {
        try {
            var file = new FileWriter(new File(path));
            for (var t : history.getHistory())
                file.write(
                    String.format("%f,%s,%s,%s,%s\n",
                    t.getAmount(),
                    t.getName(),
                    t.getCategory(),
                    t.getDate().toString(),
                    t.getClass().getSimpleName().toLowerCase()
                ));
            file.close();
        } catch (IOException err) {
            throw new RuntimeException("File not found");
        }
    }
}