package data_access;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.lang.model.type.UnionType;

import entity.Budget;
import entity.Expense;
import entity.Goal;
import entity.Income;
import entity.Transaction;
import entity.TransactionHistory;

public class UserDataFileAccess extends UserData {
    private ArrayList<ArrayList<String>> csv;
    private String filePath;

    public UserDataFileAccess(String file) {
        super();
        filePath = file;
        csv = readFile();
        parseData();
    }

    private ArrayList<ArrayList<String>> readFile() {
        String fileContent;
        try {
            fileContent = Files.readString(Path.of(filePath));
        } catch (Exception err) {
            throw new RuntimeException("File not found");
        }

        var lines = fileContent.split("\n");
        var csv = new ArrayList<ArrayList<String>>();
        for (var line : lines) {
            var parts = line.split(",");
            var row = new ArrayList<String>();
            for (var part : parts)
                row.add(part);
            csv.add(row);
        }
        csv.remove(0);
        return csv;
    }

    private void parseData() {
        for (var row : csv) {
            var type = row.get(4);
            if (type.equals("income")) {
                var amount = Double.parseDouble(row.get(0));
                var name = row.get(1);
                var category = row.get(2);
                var date = LocalDate.parse(row.get(3));
                var entry = new Income(name, amount, category, date);
                history.add(entry);
            } else if (type.equals("expense")) {
                var amount = Double.parseDouble(row.get(0));
                var name = row.get(1);
                var category = row.get(2);
                var date = LocalDate.parse(row.get(3));
                var entry = new Expense(name, amount, category, date);
                history.add(entry);
            } else if (type.equals("transaction")) {
                var amount = Double.parseDouble(row.get(0));
                var name = row.get(1);
                var category = row.get(2);
                var date = LocalDate.parse(row.get(3));
                var entry = new Transaction(name, amount, category, date);
                history.add(entry);
            } else if (type.equals("budget")) {
                var amount = Double.parseDouble(row.get(0));
                var category = row.get(2);
                var entry = new Budget(category, amount);
                budgets.add(entry);
            } else if (type.equals("goal")) {
                var amount = Double.parseDouble(row.get(0));
                var name = row.get(1);
                var date = LocalDate.parse(row.get(3));
                var entry = new Goal(name, amount, date);
                goals.add(entry);
            } else {
                throw new RuntimeException("Invalid type: " + type);
            }
        }
    }

    public void save(TransactionHistory history, String path) {
        // TODO
        //copied previous code from exportData to save for current testing
        try {
            var file = new FileWriter(new File(path));
            file.write(String.format("amount, name, category, date, type\n"));
            for (var t: history.getHistory())
                file.write(
                        String.format("%f,%s,%,%s,%s\n",
                                t.getAmount(),
                                t.getName(),
                                t.getCategory(),
                                t.getDate().toString(),
                                t.getClass().getSimpleName().toLowerCase()
                        ));
            file.close();
        }  catch (IOException err) {
            throw new RuntimeException("File not found");
        }
    }
}