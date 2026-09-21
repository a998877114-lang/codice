package ApiGateway;

public class ImageClientImpl implements ImageClient {
    @Override
    public String getImagePath() {
        return "/images/product1.jpg";
    }
}
