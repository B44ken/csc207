package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.add_income.AddIncomeController;
import interface_adapter.add_income.AddIncomeViewModel;
//change above to what its actually called if its different

public class IncomeView extends JPanel implements ActionListener, PropertyChangeListener {
    private String viewName = "Add Income";

    private final AddIncomeController addIncomeController;
    private final AddIncomeViewModel addIncomeViewModel;

    private final JFrame outerFrame;
    // change above to what controller is actually called later

    public IncomeView(AddIncomeViewModel incomeViewModel, AddIncomeController controller) {
        super();

        this.addIncomeController = controller;
        this.addIncomeViewModel = incomeViewModel;
        addIncomeViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Add Income");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel namePanel = new JPanel();
        JTextField nameTextField = new JTextField(15);
        namePanel.add(new JLabel("First Name:"));
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

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                Double amount = Double.valueOf(amountTextField.getText());
                String category = categoryTextField.getText();
                Integer day = Integer.valueOf(dayTextField.getText());
                Integer month = Integer.valueOf(monthTextField.getText());
                Integer year = Integer.valueOf(yearTextField.getText());
                // input into text file here
                // after everything funnelled into txt file go back to home
                // addIncomeController.switchToHomeView();
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

        outerFrame = new JFrame("Add Income");
        outerFrame.setContentPane(mainPanel);
        outerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        outerFrame.pack();
        // frame.setVisible(true);
    };

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Action Performed not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        JOptionPane.showMessageDialog(this, "Property Change not implemented yet.");
    }

    public void setVisible(boolean visible) {
        outerFrame.setVisible(visible);
    }

    public String getViewName() {
        return viewName;
    }
}
