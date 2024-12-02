package view;

import use_case.budget_report.BudgetReportInteractor;

import java.time.LocalDate;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// import interface_adapter.BudgetReportInteractor;

public class BudgetReportView extends JPanel {
    private BudgetReportInteractor interactor;

    private JTextArea report;

    public BudgetReportView(BottomButtons bottom) {
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
        this.add(bottom);
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

    public void onCategoricalReport() { }

    public void onBalanceReport() { }

    public void setInteractor(BudgetReportInteractor interactor) {
        this.interactor = interactor;
        repaint();
    }

    public void repaint() {
        if (interactor != null)
            report.setText(interactor.createBudgetReport(LocalDate.now()));
    }
}
