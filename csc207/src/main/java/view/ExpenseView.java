package view;

import java.util.Date;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.labrats.app.ViewNames;

import interface_adapter.add_income.AddIncomeController;
import interface_adapter.add_income.AddIncomeState;
import interface_adapter.add_income.AddIncomeViewModel;
//change above to what its actually called if its different
import interface_adapter.add_expense.AddExpenseController;
import interface_adapter.add_expense.AddExpenseViewModel;

public class ExpenseView extends JPanel {

    // private final AddExpenseController addExpenseController;
    // private final AddExpenseViewModel addExpenseViewModel;
    // change above to what controller is actually called

    public ViewSwitcher viewSwitcher;

    public ExpenseView() {
        this.viewSwitcher = viewSwitcher;

        final JLabel title = new JLabel("Add Expense");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel namePanel = new JPanel();
        JTextField nameTextField = new JTextField(15);
        namePanel.add(new JLabel("Name:"));
        namePanel.add(nameTextField);

        JPanel amountPanel = new JPanel();
        JTextField amountTextField = new JTextField(15);
        amountPanel.add(new JLabel("Amount:"));
        amountPanel.add(amountTextField);

        JPanel categoryPanel = new JPanel();
        JTextField categoryTextField = new JTextField(15);
        categoryPanel.add(new JLabel("Category:"));
        categoryPanel.add(categoryTextField);

        JPanel dayPanel = new JPanel();
        JTextField dayTextField = new JTextField(15);
        dayPanel.add(new JLabel("Day:"));
        dayPanel.add(dayTextField);

        JPanel monthPanel = new JPanel();
        JTextField monthTextField = new JTextField(15);
        monthPanel.add(new JLabel("Month:"));
        monthPanel.add(monthTextField);

        JPanel yearPanel = new JPanel();
        JTextField yearTextField = new JTextField(15);
        yearPanel.add(new JLabel("Year:"));
        yearPanel.add(yearTextField);

        JPanel confirmPanel = new JPanel();
        JButton confirmButton = new JButton("Confirm");
        confirmPanel.add(confirmButton);

        JPanel cancelPanel = new JPanel();
        JButton cancelButton = new JButton("Cancel");
        cancelPanel.add(cancelButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // String name = nameTextField.getText();
                // Double amount = Double.valueOf(amountTextField.getText());
                // String category = categoryTextField.getText();
                // Integer day = Integer.valueOf(dayTextField.getText());
                // Integer month = Integer.valueOf(monthTextField.getText());
                // Integer year = Integer.valueOf(yearTextField.getText());
                // Date date = new Date(year, month, day);
                // input into text file here
                // after everything funnelled into txt file go back to home
                // addExpenseController.switchToHomeView();
                viewSwitcher.switchTo(ViewNames.home);
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(namePanel);
        mainPanel.add(amountPanel);
        mainPanel.add(categoryPanel);
        mainPanel.add(dayPanel);
        mainPanel.add(monthPanel);
        mainPanel.add(yearPanel);
        mainPanel.add(confirmPanel);

        // JFrame frame = new JFrame("Add Expense");
        // frame.setContentPane(mainPanel);
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.pack();
        // frame.setVisible(true);

        this.add(mainPanel);

    };

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }
}
