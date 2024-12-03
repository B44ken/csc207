package entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class GoalListTest {

    @Test
    void constructorTest() throws Exception {
        GoalList  goalList = new GoalList();
        if(goalList.getList() == null) {
            throw new Exception("Fail: Initializing Constructor.");
        }
    }
    @Test
    void addTest() throws Exception {
        GoalList goalList = new GoalList();
        Goal goal = new Goal(null, null, null);
        goal.setTarget("car");
        goal.setAmount(2000.0);
        goal.setTargetDate(LocalDate.of(2024,12,12));
        goalList.add(goal);
        if(!goalList.getList().contains(goal)){
            throw new Exception("add() method error.");
        }
    }
}
