package com.labrats.app;

import entity.Income;
import interface_adapter.add_income.AddIncomeViewModel;
import view.*;

import data_access.UserData;
import data_access.UserDataFile;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppBuilder {
    private JPanel cards;
    private JFrame app;
    
    private UserData userData;
    private ViewSwitcher viewSwitcher;

    private HomeView homeView;
    private IncomeHistoryView incomeHistoryView;
    private AddIncomeView addIncomeView;
    private GetInsightView getInsightView;

    public AppBuilder() {
        cards = new JPanel(new CardLayout());
        userData = new UserDataFile("testdata.csv");
        viewSwitcher = new ViewSwitcher(cards);
    }

    public AppBuilder addUserData() {
        homeView.setUserData(userData);
        incomeHistoryView.setUserData(this.userData);
        getInsightView.setUserData(this.userData);
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
        // addIncomeView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.addIncome, addIncomeView);
        return this;
    }

    public AppBuilder addIncomeHistoryView() {
        incomeHistoryView = new IncomeHistoryView();
        incomeHistoryView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.incomeHistory, incomeHistoryView);
        return this;
    }

    public AppBuilder addAddIncomeView() {
        addIncomeView = new AddIncomeView(new AddIncomeViewModel());
        addIncomeView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.addIncome, addIncomeView);
        return this;
    }

    public AppBuilder addAddExpenseView() {
        var expenseView = new AddExpenseView();
        expenseView.setViewSwitcher(viewSwitcher);
        // expenseView.setAddExpenseController();
        viewSwitcher.add(ViewNames.addExpense, expenseView);
        return this;
    }

    public AppBuilder addExpenseHistoryView() {
        var expenseHistoryView = new ExpenseHistoryView();
        expenseHistoryView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.expenseHistory, expenseHistoryView);
        return this;
    }

    public AppBuilder addAddBudgetView() {
        var budgetView = new AddBudgetView();
        budgetView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.addBudget, budgetView);
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
        goalsView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.goals, goalsView);
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
        return app;
    }

}
