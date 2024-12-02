package use_case.add_expense;

import entity.TransactionFactory;
import entity.Transaction;

import java.time.LocalDate;

/**
 * The Add Expense Interactor
 */
public class AddExpenseInteractor implements AddExpenseInputBoundary {
    private final AddExpenseDataAccessInterface addExpenseDataAccessObject;
    private final AddExpenseOutputBoundary addExpensePresenter;
    private final TransactionFactory transactionFactory;

    public AddExpenseInteractor(AddExpenseDataAccessInterface addExpenseDataAccessInterface,
                                AddExpenseOutputBoundary addExpenseOutputBoundary,
                                TransactionFactory transactionFactory) {
        this.addExpenseDataAccessObject = addExpenseDataAccessInterface;
        this.addExpensePresenter = addExpenseOutputBoundary;
        this.transactionFactory = transactionFactory;
    }

    @Override
    public void execute(AddExpenseInputData addExpenseInputData) {

        if (addExpenseDataAccessObject.existsByName(addExpenseInputData.getName())) {
            addExpensePresenter.prepareFailView("Transaction already exists");
        }
        else {
            final Transaction transaction = transactionFactory.create(addExpenseInputData.getName(),
                    addExpenseInputData.getAmount(), addExpenseInputData.getCategory(), addExpenseInputData.getDate());

            addExpenseDataAccessObject.save(transaction);

            final AddExpenseOutputData addExpenseOutputData = new AddExpenseOutputData(transaction.getName());
        }
    }

    @Override
    public void switchToHomeView() {
        addExpensePresenter.switchToHomeView();
    }
}
