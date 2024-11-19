package interface_adapter.home;

import java.awt.CardLayout;

import javax.swing.JOptionPane;

import view.ViewManager;

public class HomeController {

    private ViewManager viewManager;
    private CardLayout cardLayout;

    public HomeController() {
        // this.viewManager = viewManager;
    }

    public void switchToAddIncome() {
        this.cardLayout.show(cardPanel, "Add Income");
        // this.viewManager.selectView("Add Income");
    }

    // public void switchToAddExpense() {
    //     JOptionPane.showMessageDialog(null, "Button not implemented yet.");
    // }

    // public void switchToIncomeView() {
    //     JOptionPane.showMessageDialog(null, "Button not implemented yet.");
    // }

    // public void switchToExpenseView() {
    //     JOptionPane.showMessageDialog(null, "Button not implemented yet.");
    // }

    // public void switchToGoalView() {
    //     JOptionPane.showMessageDialog(null, "Button not implemented yet.");
    // }
}