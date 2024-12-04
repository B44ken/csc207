package entity;

import java.time.LocalDate;

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

    public double getIncomeAmount() {
        return credit.getAmount();
    }

    public double getExpenseAmount() {
        return expense.getAmount();
    }

    public String getExpenseName() {
        return expense.getName();
    }

    public LocalDate getCreditDate() {
        return credit.getDate();
    }

    public LocalDate getExpenseDate() {
        return expense.getDate();
    }
}
