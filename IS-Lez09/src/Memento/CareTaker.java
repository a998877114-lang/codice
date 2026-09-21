package Memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento stato) {
        mementoList.add(stato);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
