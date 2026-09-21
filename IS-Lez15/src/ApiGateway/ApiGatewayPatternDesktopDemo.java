package ApiGateway;

public class ApiGatewayPatternDesktopDemo {
    public static void main(String[] args) {
        ApiGateway apiGateway = new ApiGateway();
        System.out.println(apiGateway.getProductDesktop().getImagePath());
        System.out.println(apiGateway.getProductDesktop().getPrice());
    }
}
