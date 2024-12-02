package view;

import com.labrats.app.ViewNames;
import data_access.ChartImageFactory;
import data_access.UserData;
import entity.Transaction;
import entity.TransactionHistory;
import interface_adapter.income_history.IncomeHistoryController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;


/**
 * Class for IncomeHistoryView. Includes Title, incomeHistory, addIncome, CHARTAPI, home buttons.
 */

public class IncomeHistoryView extends JPanel implements ActionListener {
    private final String viewName = "income history";
    private DefaultTableModel tableModel;
    private JTable incomeHistoryTable;
    private JPanel panel;
    private JPanel panelChart;

    private final JButton homeButton;
    private final JButton incomeButton;
    private final JButton expenseButton;
    private final JButton goalsButton;
    private ViewSwitcher viewSwitcher;
    private IncomeHistoryController controller;

    public IncomeHistoryView(IncomeHistoryController controller) {
        this.controller = controller;
        // this.viewSwitcher = viewSwitcher;
        final JLabel title = new JLabel("Income History");

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        //Add chart API here!

        this.panel = new JPanel();
        this.panelChart = new JPanel();
        var addIncomeButton = new JButton(ViewNames.addIncome);

        addIncomeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                viewSwitcher.switchTo(ViewNames.addIncome);
            }
        });

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
                        viewSwitcher.switchTo(ViewNames.goalList);
                    }
                }
        );


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setUpTable();


        this.add(title);
        this.add(panel);
        this.add(panelChart);
        this.add(addIncomeButton);
        this.add(buttons, BorderLayout.AFTER_LAST_LINE);

        repaint();
    }

    @Override
    public void repaint() {
        if (controller!= null) {
            controller.execute(tableModel);
        }
        // this.repaintChart();
    }

//    public void repaintChart() {
//        var api = new ChartImageFactory(new TransactionHistory());
//        JLabel incomeChart = api.createIncomeImage(LocalDate.of(2024, 1, 1), LocalDate.now());
//        this.panelChart.setComponentZOrder(incomeChart, 0);
//    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    @Override
    public void actionPerformed(ActionEvent evt) {System.out.println("Click " + evt.getActionCommand());}

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }


    /**
     * Populates table when view is switched....
     */
    public void setUpTable() {
        String[] columnNames = {"Name", "Amount", "Date", "Category"};
        tableModel = new DefaultTableModel(columnNames, 0);

        incomeHistoryTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(incomeHistoryTable);
        TitledBorder tableTitle = BorderFactory.createTitledBorder("Expense History");
        tableScrollPane.setBorder(tableTitle);
        incomeHistoryTable.setFillsViewportHeight(true);
        incomeHistoryTable.setVisible(true);
        panel = new JPanel();
        panel.add(tableScrollPane);
        panel.setSize(300, 400);
        panel.setVisible(true);
    }

}
