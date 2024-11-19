package view;

import java.awt.Component;
import java.awt.Desktop.Action;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.temporal.ValueRange;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.labrats.app.ViewNames;

import data_access.ChartImageFactory;

/**
 * The view for the home view case.
 */
public class HomeView extends JPanel {

    private final String viewName = "my cool finance app";

    private ViewSwitcher homeViewModel;
    private HomeController homeController;

    private final JButton addIncome;
    private final JButton addExpense;

    private final JButton incomeButton;
    private final JButton expenseButton;
    private final JButton goalButton;

    public HomeView() {
        final JLabel title = new JLabel("My Cool Finance App");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel netBalance = new JLabel("Net Balance");
        netBalance.setAlignmentX(Component.CENTER_ALIGNMENT);
        final JLabel netBalanceValue = new JLabel(Float.toString(0));
        netBalanceValue.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel incomeText = new JLabel("Income");
        incomeText.setAlignmentX(Component.CENTER_ALIGNMENT);
        final JLabel incomeValue = new JLabel(Float.toString(0));
        incomeValue.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel expenseText = new JLabel("Expenses");
        expenseText.setAlignmentX(Component.CENTER_ALIGNMENT);
        final JLabel expensesValue = new JLabel(Float.toString(0));
        expensesValue.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons1 = new JPanel();
        addIncome = new JButton("Add Income");
        buttons1.add(addIncome);
        addExpense = new JButton("Add Expense");
        buttons1.add(addExpense);

        addIncome.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        // homeController.switchToAddIncome();
                    }
                });

        addExpense.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        // homeController.switchToAddExpense();
                        // System.out.println("switching to add expense");
                        // homeViewModel.switchTo(ViewNames.addExpense);
                    }
                });

        final JPanel buttons2 = new JPanel();
        incomeButton = new JButton("Income");
        buttons2.add(incomeButton);
        expenseButton = new JButton("Expense");
        buttons2.add(expenseButton);
        goalButton = new JButton("Goal");
        buttons2.add(goalButton);

        incomeButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        homeViewModel.switchTo(ViewNames.incomeHistory);
                    }
                });

        expenseButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        homeViewModel.switchTo(ViewNames.expense);
                    }
                });

        goalButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        // homeController.switchToGoalView();
                    }
                });

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

    public String getName() {
        return viewName;
    }

    // public void setHomeController(HomeController controller) {
    //     this.homeController = controller;
    // }

    public void setHomeViewModel(ViewSwitcher homeViewModel) {
        this.homeViewModel = homeViewModel;
    }
}
