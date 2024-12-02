package interface_adapter.get_insight;

import data_access.UserData;
import entity.Deductible;
import entity.Deductible;
import use_case.get_insight.GetInsightInputData;
import use_case.get_insight.GetInsightInteractor;

import java.util.ArrayList;

public class GetInsightController {
    private final GetInsightInteractor interactor;

    public GetInsightController(GetInsightInteractor interactor) {
        // pass userdata to interactor
        this.interactor = interactor;
    }

    public void execute(UserData userData) {
        GetInsightInputData inputData = new GetInsightInputData(userData.getHistory());
        this.interactor.execute(inputData);
    }
    public ArrayList<Deductible> getDeductibles(UserData userData){
        GetInsightInputData inputData = new GetInsightInputData(userData.getHistory());
        return this.interactor.execute(inputData);
    }

}
