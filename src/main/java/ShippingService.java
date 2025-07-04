import java.util.List;

public class ShippingService {
    private List<ShippingItm> shippingItms;


    public double calculateTotalWeight() {
        double totalWeight = 0;
        for (ShippingItm shippingItm : shippingItms) {
            totalWeight += shippingItm.getWeight()*shippingItm.getQuantity();
        }
        return totalWeight;
    }


    public List<ShippingItm> getShippingItms() {
        return shippingItms;
    }

    public void setShippingItms(List<ShippingItm> shippingItms) {
        this.shippingItms = shippingItms;
    }
}
