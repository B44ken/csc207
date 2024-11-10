package view;

import java.awt.Component;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The view for the home view case.
 */
public class HomeView extends JPanel implements ActionListener {

    private final String viewName = "my cool finance app";

    private final HomeViewModel homeViewModel;
    private HomeController homeController;

    private final JButton addIncome;
    private final JButton addExpense;

    private final JButton incomeButton;
    private final JButton expenseButton;
    private final JButton goalButton;

    public HomeView(HomeViewModel homeViewModel) {
        this.homeViewModel = homeViewModel;

        final JLabel title = new JLabel(HomeViewModel.TITLE_LABEL);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel netBalance = new JLabel(HomeViewModel.NET_BALANCE_LABEL);
        netBalance.setAlignmentX(Component.CENTER_ALIGNMENT);
        final JLabel netBalanceValue = new JLabel(Float.toString(HomeViewModel.NET_BALANCE_VALUE));
        netBalanceValue.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel incomeText = new JLabel(HomeViewModel.INCOME_TEXT_LABEL);
        incomeText.setAlignmentX(Component.CENTER_ALIGNMENT);
        final JLabel incomeValue = new JLabel(Float.toString(HomeViewModel.INCOME_VALUE));
        incomeValue.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel expenseText = new JLabel(HomeViewModel.EXPENSE_TEXT_LABEL);
        expenseText.setAlignmentX(Component.CENTER_ALIGNMENT);
        final JLabel expensesValue = new JLabel(Float.toString(HomeViewModel.EXPENSES_VALUE));
        expensesValue.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons1 = new JPanel();
        addIncome = new JButton(HomeViewModel.ADD_INCOME_BUTTON_LABEL);
        buttons1.add(addIncome);
        addExpense = new JButton(HomeViewModel.ADD_EXPENSE_BUTTON_LABEL);
        buttons1.add(addExpense);

        addIncome.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        homeController.switchToAddIncome();
                    }
                }
        );

        addExpense.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        homeController.switchToAddExpense();
                    }
                }
        );

        final JPanel buttons2 = new JPanel();
        incomeButton = new JButton(HomeViewModel.INCOME_BUTTON_LABEL);
        buttons2.add(incomeButton);
        expenseButton = new JButton(HomeViewModel.EXPENSE_BUTTON_LABEL);
        buttons2.add(expenseButton);
        goalButton = new JButton(HomeViewModel.GOAL_BUTTON_LABEL);
        buttons2.add(goalButton);

        incomeButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        homeController.switchToIncomeView();
                    }
                }
        );

        expenseButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        homeController.switchToExpenseView();
                    }
                }
        );

        goalButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        homeController.switchToGoalView();
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(netBalance);
        this.add(netBalanceValue);
        this.add(incomeText);
        this.add(incomeValue);
        this.add(expenseText);
        this.add(expensesValue);
        this.add(buttons1);
        this.add(buttons2);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Button not implemented yet.");
    }

    public String getViewName() {
        return viewName;
    }

    public void setHomeController(HomeController controller) {
        this.homeController = controller;
    }
}
