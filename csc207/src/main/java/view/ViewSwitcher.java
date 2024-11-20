package view;

import java.awt.CardLayout;
import javax.swing.JPanel;

public class ViewSwitcher {
    private CardLayout layout;
    private JPanel cards;

    public ViewSwitcher(JPanel cards, CardLayout layout) {
        this.cards = cards;
        this.layout = layout;
    }

    public void switchTo(String name) {
        System.out.println("switching to " + name);
        layout.show(cards, name);
    }
}