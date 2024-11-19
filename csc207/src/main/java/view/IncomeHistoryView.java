package view;

import interface_adapter.income_history.IncomeHistoryState;
import interface_adapter.income_history.IncomeHistoryViewModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;



import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.*;

import interface_adapter.add_income.AddIncomeController;
import interface_adapter.add_income.AddIncomeViewModel;
//change above to what its actually called if its different


public class IncomeHistoryView extends JPanel implements ActionListener, PropertyChangeListener {
    private final String viewName = "income history";
    private final IncomeHistoryViewModel viewModel;
//    private final IncomeHistoryOutputBoundary incomeHistoryOutputBoundary;

    private final JButton Home;
    private final JButton Expense;
    private final JButton Goals;

    public IncomeHistoryView(IncomeHistoryViewModel incomeHistoryViewModel) {
        this.viewModel = incomeHistoryViewModel;
        this.viewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Income History");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        Home = new JButton("Home");
        buttons.add(Home);
        Expense = new JButton("Expense");
        buttons.add(Expense);
        Goals = new JButton("Goals");
        buttons.add(Goals);

        // txt file/goals in here
        // Add Chart API here!!

        Home.addActionListener(
                //how do i choose which presenter/output boundary to use "switch to home view?"
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        incomeHistoryViewModel.setState();
                        }
                    }
        );

        Expense.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        incomeHistoryOutputBoundary.switchToExpenseHistoryView();
                    }
                }
        );

        Goal.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        IncomeHistoryController.switchToGoalView();
                    }
                }
        );


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        this.add(title);
//        this.add(); txt file/chart api here
        this.add(buttons);
    }


    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
        }

    public String getViewName() {
        return viewName;
    }

}
