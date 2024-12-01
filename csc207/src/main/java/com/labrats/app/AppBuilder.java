package com.labrats.app;


import interface_adapter.add_budget.AddBudgetController;
import use_case.ExpenseHistoryController;
import use_case.AddExpenseController;
import use_case.add_budget.AddBudgetInteractor;
import use_case.history.BudgetHistoryController;

import interface_adapter.add_income.AddIncomeViewModel;
import use_case.ExpenseHistoryController;

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
    private AddIncomeView addIncomeView;
    private GetInsightView getInsightView;
    private ExpenseHistoryView expenseHistoryView;

    public AppBuilder() {
        cards = new JPanel(new CardLayout());
        userData = new UserDataFileAccess("testdata.csv");
        viewSwitcher = new ViewSwitcher(cards);
        bottomButtons = new BottomButtons(viewSwitcher);
    }

    public AppBuilder addHomeView() {
        homeView = new HomeView();
        homeView.setUserData(userData);
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
        incomeHistoryView = new IncomeHistoryView(viewSwitcher);
        incomeHistoryView.setUserData(this.userData);
        incomeHistoryView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.incomeHistory, incomeHistoryView);
        return this;
    }

    /*
    public AppBuilder addAddIncomeView() {
        addIncomeView = new AddIncomeView(new AddIncomeViewModel());
        addIncomeView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.addIncome, addIncomeView);
        return this;
    }
     */

    public AppBuilder addAddExpenseView() {
        var expenseView = new AddExpenseView();
        expenseView.setViewSwitcher(viewSwitcher);
        // expenseView.setAddExpenseController();
        expenseView.setUserData(userData);
        viewSwitcher.add(ViewNames.addExpense, expenseView);
        return this;
    }

    public AppBuilder addExpenseHistoryView() {
        var expenseController = new ExpenseHistoryController(userData);
        var budgetController = new BudgetHistoryController(userData);
        var expenseHistoryView = new ExpenseHistoryView(bottomButtons, expenseController, budgetController);
        expenseHistoryView.setUserData(this.userData);
        expenseHistoryView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.expenseHistory, expenseHistoryView);
        return this;
    }

    public AppBuilder addAddBudgetView() {
        var addBudgetController = new AddBudgetController(viewSwitcher, userData);
        var addBudgetView = new AddBudgetView(addBudgetController, viewSwitcher);
        addBudgetView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.addBudget, addBudgetView);
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
        viewSwitcher.switchTo(ViewNames.home);
        return app;
    }

}
