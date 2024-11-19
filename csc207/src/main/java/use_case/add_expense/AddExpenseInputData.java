package use_case.add_expense;

/**
 * The input data for the Add Expense Use Case.
 */
public class AddExpenseInputData {
    private final float amount;
    private final String name;
    private final String category;
    private final String date;

    public AddExpenseInputData(float amount, String name, String category, String date) {
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

    String getDate(){
        return date;
    }
}
