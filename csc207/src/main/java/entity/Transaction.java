package entity;

import java.time.LocalDate;

/**
 * Transaction parent class.
 */
public class Transaction {
    private String name;
    private double amount;
    private String category;
    private LocalDate date;

    public Transaction(String name, double amount, String category, LocalDate date) {
        this.name = name;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    /**
     * Returns name of Transaction.
     * @return name of Transaction.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name of Transaction.
     * @param name of Transaction.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns amount of Transaction.
     * @return amount of Transaction.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets amount of Transaction.
     * @param amount of Transaction.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Returns category of Transaction.
     * @return category of Transaction.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets category of Transaction.
     * @param category of Transaction.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Returns date of Transaction.
     * @return date of Transaction.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Sets date of Transaction.
     * @param date of Transaction.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

}
