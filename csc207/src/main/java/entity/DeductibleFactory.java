package entity;

public class DeductibleFactory {

    public DeductibleFactory() {
    }

    /**
     * Singly responsible for creating Deductible objects.
     * @param expense Exepense object within Deductible.
     * @param income Income object within Deductible.
     * @return a Deductible object.
     */
    public Deductible createDeductible(Expense expense, Income income) {
        return new Deductible(expense, income);
    }
}
