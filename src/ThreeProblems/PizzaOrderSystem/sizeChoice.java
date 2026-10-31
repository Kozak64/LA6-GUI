package ThreeProblems.PizzaOrderSystem;

public enum sizeChoice {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");


    private final String display;
    sizeChoice(String display) {
        this.display = display;
    }

    public String toString() {
        return display;
    }
}
