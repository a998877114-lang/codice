package IoC;

public class FoodProduct implements Product {
    private String description;

    public FoodProduct() {
        description = "Food";
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
