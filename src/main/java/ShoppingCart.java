import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<CartItem> cartItems=new ArrayList<>();


    public void addProduct(Product product, int quantity) {
        cartItems.add(new CartItem(product,quantity));
    }
    public void addProduct(ExpiredableProduct product, int quantity) {
        if(LocalDate.now().isAfter(product.getExpiredDate())){
            throw new IllegalArgumentException("Expired Product");
        }
        cartItems.add(new CartItem(product,quantity));
    }
    public void addProduct(ShippedableExpiredableProduct product, int quantity) {
        if(LocalDate.now().isAfter(product.getExpiredDate())){
            throw new IllegalArgumentException("Expired Product");
        }
        cartItems.add(new CartItem(product,quantity));
    }


    public double calculateSubtotal(){
        double subtotal = 0L;
        for (CartItem cartItem : cartItems) {
            subtotal += cartItem.getProduct().price * cartItem.getQuantity();
        }
        return subtotal;
    }

    public boolean validateStock(){
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().stock < cartItem.getQuantity()){
                return false;
            }
        }
        return true;
    }


    public boolean validateCart(){
        return cartItems.isEmpty();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

}
