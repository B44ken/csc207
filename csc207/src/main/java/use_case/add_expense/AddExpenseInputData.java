package use_case.add_expense;

import java.time.LocalDate;

/**
 * The input data for the Add Expense Use Case.
 */
public class AddExpenseInputData {
    private final float amount;
    private final String name;
    private final String category;
    private final LocalDate date;

    public AddExpenseInputData(float amount, String name, String category, LocalDate date) {
        this.amount = amount;
        this.name = name;
        this.category = category;
        this.date = date;
    }

    float getAmount(){
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
