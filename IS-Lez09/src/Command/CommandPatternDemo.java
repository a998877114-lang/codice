package Command;

public class CommandPatternDemo {
    public static void main(String[] args) {
        Stock stock = new Stock("Il mio ordine", 10);
        BuyStock buyStockOrder = new BuyStock(stock);
        SellStock sellStockOrder = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);
        broker.placeOrders();
    }
}
