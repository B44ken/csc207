package com.labrats.app;

import java.util.Date;

import entity.Transaction;
import entity.TransactionHistory;
import javax.swing.JFrame;
import view.AppBuilder;

public class App {
    public static void main(String[] args) {
        var budget = new TransactionHistory();

        var salary = new Transaction(3000, "Job", new Date(2024, 10, 10));
        budget.add(salary);

        var nextMonthSalary = new Transaction(3000, "Job", new Date(2024, 11, 10));
        budget.add(nextMonthSalary);

        System.out.println("Net budget " + Integer.toString(budget.getAmountBetween(new Date(2024, 10, 1), new Date(2024, 10, 31))));

        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                                             .addHomeView()
                                             .addHomeUseCase()
                                             .build();
        application.pack();
        application.setVisible(true);
    }
}
