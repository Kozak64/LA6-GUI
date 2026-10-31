package ThreeProblems.PizzaOrderSystem;

public enum cheeseChoice {
    YES("Yes"),
    NO("No");

    private final String display;
    cheeseChoice(String display) {
        this.display = display;
    }

    public String toString() {
        return display;
    }
}
