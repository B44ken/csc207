package use_case.add_expense;

/**
 * The Add Expense Interactor
 */
public class AddExpenseInteractor implements AddExpenseInputBoundary {
    private final AddExpenseOutputBoundary addExpensePresenter;

    public AddExpenseInteractor(AddExpenseOutputBoundary addExpenseOutputBoundary) {
        this.addExpensePresenter = addExpenseOutputBoundary;
    }

    @Override
    public void execute(AddExpenseInputData addExpenseInputData) {
        final String name = addExpenseInputData.getName();
        final float amount = addExpenseInputData.getAmount();
        final String category = addExpenseInputData.getCategory();
        final String date = addExpenseInputData.getDate();

        //to check: does the expense by name already exist?
        //if not, then create the expense and add to the expenses database
    }

    @Override
    public void switchToHomeView() {
        addExpensePresenter.switchToHomeView();
    }
}
