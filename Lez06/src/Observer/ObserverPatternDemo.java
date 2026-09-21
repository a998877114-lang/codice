package Observer;

import java.util.Timer;
import java.util.TimerTask;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject(0);

        new DecimalObserver(subject);
        new BinaryObserver(subject);
        new HexadecimalObserver(subject);

        System.out.println("Cambiamo lo stato del subject ogni secondo");

        Timer timer = new Timer();
        TimerTask task = new TimerHelper(subject);
        timer.schedule(task, 0, 1000);
    }
}
