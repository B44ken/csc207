package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.labrats.app.ViewNames;

public class BottomButtons extends JPanel {
    public BottomButtons(ViewSwitcher vs) {
        var homeButton = new JButton("Home");
        homeButton.addActionListener(e -> vs.switchTo(ViewNames.home));
        this.add(homeButton);

        var incomeButton = new JButton("Income History");
        incomeButton.addActionListener(e -> vs.switchTo(ViewNames.incomeHistory));
        this.add(incomeButton);

        var expenseButton = new JButton("Expense History");
        expenseButton.addActionListener(e -> vs.switchTo(ViewNames.expenseHistory));
        this.add(expenseButton);

        var goalButton = new JButton("Goal List");
        goalButton.addActionListener(e -> vs.switchTo(ViewNames.goalList));
        this.add(goalButton);
    }

    public static JPanel create(ViewSwitcher vs) {
        var panel = new JPanel();

        var homeButton = new JButton("Home");
        homeButton.addActionListener(e -> vs.switchTo(ViewNames.home));
        panel.add(homeButton);

        var incomeButton = new JButton("Income History");
        incomeButton.addActionListener(e -> vs.switchTo(ViewNames.incomeHistory));
        panel.add(incomeButton);

        var expenseButton = new JButton("Expense History");
        expenseButton.addActionListener(e -> vs.switchTo(ViewNames.expenseHistory));
        panel.add(expenseButton);

        var goalButton = new JButton("Goal List");
        goalButton.addActionListener(e -> vs.switchTo(ViewNames.goalList));
        panel.add(goalButton);

        return panel;
    }
}