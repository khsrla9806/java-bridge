package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;

    public BridgeGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void getGameStartMessage() {
        outputView.printGameStartMessage();
    }

    public List<String> getBridge() {
        outputView.printEnterBridgeSizeMessage();
        return bridgeMaker.makeBridge(inputView.readBridgeSize());
    }

    public String getMoving() {
        outputView.printEnterMovingMessage();
        return inputView.readMoving();
    }

    public String getGameCommand() {
        outputView.printEnterGameCommandMessage();
        return inputView.readGameCommand();
    }

    public void getRoundResult(int numberOfAttempts, boolean passable, String moving) {
        outputView.printMap(numberOfAttempts, passable, moving);
    }

    public void finishGame(int totalNumberAttempts, boolean isGameSuccess) {
        outputView.printResult(totalNumberAttempts, isGameSuccess);
    }
}
