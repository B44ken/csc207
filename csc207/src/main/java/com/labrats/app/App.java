package com.labrats.app;

import view.AppBuilder;

/**
 * App class.
 */
public class App {
    /**
     * Main method for this project.
     * @param args argument.
     */
    public static void main(String[] args) {
        var ab = new AppBuilder();
        ab
        .addHomeView()
        .addHomeUseCase()
        .addIncomeView()
        .addIncomeUseCase()
        .build()
        .setVisible(true);
    }
}
