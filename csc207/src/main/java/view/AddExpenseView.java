package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.time.LocalDate;
import javax.swing.*;
import javax.swing.text.View;

import com.labrats.app.ViewNames;
import data_access.UserData;
import interface_adapter.add_expense.AddExpenseController;
import interface_adapter.add_expense.AddExpenseViewModel;

/**
 * The View for the Add Expense Use Case
 */
public class AddExpenseView extends JPanel implements ActionListener {
    private final String viewName = "add expense";

    private ViewSwitcher viewSwitcher;

    private final JButton confirmButton;
    private final JButton cancelButton;

    private final LocalDate date = LocalDate.now();
    private UserData userData;
    private AddExpenseController addExpenseController;

    public AddExpenseView(ViewSwitcher vs) {
        super();
        this.viewSwitcher = vs;
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

        final JPanel buttons1 = new JPanel();
        cancelButton = new JButton("Cancel");
        buttons1.add(cancelButton);
        confirmButton = new JButton("Confirm");
        buttons1.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addExpenseController.execute(nameTextField.getText(), amountTextField.getText()
                        ,categoryTextField.getText(), yearTextField.getText(), monthTextField.getText(), dayTextField.getText());
                viewSwitcher.switchTo(ViewNames.expenseHistory);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.home);
                    }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(namePanel);
        this.add(amountPanel);
        this.add(categoryPanel);
        this.add(dayPanel);
        this.add(monthPanel);
        this.add(yearPanel);
        this.add(buttons1);
//        this.add(buttons2);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showMessageDialog(this,
                "Button not implemented yet");
    }

    public void propertyChange(PropertyChangeEvent evt) {

    }

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    public void setAddExpenseController(AddExpenseController addExpenseController) {
        this.addExpenseController = addExpenseController;
    }
}

