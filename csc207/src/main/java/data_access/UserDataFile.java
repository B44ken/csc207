package data_access;

public class UserDataFile extends UserData {
    private String file;

    public UserDataFile(String fileName) {
        super();
        file = fileName;
        history = FileAccess.importData(fileName);
    }

    public void save() {
        FileAccess.exportData(history, file);
    }
}