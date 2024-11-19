package com.labrats.app;

import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JFrame;

import data_access.TxtImportExport;

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
                .addHomeUseCase()
                // .addIncomeHistoryView()
                .addExpenseView()
                .build();
                // .addAddIncomeView()
                // .addAddExpenseView()
                // .addExpenseHistoryView()
                // .addGoalView()
                // .addBudgetView()
                // .addChangePasswordUseCase()
                // .addLogoutUseCase()
        application.pack();
        application.setVisible(true);
    }

    public static void runChartDemo() {
        var test = TxtImportExport.importData("testdata.csv");

        var cif = new data_access.ChartImageFactory(test);
        var chart = cif.createImage(LocalDate.of(2024, 10, 1), LocalDate.of(2024, 10, 7));
        chart.setVisible(true);

        var frame = new JFrame();
        frame.getContentPane().add(chart);
        frame.pack();
        frame.setVisible(true);
    }
}
