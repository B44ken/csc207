package entity;

public class Deductible {
    private final Expense expense;
    private final Income credit;

    public Deductible(Expense expense, Income income) {
        this.expense = expense;
        this.credit = income;
    }

    public Income getIncome() {
        return credit;
    }

    public double getExpense() {
        return expense.getAmount();
    }

    public String getExpenseName() {
        return expense.getName();
    }
}
