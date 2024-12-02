package interface_adapter.home;

import data_access.ChartImageFactory;
import data_access.UserData;

import javax.swing.*;
import java.time.LocalDate;

public class HomeChartController {

    private UserData userData;

    public HomeChartController(UserData userData) {
        this.userData = userData;
    }

    public JLabel execute() {
        if (userData != null) {
            var api = new ChartImageFactory(userData.getHistory());
            JLabel result = api.createImage(
                    LocalDate.of(2024, 12, 1), LocalDate.of(2024, 12, 31));
            result.setSize(400, 300);
            return result;
        }
        return null;
    }
}
