package com.labrats.app;

import javax.swing.*;

public class AppAddIncome {
    /**
     * AddIncome Individual view
     * @param args argument.
     */
    public static void main(String[] args) {
        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                .addAddIncomeView()
                .addAddIncomeUseCase()
                .build();
        application.pack();
        application.setVisible(true);
    }
}

