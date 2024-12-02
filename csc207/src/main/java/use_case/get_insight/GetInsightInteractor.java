package use_case.get_insight;

import data_access.UserData;
import interface_adapter.get_insight.GetInsightPresenter;
import use_case.get_insight.GetInsightInputData;

public class GetInsightInteractor implements GetInsightInputBoundary {

    public UserData userData;
    public GetInsightPresenter presenter;
    // constant: average spending of UOFT student
    private double AVERAGE_SPENDING = 1000;

    public GetInsightInteractor(GetInsightInputData getInsightInputData) {
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
    public void execute(GetInsightInputData inputData) {
        final GetInsightOutputData outputData = new GetInsightOutputData("", false);
        presenter.prepareSuccessView(outputData);
        }
    }

    // Data access objects:
    // output what the net balance spending is
    // your expenses this week are currently below/above/similar to what a UofT student spends on average!
    // check out these resources to manage your spending better:
