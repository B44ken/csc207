package use_case.add_income;

import java.util.Date;

/**
 * The input data for Add Income use case.
 */

public class AddIncomeInputData {

    private final String name;
    private final double amount;
    private final Date date;

    public AddIncomeInputData(String name, double amount, Date date) {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    String getName() {
        return name;
    }

    double getAmount() {
        return amount;
    }

    Date getDate() {
        return date;
    }
}
