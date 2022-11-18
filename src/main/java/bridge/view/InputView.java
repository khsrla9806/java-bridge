package bridge.view;

import bridge.exception.InputException;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView extends InputException {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSize = "";
        try {
            System.out.println("다리의 길이를 입력해주세요.");
            bridgeSize = Console.readLine();
            validateBridgeSize(bridgeSize);
        } catch (IllegalArgumentException exception) {
            return readBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String moving = "";
        try {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            moving = Console.readLine();
            validateMoving(moving);
        } catch (IllegalArgumentException exception) {
            return readMoving();
        }
        return moving;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommand = "";
        try {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            gameCommand = Console.readLine();
            validateGameCommand(gameCommand);
        } catch (IllegalArgumentException exception) {
            return readGameCommand();
        }
        return gameCommand;
    }
}
