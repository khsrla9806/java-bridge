package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String DELIMITER = " | ";
    private final String SUCCESS = "O";
    private final String FAIL = "X";
    private final String NOTHING = " ";
    private String upResult = "";
    private String downResult = "";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(int numberOfAttempts, boolean passable, String moving) {
        if (numberOfAttempts == 0) {
            upResult = "";
            downResult = "";
            getUpAndDownResult(passable, moving);
        }
        if (numberOfAttempts > 0) {
            upResult += DELIMITER;
            downResult += DELIMITER;
            getUpAndDownResult(passable, moving);
        }
        System.out.println("[ " + upResult + " ]");
        System.out.println("[ " + downResult + " ]");
    }

    private void getUpAndDownResult(boolean passable, String moving) {
        if (moving.equals("U")) {
            if (passable) {
                upResult += SUCCESS;
            }
            if (!passable) {
                upResult += FAIL;
            }
            downResult += NOTHING;
        }
        if (moving.equals("D")) {
            if (passable) {
                downResult += SUCCESS;
            }
            if (!passable) {
                downResult += FAIL;
            }
            upResult += NOTHING;
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int totalNumberAttempts, boolean isGameSuccess) {
        System.out.println("최종 게임 결과");
        if (isGameSuccess) {
            System.out.println("게임 성공 여부: 성공");
        }
        if (!isGameSuccess) {
            System.out.println("게임 성공 여부: 실패");
        }
        System.out.println("총 시도한 횟수: " + totalNumberAttempts);
    }

    public void printGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printEnterBridgeSizeMessage() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printEnterMovingMessage() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printEnterGameCommandMessage() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
