
package use_case.add_expense;

/**
 * The input data for the Add Expense Use Case.
 */
public class AddExpenseInputData {
    private final String name;
    private final String amount;
    private final String category;

    private final String day;
    private final String month;
    private final String year;

    public AddExpenseInputData(String name, String amount, String category, String day, String month, String year) {
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    String getAmountString(){
        return amount;
    }

    String getName() {
        return name;
    }

    String getCategory() {
        return category;
    }

    String getDay() {
        return day;
    }

    String getMonth() {
        return month;
    }

    String getYear() {
        return year;
    }
}
