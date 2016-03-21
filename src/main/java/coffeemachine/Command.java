package coffeemachine;

public enum Command {
    TEA("T", 0.4f),
    COFFEE("C", 0.6f),
    HOT_CHOCOLATE("H", 0.5f),
    MESSAGE("M");

    private String code;
    private float cost;

    Command(String code) {
        this.code = code;
    }

    Command(String code, float cost) {
        this.code = code;
        this.cost = cost;
    }

    public String getCode() {
        return code;
    }

    public float getCost() {
        return cost;
    }
}
