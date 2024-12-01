package entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class GoalTest {
    @Test
    void getTargetTest() throws Exception {
        Goal goal = new Goal("car", 2000.0, LocalDate.of(2024,12,12));
        if (!"car".equals(goal.getTarget())) {
            throw new Exception("getTarget() method error.");
        }
    }

    @Test
    void setTargetTest() throws Exception {
        Goal goal = new Goal(null, 2000.0, LocalDate.of(2024,12,12));
        goal.setTarget("car");
        if (!"car".equals(goal.getTarget())) {
            throw new Exception("setTarget() method error.");
        }
    }

    @Test
    void getAmountTest() throws Exception {
        Goal goal = new Goal("car", 2000.0, LocalDate.of(2024,12,12));
        Double amount = goal.getAmount();
        if (!amount.equals(2000.0)) {
            throw new Exception("getAmount() method error.");
        }
    }

    @Test
    void setAmountTest() throws Exception {
        Goal goal = new Goal("car", null, LocalDate.of(2024,12,12));
        goal.setAmount(2000.0);
        Double amount = goal.getAmount();
        if (!amount.equals(2000.0)){
            throw new Exception("setAmount() method error.");
        }
    }

    @Test
    void getTargetDateTest() throws Exception {
        Goal goal = new Goal("car", 2000.0, LocalDate.of(2024,12,12));
        LocalDate targetDate = goal.getTargetDate();
        if (!targetDate.equals(LocalDate.of(2024,12,12))) {
            throw new Exception("getTargetDate() method error.");
        }
    }

    @Test
    void setTargetDateTest() throws Exception {
        Goal goal = new Goal("car", 2000.0, null);
        goal.setTargetDate(LocalDate.of(2024,12,12));
        LocalDate targetDate = goal.getTargetDate();
        if (!targetDate.equals(LocalDate.of(2024,12,12))) {
            throw new Exception("setTargetDate() method error.");
        }

    }

}
