public class Item {
    private final String itemName;
    private final double itemCost;

    public Item() {
        this.itemName = "null";
        this.itemCost = 0.0;
    }
    public Item(String name, double cost) {
        this.itemName = name;
        this.itemCost = cost;
    }

    public String getName() {
        return itemName;
    }

    public double getCost() {
        return itemCost;
    }
}
