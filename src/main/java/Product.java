public abstract class Product {
    int id;
    String name;
    double price;
    int stock;

    public void addProduct(int id,String name, double price, int stock){
        this.id=id;
        this.name=name;
        this.price=price;
        this.stock=stock;
    }

    abstract double getShippingWeight();

    abstract boolean isShippable();

    abstract boolean hasExpireDate();
}
