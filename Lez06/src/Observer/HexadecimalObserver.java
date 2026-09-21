package Observer;

public class HexadecimalObserver extends Observer{

    public HexadecimalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Valore esadecimale: " + Integer.toHexString(subject.getState()));
    }
}
