package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

import com.labrats.app.ViewNames;

import data_access.UserData;
import entity.Expense;
// import interface_adapter.add_expense.AddExpenseController;
import interface_adapter.add_expense.AddExpenseState;
import interface_adapter.add_expense.AddExpenseViewModel;

//change above to what its actually called if its different

/**
 * The View for the Add Expense Use Case
 */
public class AddExpenseView extends JPanel implements ActionListener {
    private final String viewName = "add expense";

    private ViewSwitcher viewSwitcher;
    private ExpenseHistoryView expenseHistoryView;

    private final JButton confirmButton;
    private final JButton cancelButton;

    private final JButton homeButton;
    private final JButton incomeButton;
    private final JButton expenseButton;
    private final JButton goalsButton;

    private final LocalDate date = LocalDate.now();
    private UserData userData;

    public AddExpenseView(ExpenseHistoryView expenseHistoryView) {
        this.expenseHistoryView = expenseHistoryView;
        final JLabel title = new JLabel(AddExpenseViewModel.TITLE_LABEL);
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

        final JPanel buttons1 = new JPanel();
        cancelButton = new JButton("Cancel");
        buttons1.add(cancelButton);
        confirmButton = new JButton("Confirm");
        buttons1.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(confirmButton)) {
                    var name = nameTextField.getText();
                    var amount = 0.0;
                    try {
                        amount = Double.valueOf(amountTextField.getText());
                    } catch (NumberFormatException ex) {
                        System.out.println("failed to parse amount");
                    };
                    var category = categoryTextField.getText();
                    var date = LocalDate.now();

                    userData.getHistory().add(new Expense(name, amount, category, date));
                    userData.save();

                    expenseHistoryView.setupExpenseTable();

                    viewSwitcher.switchTo(ViewNames.home);
                }
            }
        });

        cancelButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.home);
                    }
                });

        final JPanel buttons2 = new JPanel();
        homeButton = new JButton("Home");
        buttons2.add(homeButton);
        incomeButton = new JButton("Income");
        buttons2.add(incomeButton);
        expenseButton = new JButton("Expense");
        buttons2.add(expenseButton);
        goalsButton = new JButton("Goals");
        buttons2.add(goalsButton);

        homeButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.home);
                    }
                }
        );

        expenseButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.expenseHistory);
                    }
                }
        );

        incomeButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.incomeHistory);
                    }
                }
        );

        goalsButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.goalList);
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(namePanel);
        this.add(amountPanel);
        this.add(categoryPanel);
        this.add(buttons1);
        this.add(buttons2);

    };

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this, "Button not implemented yet");
    }

    public void setUserData(UserData ud) {
        this.userData = ud;
    }

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

}
