public class ShipableProduct extends Product {

    private double shippingWeight;


    public void addProduct(int id, String name, double price, int stock, double shippingWeight) {
        super.addProduct(id,name,price,stock);
        this.shippingWeight = shippingWeight;
    }


    @Override
    double getShippingWeight() {
        return shippingWeight;
    }

    @Override
    boolean isShippable() {
        return true;
    }

    @Override
    boolean hasExpireDate() {
        return false;
    }
}
