package use_case.add_income;

import entity.Income;
import entity.TransactionHistory;

/**
 * The Add Income Interactor.
 */
public class AddIncomeInteractor implements AddIncomeInputBoundary {
    private final AddIncomeUserDataAccessInterface userDataAccessObject;
    private final AddIncomeOutputBoundary userPresenter;
    private final TransactionHistory transactionHistory;

    public AddIncomeInteractor(AddIncomeUserDataAccessInterface userDataAccessObject,
                                AddIncomeOutputBoundary userPresenter,
                                TransactionHistory transactionHistory) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
        this.transactionHistory = transactionHistory;
    }

    /**
     * Execute the Change Password Use Case.
     *
     * @param addIncomeInputData the input data for this use case
     */
    @Override
    public void execute(AddIncomeInputData addIncomeInputData) {
        final Income income = null;
        income.setAmount(addIncomeInputData.getAmount());
        income.setCategory(addIncomeInputData.getName());
        income.setDate(addIncomeInputData.getDate());
        transactionHistory.add(income);

        userDataAccessObject.addIncome(income);
        final AddIncomeOutputData addIncomeOutputData = new AddIncomeOutputData(income.getName(), false);
        userPresenter.prepareSuccessView(addIncomeOutputData);
    }
}
