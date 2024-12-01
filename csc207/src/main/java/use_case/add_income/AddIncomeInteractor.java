package use_case.add_income;

import java.time.LocalDate;

import data_access.UserData;
import entity.Income;
import entity.IncomeFactory;


// this class no longer implements AddIncomeInputBoundary
/**
 * The Add Income Interactor.
 */
public class AddIncomeInteractor{
    private final UserData userData;
    private final IncomeFactory incomeFactory;
    private final AddIncomeOutputBoundary userPresenter;

    public AddIncomeInteractor(UserData userData, AddIncomeOutputBoundary userPresenter, IncomeFactory incomeFactory) {
        this.userData = userData;
        this.incomeFactory = incomeFactory;
        this.userPresenter = userPresenter;
    }

    /**
     * Execute the Change Password Use Case.
     *
     * @param addIncomeInputData the input data for add income use case
     */
    // @Override
    public void execute(AddIncomeInputData addIncomeInputData) {
        final Income income = incomeFactory.create(addIncomeInputData.getName(), addIncomeInputData.getAmount(),
                addIncomeInputData.getCategory(), addIncomeInputData.getDate());
        userData.getHistory().add(income);
        userData.save();
        System.out.println("saved");
        // is the above code how we add new Transaction object into txt file?

    }

}
