import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ECommMain {
    public static void main(String[] args) {
        Product phone=new NormalProduct();
        phone.addProduct(1,"iPhone",20000.0,5);
        ExpiredableProduct cheese=new ExpiredableProduct();
        cheese.addProduct(2,"Cheese",100.0,3, LocalDate.of(2025,8,1));
        ShipableProduct tv=new ShipableProduct();
        tv.addProduct(3,"TV",9000.0,2,600.0);
        ShipableProduct chair=new ShipableProduct();
        chair.addProduct(4,"Chair",7000.0,5,900.0);


        Customer customer=new Customer();
        customer.setId(1);
        customer.setName("John");
        customer.setBalance(500000.0);

        ShoppingCart cart=new ShoppingCart();
        cart.addProduct(phone,3);
        cart.addProduct(cheese,2);
        cart.addProduct(chair,2);
        cart.addProduct(tv,2);
        checkout(customer,cart);



    }

    private static void checkout(Customer customer, ShoppingCart cart) {

        if(cart.validateCart()){
            throw new RuntimeException("Empty Cart");
        }
        if(!cart.validateStock()){
            throw new RuntimeException("Invalid Stock");
        }



        List<ShippingItm> itms=new ArrayList<>();
        for (CartItem item : cart.getCartItems()) {
            if(item.getProduct().isShippable()){
                itms.add(new ShippingItm(item.getProduct().name,item.getProduct().getShippingWeight(),item.getQuantity()));
            }
        }
        double total=0.0;
        if(!itms.isEmpty()){
            ShippingService shippingService=new ShippingService();
            shippingService.setShippingItms(itms);
            System.out.println("** Shipment notice **");
            for (ShippingItm shippingItm : itms) {
                System.out.println(shippingItm.getQuantity()+"x "+shippingItm.getName()+"  "+shippingItm.getQuantity()*shippingItm.getWeight());
            }

            total=shippingService.calculateTotalWeight();
            double weight=total/1000;
            System.out.println("Total Package weight "+weight + "kg");
        }

        double fee=total*0.035;
        double totalPrice= fee+cart.calculateSubtotal();
        if(customer.getBalance()<totalPrice){
            throw new RuntimeException("Not enough balance");
        }

        customer.setBalance(customer.getBalance()-totalPrice);

        System.out.println("\n** Checkout receipt **");
        for (CartItem item : cart.getCartItems()) {
            System.out.println(item.getQuantity()+"x "+item.getProduct().name+"  "+item.getProduct().price*item.getQuantity());
        }
        System.out.println("----------------------------------------");
        System.out.println("Subtotal       "+cart.calculateSubtotal());
        System.out.println("Shipping       "+fee);
        System.out.println("Amount         "+totalPrice);


        System.out.println("\nbalance after this proccess is : "+customer.getBalance());
    }
}
