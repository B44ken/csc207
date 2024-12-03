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

    /**
     * Getter for name of AddGoalState.
     * @return name of AddGoalState.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name of AddGoalState to name.
     * @param name the new name to set AddGoalState's name to.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter for name of AddGoalstate to name.
     * @param addFail new addFail to set AddGoalState's addFail to.
     */
    public void setAddFail(String addFail) {
        this.addFail = addFail;
    }
}
