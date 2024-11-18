package view;

import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;

import javax.swing.JPanel;

import interface_adapter.ViewManagerModel;

/**
 * The View Manager for the program. It listens for property change events
 * in the ViewManagerModel and updates which View should be visible.
 */
public class ViewManager implements PropertyChangeListener {
    private final CardLayout cardLayout;
    private final JPanel views;
    private final ViewManagerModel viewManagerModel;

    public String currentView = "Home";
    private HashMap<String, JPanel> viewMap = new HashMap<>();

    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.addPropertyChangeListener(this);
    }

    public void setVisible(boolean visible) {
        views.setVisible(visible);
    }

    public void selectView(String viewName) {
        viewMap.get(currentView).setVisible(false);
        viewMap.get(viewName).setVisible(true);
        currentView = viewName;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final String viewModelName = (String) evt.getNewValue();
            cardLayout.show(views, viewModelName);
            System.out.println("Switched to " + viewModelName);
        }
    }
}
