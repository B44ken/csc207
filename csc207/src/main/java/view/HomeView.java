package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.*;

import com.labrats.app.ViewNames;

import data_access.UserData;

/**
 * The view for the home view case.
 */
public class HomeView extends JPanel {

    private final String viewName = "my cool finance app";

    private ViewSwitcher viewSwitcher;
    private UserData userData;

    private final JButton addIncome;
    private final JButton addExpense;
    private final JButton getInsight;

    private JLabel incomeValue;
    private JLabel expensesValue;
    private JLabel netBalanceValue;

    private final JButton incomeButton;
    private final JButton expenseButton;
    private final JButton goalButton;


    public HomeView() {
        final JLabel title = new JLabel("My Cool Finance App");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel netBalance = new JLabel("Net Balance");
        netBalance.setAlignmentX(Component.CENTER_ALIGNMENT);
        final JLabel netBalanceValue = new JLabel(Float.toString(0));
        netBalanceValue.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel incomeText = new JLabel("Income");
        incomeText.setAlignmentX(Component.CENTER_ALIGNMENT);

        incomeValue = new JLabel("?");
        incomeValue.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel expenseText = new JLabel("Expenses");
        expenseText.setAlignmentX(Component.CENTER_ALIGNMENT);
        expensesValue = new JLabel(Float.toString(0));
        expensesValue.setAlignmentX(Component.CENTER_ALIGNMENT);
        final JLabel netValue = new JLabel("Goal");

        // add chart API here

        final JPanel buttons1 = new JPanel();
        addIncome = new JButton("Add Income");
        buttons1.add(addIncome);
        addExpense = new JButton("Add Expense");
        buttons1.add(addExpense);

        getInsight = new JButton("Get Insight");
        buttons1.add(getInsight, 0);

        getInsight.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        viewSwitcher.switchTo(ViewNames.getInsight);
                    }
        });


        addIncome.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                         viewSwitcher.switchTo(ViewNames.addIncome);
                    }
                });

        addExpense.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.addExpense);
                    }
                });

        final JPanel buttons2 = new JPanel();
        incomeButton = new JButton("Income");
        buttons2.add(incomeButton);
        expenseButton = new JButton("Expense");
        buttons2.add(expenseButton);
        goalButton = new JButton("Goal");
        buttons2.add(goalButton);

         incomeButton.addActionListener(
                 new ActionListener() {
                     public void actionPerformed(ActionEvent evt) {
                         viewSwitcher.switchTo(ViewNames.incomeHistory);
                     }
                 });

        expenseButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.expenseHistory);
                    }
                });

        goalButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.goals);
                    }
                });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(netBalance);
        this.add(netBalanceValue);
        this.add(incomeText);
        this.add(incomeValue);
        this.add(expenseText);
        this.add(expensesValue);
        this.add(buttons1);
        this.add(buttons2);
    }

    public String getName() {
        return viewName;
    }

    public void setViewSwitcher(ViewSwitcher vs) {
        viewSwitcher = vs;
    }

    public void setUserData(UserData ud) {
        userData = ud;
        this.repaint();
    }

    public void attachSwitchToOnButton(JButton button, String viewName) {
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(viewName);
                    }
                });
    }

    public void repaint() {

        if (userData != null && incomeValue != null) {
            incomeValue.setText(Double.toString(userData.getHistory().getIncomeTotal()));
        }
        if (userData != null && expensesValue != null) {
            expensesValue.setText(Double.toString(userData.getHistory().getExpensesTotal()));
        }
        if (userData != null && netBalanceValue != null) {
            netBalanceValue.setText(Double.toString(userData.getHistory().getNetBalance()));
        }
    }

        // TODO
        // repaint is called when a Swing component is switched to
        // use this to update numbers and stuff
        // other components also need repaint() methods
    }
