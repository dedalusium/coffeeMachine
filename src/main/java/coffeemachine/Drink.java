package coffeemachine;

public enum Drink {
    T("Tea", 0.4f),
    C("Coffee", 0.6f),
    H("Hot chocolate", 0.5f);


    private String name;
    private float cost;

    Drink(String name) {
        this.name = name;
    }

    Drink(String name, float cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public float getCost() {
        return cost;
    }
}
