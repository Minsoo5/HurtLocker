public class GroceryItemBuilder {
    private String name;
    private double price;
    private String type;
    private String expiration;

    public void name(String name) {
        this.name = name;
    }
    public void price(Double price) {
        this.price = price;
    }
    public void type(String type) {
        this.type = type;
    }
    public void expiration(String expiration) {
        this.expiration = expiration;
    }
    public GroceryItem build() {
        return new GroceryItem(name, price, type, expiration);
    }
}