package use_case.get_insight;

import data_access.UserData;
import entity.Transaction;
import entity.TransactionHistory;

import java.util.ArrayList;

public class GetInsightInputData {
    private ArrayList<Transaction> inputData;

    public GetInsightInputData(TransactionHistory transactionHistory) {
        this.inputData = transactionHistory.getHistory();
    }

    public ArrayList<Transaction> getInputData() {
        return inputData;
    }

}
