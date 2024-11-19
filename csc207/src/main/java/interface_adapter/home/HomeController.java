package interface_adapter.home;

import view.ViewManager;

import javax.swing.JOptionPane;

public class HomeController {

    private final HomeInputBoundary homeUseCaseInteractor;

    private final ViewManager viewManager;

    public HomeController(HomeInputBoundary homeUseCaseInteractor, ViewManager viewManager) {
        this.homeUseCaseInteractor = homeUseCaseInteractor;
        this.viewManager = viewManager;
    }

    public void switchToAddIncome(){
        // this.cardLayout.show(cardPanel, "Add Income");
        viewManager.selectView("Add Income");
    }

    public void switchToAddExpense(){
        homeUseCaseInteractor.switchToAddExpense();
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