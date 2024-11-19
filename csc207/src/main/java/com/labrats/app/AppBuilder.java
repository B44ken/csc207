package com.labrats.app;

import data_access.InMemoryUserDataAccessObject;
import interface_adapter.add_budget.AddBudgetViewModel;
import interface_adapter.add_expense.AddExpenseController;
import interface_adapter.add_income.AddIncomePresenter;
import interface_adapter.income_history.IncomeHistoryViewModel;
import use_case.add_goal.AddGoalInputData;
import use_case.add_income.AddIncomeInteractor;
import use_case.add_income.AddIncomeOutputBoundary;
import view.*;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import interface_adapter.ViewManagerModel;
import interface_adapter.home.HomeController;
import interface_adapter.home.HomePresenter;
import interface_adapter.home.HomeViewModel;
import interface_adapter.add_expense.AddExpenseController;
import interface_adapter.add_expense.AddExpensePresenter;
import interface_adapter.add_expense.AddExpenseViewModel;
import use_case.home.HomeInteractor;
import use_case.home.HomeInputBoundary;
import use_case.home.HomeOutputBoundary;
import use_case.add_expense.AddExpenseInteractor;
import use_case.add_expense.AddExpenseOutputBoundary;
import view.ViewManager;
import view.HomeView;
import view.AddExpenseView;
import interface_adapter.add_income.AddIncomeViewModel;
import use_case.add_income.AddIncomeInputBoundary;
import use_case.add_income.AddIncomeInputData;
import view.AddIncomeView;

public class AppBuilder {
    public final JPanel cardPanel = new JPanel();
    public final CardLayout cardLayout = new CardLayout();
    // private final UserFactory userFactory = newCommonUserFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private final InMemoryUserDataAccessObject userDataAccessObject = new InMemoryUserDataAccessObject();

    private HomeView homeView;
    private HomeViewModel homeViewModel;

    private IncomeHistoryView incomeHistoryView;
    private IncomeHistoryViewModel incomeHistoryViewModel;
    private ExpenseHistoryViewModel expenseHistoryViewModel;
    private ExpenseHitoryView expenseHistoryView;
    private AddIncomeView addIncomeView;
    private AddIncomeViewModel addIncomeViewModel;
    private AddExpenseView addExpenseView;
    private AddExpenseViewModel addExpenseViewModel;
    private AddGoalView addGoalView;
    private AddGoalViewModel addGoalViewModel;
    private AddBudgetView addBudgetView;
    private AddBudgetViewModel addBudgetViewModel;
    // private GetInsightView;
    // private GetInsightViewModel;

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
        viewManager.setVisible(true);
    }

    /**
     * Adds the Home View to the Application.
     * @return this builder
     */
    public AppBuilder addHomeView() {
        homeViewModel = new HomeViewModel();
        homeView = new HomeView(homeViewModel);
        cardPanel.add(homeView, homeView.getViewName());
//        viewManager.addView(homeView.getViewName(), homeView);
        return this;
    }

    /**
     * Adds Income View to the Application.
     * @return this builder
     */
    public AppBuilder addIncomeHistoryView() {
//        should call to API in above line
        incomeHistoryViewModel = new IncomeHistoryViewModel();
        incomeHistoryView = new IncomeHistoryView(incomeHistoryViewModel, incomeHistoryController);
        cardPanel.add(incomeHistoryView, incomeHistoryView.getViewName());
//        addIncomeHistoryView.setVisible(true);
//        viewManager.addView(addIncomeHistoryView.getViewName(), addIncomeHistoryView);
        return this;
    }

    /**
     * Adds Expense History View to the Application.
     * @return this builder
     */
    public AppBuilder addExpenseHistoryView() {
        expenseHistoryViewModel = new ExpenseHistoryViewModel();
        // shouldn't need a controller for ExpHistoryView:
        // there is no input data.. but there is actionperformed and property change!
        expenseHistoryView = new ExpenseHistoryView(expenseHistoryViewModel, expenseHistoryController);
        cardPanel.add(addIncomeView, addIncomeView.getViewName());
        return this;
    }


    /**
     * Adds Add Budget View to the Application.
     * @return this builder
     */
    public AppBuilder addAddBudgetView() {
        addBudgetViewModel = new AddBudgetViewModel();
        addBudgetView = new AddBudgetView(addBudgetViewModel);
        cardPanel.add(addBudgetView, addBudgetView.getViewName());
        return this;
    }

    /**
     * Adds Add Income View to the Application.
     * @return this builder
     */
    public AppBuilder addGoalView() {
        addGoalViewModel = new AddGoalViewModel();
        addGoalView = new AddGoalView(addGoalViewModel);
        cardPanel.add(addGoalView, addGoalView.getViewName());
        return this;
    }

    /**
     * Adds Add Income View to the Application.
     * @return this builder
     */
    public AppBuilder addAddIncomeView() {
        addAddIncomeViewModel = new AddIncomeViewModel();
        addAddIncomeView = new AddIncomeView(addIncomeViewModel, addIncomeController);
        cardPanel.add(addIncomeView, addIncomeView.getViewName());
        return this;
    }

    /**
     * Adds Add Expense View to the Application.
     * @return this builder
     */
    public AppBuilder addAddExpenseView() {
        addExpenseViewModel = new AddExpenseViewModel();
        addExpenseView = new AddExpenseView(addExpenseViewModel);
        cardPanel.add(addExpenseView, addExpenseView.getViewName());
        return this;
    }


    /**
     * Adds Add Goal View to the Application.
     * @return this builder
     */
    public AppBuilder addAddGoalView() {
        AddGoalInputData inputData = new AddGoalInputData(null, 0, null);
//        should call to API in above line
        addGoalViewModel = new AddGoalViewModel();
        addGoalView = new AddGoalView(addGoalViewModel, addGoalController);
        cardPanel.add(addGoalView, addGoalView.getViewName());
        return this;
    }


    /**
     * Adds Add Income Use Case to the application
     * @return this builder
     */
    public AppBuilder addAddIncomeUseCase() {
        final AddIncomeOutputBoundary addIncomeOutputBoundary = new AddIncomePresenter(viewManagerModel,
                addIncomeViewModel, addIncomeViewModel);
        final AddIncomeInputBoundary userAddExpenseInteractor = new AddIncomeInteractor(
                userDataAccessObject, addExpenseOutputBoundary, expenseFactory);

        final AddExpenseController controller = new AddExpenseController(userAddExpenseInteractor);
        addExpenseView.setAddExpenseController(controller);
        return this;
    }

    /**
     * Adds Add Expense Use Case to the application
     * @return this builder
     */
    public AppBuilder addAddExpenseUseCase() {
        final AddExpenseOutputBoundary addExpenseOutputBoundary = new AddExpensePresenter(viewManagerModel,
                addExpenseViewModel, homeViewModel);
        final AddExpenseInputBoundary addExpenseUseCaseInteractor = new AddExpenseInteractor(addExpenseOutputBoundary);

        final AddExpenseController controller = new AddExpenseController(addExpenseUseCaseInteractor);
        addExpenseView.setAddExpenseController(controller);
        return this;
    }

    /**
     * Creates the JFrame for the application and initially sets up the HomeView
     * to be displayed.
     * 
     * @return the application
     */
    public JFrame build() {
        final JFrame application = new JFrame("My Cool Finance App");
        application.setSize(400, 300);
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(homeView.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }

}
