package Bridge;

public class Circle extends Shape{
    int raggio, x, y;

    public Circle(int raggio, int x, int y, DrawAPI drawAPI) {
        super(drawAPI);
        this.raggio = raggio;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(raggio, x, y);
    }
}
