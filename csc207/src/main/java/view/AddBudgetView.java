package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import com.labrats.app.ViewNames;
import data_access.UserData;
import interface_adapter.add_budget.AddBudgetController;

/**
 * The View for the Add Budget Use Case.
 */
public class AddBudgetView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "Add Budget";

    private final JButton confirmButton;
    private final JButton cancelButton;

    private ViewSwitcher viewSwitcher;
    private UserData userData;

    private AddBudgetController controller;

    /**
     * Creates AddBudgetView with viewSwitcher.
     * @param viewSwitcher the class responsible for switching between views.
     */
    public AddBudgetView(ViewSwitcher viewSwitcher) {

        this.viewSwitcher = viewSwitcher;

        final JLabel title = new JLabel("Add Budget");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel categoryNamePanel = new JPanel();
        final JTextField categoryNameTextField = new JTextField(15);
        categoryNamePanel.add(new JLabel("Category:"));
        categoryNamePanel.add(categoryNameTextField);

        final JPanel amountPanel = new JPanel();
        final JTextField amountTextField = new JTextField(15);
        amountPanel.add(new JLabel("Amount:"));
        amountPanel.add(amountTextField);

        final JPanel buttonPanel = new JPanel();
        cancelButton = new JButton("Cancel");
        buttonPanel.add(cancelButton);
        confirmButton = new JButton("Confirm");
        buttonPanel.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                controller.addBudget(categoryNameTextField.getText(), amountTextField.getText());
                // TODO: move vs to controller
                viewSwitcher.switchTo(ViewNames.home);
            }
        });

        cancelButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.home);
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.add(title);
        this.add(categoryNamePanel);
        this.add(amountPanel);
        this.add(buttonPanel);
    }

    /**
     * The actionPerformed method.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    /**
     * The propertyChange method.
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

    /**
     * Sets AddBudgetView's viewSwitcher to vs.
     * @param viewSwitcher the ViewSwitcher object to be set as AddBudgetView's viewSwitcher.
     */
    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    /**
     * Sets AddBudgetView's userData to ud.
     * @param userData the UserData object to be set as AddBudgetView's userData.
     */
    public void setUserData(UserData userData) {
        this.userData = userData;
        this.repaint();
    }

    // public void repaint() {}

    /**
     * Getter for AddBudgetView's viewName.
     * @return the viewName of AddBudgetView.
     */
    public String getViewName() {
        return viewName;
    }

    /**
     * Setter for AddBudgetView's controller as the controller parameter.
     * @param ctrlr the controller for AddBudgetView's controller to be set to.
     */
    public void setAddBudgetController(AddBudgetController ctrlr) {
        this.controller = ctrlr;
    }

}
