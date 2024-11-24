package view;

import com.labrats.app.ViewNames;
import data_access.UserData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        final JLabel title = new JLabel("Income History");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        String[] columnNames = {"Name", "Amount", "Date", "Category"};
        tableModel = new DefaultTableModel(columnNames, 0);
        incomeHistoryTable = new JTable(tableModel);

        incomeHistoryTable.setFillsViewportHeight(true);
        JScrollPane tableScrollPane = new JScrollPane(incomeHistoryTable);
        add(tableScrollPane, BorderLayout.CENTER);

        // add call to data here
        loadDataFromFile("testdata.csv");
        // userData.getData()

        final JFrame table = new JFrame("List of Income:");
        table.setSize(50, 100);
        table.add(incomeHistoryTable);

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

        this.add(incomeHistoryTable);
        this.add(addIncomeBut);
        this.add(buttons);
    }

    private void loadDataFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split each line by commas
                String[] data = line.split(",");
                // Add the data as a new row to the table model
                if (data.length == 4) {  // Ensure correct number of columns
                    tableModel.addRow(new Object[]{data[0], Double.parseDouble(data[1]), data[2], data[3]});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {System.out.println("Click " + evt.getActionCommand());}


    public String getViewName() {
        return viewName;
    }

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }
}
