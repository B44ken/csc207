package view;

import com.labrats.app.ViewNames;
import data_access.UserData;
import interface_adapter.get_insight.GetInsightController;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GetInsightView extends JPanel implements ActionListener {
    private final JLabel title = new JLabel("Get Insight");

    private ViewSwitcher viewSwitcher;

    private GetInsightController getInsightController;

    public GetInsightView(BottomButtons bottomButtons, GetInsightController getInsightController) {
        this.setSize(1080,748);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // call the controller!! this should change something in the View....
        // controller -> interactor, decides what to output based on DAO -> presenter changes State in ViewModel
        // View listens for change in ViewModel and updates the view

        this.getInsightController = getInsightController;

        // add QR Code API

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.add(title);
        this.add(bottomButtons, BorderLayout.AFTER_LAST_LINE);
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
