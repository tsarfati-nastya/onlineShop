public class Product {

    private String productName;
    private final String productDescription;
    private double price;
    private int amount;
    private int discount;
    private boolean isInStock;

    public Product(String productName, String productDescription, double price, int discount) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.price = price;
        this.discount = discount;
    }
    public void buyProduct(int amount){
        this.amount -= amount;
        this.isInStock = amount != 0;
    }

    public boolean isInStock(){
        return isInStock();
    }
    public void changeStatusOfProduct(){
        isInStock = !this.isInStock;
    }

    @Override
    public String toString() {
        return "Product " +
                "productName = " + productName + '\'' +
                "price = " + price;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public int getDiscount() {
        return discount;
    }

    public void addProduct(Shop shop){
        shop.products.add(this);
    }


}
