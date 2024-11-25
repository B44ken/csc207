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

public class IncomeHistoryView extends JPanel implements ActionListener {
    private final String viewName = "income history";

    private final DefaultTableModel tableModel;
    private final JTable incomeHistoryTable;

    private final JButton addIncome;

    private final JButton homeButton;
    private final JButton incomeButton;
    private final JButton expenseButton;
    private final JButton goalsButton;
    private ViewSwitcher viewSwitcher;

    private UserData userData;


    public IncomeHistoryView() {
        super();
        final JLabel title = new JLabel("Income History");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        String[] columnNames = {"Name", "Amount", "Date", "Category"};
        tableModel = new DefaultTableModel(columnNames, 0);

        if (this.userData != null) {
            TransactionHistory data = userData.getHistory().getAllIncomes();
            // DefaultTableModel model = (DefaultTableModel) incomeHistoryTable.getModel();
            for (Transaction transaction : data.getHistory()) {
                tableModel.addRow(new Object[]{transaction.getName(), transaction.getAmount(),
                        transaction.getDate().toString(), transaction.getCategory()});
                tableModel.addRow(new Object[]{"transaction.getName()", "transaction.getAmount()",
                        "transaction.getDate()", "transaction.getCategory()"});
            }
        }
        incomeHistoryTable = new JTable(tableModel);


        incomeHistoryTable.setFillsViewportHeight(true);
        JScrollPane tableScrollPane = new JScrollPane(incomeHistoryTable);
        add(tableScrollPane, BorderLayout.CENTER);

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
//        this.add(incomeHistoryTable);
        this.add(addIncomeBut);
        this.add(buttons);
    }

//    private void populateTable() {
//        if (incomeHistoryTable != null) {
//
//            }
//        }
//    }
//
//    public void repaint() {
//        populateTable();
//    }

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
//        repaint();
    }
}
