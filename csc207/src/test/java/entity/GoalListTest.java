package entity;

import org.junit.jupiter.api.Test;

public class GoalListTest {

    @Test
    void addTest() throws Exception {
        GoalList goalList = new GoalList();
        Goal goal = new Goal(null, null, null);
        goal.setTarget("car");
        goal.setAmount(2000.0);
        goalList.add(goal);
        if(!goalList.getList().contains(goal)){
            throw new Exception("add() method error.");
        }
    }
}
