package view;

import java.io.*;
import java.util.Date;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.View;

import com.labrats.app.ViewNames;
import data_access.UserData;
import entity.Budget;
import interface_adapter.add_budget.AddBudgetController;
import interface_adapter.add_budget.AddBudgetState;
import interface_adapter.add_budget.AddBudgetViewModel;
import use_case.AddExpenseController;


public class AddBudgetView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "Add Budget";
    private AddBudgetController addBudgetController;
    // private final AddBudgetViewModel addBudgetViewModel;
    // change above to what controller is actually called later
    // need to move the input fields out here unfortunately!!!!!!!!!!!

    private final JButton homeButton;
    private final JButton incomeButton;
    private final JButton expenseButton;
    private final JButton goalButton;

    private final JButton confirmButton;
    private final JButton cancelButton;

    private ViewSwitcher viewSwitcher;
    private UserData userData;

    private AddBudgetController controller;

    public AddBudgetView(AddBudgetController controller, ViewSwitcher viewSwitcher) {

        // this.addBudgetController = controller;
        // this.addBudgetViewModel = budgetViewModel;
        // addBudgetViewModel.addPropertyChangeListener(this);
        this.controller = controller;
        final JLabel title = new JLabel("Add Budget");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel categoryNamePanel = new JPanel();
        JTextField categoryNameTextField = new JTextField(15);
        categoryNamePanel.add(new JLabel("Category:"));
        categoryNamePanel.add(categoryNameTextField);

        JPanel amountPanel = new JPanel();
        JTextField amountTextField = new JTextField(15);
        amountPanel.add(new JLabel("Amount:"));
        amountPanel.add(amountTextField);

        final JPanel buttonPanel = new JPanel();
        confirmButton = new JButton("Confirm");
        buttonPanel.add(confirmButton);
        cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(confirmButton)) {
                    controller.addBudget(
                            categoryNameTextField.getText(),
                            amountTextField.getText());
                }
                controller.switchToHomeView();
            }
        });

        cancelButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {viewSwitcher.switchTo(ViewNames.home);}
        });

        final JPanel buttons2 = new JPanel();
        homeButton = new JButton("Home");
        buttons2.add(homeButton);
        incomeButton = new JButton("Income");
        buttons2.add(incomeButton);
        expenseButton = new JButton("Expense");
        buttons2.add(expenseButton);
        goalButton = new JButton("Goal");
        buttons2.add(goalButton);

        homeButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewSwitcher.switchTo(ViewNames.home);
                    }
                });

        incomeButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewSwitcher.switchTo(ViewNames.incomeHistory);
                    }
                });

        expenseButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewSwitcher.switchTo(ViewNames.expenseHistory);
                    }
                });

        goalButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        viewSwitcher.switchTo(ViewNames.goalList);
                    }
                });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.add(title);
        this.add(categoryNamePanel);
        this.add(amountPanel);
        this.add(buttonPanel);
        this.add(buttons2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

    public void setViewSwitcher(ViewSwitcher vs) {
        viewSwitcher = vs;
    }

    public void setUserData(UserData ud) {
        userData = ud;
        this.repaint();
    }

    // public void repaint() {}

    public String getViewName() {return viewName;}

    public void setAddBudgetController(AddBudgetController controller) {this.addBudgetController = controller;}

}
