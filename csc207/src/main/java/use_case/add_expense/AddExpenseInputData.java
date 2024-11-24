package use_case.add_expense;

import java.time.LocalDate;

/**
 * The input data for the Add Expense Use Case.
 */
public class AddExpenseInputData {
    private final String name;
    private final double amount;
    private final String category;
    private final LocalDate date;

    public AddExpenseInputData(String name, double amount, String category, LocalDate date) {
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    double getAmount(){
        return amount;
    }

    String getName(){
        return name;
    }

    String getCategory(){
        return category;
    }

    LocalDate getDate(){
        return date;
    }
}
