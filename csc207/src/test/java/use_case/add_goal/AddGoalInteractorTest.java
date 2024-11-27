package use_case.add_goal;

import entity.GoalList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AddGoalInteractorTest {
    private AddGoalUserDataAccessInterface userDataAccessInterface;
    private AddGoalOutputBoundary userPresenter;
    private GoalList goalList;
    private AddGoalInteractor interactor;

    void successTest() {
        LocalDate exampleDate = LocalDate.of(2024, 12, 31);
        AddGoalInputData inputData = new AddGoalInputData("car", 4000,
                LocalDate.of(2024, 12, 31));

        interactor.execute(inputData);

        // assertEquals(1, goalList.size());

    }
}
