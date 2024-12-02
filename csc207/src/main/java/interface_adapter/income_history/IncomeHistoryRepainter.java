package interface_adapter.income_history;

import data_access.ChartImageFactory;
import data_access.UserData;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class IncomeHistoryRepainter {
    private UserData userData;

    public IncomeHistoryRepainter(UserData userData) {
        this.userData = userData;
    }
        public JPanel execute() {
            var api = new ChartImageFactory(userData.getHistory());
            JLabel incomeChart = api.createIncomeImage(LocalDate.of(2000, 1, 1), LocalDate.now());
            JPanel result = new JPanel();
            result.setSize(300, 300);
            result.add(incomeChart);
            return result;
        }
}
