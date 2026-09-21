package DbInterface;

public class TestDriver {
    public static void main(String[] args) {
        try {
            Class cls = Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Ho caricato il diver jdbc per MySQL");
        } catch (ClassNotFoundException e) {
            System.out.println("Non riesco a trovare il driver");
        }
    }
}
