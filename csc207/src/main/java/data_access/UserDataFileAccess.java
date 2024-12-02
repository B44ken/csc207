package data_access;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entity.Budget;
import entity.Expense;
import entity.Goal;
import entity.Income;
import entity.Transaction;

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
                var target = row.get(0);
                var amount = Double.parseDouble(row.get(1));
                var targetDate = LocalDate.parse(row.get(3));
                var entry = new Goal(target, amount, targetDate);
                goals.add(entry );
            } else {
                throw new RuntimeException("Invalid type: " + type);
            }
        }
    }

    public String serializeBudget(Budget budget) {
        // amount,name,category,date,type
        return String.format(
            "%s,,%s,,budget\n",
            budget.getAmount(),
            budget.getCategoryName()
        );
    }

    public String serializeGoal(Goal goal) {
        return String.format(
            "%s,%s,,%s,goal\n",
            goal.getAmount(), goal.getTarget(), goal.getTargetDate()
        );
    }

    public String serializeTransaction(Transaction txn) {
        return String.format(
            "%s,%s,%s,%s,%s\n",
            txn.getAmount(),
            txn.getName(),
            txn.getCategory(),
            txn.getDate(),
            txn.getClass().getSimpleName().toLowerCase()
        );
    }

    public String serializeSomething(Object s) {
        if(s instanceof Transaction)
            return serializeTransaction((Transaction) s);
        else if(s instanceof Goal)
            return serializeGoal((Goal) s);
        else if(s instanceof Budget)
            return serializeBudget((Budget) s);
        return "uh oh";
    }

    public void save() {
        try {
            var file = new PrintWriter(filePath);
            for(var g : getGoals().getList())
                file.write(serializeGoal(g));
            for(var b : getBudgets().getList())
                file.write(serializeBudget(b));
            for(var t : getHistory().getHistory())
                file.write(serializeTransaction(t));
            file.flush();
        } catch (FileNotFoundException x) {
            JOptionPane.showMessageDialog(null, "couldnt find file " + filePath);
        }
    }
}