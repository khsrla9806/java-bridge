package bridge.exception;

import bridge.enums.ErrorMessage;
import bridge.enums.Keyboard;


public class InputException {
    private final int MINIMUM_BRIDGE_SIZE = 3;
    private final int MAXIMUM_BRIDGE_SIZE = 20;
    public int validateBridgeSize(String inputData) {
        int bridgeSize;
        try {
            bridgeSize = Integer.valueOf(inputData);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getMessage());
        }
        if (bridgeSize < MINIMUM_BRIDGE_SIZE || bridgeSize > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
        return bridgeSize;
    }

    public String validateMoving(String inputData) {
        if (!inputData.equals(Keyboard.UP.getCommand())
                && !inputData.equals(Keyboard.DOWN.getCommand())) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_OPTIONS.getMessage());
        }
        return inputData;
    }

    public String validateGameCommand(String inputData) {
        if (!inputData.equals(Keyboard.RESTART.getCommand())
                && !inputData.equals(Keyboard.QUIT.getCommand())) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_OPTIONS.getMessage());
        }
        return inputData;
    }
}
