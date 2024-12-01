package interface_adapter.get_insight;

import data_access.UserData;
import use_case.get_insight.GetInsightInputData;
import use_case.get_insight.GetInsightInteractor;

public class GetInsightController {
    private final GetInsightInteractor interactor;

    public GetInsightController(GetInsightInteractor interactor) {
        // pass userdata to interactor
        this.interactor = interactor;
    }

    public void execute(UserData userData) {
        final GetInsightInputData inputData = new GetInsightInputData();
        this.interactor.execute(inputData);
    }
}
