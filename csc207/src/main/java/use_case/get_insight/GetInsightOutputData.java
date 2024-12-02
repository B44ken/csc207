package use_case.get_insight;

import entity.Deductible;

import java.util.ArrayList;

public class GetInsightOutputData {
    private ArrayList<Deductible> deductableArrayList;

    public GetInsightOutputData() {
        // save the parameters in the instance variables.
        this.deductableArrayList = new ArrayList<>();
    }

    public ArrayList<Deductible> getDeductibleList() {
        return this.deductableArrayList;
    }
}
