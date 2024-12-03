package use_case.budget_report;

import data_access.UserData;
import view.BudgetReportView;

public class BudgetReportController {
    UserData userData;
    public BudgetReportController() {
        var budgetReportInteractor = new BudgetReportInteractor(new UserData());
        var budgetReportView = new BudgetReportView(null);
    }
}
