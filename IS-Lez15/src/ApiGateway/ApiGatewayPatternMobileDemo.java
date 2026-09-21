package ApiGateway;

public class ApiGatewayPatternMobileDemo {
    public static void main(String[] args) {
        ApiGateway apiGateway = new ApiGateway();
        System.out.println(apiGateway.getProductMobile().getPrice());
    }
}
