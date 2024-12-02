package com.labrats.app;

import java.time.LocalDate;

import javax.swing.JFrame;

import data_access.ChartImageFactory;
import data_access.UserDataFileAccess;

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
                .addExpenseHistoryView()
                .addAddExpenseView()
                .addIncomeHistoryView()
                .addAddIncomeView()
                .addGoalListView()
                .addAddGoalView()
                .addAddBudgetView()
                .addAddIncomeUseCase()
                .addAddBudgetUseCase()
                .addAddExpenseUseCase()
                .addAddGoalUseCase()
                .build();
        application.pack();
        application.setVisible(true);
    }

    public static void runChartDemo() {
        // var test = FileAccess.importData("testdata.csv");
        var test = new UserDataFileAccess("testdata.csv");

        var cif = new ChartImageFactory(test.getHistory());
        var chart = cif.createImage(LocalDate.of(2024, 10, 1), LocalDate.of(2024, 10, 7));
        chart.setVisible(true);

        var frame = new JFrame();
        frame.getContentPane().add(chart);
        frame.pack();
        frame.setVisible(true);
    }
}
