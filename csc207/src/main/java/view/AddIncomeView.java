package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import com.labrats.app.ViewNames;
import interface_adapter.add_income.AddIncomeController;

/**
 * The AddIncomeView for adding an Income.
 */
public class AddIncomeView extends JPanel implements ActionListener, PropertyChangeListener {
    private String viewName = "Add Income";

    private AddIncomeController addIncomeController;

    private ViewSwitcher viewSwitcher;

    /**
     * The AddIncomeView constructor.
     * @param viewSwitcher a ViewSwitcher object to display views.
     */
    public AddIncomeView(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
        final JLabel title = new JLabel("Add Income");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel namePanel = new JPanel();
        final JTextField nameTextField = new JTextField(15);
        namePanel.add(new JLabel("Name:"));
        namePanel.add(nameTextField);

        final JPanel amountPanel = new JPanel();
        final JTextField amountTextField = new JTextField(15);
        amountPanel.add(new JLabel("Amount:"));
        amountPanel.add(amountTextField);

        final JPanel categoryPanel = new JPanel();
        final JTextField categoryTextField = new JTextField(15);
        categoryPanel.add(new JLabel("Category:"));
        categoryPanel.add(categoryTextField);

        final JPanel dayPanel = new JPanel();
        final JTextField dayTextField = new JTextField(15);
        dayPanel.add(new JLabel("Day:"));
        dayPanel.add(dayTextField);

        final JPanel monthPanel = new JPanel();
        final JTextField monthTextField = new JTextField(15);
        monthPanel.add(new JLabel("Month:"));
        monthPanel.add(monthTextField);

        final JPanel yearPanel = new JPanel();
        final JTextField yearTextField = new JTextField(15);
        yearPanel.add(new JLabel("Year:"));
        yearPanel.add(yearTextField);

        final JPanel confirmPanel = new JPanel();
        final JButton confirmButton = new JButton("Confirm");
        confirmPanel.add(confirmButton);

        final JPanel cancelPanel = new JPanel();
        final JButton cancelButton = new JButton("Cancel");
        cancelPanel.add(cancelButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                // input into text file here using controller (--> interactor --> presenter)
                // after everything funnelled into txt file go back to home
                addIncomeController.execute(nameTextField.getText(), amountTextField.getText(),
                        categoryTextField.getText(), yearTextField.getText(), monthTextField.getText(),
                        dayTextField.getText());
                viewSwitcher.switchTo(ViewNames.incomeHistory);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewSwitcher.switchTo(ViewNames.home);
            }
        });

        final JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(title);
        mainPanel.add(namePanel);
        mainPanel.add(amountPanel);
        mainPanel.add(categoryPanel);
        mainPanel.add(dayPanel);
        mainPanel.add(monthPanel);
        mainPanel.add(yearPanel);
        mainPanel.add(confirmPanel);
        mainPanel.add(cancelPanel);

        this.add(title);
        this.add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // JOptionPane.showMessageDialog(this, "Action Performed not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // JOptionPane.showMessageDialog(this, "Property Change not implemented yet.");
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;

    }

    public void setAddIncomeController(AddIncomeController controller) {
        this.addIncomeController = controller;
    }
}
