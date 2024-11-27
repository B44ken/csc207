package com.labrats.app;

import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JFrame;

import data_access.FileAccess;

/**
 * App class.
 */
public class App {
    /**
     * Main method for this project.
     * 
     * @param args argument.
     */
    public static void main(String[] args) {
        runWholeApp();
        // runChartDemo();
    }

    public static void runWholeApp() {
        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                .addHomeView()
                // .addIncomeHistoryView()
                .addAddExpenseView()
                .addUserData()
                .addGoalsView()
                .addExpenseHistoryView()
                .addAddIncomeView()
                // .addAddExpenseView()
                .addAddBudgetView()
                .addAddGoalView()
                // .addGoalsView()
                // .addChangePasswordUseCase()
                // .addLogoutUseCase()
                .build();
        application.pack();
        application.setVisible(true);
    }

    public static void runChartDemo() {
        var test = FileAccess.importData("testdata.csv");

        var cif = new data_access.ChartImageFactory(test);
        var chart = cif.createImage(LocalDate.of(2024, 10, 1), LocalDate.of(2024, 10, 7));
        chart.setVisible(true);

        var frame = new JFrame();
        frame.getContentPane().add(chart);
        frame.pack();
        frame.setVisible(true);
    }
}
