package interface_adapter.home;

import data_access.UserData;

import javax.swing.*;

public class HomeValuesController {
    private UserData userData;

    public HomeValuesController(UserData userData) {
        this.userData = userData;
    }

    public void execute(JLabel incomeValue, JLabel expensesValue, JLabel netBalanceValue) {
        if (userData != null && incomeValue != null) {
            incomeValue.setText(Double.toString(userData.getHistory().getIncomeTotal()));
        }
        if (userData != null && expensesValue != null) {
            expensesValue.setText(Double.toString(userData.getHistory().getExpensesTotal()));
        }
        if (userData != null && netBalanceValue != null) {
            netBalanceValue.setText(Double.toString(userData.getHistory().getNetBalance()));
        }
    }
}
