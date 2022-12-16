package bridge.enums;

public enum Keyboard {
    DOWN("D"),
    UP("U"),
    QUIT("Q"),
    RESTART("R");

    private String command;

    Keyboard(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
