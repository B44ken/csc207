package view;

import use_case.history.ExpenseHistoryController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExpenseHistoryView extends JPanel {
    private JPanel panel;
    private ViewSwitcher viewSwitcher;

    private JTable table;
    private DefaultTableModel tableModel;
    private JPanel tablePanel;

    private ExpenseHistoryController interactor;

    public ExpenseHistoryView(BottomButtons bottomButtons, ExpenseHistoryController interactor) {
        this.interactor = interactor;

        final JLabel title = new JLabel("Expense History");

        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        this.panel = new JPanel();

        JPanel addExpenseButton = new JPanel();
        JButton addExpense = new JButton("Add Expense");
        addExpenseButton.add(addExpense);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(panel);
        
        setupTable();
        add(tablePanel);
        

        this.add(addExpenseButton);
        add(bottomButtons, BorderLayout.AFTER_LAST_LINE);

    }

    public void setViewSwitcher(ViewSwitcher viewSwitcher) {
        this.viewSwitcher = viewSwitcher;
    }

    public void repaint() {
        if (interactor != null)
            interactor.execute(tableModel);
    }

    public void attachSwitchToOnButton(JButton button, String viewName) {
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        viewSwitcher.switchTo(viewName);
                    }
                });
    }

    public void setupTable() {
        String[] columnNames = { "Name", "Amount", "Date", "Category" };
        tableModel = new DefaultTableModel(columnNames, 0);

        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setVisible(true);
        tablePanel = new JPanel();
        tablePanel.add(tableScrollPane);
        tablePanel.setSize(300, 400);
        tablePanel.setVisible(true);
    }

}
