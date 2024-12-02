package use_case.get_insight;

public class GetInsightOutputData {
    private String expensesLevel;
    private boolean useCaseFailed;

    public GetInsightOutputData(String expensesLevel, boolean useCaseFailed) {
        // save the parameters in the instance variables.
        this.expensesLevel = expensesLevel;
    }

    public String getExpensesLevel() {
        return expensesLevel;
    }
}
