package use_case.get_insight;

/**
 * Abstraction layer for Get Insight Use Case, according to Dependency Inversion Principle.
 */
public interface GetInsightInputBoundary {
    Object execute(GetInsightInputData getInsightInputData);
}
