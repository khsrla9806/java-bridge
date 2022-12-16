package bridge.controller;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private BridgeGameController bridgeGameController;
    private List<String> bridge;
    private int totalNumberAttempts = 1;
    private int numberOfAttempts = 0;
    private boolean isGameSuccess = true;

    public BridgeGame() {
        this.bridgeGameController = new BridgeGameController();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        int index = numberOfAttempts;
        if (bridge.get(index).equals(moving)) {
            bridgeGameController.getRoundResult(numberOfAttempts, true, moving);
            numberOfAttempts++;
        }
        if (!bridge.get(index).equals(moving)) {
            bridgeGameController.getRoundResult(numberOfAttempts, false, moving);
            retry();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        String gameCommand = bridgeGameController.getGameCommand();
        if (gameCommand.equals("R")) {
            numberOfAttempts = 0;
            totalNumberAttempts++;
        }
        if (gameCommand.equals("Q")) {
            numberOfAttempts = Integer.MAX_VALUE;
            isGameSuccess = false;
        }
    }

    public void playGame() {
        bridgeGameController.getGameStartMessage();
        bridge = bridgeGameController.getBridge();
        while (numberOfAttempts < bridge.size()) {
            move(bridgeGameController.getMoving());
        }
        bridgeGameController.finishGame(totalNumberAttempts, isGameSuccess);
    }
}
