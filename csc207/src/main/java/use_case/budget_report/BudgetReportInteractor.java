// Example Report, March 2024
// Expenses: $1,101
// Income: $1,351
// Remaining Balance: $3502
// Your spendings on food was $256 over your budget
// Your spendings on transport was $80 over your budget
 
// Example Categorical Report, March 2024
// Income
// Paycheck ($2133)
// Expenses
// Rent ($1321)
// Food ($462)


package use_case.budget_report;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import data_access.UserData;
import entity.TransactionHistory;

public class BudgetReportInteractor {
    class KeyValue {
        String key;
        Double value;

        public KeyValue(String k, Double v) {
            key = k;
            value = v;
        }
    }

    UserData userData;

    public BudgetReportInteractor(UserData ud) {
        userData = ud;
    }

    private TransactionHistory getMonthsTransactions(TransactionHistory history) {
        var monthStart = LocalDate.now().withDayOfMonth(1);
        var monthEnd = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());
        return history.getBetween(monthStart, monthEnd);
    }

    private ArrayList<KeyValue> categorizeExpenses(TransactionHistory history) {
        var cats = new ArrayList<KeyValue>();
        for (var t : history.getAllExpenses().getHistory()) {
            var found = false;
            for (var c : cats) {
                if (c.key.equals(t.getCategory()) && !found) {
                    c.value += t.getAmount();
                    found = true;
                } 
            }
            if (!found)
                cats.add(new KeyValue(t.getCategory(), t.getAmount()));
        }

        cats.sort((a, b) -> b.value.compareTo(a.value));
       
        return cats;
    }

    public String createBudgetReport(LocalDate stamp) {
        var monthStart = stamp.withDayOfMonth(1);
        var monthEnd = stamp.withDayOfMonth(stamp.lengthOfMonth());
        var transactions = userData.getHistory().getBetween(monthStart, monthEnd);
        
        StringBuilder report = new StringBuilder();

        report.append("Budget Report for " + stamp.getMonth() + " " + stamp.getYear() + "\n");

        var categories = categorizeExpenses(transactions);

        for (var c : categories) {
            var i = categories.indexOf(c) + 1;
            report.append(i + ". " + c.key + " ($" + c.value + ")\n");
        }

        return report.toString();
    }
}
