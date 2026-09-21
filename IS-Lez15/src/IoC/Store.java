package IoC;

public class Store {
    private String storeName;
    private Product product;

    public Store(String storeName, Product product) {
        this.storeName = storeName;
        this.product = product;
    }

    public String getStoreName() {
        return storeName;
    }

    public Product getProduct() {
        return this.product;
    }
}
