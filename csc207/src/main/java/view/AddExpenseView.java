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

import interface_adapter.add_expense.AddExpenseViewModel;
import use_case.AddExpenseController;

//change above to what its actually called if its different

/**
 * The View for the Add Expense Use Case
 */
public class AddExpenseView extends JPanel {
    private final JButton confirmButton;
    private final JButton cancelButton;

    private AddExpenseController controller;

    public AddExpenseView(AddExpenseController controller, ViewSwitcher viewSwitcher) {
        this.controller = controller;

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

        final JPanel buttons = new JPanel();
        cancelButton = new JButton("Cancel");
        buttons.add(cancelButton);
        confirmButton = new JButton("Confirm");
        buttons.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(confirmButton)) {
                    controller.addExpense(
                            nameTextField.getText(),
                            amountTextField.getText(),
                            categoryTextField.getText());
                }
                controller.switchToHome();
            }
        });

        viewSwitcher.listenForButton(cancelButton, ViewNames.home);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(namePanel);
        this.add(amountPanel);
        this.add(categoryPanel);
        this.add(buttons);
    };
}
