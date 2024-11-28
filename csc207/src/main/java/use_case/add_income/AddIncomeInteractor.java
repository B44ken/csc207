package use_case.add_income;

import java.time.LocalDate;

import data_access.UserData;
import entity.Income;


// this class no longer implements AddIncomeInputBoundary
/**
 * The Add Income Interactor.
 */
public class AddIncomeInteractor{
    private final UserData userData;
    // private final AddIncomeOutputBoundary userPresenter;

    public AddIncomeInteractor(UserData userData) {
        this.userData = userData;
        // this.userPresenter = userPresenter;
    }

    /**
     * Execute the Change Password Use Case.
     *
     * @param userData the input data for this use case
     */
    // @Override
    public void execute(UserData userData) {
        userData.getHistory().add(new Income("food", 10.0, "income", LocalDate.of(2024, 12, 12)));
        // is the above code how we add new Transaction object into txt file?

    }

//    /**
//     *
//     */
//    @Override
//    public void switchToHomeView() {
//        userPresenter.switchToHomeVIew();
//    }
}
