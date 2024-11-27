package view;

import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data_access.UserData;

public class ViewSwitcher {
    private CardLayout layout;
    private JPanel cards;
    private ArrayList<String> views;

    public ViewSwitcher(JPanel cards) {
        this.cards = cards;
        this.layout = (CardLayout) cards.getLayout();
        this.views = new ArrayList<String>();
    }

    public void switchTo(String name) {
        if(!views.contains(name)) {
            JOptionPane.showMessageDialog(null, "view '" + name + "' does not exist", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        layout.show(cards, name);
    }

    public void add(String name, JPanel panel) {
        if(views.contains(name))
            throw new IllegalArgumentException("view '" + name + "' already exists");
        views.add(name);
        cards.add(panel, name);
    }

}