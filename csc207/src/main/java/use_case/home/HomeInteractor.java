package use_case.home;

/**
 * The inpiut data for the Home View Use Case.
 */
public class HomeInteractor extends HomeInputBoundary {
    private final HomeOutputBoundary homePresenter;

    public HomeInteractor(HomeOutputBoundary homeOutputBoundary) {
        this.homePresenter = homeOutputBoundary;
    }

    @Override
    public void switchToAddExpense() {
        homePresenter.switchToAddExpense();
    }
}
