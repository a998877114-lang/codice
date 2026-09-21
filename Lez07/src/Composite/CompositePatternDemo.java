package Composite;

import java.util.Iterator;
import java.util.List;

public class CompositePatternDemo {
    public static void main(String[] args) {

        Employee ceo = new Employee("Adriana","CEO", 30000);

        Employee headDevelopment = new Employee("Luigi","Head Development", 20000);

        Employee headMarketing = new Employee("Roberto","Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Alessandro","Marketing", 10000);

        Employee developer1 = new Employee("Ilaria","Development", 10000);
        Employee developer2 = new Employee("Giovanni","Development", 10000);

        ceo.addSubordinate(headDevelopment);
        ceo.addSubordinate(headMarketing);

        headDevelopment.addSubordinate(developer1);
        headDevelopment.addSubordinate(developer2);

        headMarketing.addSubordinate(clerk1);
        headMarketing.addSubordinate(clerk2);

        //Stampa tutti i dipendenti dell'organizzazione in ordine gerarchico
        System.out.println(ceo);

        List<Employee> ceoSubordinates = ceo.getSubordinates();
        Iterator<Employee> ceoSubordinatesIterator = ceoSubordinates.iterator();

        while (ceoSubordinatesIterator.hasNext()) {
            Employee employee = ceoSubordinatesIterator.next();
            System.out.println(employee);

            List<Employee> headSubordinates = employee.getSubordinates();
            Iterator<Employee> headSubordinatesIterator = headSubordinates.iterator();
            while (headSubordinatesIterator.hasNext()) {
                System.out.println(headSubordinatesIterator.next());
            }
        }
    }
}