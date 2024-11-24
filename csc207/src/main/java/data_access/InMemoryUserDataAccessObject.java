package data_access;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import entity.Transaction;
import entity.TransactionFactory;
/**
 * DAO for user data implemented using a File to persist the data.
 */
public class InMemoryUserDataAccessObject {
/*
    private static final String HEADER = "name,amount,category,date";

    private final File csvFile;
    private final Map<String, Integer> headers = new HashMap<>();
    private final Map<String, Transaction> transactions = new HashMap<>();
    //private String currentTransaction;

    public FileTransactionDataAccessObject(String txtPath, TransactionHistory transactionFactory) throws IOException {

        txtFile = new File (txtPath);
        headers.put("name", 0);
        headers.put("amount", 1);
        headers.put("category", 2);
        headers.put("date", 3);

        if (txtFile.length() == 0) {
            save();
        }
        else {

            try (BufferedReader reader = new BufferedReader(new FileReader(txtFile))) {
                final String header = reader.readLine();

                if (!header.equals(HEADER)) {
                    throw new RuntimeException(String.format("header should be%n: %s%but was %n%s", HEADER, header));
                }

                String row;
                while ((row = reader.readLine()) != null) {
                    final String[] col = row.split(",");
                    final String name = String.valueOf(col[headers.get("name")]);
                    final double amount = Double.valueOf(col[headers.get("amount")]);
                    final String category = String.valueOf(col[headers.get("category")]);
                    final String date = String.valueOf(col[headers.get("date")]);
                    final Transaction transaction = transactionFactory.create(name, amount, category, date);
                    transactions.put(name, transaction);
                }
            }
        }
    }

    private void save() {
        final BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(txtFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (Transaction transaction : transactions.values()) {
                final String line = String.format("%d,%f,%s,%s",
                        transaction.getName(), transaction.getAmount(), transaction.getCategory(), transaction.getDate());
                writer.write(line);
                writer.newLine();
                System.out.println(line);
            }

            write.close();
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void save(Transaction transaction) {
        transactions.put(transaction.getName(), transaction);
        this.save();
    }

    @Override
    public boolean existsByName(String identifier) {
        //return accounts.containsKey(identifier);
        return false;
    }
*/
}
