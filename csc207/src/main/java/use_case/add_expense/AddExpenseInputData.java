package use_case.add_expense;

import java.time.LocalDate;

/**
 * The input data for the Add Expense Use Case.
 */
public class AddExpenseInputData {
    private final String name;
    private final String amount;
    private final String category;

    public AddExpenseInputData(String name, String amount, String category) {
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    String getAmountString(){
        return amount;
    }

    String getName(){
        return name;
    }

    String getCategory(){
        return category;
    }

}
