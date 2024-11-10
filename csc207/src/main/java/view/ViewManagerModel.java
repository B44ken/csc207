package view;

/**
 * Model for the View Manager. Its state is the name of the view
 * which is currently active. An initial state of "" is used.
 */
public class ViewManagerModel extends ViewModel<String> {

    public ViewManagerModel() {
        super("view manager");
        this.setState("");
    }
}
