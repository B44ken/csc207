package com.labrats.app;

import data_access.InMemoryUserDataAccessObject;
import interface_adapter.add_expense.AddExpenseController;
import interface_adapter.add_income.AddIncomePresenter;
import use_case.add_goal.AddGoalInputData;
import use_case.add_income.AddIncomeInteractor;
import use_case.add_income.AddIncomeOutputBoundary;
import view.*;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import interface_adapter.ViewManagerModel;
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
     * Adds Add Income View to the Application.
     * @return this builder
     */
    public AppBuilder addIncomeView() {
        AddIncomeInputData inputData = new AddIncomeInputData(null, 0, null);
//        should call to API in above line
        addIncomeViewModel = new AddIncomeViewModel();
        addIncomeView = new AddIncomeView(addIncomeViewModel, addIncomeController);
        cardPanel.add(addIncomeView, addIncomeView.getViewName());
//        addIncomeView.setVisible(true);
//        viewManager.addView(addIncomeView.getViewName(), addIncomeView);
        return this;
    }

    /**
     * Adds Add Expense View to the Application.
     * @return this builder
     */
    public AppBuilder addExpenseView() {
        AddIncomeInputData inputData = new AddIncomeInputData(null, 0, null);
//        should call to API in above line
        addIncomeViewModel = new AddIncomeViewModel();
        addIncomeView = new AddIncomeView(addIncomeViewModel, addIncomeController);
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
     * Adds Set Goal View to the Application.
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
                addExpenseViewModel, addExpenseViewModel);
        final AddExpenseInputBoundary userAddExpenseInteractor = new AddExpenseInteractor(
                userDataAccessObject, addExpenseOutputBoundary, expenseFactory);

        final AddExpenseController controller = new AddExpenseController(userAddExpenseInteractor);
        addExpenseView.setAddExpenseController(controller);
        return this;
    }

    /**
     * Creates the JFrame for the application and initially sets up the SignupView
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

    public void setVisible(boolean visible) {
        viewManager.setVisible(visible);
    }

}
