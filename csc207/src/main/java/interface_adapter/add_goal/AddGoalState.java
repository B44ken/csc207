package interface_adapter.add_goal;

/**
 * The State information representing the new goal to be logged.
 */
public class AddGoalState {
    private String name = "";

    private String addFail;

    public AddGoalState(AddGoalState copy) {
        this.name = copy.name;
        this.addFail = copy.addFail;
    }

    public AddGoalState() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddFail(String addFail) {
        this.addFail = addFail;
    }
}
