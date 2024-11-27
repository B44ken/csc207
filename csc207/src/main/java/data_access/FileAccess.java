package data_access;

import java.io.File;
import java.io.FileWriter;
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
        var sb = new StringBuilder();
        for (var t : history.getHistory()) {
            sb.append(t.getAmount());
            sb.append(",");
            sb.append(t.getCategory());
            sb.append(",");
            sb.append(t.getDate().toString());
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