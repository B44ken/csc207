package interface_adapter.add_income;

// takes output data and turns it into raw strings
// this tells UI what to do when the use case finishes running

import use_case.add_income.AddIncomeOutputBoundary;
import use_case.add_income.AddIncomeOutputData;

public class AddIncomePresenter implements AddIncomeOutputBoundary {

    private final AddIncomeViewModel addIncomeViewModel;

    public AddIncomePresenter(AddIncomeViewModel addIncomeViewModel) {
        this.addIncomeViewModel = addIncomeViewModel;
    }

    /**
     * Prepares the success view for the Add Income Use Case.
     *
     * @param outputData the output data
     */
    @Override
    public void prepareSuccessView(AddIncomeOutputData outputData) {
        // i'm kinda confused on what's happening here
        addIncomeViewModel.firePropertyChanged("income");
    }

    /**
     * Prepares the failure view for the Add Income Use Case.
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage) {
        // this use case currently cannot fail.
    }
}
