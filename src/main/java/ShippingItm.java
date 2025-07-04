public class ShippingItm implements ShippingItem{
    private String name;
    private double weight;
    private int quantity;

    public ShippingItm(String name, double weight,int quantity) {
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }
}
