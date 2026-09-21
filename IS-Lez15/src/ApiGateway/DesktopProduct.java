package ApiGateway;

public class DesktopProduct {
    private String Price;
    private String imagePath;

    public DesktopProduct() {
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
