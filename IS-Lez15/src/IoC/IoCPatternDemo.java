package IoC;

public class IoCPatternDemo {
    public static void main(String[] args) {
        Store store1 = StoreFactory.getStore("Food store");
        try {
            System.out.println(store1.getStoreName());
            System.out.println(store1.getProduct().getDescription());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        Store store2 = StoreFactory.getStore("Drink store");
        try {
            System.out.println(store2.getStoreName());
            System.out.println(store2.getProduct().getDescription());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
