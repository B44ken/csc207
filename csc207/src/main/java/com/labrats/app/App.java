package com.labrats.app;

import java.time.LocalDate;

import javax.swing.JFrame;
import javax.swing.JLabel;

import data_access.ChartImageFactory;
import data_access.UserDataFileAccess;

/**
 * App class.
 */
public class App {
    /**
     * Main method for this project.
     * @param args argument.
     */
    public static void main(String[] args) {
        runWholeApp();
    }

    /**
     * Main method for running the whole app.
     */
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
                .addReportView()
                .addAddBudgetView()
                .addAddIncomeUseCase()
                .addAddBudgetUseCase()
                .addAddExpenseUseCase()
                .addReportUseCase()
                .addAddGoalUseCase()
                .addGetInsightView()
                .addGetInsightUseCase()
                .build();
        application.pack();
        application.setVisible(true);
    }

    /**
     * Demo for running chart.
     */
    public static void runChartDemo() {
        // var test = FileAccess.importData("testdata.csv");
        final UserDataFileAccess test = new UserDataFileAccess("testdata.csv");

        final ChartImageFactory cif = new ChartImageFactory(test.getHistory());
        final JLabel chart = cif.createImage(LocalDate.of(2024, 10, 1), LocalDate.of(2024, 10, 7));
        chart.setVisible(true);

        final JFrame frame = new JFrame();
        frame.getContentPane().add(chart);
        frame.pack();
        frame.setVisible(true);
    }
}
