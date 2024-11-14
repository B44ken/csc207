package com.labrats.app;

import view.*;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_income.AddIncomeController;
import interface_adapter.add_income.AddIncomeViewModel;
import use_case.add_income.AddIncomeInputBoundary;
import use_case.add_income.AddIncomeInputData;

public class AppBuilder {
    public final JPanel cardPanel = new JPanel();
    public final CardLayout cardLayout = new CardLayout();
    // private final UserFactory userFactory = newCommonUserFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private HomeView homeView;
    private HomeViewModel homeViewModel;

    private IncomeView incomeView;
    // private IncomeViewModel incomeViewModel;

    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
        viewManager.setVisible(true);
    }

    /**
     * Adds the Home View to the Application.
     * 
     * @return this builder
     */
    public AppBuilder addHomeView() {
        homeViewModel = new HomeViewModel();
        homeView = new HomeView(homeViewModel);
        cardPanel.add(homeView, homeView.getViewName());
        viewManager.addView(homeView.getViewName(), homeView);
        return this;
    }

    /**
     * Add the Home Use Case to the application
     * 
     * @return
     */
    public AppBuilder addHomeUseCase() {
        final HomeController controller = new HomeController(viewManager);
        homeView.setHomeController(controller);
        return this;
    }

    public AppBuilder addIncomeView() {
        AddIncomeInputData inputData = new AddIncomeInputData(null, 0, null);
        incomeView = new IncomeView(
            new AddIncomeViewModel(),
            new AddIncomeController(inputData)
        );
        cardPanel.add(incomeView, incomeView.getViewName());
        incomeView.setVisible(true);
        viewManager.addView(incomeView.getViewName(), incomeView);
        return this;
    }

    public AppBuilder addIncomeUseCase() {
        AddIncomeInputBoundary inputBoundary = new AddIncomeInputBoundary() {
            @Override
            public void execute(AddIncomeInputData inputData) {
                JOptionPane.showMessageDialog(null, "im tweaking bro");
            }
        };
        // inputBoundary.addIncome(null, 0, null);
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
