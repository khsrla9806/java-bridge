package bridge.enums;

public enum ErrorMessage {
    IS_NOT_NUMBER("숫자를 입력해야 합니다."),
    OUT_OF_RANGE("올바른 범위의 숫자를 입력하세요."),
    OUT_OF_OPTIONS("올바른 선택지를 입력해주세요.");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return "[ERROR] " + errorMessage;
    }
}
