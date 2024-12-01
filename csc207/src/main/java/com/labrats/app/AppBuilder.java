package com.labrats.app;


import entity.Expense;
import entity.GoalList;
import entity.IncomeFactory;
import interface_adapter.add_budget.AddBudgetController;
import interface_adapter.add_goal.AddGoalController;
import interface_adapter.add_income.AddIncomeController;
import interface_adapter.add_income.AddIncomePresenter;
import use_case.ExpenseHistoryController;
import use_case.AddExpenseController;
import use_case.add_budget.AddBudgetInteractor;
import use_case.add_income.AddIncomeInteractor;
import use_case.goals.GoalListController;
import use_case.history.BudgetHistoryController;

import interface_adapter.add_income.AddIncomeViewModel;
import interface_adapter.get_insight.GetInsightController;
import interface_adapter.get_insight.GetInsightViewModel;
import use_case.get_insight.GetInsightInteractor;
import use_case.ExpenseHistoryController;

import view.*;

import data_access.UserData;
import data_access.UserDataFileAccess;

import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppBuilder {
    private JPanel cards;
    private JFrame app;

    private UserData userData;
    private ViewSwitcher viewSwitcher;
    private BottomButtons bottomButtons;
    private final IncomeFactory incomeFactory = new IncomeFactory();

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

    public AppBuilder addHomeView() {
        homeView = new HomeView();
        homeView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.home, homeView);
        return this;
    }

    public AppBuilder addAddIncomeView() {
        addIncomeView = new AddIncomeView(viewSwitcher);
        // addIncomeView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.addIncome, addIncomeView);
        return this;
    }

    public AppBuilder addIncomeHistoryView() {
        incomeHistoryView = new IncomeHistoryView(viewSwitcher);
        viewSwitcher.add(ViewNames.incomeHistory, incomeHistoryView);
        return this;
    }


    public AppBuilder addAddIncomeUseCase() {
        final AddIncomePresenter presenter = new AddIncomePresenter();
        final AddIncomeInteractor interactor = new AddIncomeInteractor(userData, presenter, incomeFactory);
        final AddIncomeController controller = new AddIncomeController(interactor);
        addIncomeView.setAddIncomeController(controller);
//      viewSwitcher.add(ViewNames.addIncome, addIncomeView);
        return this;
    }

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
        var controller = new AddGoalController(viewSwitcher, userData);
        var goalsView = new AddGoalView(controller, viewSwitcher);
        goalsView.setViewSwitcher(viewSwitcher);
        goalsView.setUserData(userData);
        viewSwitcher.add(ViewNames.addGoal, goalsView);
        return this;
    }

    public AppBuilder addGoalsView() {
        var interactor = new GoalListController(userData);
        goalListView = new GoalListView(bottomButtons, interactor);
        goalListView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.goalList, goalListView);
        return this;
    }


    // TODO need to fix
    public AppBuilder addGetInsightView() {
        // GetInsightInteractor interactor = new GetInsightInteractor();
        GetInsightView getInsightView = new GetInsightView(bottomButtons, new GetInsightViewModel());
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
