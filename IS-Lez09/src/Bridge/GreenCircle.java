package Bridge;

public class GreenCircle implements DrawAPI{
    @Override
    public void drawCircle(int raggio, int x, int y) {
        System.out.println("Sono un cerchio verde con raggio " + raggio + " e centro di coordinate " + x + " " + y);
    }
}
