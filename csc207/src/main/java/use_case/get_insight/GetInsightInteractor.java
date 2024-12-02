package use_case.get_insight;

import data_access.UserData;
import entity.*;
import interface_adapter.get_insight.GetInsightPresenter;
import use_case.get_insight.GetInsightInputData;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class GetInsightInteractor implements GetInsightInputBoundary {

    public UserData userData;
    public GetInsightPresenter presenter;
    // constant: average spending of UOFT student
    private double AVERAGE_SPENDING = 1000;

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
     * @param inputData
     */
    public ArrayList<Deductible> execute(GetInsightInputData inputData) {
        ArrayList<Deductible> result = new ArrayList<>();
        // for every charity category transaction,
        for (Transaction t : inputData.getInputData()) {
            if (Objects.equals(t.getCategory(), "charity") && t instanceof Expense) {
                Deductible deductible = new Deductible((Expense) t, new Income(t.getName(), t.getAmount() * 0.75, t.getCategory(), t.getDate()));
                result.add(deductible);
            }
        }
        return result;
    }

}
