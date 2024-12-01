package com.labrats.app;

import interface_adapter.add_income.AddIncomeViewModel;
import interface_adapter.get_insight.GetInsightController;
import interface_adapter.get_insight.GetInsightViewModel;
import use_case.get_insight.GetInsightInteractor;
import use_case.history.ExpenseHistoryController;
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
    private BottomButtons bottomButtons;

    private HomeView homeView;
    private IncomeHistoryView incomeHistoryView;
    private AddIncomeView addIncomeView;
    private GetInsightView getInsightView;
    private ExpenseHistoryView expenseHistoryView;

    public AppBuilder() {
        cards = new JPanel(new CardLayout());
        userData = new UserDataFile("testdata.csv");
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
        // incomeHistoryView.setViewSwitcher(viewSwitcher);
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
        expenseHistoryView = new ExpenseHistoryView();
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
        var addGoalView = new AddGoalView();
        addGoalView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.addGoal, addGoalView);
        return this;
    }

    public AppBuilder addGoalsView() {
        var goalsView = new GoalsView();
        goalsView.setViewSwitcher(viewSwitcher);
        viewSwitcher.add(ViewNames.goalList, goalsView);
        return this;
    }


    //need to fix
    public AppBuilder addGetInsightView() {
//        GetInsightInteractor interactor = new GetInsightInteractor();
//        GetInsightView getInsightView = new GetInsightView(bottomButtons, new GetInsightViewModel());
//        getInsightView.setViewSwitcher(viewSwitcher);
//        viewSwitcher.add(ViewNames.getInsight, getInsightView);
        return this;
    }

    public JFrame build() {
        app = new JFrame("My Cool Finance App");
        app.add(cards);
        viewSwitcher.switchTo(ViewNames.home);
        return app;
    }

}
