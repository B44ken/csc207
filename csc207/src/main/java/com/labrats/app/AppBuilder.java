package com.labrats.app;


import entity.*;
import interface_adapter.GoalListController;
import interface_adapter.add_budget.AddBudgetPresenter;
import interface_adapter.add_expense.AddExpenseController;
import interface_adapter.add_expense.AddExpensePresenter;
import interface_adapter.home.HomeChartController;
import interface_adapter.home.HomeValuesController;
import interface_adapter.add_budget.AddBudgetController;
import interface_adapter.add_goal.AddGoalController;
import interface_adapter.add_income.AddIncomeController;
import interface_adapter.add_income.AddIncomePresenter;
import interface_adapter.income_history.IncomeHistoryController;
import interface_adapter.ExpenseHistoryController;
import use_case.add_budget.AddBudgetInteractor;
import use_case.add_expense.AddExpenseInteractor;
import use_case.add_goal.AddGoalInteractor;
import use_case.add_income.AddIncomeInteractor;
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
    private final ExpenseFactory expenseFactory = new ExpenseFactory();
    private final BudgetFactory budgetFactory = new BudgetFactory();
    private final GoalFactory goalFactory = new GoalFactory();

    private HomeView homeView;
    private IncomeHistoryView incomeHistoryView;
    private AddIncomeView addIncomeView;
    private AddExpenseView addExpenseView;
    private AddBudgetView addBudgetView;
    private AddGoalView addGoalView;
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
        addExpenseView = new AddExpenseView(viewSwitcher);
        viewSwitcher.add(ViewNames.addExpense, addExpenseView);
        return this;
    }

    public AppBuilder addExpenseHistoryView() {
        ExpenseHistoryController controller = new ExpenseHistoryController(userData);
        BudgetHistoryController controller1 = new BudgetHistoryController(userData);
        expenseHistoryView = new ExpenseHistoryView(bottomButtons, controller, controller1);
        expenseHistoryView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.expenseHistory, expenseHistoryView);
        return this;
    }

    public AppBuilder addAddExpenseUseCase() {
        final AddExpensePresenter presenter = new AddExpensePresenter(viewSwitcher);
        final AddExpenseInteractor interactor = new AddExpenseInteractor(userData, presenter, expenseFactory);
        final AddExpenseController controller = new AddExpenseController(interactor);
        addExpenseView.setAddExpenseController(controller);
//      viewSwitcher.add(ViewNames.addIncome, addIncomeView);
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
        addGoalView = new AddGoalView(viewSwitcher);
        viewSwitcher.add(ViewNames.addGoal, addGoalView);
        return this;
    }

    public AppBuilder addGoalListView() {
        GoalListController controller = new GoalListController(userData);
        goalListView = new GoalListView(controller);
        goalListView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.goalList, goalListView);
        return this;
    }

    public AppBuilder addAddGoalUseCase() {
        final AddGoalInteractor interactor = new AddGoalInteractor(userData, goalFactory);
        final AddGoalController controller = new AddGoalController(interactor);
        addGoalView.setAddGoalController(controller);
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
