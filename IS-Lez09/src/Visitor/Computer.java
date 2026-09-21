package Visitor;

public class Computer implements ComputerPart{

    private ComputerPart[] parts = {new Monitor(), new Keyboard()};

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
