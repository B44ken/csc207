package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import com.labrats.app.ViewNames;
import interface_adapter.add_goal.AddGoalController;

/**
 * The view for adding a new goal.
 */
public class AddGoalView extends JPanel implements ActionListener, PropertyChangeListener {
    private String viewName = "Add Goal View";

    private AddGoalController addGoalController;

    private ViewSwitcher viewSwitcher;

    /**
     * Creates AddGoalView with viewSwitcher.
     * @param viewSwitcher the class responsible for switching between views.
     */
    public AddGoalView(ViewSwitcher viewSwitcher) {
        super();
        this.viewSwitcher = viewSwitcher;
        final JLabel title = new JLabel("Add Goal");
        title.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        JPanel targetPanel = new JPanel();
        JTextField targetTextField = new JTextField(15);
        targetPanel.add(new JLabel("Target:"));
        targetPanel.add(targetTextField);

        JPanel amountPanel = new JPanel();
        JTextField amountTextField = new JTextField(15);
        amountPanel.add(new JLabel("Amount:"));
        amountPanel.add(amountTextField);

        JPanel targetDayPanel = new JPanel();
        JTextField dayTextField = new JTextField(15);
        targetDayPanel.add(new JLabel("Target Day:"));
        targetDayPanel.add(dayTextField);

        JPanel targetMonthPanel = new JPanel();
        JTextField monthTextField = new JTextField(15);
        targetMonthPanel.add(new JLabel("Target Month:"));
        targetMonthPanel.add(monthTextField);

        JPanel targetYearPanel = new JPanel();
        JTextField yearTextField = new JTextField(15);
        targetYearPanel.add(new JLabel("Target Year:"));
        targetYearPanel.add(yearTextField);

        JPanel confirmPanel = new JPanel();
        JButton confirmButton = new JButton("Confirm");
        confirmPanel.add(confirmButton);

        JPanel cancelPanel = new JPanel();
        JButton cancelButton = new JButton("Cancel");
        cancelPanel.add(cancelButton);

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addGoalController.execute(targetTextField.getText(), amountTextField.getText(),
                        dayTextField.getText(), monthTextField.getText(), yearTextField.getText());
                viewSwitcher.switchTo(ViewNames.goalList);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                viewSwitcher.switchTo(ViewNames.home);
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(title);
        mainPanel.add(targetPanel);
        mainPanel.add(amountPanel);
        mainPanel.add(targetDayPanel);
        mainPanel.add(targetMonthPanel);
        mainPanel.add(targetYearPanel);
        mainPanel.add(confirmPanel);
        mainPanel.add(cancelPanel);

        this.add(title);
        this.add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

    /**
     * Getter for AddGoalView's viewname.
     * @return the viewName of AddGoalView.
     */
    public String getViewName() {
        return viewName;
    }

    /**
     * Sets AddGoalView's viewSwticher.
     * @param viewSwitcher the ViewSwitcher object to be set as AddGoalView's ViewSwitcher.
     */
    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    /**
     * Setter for AddGoalView's controller as the controller parameter.
     * @param controller the controller for AddGoalView's controller to be set to.
     */
    public void setAddGoalController(AddGoalController controller) {
        this.addGoalController = controller;
    }
}
