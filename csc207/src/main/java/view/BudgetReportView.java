package view;

import use_case.budget_report.BudgetReportInteractor;

import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.labrats.app.ViewNames;

// import interface_adapter.BudgetReportInteractor;

public class BudgetReportView extends JPanel {
    private BudgetReportInteractor interactor;

    private JTextArea report;

    public BudgetReportView(BottomButtons bottom, ViewSwitcher vs) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        var titleContainer = new JPanel();
        var title = new JLabel("Budget Report");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(title.getFont().deriveFont(24.0f));
        titleContainer.add(title);

        var reportContainer = new JPanel(); 
        report = new JTextArea();
        report.setEditable(false);
        reportContainer.setSize(400, 400);
        reportContainer.add(report);

        this.add(titleContainer);
        this.add(reportContainer);
        this.add(reportButtons());

        var home = new JButton("Home");
        home.addActionListener(e -> vs.switchTo(ViewNames.home));
        this.add(home);

        var incomeHistory = new JButton("Income History");
        incomeHistory.addActionListener(e -> vs.switchTo(ViewNames.incomeHistory));
        this.add(incomeHistory);

        var expenseHistory = new JButton("Expense History");
        expenseHistory.addActionListener(e -> vs.switchTo(ViewNames.expenseHistory));
        this.add(expenseHistory);

        var goalList = new JButton("Goal List");
        goalList.addActionListener(e -> vs.switchTo(ViewNames.goalList));
        this.add(goalList);
    }

    public JPanel reportButtons() {
        var buttons = new JPanel();

        var categoricalButton = new JButton("Categorical Report");
        var balanceButton = new JButton("Balance Report");

        categoricalButton.addActionListener(e -> onCategoricalReport());
        balanceButton.addActionListener(e -> onBalanceReport());

        buttons.add(categoricalButton);
        buttons.add(balanceButton);

        return buttons;
    }

    public void onCategoricalReport() {
        report.setText(interactor.createCategoryReport(LocalDate.now()));
    }

    public void onBalanceReport() {
        report.setText(interactor.createBalanceReport(LocalDate.now()));6
    }

    public void setInteractor(BudgetReportInteractor interactor) {
        this.interactor = interactor;
        repaint();
    }

    public void repaint() {
        if (interactor != null)
            report.setText(interactor.createCategoryReport(LocalDate.now()));
    }
}
