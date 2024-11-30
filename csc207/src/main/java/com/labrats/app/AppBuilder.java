package com.labrats.app;

import use_case.ExpenseHistoryController;
import use_case.AddExpenseController;
import view.*;

import data_access.UserData;
import data_access.UserDataFileAccess;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppBuilder {
    private JPanel cards;
    private JFrame app;

    private UserData userData;
    private ViewSwitcher viewSwitcher;
    private BottomButtons bottomButtons;

    private HomeView homeView;
    private IncomeHistoryView incomeHistoryView;
    private GetInsightView getInsightView;


    public AppBuilder() {
        cards = new JPanel(new CardLayout());
        userData = new UserDataFileAccess("testdata.csv");
        viewSwitcher = new ViewSwitcher(cards);
        bottomButtons = new BottomButtons(viewSwitcher);
    }

    public AppBuilder addUserData() {
        homeView.setUserData(userData);
        incomeHistoryView.setUserData(this.userData);
        // getInsightView.setUserData(this.userData);
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

    public AppBuilder addAddIncomeView() {
        var addIncomeView = new AddIncomeView();
        addIncomeView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.addIncome, addIncomeView);
        return this;
    }

    public AppBuilder addIncomeHistoryView() {
        incomeHistoryView = new IncomeHistoryView(viewSwitcher);
        viewSwitcher.add(ViewNames.incomeHistory, incomeHistoryView);
        return this;
    }

    public AppBuilder addAddExpenseView() {
        var controller = new AddExpenseController(viewSwitcher, userData);
        var view = new AddExpenseView(controller, viewSwitcher);
        viewSwitcher.add(ViewNames.addExpense, view);
        return this;
    }

    public AppBuilder addExpenseHistoryView() {
        var controller = new ExpenseHistoryController(userData);
        var expenseHistoryView = new ExpenseHistoryView(bottomButtons, controller);
        expenseHistoryView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.expenseHistory, expenseHistoryView);
        return this;
    }

    public AppBuilder addAddBudgetView() {
        return this;
    }

    public AppBuilder addAddGoalView() {
        var addGoalView = new AddGoalView();
        addGoalView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.addGoal, addGoalView);
        return this;
    }

    public AppBuilder addGoalsView() {
        var goalsView = new GoalsView();
        goalsView.setUserData(userData);
        goalsView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.goalList, goalsView);
        return this;
    }

    public AppBuilder addGetInsightView() {
        getInsightView = new GetInsightView();
        getInsightView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.getInsight, getInsightView);
        return this;
    }

    public JFrame build() {
        app = new JFrame("My Cool Finance App");
        app.add(cards);
        viewSwitcher.switchTo(ViewNames.expenseHistory);
        return app;
    }
}
