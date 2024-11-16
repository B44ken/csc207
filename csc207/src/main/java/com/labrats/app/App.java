package com.labrats.app;

import java.io.IOException;
import java.time.LocalDate;

import javax.swing.JFrame;

import data_access.ChartAPI;
import data_access.TxtImportExport;
import entity.Expense;
import entity.Income;
import entity.TransactionHistory;
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
        testApp();
        // var ab = new AppBuilder();
        // ab
        // .addHomeView()
        // .addHomeUseCase()
        // .addIncomeView()
        // .addIncomeUseCase()
        // .build()
        // .setVisible(true);
    }

    public static void testApp() {
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
