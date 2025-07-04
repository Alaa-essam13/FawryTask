import java.time.LocalDate;

public class ExpiredableProduct extends Product {

    private LocalDate expiredDate;


    public void addProduct(int id, String name, double price, int stock,LocalDate expiredDate) {
        super.addProduct(id, name, price, stock);
        this.expiredDate = expiredDate;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    double getShippingWeight() {
        return 0;
    }

    @Override
    boolean isShippable() {
        return false;
    }

    @Override
    boolean hasExpireDate() {
        return true;
    }
}
