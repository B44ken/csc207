package view;

/**
 * The state for the Home View Model.
 */
public class HomeState {
    private float balance = 0;
    private float income = 0;
    private float expenses = 0;

    @Override
    public String toString() {
        return "HomeState{"
                + "NetBalance'" + balance + '\''
                + ", Income'" + income + '\''
                + ", Expenses'" + expenses + '\''
                + '}';
    }
}
