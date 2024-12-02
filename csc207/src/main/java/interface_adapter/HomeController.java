package interface_adapter;

import data_access.UserData;

public class HomeController {
    private UserData userData;
    public HomeController(UserData userData) {
        this.userData = userData;
    }

    public void execute() {

    }
}
