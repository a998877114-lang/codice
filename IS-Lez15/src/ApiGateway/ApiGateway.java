package ApiGateway;

public class ApiGateway {
    private ImageClient imageClient;
    private PriceClient priceClient;

    public ApiGateway() {
        this.imageClient = new ImageClientImpl2();
        this.priceClient = new PriceClientImpl();
    }

    public DesktopProduct getProductDesktop() {
        DesktopProduct desktopProduct = new DesktopProduct();
        desktopProduct.setImagePath(imageClient.getImagePath());
        desktopProduct.setPrice(priceClient.getPrice());
        return desktopProduct;
    }

    public MobileProduct getProductMobile() {
        MobileProduct mobileProduct = new MobileProduct();
        mobileProduct.setPrice(priceClient.getPrice());
        return mobileProduct;
    }
}
