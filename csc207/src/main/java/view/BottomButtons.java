package view;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.labrats.app.ViewNames;

public class BottomButtons extends JPanel {
    ViewSwitcher vs;

    public BottomButtons(ViewSwitcher vs) {
        this.vs = vs;
        makeAndAddButton(ViewNames.home);
        makeAndAddButton(ViewNames.incomeHistory);
        makeAndAddButton(ViewNames.expenseHistory);
        makeAndAddButton(ViewNames.goalList);
    }

    void makeAndAddButton(String name) {
        var button = new JButton(name);
        button.addActionListener(e -> vs.switchTo(name));
        add(button);
    }
}
