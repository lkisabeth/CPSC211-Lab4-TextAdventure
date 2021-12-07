import java.util.HashMap;

public class PlayerStateModel extends StateModel {
    private PlayerState currentState = PlayerState.IN_BED;
    private HashMap<String, Boolean> booleanAttributes = new HashMap<>();

    public PlayerStateModel() {
        booleanAttributes.put("keys", true);
    }

    @Override
    public PlayerState getCurrentState() {
        return currentState;
    }

    @Override
    String saveCurrentState() {
        switch (currentState) {
            case IN_BED:
                return "1";
        }
        return "0";
    }

    @Override
    void loadCurrentState(int state) {
        switch (state) {
            case 1:
                currentState = PlayerState.IN_BED;
                break;
        }
    }
}
