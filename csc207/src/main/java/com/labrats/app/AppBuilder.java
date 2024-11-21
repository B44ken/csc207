package com.labrats.app;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.ExpenseView;
import view.HomeView;
import view.ViewSwitcher;
import view.IncomeHistoryView;

import java.awt.CardLayout;
import java.security.Principal;

public class AppBuilder {
    private CardLayout layout;
    private JPanel cards;
    private JFrame app;

    private ViewSwitcher viewSwitcher;

    private IncomeHistoryView incomeHistoryView;
    private HomeView homeView;

    public AppBuilder() {
        cards = new JPanel(new CardLayout());
        viewSwitcher = new ViewSwitcher(cards, layout);

    }

    public AppBuilder addHomeView() {
        homeView = new HomeView();
        cards.add(homeView, homeView.getName());
        return this;
    }

    public AppBuilder addHomeUseCase() {
        layout = (CardLayout) cards.getLayout();
        viewSwitcher = new ViewSwitcher(cards, layout);
        homeView.setHomeViewModel(viewSwitcher);
        return this;
    }

    public AppBuilder addIncomeHistoryView() {
        incomeHistoryView = new IncomeHistoryView();
        cards.add(incomeHistoryView, ViewNames.incomeHistory);
        System.out.println(incomeHistoryView.getViewName());
        return this;
    }

    public AppBuilder addExpenseView() {
        var expenseView = new ExpenseView();
        cards.add(expenseView, ViewNames.expense);
        return this;
    }

    public JFrame build() {
        app = new JFrame("My Cool Finance App");
        app.add(cards);
        layout.show(cards, ViewNames.home);
        return app;
    }
}
