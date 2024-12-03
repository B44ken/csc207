package interface_adapter.get_insight;

import javax.swing.*;

import com.labrats.app.ViewNames;
import entity.Deductible;
import interface_adapter.ViewManagerModel;
import use_case.get_insight.GetInsightInputData;
import use_case.get_insight.GetInsightOutputData;
import view.ViewSwitcher;

import java.util.ArrayList;

public class GetInsightPresenter {

    private final GetInsightViewModel viewModel;
    private final ViewSwitcher viewSwitcher;

    public GetInsightPresenter(ViewSwitcher viewSwitcher,
                          GetInsightViewModel viewModel) {
        this.viewSwitcher = viewSwitcher;
        this.viewModel = viewModel;
    }

    public void createAllButtons(ArrayList<Deductible> deductables) {

    }

    public void prepareFailView() {
        // Existing logic...
        JOptionPane.showMessageDialog(null, "Login failed: " , "Error", JOptionPane.ERROR_MESSAGE);
    }
}
