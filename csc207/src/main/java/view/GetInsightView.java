package view;

import com.labrats.app.ViewNames;
import data_access.UserData;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetInsightView extends JPanel implements ActionListener {
    private final JLabel title = new JLabel("Get Insight");

    //

    // buttons
    private final JButton homeButton;
    private final JButton incomeButton;
    private final JButton expenseButton;
    private final JButton goalsButton;
    private ViewSwitcher viewSwitcher;

    public GetInsightView() {
        this.setSize(1080,748);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // call the use

        // generate inisght!!

        // add QR Code API

        final JPanel buttons = new JPanel();
        homeButton = new JButton("Home");
        buttons.add(homeButton);
        incomeButton = new JButton("Income");
        buttons.add(incomeButton);
        expenseButton = new JButton("Expense");
        buttons.add(expenseButton);
        goalsButton = new JButton("Goal");
        buttons.add(goalsButton);

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

        goalsButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.goals);
                    }
                }
        );


        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(title);

        this.add(buttons, BorderLayout.AFTER_LAST_LINE);
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Sets viewswitcher.
     * @param viewSwitcher
     */
    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    /**
     * Sets userdata for Get Insight View
     * @param userData
     */
    public void setUserData(UserData userData) {
    }
}
