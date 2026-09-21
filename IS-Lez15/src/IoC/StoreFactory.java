package IoC;

public class StoreFactory {
    public static Store getStore(String storeType) {
        if (storeType == null) {
            return null;
        }
        if (storeType.equalsIgnoreCase("Food store")) {
            return new Store("Mio food store", new FoodProduct());
        }
        if (storeType.equalsIgnoreCase("Drink store")) {
            return new Store("Mio drink store", new DrinkProduct());
        }
        return null;
    }
}
