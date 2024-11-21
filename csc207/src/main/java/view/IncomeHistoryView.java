package view;

import interface_adapter.home.HomeController;
import interface_adapter.income_history.IncomeHistoryViewController;
import interface_adapter.income_history.IncomeHistoryState;
import interface_adapter.income_history.IncomeHistoryViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
// change above to what its actually called if its different

public class IncomeHistoryView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "income history";
    private final IncomeHistoryViewModel viewModel;

    private final JButton Home;
    private final JButton Expense;
    private final JButton Goals;
    private IncomeHistoryViewController incomeHistoryViewController;


    public IncomeHistoryView(IncomeHistoryViewModel incomeHistoryViewModel) {
        this.viewModel = incomeHistoryViewModel;
        this.viewModel.addPropertyChangeListener(this);
        final JLabel title = new JLabel("Income History");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // add JTABLE here
        final JFrame frame = new JFrame();
        String columm[] = {"Name", "Amount", "Date", "Category"};
        JTable table = new JTable(data,column);
        table.setBounds(30,40,200,300);
        frame.add(sp);
        frame.setSize(300,400);
        frame.setVisible(true);

        //Add chart API here!

        final JPanel buttons = new JPanel();
        Home = new JButton("Home");
        buttons.add(Home);
        Expense = new JButton("Expense");
        buttons.add(Expense);
        Goals = new JButton("Goals");
        buttons.add(Goals);

        Home.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(Home)) {
                            final IncomeHistoryState currentState = incomeHistoryViewModel.getState();

                            HomeController.switch();
                        }
                    }
                }
        );

        Home.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(Home)) {
                            final IncomeHistoryState currentState = incomeHistoryViewModel.getState();

                            HomeController.execute();
                        }
                    }
                }
        );


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        this.add(title);
        this.add();
        this.add(usernameErrorField);
        this.add(passwordInfo);
        this.add(buttons);
    }


    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {System.out.println("Click " + evt.getActionCommand());}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final IncomeHistory state = (IncomeHistory) evt.getNewValue();
        usernameErrorField.setText(state.getLoginError());
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewIncomeController(IncomeHistoryViewController controller) {
        this.loginController = controller;
    }
}
