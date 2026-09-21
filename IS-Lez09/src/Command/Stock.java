package Command;

public class Stock {
    private String name;
    private int quantity;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void buy() {
        System.out.println("Ordine " + name + " con quantità " + quantity + " acquistato");
    }

    public void sell() {
        System.out.println("Ordine " + name + " con quantità " + quantity + " venduto");
    }
}
