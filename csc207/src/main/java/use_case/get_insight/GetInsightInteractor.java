package use_case.get_insight;

import java.util.ArrayList;
import java.util.Objects;

import data_access.UserData;
import entity.*;

public class GetInsightInteractor implements GetInsightInputBoundary {
    private final double percentage = 0.75;

    private UserData userData;
    // constant: average spending of UOFT student

    public GetInsightInteractor(UserData userData) {
        this.userData = userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    /**
     * Executes get insight use case
     * Implements the logic of execution:
     *         get the expense out of the input data.
     *         instantiate the `LogoutOutputData`, which needs to contain the correct insight.
     *         tell the presenter to prepare a success view.
     * @param inputData the inputData created by Controller.
     * @return ArrayList output Data object to be returned.
     */
    public ArrayList<Deductible> execute(GetInsightInputData inputData) {
        final ArrayList<Deductible> result = new ArrayList<>();
        final DeductibleFactory factory = new DeductibleFactory();
        final IncomeFactory incomeFactory = new IncomeFactory();
        // for every charity category transaction,
        for (Transaction t : inputData.getInputData()) {
            if (Objects.equals(t.getCategory(), "charity") && t instanceof Expense) {
                final Income income = incomeFactory.create(t.getName(),
                        t.getAmount() * percentage, t.getCategory(), t.getDate());
                final Deductible deductible = factory.createDeductible((Expense) t, income);
                result.add(deductible);
            }
        }
        return result;
    }

    public UserData getUserData() {
        return userData;
    }

    public double getPercentage() {
        return percentage;
    }
}
