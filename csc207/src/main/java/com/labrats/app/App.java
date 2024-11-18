package com.labrats.app;

import javax.swing.*;

/**
 * App class.
 */
public class App {
    /**
     * Main method for this project.
     * @param args argument.
     */
    public static void main(String[] args) {
        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                .addAddIncomeView()
                .addAddExpenseView()
                .addExpenseView()
                .addIncomeView()
                .addHomeView()
                .addGoalView()
                .addBudgetView()
                .addChangePasswordUseCase()
                .addLogoutUseCase()
                .build();

        application.pack();
        application.setVisible(true);
    }

}
