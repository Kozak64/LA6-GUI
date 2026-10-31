package TwoProblems.SimpleCalculator;

public enum Operations {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String display;
    Operations(String display) {
        this.display = display;
    }

    public String toString() {
        return display;
    }

}
