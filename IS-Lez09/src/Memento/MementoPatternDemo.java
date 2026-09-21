package Memento;

public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setStato("Stato 1");
        originator.setStato("Stato 2");
        careTaker.add(originator.saveStateToMemento());
        originator.setStato("Stato 3");
        careTaker.add(originator.saveStateToMemento());
        originator.setStato("Stato 4");
        System.out.println(careTaker.get(0).getStato());
        System.out.println(careTaker.get(1).getStato());
        originator.getStateFromMemento(careTaker.get(0));
    }
}
