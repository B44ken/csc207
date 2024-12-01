package com.labrats.app;

import use_case.ExpenseHistoryController;
import use_case.goals.GoalListController;
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
    private GoalListView goalListView;

    public AppBuilder() {
        cards = new JPanel(new CardLayout());
        userData = new UserDataFileAccess("testdata.csv");
        viewSwitcher = new ViewSwitcher(cards);
        bottomButtons = new BottomButtons(viewSwitcher);
    }

    public AppBuilder addUserData() {
        homeView.setUserData(userData);
        incomeHistoryView.setUserData(this.userData);
        expenseHistoryView.setUserData(this.userData);
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
        // addIncomeView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.addIncome, addIncomeView);
        return this;
    }

    public AppBuilder addIncomeHistoryView() {
        incomeHistoryView = new IncomeHistoryView(viewSwitcher);
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
        var interactor = new ExpenseHistoryController(userData);
        expenseHistoryView = new ExpenseHistoryView(interactor);
        expenseHistoryView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.expenseHistory, expenseHistoryView);
        return this;
    }

    public AppBuilder addAddBudgetView() {
        //var controller = new ExpenseHistoryController(userData);
        //var expenseView = new ExpenseHistoryView(bottomButtons, controller);
        //viewSwitcher.add(ViewNames.expenseHistory, expenseView);

        return this;
    }

    public AppBuilder addAddGoalView() {
        var controller = new GoalListController(userData);
        var addGoalView = new GoalListView(bottomButtons, controller);
        viewSwitcher.add(ViewNames.addGoal, addGoalView);
        return this;
    }

    public AppBuilder addGoalsView() {
        var interactor = new GoalListController(userData);
        goalListView = new GoalListView(bottomButtons, interactor);
        goalListView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.goalList, goalListView);
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
