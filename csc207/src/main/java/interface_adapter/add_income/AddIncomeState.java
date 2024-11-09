package interface_adapter.add_income;

import java.util.Date;

/**
 * The State information representing the new income transaction to be logged.
 */
public class AddIncomeState {
    private String name = "";
    private int amount;

    private Date date;

    public AddIncomeState(AddIncomeState copy) {
        this.name = copy.name;
        this.amount = copy.amount;
        this.date = copy.date;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    // I DON'T GET THIS
    public AddIncomeState() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
