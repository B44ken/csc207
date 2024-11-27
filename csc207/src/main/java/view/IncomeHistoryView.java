package view;

import com.labrats.app.ViewNames;
import data_access.UserData;
import entity.Transaction;
import entity.TransactionHistory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class IncomeHistoryView extends JPanel implements ActionListener {
    private final String viewName = "income history";

    private final JButton addIncome;

    private final JButton homeButton;
    private final JButton incomeButton;
    private final JButton expenseButton;
    private final JButton goalsButton;
    private ViewSwitcher viewSwitcher;

    private UserData userData;


    public IncomeHistoryView() {
        final JLabel title = new JLabel("Income History");
        final JPanel panel = new JPanel();
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        String[] columnNames = {"Name", "Amount", "Date", "Category"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // System.out.println(this.userData);
        // this printed that user data is null

        if (this.userData != null) {
            TransactionHistory data = userData.getHistory().getAllIncomes();
            System.out.println("user data not null");
            // DefaultTableModel model = (DefaultTableModel) incomeHistoryTable.getModel();
            for (Transaction transaction : data.getHistory()) {
                tableModel.addRow(new String[]{transaction.getName(), String.valueOf(transaction.getAmount()),
                        transaction.getDate().toString(), transaction.getCategory()});
                tableModel.addRow(new String[]{"transaction.getName()", "transaction.getAmount()",
                        "transaction.getDate()", "transaction.getCategory()"});
            }
        }

        JTable incomeHistoryTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(incomeHistoryTable);

        panel.add(tableScrollPane);
        panel.setSize(300, 400);
        incomeHistoryTable.setFillsViewportHeight(true);
        incomeHistoryTable.setVisible(true);
        panel.setVisible(true);

        //Add chart API here!

        final JPanel addIncomeBut = new JPanel();
        addIncome = new JButton("AddIncome");
        addIncomeBut.add(addIncome);

        addIncome.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        viewSwitcher.switchTo(ViewNames.addIncome);
                    }
                }
        );

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

        incomeButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(ViewNames.incomeHistory);
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

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(panel);
        this.add(addIncomeBut);
        this.add(buttons);
    }


    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    @Override
    public void actionPerformed(ActionEvent evt) {System.out.println("Click " + evt.getActionCommand());}


    public String getViewName() {
        return viewName;
    }

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
        populateTable();
    }

    private void populateTable() {

    }
}
