package entity;


public class Deductible {
    Expense expense;
    Income credit;

    public Deductible(Expense expense, Income income) {
        this.expense = expense;
        this.credit = income;
    }

    public Income getIncome() {
        return credit;
    }

    public Expense getExpense() {
        return expense;
    }

    public String getExpenseName() {
        return expense.getName();
    }

    public double getIncomeCredit() {
        return credit.getAmount();
    }
}
