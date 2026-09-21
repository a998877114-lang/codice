package Bridge;

public class RedCircle implements DrawAPI{
    @Override
    public void drawCircle(int raggio, int x, int y) {
        System.out.println("Sono un cerchio rosso con raggio " + raggio + " e centro di coordinate " + x + " " + y);
    }
}
