package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;

import javax.swing.*;

import com.labrats.app.ViewNames;
import interface_adapter.add_income.AddIncomeController;
import interface_adapter.add_income.AddIncomeViewModel;
//change above to what its actually called if its different

public class AddIncomeView extends JPanel implements ActionListener, PropertyChangeListener {
    private String viewName = "Add Income";

    private AddIncomeController addIncomeController;
    private final AddIncomeViewModel addIncomeViewModel;

    private ViewSwitcher viewSwitcher;
    // change above to what controller is actually called later

    public AddIncomeView(AddIncomeViewModel incomeViewModel) {
        super();

        this.addIncomeViewModel = incomeViewModel;

        final JLabel title = new JLabel("Add Income");
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
                String name = nameTextField.getText();
                Double amount = Double.valueOf(amountTextField.getText());
                String category = categoryTextField.getText();
                Integer day = Integer.valueOf(dayTextField.getText());
                Integer month = Integer.valueOf(monthTextField.getText());
                Integer year = Integer.valueOf(yearTextField.getText());
                LocalDate date = LocalDate.of(year, month, day);
                // input into text file here using controller (--> interactor --> presenter)
                // after everything funnelled into txt file go back to home
                viewSwitcher.switchTo(ViewNames.home);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        mainPanel.add(cancelPanel);

        this.add(title);
        this.add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, "Action Performed not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        JOptionPane.showMessageDialog(this, "Property Change not implemented yet.");
    }


    public String getViewName() {
        return viewName;
    }

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }
}
