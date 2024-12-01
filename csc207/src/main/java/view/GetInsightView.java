package view;

import com.labrats.app.ViewNames;
import data_access.UserData;
import interface_adapter.get_insight.GetInsightController;
import interface_adapter.get_insight.GetInsightViewModel;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GetInsightView extends JPanel implements ActionListener, PropertyChangeListener {
    private final JLabel title = new JLabel("Get Insight");

    private ViewSwitcher viewSwitcher;

    private GetInsightViewModel viewModel;
    private GetInsightController getInsightController;

    public GetInsightView(BottomButtons bottomButtons, GetInsightViewModel viewModel) {
        this.viewModel = viewModel;
        this.viewModel.addPropertyChangeListener(this);

        this.setSize(1080,748);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // call the controller!! this should change something in the View.... --> creates a popup
        // controller -> interactor, decides what to output based on DAO -> presenter
        // View listens for change in ViewModel and updates the view

        this.getInsightController = getInsightController;
        getInsightController.execute(new UserData());

        // add explore scholarships: url button
        // get advice from finance counsellor: url button
        // get a part time job? scan QR code to clnx

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

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    public void setGetInsightController(GetInsightController getInsightController) {
        this.getInsightController = getInsightController;
    }
}
