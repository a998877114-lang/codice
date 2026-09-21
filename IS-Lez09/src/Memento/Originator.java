package Memento;

public class Originator {
    private String stato;

    public String getStato() {
        return this.stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Memento saveStateToMemento() {
        return new Memento(this.stato);
    }

    public void getStateFromMemento(Memento memento) {
        this.stato = memento.getStato();
    }
}
