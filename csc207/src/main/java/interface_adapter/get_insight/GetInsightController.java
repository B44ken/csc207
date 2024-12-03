package interface_adapter.get_insight;

import java.util.List;

import data_access.UserData;
import entity.Deductible;
import use_case.get_insight.GetInsightInputData;
import use_case.get_insight.GetInsightInteractor;

public class GetInsightController {
    private final GetInsightInteractor interactor;

    public GetInsightController(GetInsightInteractor interactor) {
        // pass userdata to interactor
        this.interactor = interactor;
    }

    /**
     * Execute method of controller to pass inputData into interactor.
     * @param userData the input UserData.
     * @return ArrayList<> as return type.
     */
    public List<Deductible> execute(UserData userData) {
        final GetInsightInputData inputData = new GetInsightInputData(userData.getHistory());
        System.out.println("controller executed");
        return this.interactor.execute(inputData);
    }
}
