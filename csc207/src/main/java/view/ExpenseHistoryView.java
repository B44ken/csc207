import data_access.UserData;
import view.ViewSwitcher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpenseHistoryView extends JPanel implements ActionListener{

    private ViewSwitcher viewSwitcher;

    private UserData userData;

    public ExpenseHistoryView(){
        final JLabel title = new JLabel("Expense History");
    }

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }
    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}