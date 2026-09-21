package Visitor;

public interface ComputerPartVisitor {
    void visit(Computer computer);
    void visit(Mouse mouse);
    void visit(Monitor monitor);
    void visit(Keyboard keynoard);
}
