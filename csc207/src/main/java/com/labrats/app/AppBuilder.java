package com.labrats.app;


import entity.BudgetFactory;
import entity.IncomeFactory;
import interface_adapter.add_budget.AddBudgetPresenter;
import interface_adapter.home.HomeChartController;
import interface_adapter.home.HomeValuesController;
import interface_adapter.add_budget.AddBudgetController;
import interface_adapter.add_goal.AddGoalController;
import interface_adapter.add_income.AddIncomeController;
import interface_adapter.add_income.AddIncomePresenter;
import interface_adapter.income_history.IncomeHistoryController;
import interface_adapter.ExpenseHistoryController;
import use_case.add_budget.AddBudgetInteractor;
import use_case.add_income.AddIncomeInteractor;
import use_case.goals.GoalListController;
import use_case.history.BudgetHistoryController;

import interface_adapter.get_insight.GetInsightViewModel;

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
    private final IncomeFactory incomeFactory = new IncomeFactory();
    private final BudgetFactory budgetFactory = new BudgetFactory();

    private HomeView homeView;
    private IncomeHistoryView incomeHistoryView;
    private AddIncomeView addIncomeView;
    private AddExpenseView addExpenseView;
    private GetInsightView getInsightView;
    private AddBudgetView addBudgetView;
    private ExpenseHistoryView expenseHistoryView;
    private GoalListView goalListView;


    public AppBuilder() {
        cards = new JPanel(new CardLayout());
        userData = new UserDataFileAccess("testdata.csv");
        viewSwitcher = new ViewSwitcher(cards);
        bottomButtons = new BottomButtons(viewSwitcher);
    }

    public AppBuilder addHomeView() {
        HomeValuesController valuesController = new HomeValuesController(userData);
        HomeChartController chartController = new HomeChartController(userData);
        homeView = new HomeView(valuesController, chartController);
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
        IncomeHistoryController controller = new IncomeHistoryController(userData);
        incomeHistoryView = new IncomeHistoryView(controller);
        incomeHistoryView.setViewSwitcher(viewSwitcher);
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
        addExpenseView = new AddExpenseView(expenseHistoryView);
        addExpenseView.setViewSwitcher(viewSwitcher);
        // expenseView.setAddExpenseController();
        addExpenseView.setUserData(userData);
        viewSwitcher.add(ViewNames.addExpense, addExpenseView);
        return this;
    }

    public AppBuilder addExpenseHistoryView() {
        var expenseController = new ExpenseHistoryController(userData);
        var budgetController = new BudgetHistoryController(userData);
        expenseHistoryView = new ExpenseHistoryView(bottomButtons, expenseController, budgetController);
        expenseHistoryView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.expenseHistory, expenseHistoryView);
        return this;
    }

    public AppBuilder addAddBudgetView() {
        addBudgetView = new AddBudgetView(viewSwitcher);
        // addIncomeView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.addBudget, addBudgetView);
        return this;
    }

    public AppBuilder addAddBudgetUseCase() {
        final AddBudgetPresenter presenter = new AddBudgetPresenter();
        final AddBudgetInteractor interactor = new AddBudgetInteractor(userData, presenter, budgetFactory);
        final AddBudgetController controller = new AddBudgetController(interactor);
        addBudgetView.setAddBudgetController(controller);
//      viewSwitcher.add(ViewNames.addIncome, addIncomeView);
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
