package view;

import javax.swing.JOptionPane;

public class HomeController {
    private final ViewManager viewManager;

    public HomeController(ViewManager viewManager) {
        this.viewManager = viewManager;
    }

    public void switchToAddIncome(){
        // this.cardLayout.show(cardPanel, "Add Income");
        viewManager.selectView("Add Income");
    }

    public void switchToAddExpense(){
        JOptionPane.showMessageDialog(null, "Button not implemented yet.");
    }

    public void switchToIncomeView(){
        JOptionPane.showMessageDialog(null, "Button not implemented yet.");
    }

    public void switchToExpenseView(){
        JOptionPane.showMessageDialog(null, "Button not implemented yet.");
    }

    public void switchToGoalView(){
        JOptionPane.showMessageDialog(null, "Button not implemented yet.");
    }
}