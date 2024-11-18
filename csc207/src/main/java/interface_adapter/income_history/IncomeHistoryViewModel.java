package interface_adapter.income_history;

import interface_adapter.ViewModel;
import view.IncomeHistoryView;

public class IncomeHistoryViewModel extends ViewModel<IncomeHistoryState> {
    public IncomeHistoryViewModel(String viewName) {
        super("income_history");
        setState(new IncomeHistoryState());
    }
}
