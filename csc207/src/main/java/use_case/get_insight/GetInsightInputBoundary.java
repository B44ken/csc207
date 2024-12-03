package use_case.get_insight;

import java.util.ArrayList;

import entity.Deductible;

/**
 * ArrayList interface.
 */
public interface GetInsightInputBoundary {
    /**
     * Execute method.
     * @param getInsightInputData input data.
     * @return ArrayList type.
     */
    ArrayList<Deductible> execute(GetInsightInputData getInsightInputData);
}
