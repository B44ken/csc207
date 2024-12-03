package interface_adapter.add_goal;

import interface_adapter.ViewModel;

/**
 * The View Model for Add Goal View.
 */
public class AddGoalViewModel extends ViewModel<AddGoalState> {
    public AddGoalViewModel() {
        super("add goal");
        setState(new AddGoalState());
    }
}
