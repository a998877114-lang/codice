package IoC;

public class DrinkProduct implements Product {
    private String description;

    public DrinkProduct() {
        description = "Drink";
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
