package bridge.exception;

public class InputException {
    public int validateBridgeSize(String inputData) {
        int bridgeSize;
        try {
            bridgeSize = Integer.valueOf(inputData);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 올바른 범위의 숫자를 입력하세요.");
        }
        return bridgeSize;
    }

    public String validateMoving(String inputData) {
        if (!inputData.equals("U") && !inputData.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 올바른 선택지를 입력해주세요.");
        }
        return inputData;
    }

    public String validateGameCommand(String inputData) {
        if (!inputData.equals("R") && !inputData.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 올바른 선택지를 입력해주세요.");
        }
        return inputData;
    }
}
