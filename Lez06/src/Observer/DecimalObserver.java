package Observer;

public class DecimalObserver extends Observer{

    public DecimalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Valore decimale: " + subject.getState());
    }
}
