package use_case.add_expense;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;

import data_access.UserData;
import data_access.UserDataFileAccess;
import entity.Expense;
import entity.Transaction;
import use_case.add_expense.AddExpenseInputData;
import use_case.add_expense.AddExpenseOutputBoundary;
import use_case.add_expense.AddExpenseOutputData;

public class AddExpenseInteractorTest {

    @Test
    void addExpenseTest() {
        AddExpenseInputData inputData = new AddExpenseInputData("KFC", "20.0", "food" +
                "food", "2", "12", "2024");
        UserData userData = new UserDataFileAccess("/Users/ethancua/IdeaProjects/csc207/testdata.csv");

        AddExpenseOutputBoundary successPresenter = new AddExpenseOutputBoundary() {
            @Override
            public void prepareSuccessView(AddExpenseOutputData expense) {
                String name = inputData.getName();
                Double amount = Double.valueOf(inputData.getAmountString());
                String category = inputData.getCategory();
                LocalDate date = LocalDate.of(Integer.parseInt(inputData.getYear()),
                        Integer.parseInt(inputData.getMonth()), Integer.parseInt(inputData.getDay()));
                Transaction inputExpense = new Expense(name, amount, category, date);
                //2 Things to check: the output data is correct, and the user has been created in the DAO.
                assertEquals("KFC", expense.getName());
                assertTrue(userData.getHistory().getHistory().equals(inputExpense));
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToHomeView() {
                //This is expected.
            }
        };
    }

}
