package ThreeProblems.PizzaOrderSystem;

public enum toppingsChoice {
    MUSHROOMS("Mushrooms"),
    PEPPERONI("Pepperoni"),
    ONIONS("Onions");

    private final String display;
    toppingsChoice(String display) {
        this.display = display;
    }

    public String toString() {
        return display;
    }
}
