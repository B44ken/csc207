package entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class GoalFactoryTest {

    @Test
    void goalCreateTest() throws  Exception {
        GoalFactory goalFactory = new GoalFactory();
        Goal testGoal = new Goal("oven", 200.0, LocalDate.of(2025, 2, 2));
        boolean b = !testGoal.equals(goalFactory.create("oven", 200.0,
                LocalDate.parse("02-02-2025")));

        if (b) {
            throw new Exception("create() method error.");
        }
    }
}
