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

import interface_adapter.add_budget.AddBudgetController;
import interface_adapter.add_budget.AddBudgetState;
import interface_adapter.add_budget.AddBudgetViewModel;


public class AddBudgetView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "add budget";
    private AddBudgetController addBudgetController;
    private final AddBudgetViewModel addBudgetViewModel;
    // change above to what controller is actually called later
    // need to move the input fields out here unfortunately!!!!!!!!!!!

    public AddBudgetView(AddBudgetViewModel budgetViewModel, AddBudgetController controller) {

        this.addBudgetController = controller;
        this.addBudgetViewModel = budgetViewModel;
        addBudgetViewModel.addPropertyChangeListener(this);

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

        JPanel confirmPanel = new JPanel();
        JButton confirmButton = new JButton("Confirm");
        confirmPanel.add(confirmButton);

        JPanel cancelPanel = new JPanel();
        JButton cancelButton = new JButton("Cancel");
        cancelPanel.add(cancelButton);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String categoryName = categoryNameTextField.getText();
                String amount = amountTextField.getText();
                addBudgetController.createUserData(categoryName, amount);
                // i believe this inputs into budget text file here ^
                // switch back to budget view?:
                // addBudgetController.switchToBudgetView();
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(categoryNamePanel);
        mainPanel.add(amountPanel);

        JFrame frame = new JFrame("Add Budget");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Action Performed not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        JOptionPane.showMessageDialog(this, "Property Change not implemented yet.");
    }

    public String getViewName() {return viewName;}

    public void setAddBudgetState(AddBudgetController controller) {this.addBudgetController = controller;}

    private static boolean isEntryUnique(String fileName, String input) {
        File file = new File(fileName);
        if (!file.exists()) {
            return true;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(input)) {
                    return false;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
