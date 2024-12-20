package data_access;

import java.io.IOError;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entity.TransactionHistory;

// class to create java swing chart images
public class ChartImageFactory {
    private TransactionHistory history;
    // ChartAPI (in data_access) does the API stuff
    private ChartAPI api;

    // nothing special going on here
    public ChartImageFactory(TransactionHistory history) {
        this.history = history;
        this.api = new ChartAPI();
    }

    // create an image that can be added to a view
    public JLabel createImage(LocalDate start, LocalDate end) {
        byte[] image = api.fetchImage(history, start, end); // method of ChartAPI
        return new JLabel(new ImageIcon(image));
    }

    public JLabel createIncomeImage(LocalDate start, LocalDate end) {
        byte[] image = api.fetchImage(history.getAllIncomes(), start, end); // method of ChartAPI
        return new JLabel(new ImageIcon(image));
    }

    public JLabel createExpenseImage(LocalDate start, LocalDate end) {
        byte[] image = api.fetchImage(history.getAllExpenses(), start, end);
        return new JLabel(new ImageIcon(image));
    }

    public JLabel createQRCode () {
        return new JLabel(api.fetchQRCode());

    }
}