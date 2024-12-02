package use_case.add_goal;

import entity.GoalList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AddGoalInteractorTest {

    @Test
    void successTest() {
        AddGoalInputData inputData = new AddGoalInputData(
                "car", 2000, LocalDate.of(2024, 12,12));
        GoalList goalList =  new GoalList();

        AddGoalOutputBoundary successPresenter = new  {
            @Override
            public void prepareSuccessView(AddGoalOutputData goals) {
                assertEquals("goal", goals.getTarget());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected.");
            }

            @Override
            public void switchToHomeVIew() {

            }
        };
    }
}
