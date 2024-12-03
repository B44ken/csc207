package entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class GoalFactoryTest {

    @Test
    void goalCreateTest() throws  Exception {
        GoalFactory goalFactory = new GoalFactory();
        Goal createdGoal = goalFactory.create("car", 2000.0,
                LocalDate.of(2024,12,12));
        Goal compareToGoal = new Goal(null, null, null);
        compareToGoal.setTarget("car");
        compareToGoal.setAmount(2000.0);
        compareToGoal.setTargetDate(LocalDate.of(2024,12,12));
        if (!createdGoal.getTarget().equals(compareToGoal.getTarget()) &&
                createdGoal.getAmount() != compareToGoal.getAmount() &&
                createdGoal.getTargetDate() != compareToGoal.getTargetDate()) {
            throw new Exception("Fail; Creating Goal");
        }
    }
}
