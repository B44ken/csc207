package interface_adapter.get_insight;

import javax.swing.JOptionPane;

import com.labrats.app.ViewNames;
import interface_adapter.ViewManagerModel;
import use_case.get_insight.GetInsightInputData;
import use_case.get_insight.GetInsightOutputData;
import view.ViewSwitcher;

public class GetInsightPresenter {

    private final GetInsightViewModel viewModel;
    private final ViewSwitcher viewSwitcher;

    public GetInsightPresenter(ViewSwitcher viewSwitcher,
                          GetInsightViewModel viewModel) {
        this.viewSwitcher = viewSwitcher;
        this.viewModel = viewModel;
    }

    public void prepareSuccessView(GetInsightOutputData outputData) {
        // On success, pass output data of which

        // TODO need to fix below
        //this.viewModel.setState(Success);
        //this.viewModel.firePropertyChanged();

        this.viewSwitcher.switchTo(ViewNames.home);

        JOptionPane.showMessageDialog(null, "Login successful! Welcome, ", "Success", JOptionPane.INFORMATION_MESSAGE);

    }

    public void prepareFailView() {
        // Existing logic...
        JOptionPane.showMessageDialog(null, "Login failed: " , "Error", JOptionPane.ERROR_MESSAGE);
    }
}
