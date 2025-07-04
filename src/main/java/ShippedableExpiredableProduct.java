import java.time.LocalDate;

public class ShippedableExpiredableProduct extends Product {

    private LocalDate expiredDate;
    private double shippingWeight;



    public void addProduct(int id, String name, double price, int stock,LocalDate expiredDate,double shippingWeight) {
        super.addProduct(id,name,price,stock);
        this.expiredDate = expiredDate;
        this.shippingWeight = shippingWeight;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
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
        return true;
    }
}
