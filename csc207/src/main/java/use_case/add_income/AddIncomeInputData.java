package use_case.add_income;

import java.time.LocalDate;

/**
 * The input data for Add Income use case.
 */

public class AddIncomeInputData {

    private final String name;
    private final double amount;
    private final String category;
    private final LocalDate date;

    public AddIncomeInputData(String name, double amount, String category, LocalDate date) {
        this.name = name;
        this.amount = amount;
        this.category = category;
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
    String getCategory() {
        return category;
    }
}
