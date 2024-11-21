package com.labrats.app;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.*;

import data_access.UserData;

import java.awt.CardLayout;

public class AppBuilder {
    private JPanel cards;
    private JFrame app;
    
    private UserData userData;
    private ViewSwitcher viewSwitcher;

    private HomeView homeView;

    public AppBuilder() {
        cards = new JPanel(new CardLayout());
        userData = new UserData("testdata.csv");
        viewSwitcher = new ViewSwitcher(cards);
    }

    public AppBuilder addUserData() {
        if(homeView != null)
            homeView.setUserData(userData);
        // TODO
        // do user data stuff for other views
        return this;
    }

    public AppBuilder addHomeView() {
        homeView = new HomeView();
        homeView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.home, homeView);
        return this;
    }

    public AppBuilder addIncomeHistoryView() {
        var incomeHistoryView = new IncomeHistoryView();
        viewSwitcher.add(ViewNames.incomeHistory, incomeHistoryView);
        return this;
    }

    public AppBuilder addExpenseView() {
        var expenseView = new ExpenseView();
        expenseView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.expenseHistory, expenseView);
        return this;
    }

    public JFrame build() {
        app = new JFrame("My Cool Finance App");
        app.add(cards);
        return app;
    }
}
