package interface_adapter.income_history;

import interface_adapter.ViewModel;
import interface_adapter.add_income.AddIncomeState;

public class IncomeHistoryViewModel extends ViewModel<AddIncomeState> {
    public IncomeHistoryViewModel(String viewName) {
        super("income_history");
    }
}
