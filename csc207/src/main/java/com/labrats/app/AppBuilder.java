package com.labrats.app;

import data_access.UserDataFile;
import view.*;

import data_access.UserData;

import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import data_access.FileTransactionDataAccessObject;
import entity.CommonTransactionFactory;
import entity.TransactionFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeViewModel;
import interface_adapter.add_expense.AddExpenseController;
import interface_adapter.add_expense.AddExpensePresenter;
import interface_adapter.add_expense.AddExpenseViewModel;
import use_case.add_expense.AddExpenseInteractor;
import use_case.add_expense.AddExpenseInputBoundary;
import use_case.add_expense.AddExpenseOutputBoundary;
import view.ViewManager;
import view.HomeView;
import view.AddExpenseView;


public class AppBuilder {
    private JPanel cards;
    private JFrame app;
    
    private UserData userData;
    private ViewSwitcher viewSwitcher;

    private HomeView homeView;
    private GoalsView goalsView;
    private AddGoalView addGoalView;

    public AppBuilder() {
        cards = new JPanel(new CardLayout());
        userData = new UserDataFile("testdata.csv");
        viewSwitcher = new ViewSwitcher(cards);
    }

    public AppBuilder addUserData() {
        if(homeView != null)
            homeView.setUserData(userData);
        // TODO
        // do user data stuff for other views
        goalsView.setUserData(userData);
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
//        var expenseView = new ExpenseHistoryView();
//        expenseView.setViewSwitcher(viewSwitcher);
//        viewSwitcher.add(ViewNames.expenseHistory, expenseView);
        return this;
    }

    public AppBuilder addAddGoalView() {
        addGoalView = new AddGoalView();
        addGoalView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.addGoal, addGoalView);
        return this;
    }

    public AppBuilder addGoalsView() {
        goalsView = new GoalsView();
        goalsView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.goals, goalsView);
        return this;
    }

    public JFrame build() {
        app = new JFrame("My Cool Finance App");
        app.add(cards);
        return app;
    }
}
