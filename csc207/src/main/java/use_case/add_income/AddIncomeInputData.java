package use_case.add_income;

import java.time.LocalDate;

/**
 * The input data for Add Income use case.
 */

public class AddIncomeInputData {

    private final String name;
    private final double amount;
    private final LocalDate date;

    public AddIncomeInputData(String name, double amount, LocalDate date) {
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

    LocalDate getDate() {
        return date;
    }
}
