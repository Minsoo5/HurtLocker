public class GroceryItem {
    private String name;
    private double price;
    private String type;
    private String expiration;

    public GroceryItem(String name, double price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

//    public class GroceryItemBuilder {
//        private String name;
//        private double price;
//        private String type;
//        private String expiration;
//
//        public void name(String name) {
//            this.name = name;
//        }
//        public void price(Double price) {
//            this.price = price;
//        }
//        public void type(String type) {
//            this.type = type;
//        }
//        public void expiration(String expiration) {
//            this.expiration = expiration;
//        }
//        public GroceryItem build() {
//            return new GroceryItem(name, price, type, expiration);
//        }
//    }


}
