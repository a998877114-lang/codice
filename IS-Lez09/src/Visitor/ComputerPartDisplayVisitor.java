package Visitor;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor{
    @Override
    public void visit(Computer computer) {
        System.out.println("Sto visitando un computer");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("Sto visitando un mouse");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Sto visitando un monitor");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Sto visitando una tastiera");
    }
}
