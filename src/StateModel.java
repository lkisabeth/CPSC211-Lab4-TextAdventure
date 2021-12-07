import java.util.HashMap;
import java.util.Scanner;

public abstract class StateModel {
    private Enum currentState;
    private HashMap<String, Boolean> booleanAttributes = new HashMap<>();

    public String saveModel() {
        String status = "";

        status += saveCurrentState();
        for (Boolean attribute : booleanAttributes.values()) {
            status += " " + saveBoolean(attribute);
        }

        return status;
    }

    public void loadModel(String status) {
        Scanner input = new Scanner(status);

        loadCurrentState(input.nextInt());
        for (HashMap.Entry<String, Boolean> attribute : booleanAttributes.entrySet()) {
            attribute.setValue(loadBoolean(input.next()));
        }
             input.close();
    }

    public Enum getCurrentState() {
        return currentState;
    }

    String saveCurrentState() {
        return "0";
    }

    private String saveBoolean(boolean value) {
        return value ? "T" : "F";
    }

    void loadCurrentState(int state) {
        switch (state) {
            case 1:
                break;
        }
    }

    private boolean loadBoolean(String value) {
        return value.equals("T");
    }
}