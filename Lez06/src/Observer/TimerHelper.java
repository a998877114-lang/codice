package Observer;

import java.util.TimerTask;

public class TimerHelper extends TimerTask {
    static int i;
    static Subject subject;

    public TimerHelper(Subject subject) {
        this.subject = subject;
        this.i = TimerHelper.subject.getState();
    }

    @Override
    public void run() {
        subject.setState(i++);
        subject.notifyAllObservers();
    }
}
