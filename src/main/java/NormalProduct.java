public class NormalProduct extends Product {
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
        return false;
    }
}
