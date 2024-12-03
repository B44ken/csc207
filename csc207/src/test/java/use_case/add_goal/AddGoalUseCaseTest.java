package use_case.add_goal;

import data_access.UserData;
import entity.Goal;
import entity.GoalFactory;
import interface_adapter.add_goal.AddGoalPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Objects;

public class AddGoalUseCaseTest {
    private UserData testUserData;
    private GoalFactory testGoalFactory;
    private AddGoalOutputBoundary testUserPresenter;
    private AddGoalInteractor testAddGoalInteractor;
    private AddGoalInputData testAddGoalInputData;

    @BeforeEach
    void setUpForTests() {
        testUserData = new UserData();
        testGoalFactory = new GoalFactory();
        testUserPresenter = new AddGoalPresenter();
    }

    @Test
    void addToUserDataTest() {
        testAddGoalInteractor = new AddGoalInteractor(testUserData, testUserPresenter, testGoalFactory);
        testAddGoalInputData = new AddGoalInputData("car", 2000.0,
                LocalDate.of(2024, 12, 12));
        try {
            testAddGoalInteractor.execute(testAddGoalInputData);
            if (!testUserData.getGoals().getList().isEmpty()) {
                Goal testGoal = testUserData.getGoals().getList().get(0);
                if (testGoal.getTarget().equals("car") && testGoal.getAmount() == 2000.0 &&
                        Objects.equals(testGoal.getTargetDate(), LocalDate.of(2024, 12, 12))) {
                    System.out.println("Success: Adding to User Data");
                } else {
                    System.err.println("Fail: Adding to User Data");
                }
            }
        } catch (Exception e) {
            System.err.println("Fail: Adding to User Data");
        }
    }

    @Test
    void addGoalOutputDataTest() {
        try {
            AddGoalOutputData outputData = new AddGoalOutputData("vacation", false);

            if (!"vacation".equals(outputData.getTarget())) {
                throw new Exception("Fail: Output target does not match expected value.");
            }
            if (outputData.isUseCaseFailed()) {
                throw new Exception("Fail: Use case passed.");
            }

            AddGoalOutputData failedOutputData = new AddGoalOutputData("emergency", true);

            if (!"emergency".equals(failedOutputData.getTarget())) {
                throw new Exception("Fail: Failed output target does not match expected value.");
            }
            if (!failedOutputData.isUseCaseFailed()) {
                throw new Exception("Fail: Use case failed.");
            }

            System.out.println("Success: AddGoalOutputData tested.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Test
    void addMultipleGoalsTest() {
        testAddGoalInteractor = new AddGoalInteractor(testUserData, testUserPresenter, testGoalFactory);

        AddGoalInputData goal1 = new AddGoalInputData("car", 2000.0,
                LocalDate.of(2024, 12, 12));
        AddGoalInputData goal2 = new AddGoalInputData("house", 100000.0,
                LocalDate.of(2030, 6, 15));

        try {
            testAddGoalInteractor.execute(goal1);
            testAddGoalInteractor.execute(goal2);

            if (testUserData.getGoals().getList().size() != 2) {
                throw new Exception("Fail: Number of goals in user data is incorrect.");
            }

            Goal firstGoal = testUserData.getGoals().getList().get(0);
            Goal secondGoal = testUserData.getGoals().getList().get(1);

            if (!firstGoal.getTarget().equals("car") && firstGoal.getAmount() != 2000.0 &&
                    !firstGoal.getTargetDate().equals(LocalDate.of(2024, 12, 12))) {
                throw new Exception("Fail: First goal details do not match expected values.");
            }

            if (!secondGoal.getTarget().equals("house") && secondGoal.getAmount() != 100000.0 &&
                    !secondGoal.getTargetDate().equals(LocalDate.of(2030, 6, 15))) {
                throw new Exception("Fail: Second goal details do not match expected values.");
            }

            System.out.println("Success: Adding multiple goals to User Data");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}