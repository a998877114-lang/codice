package Test;

import DAO.IStudenteDAO;
import DAO.StudenteDAO;
import Model.Studente;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class StudenteDAOTest {
    @Before
    public void setUp() {
        IStudenteDAO studenteDAO = StudenteDAO.getInstance();
        Studente studente = new Studente();
        studente.setNome("Giuseppe");
        studente.setCognome("Verdi");
        studente.setMatricola("33334444");
        studente.setEmail("giuseppe.verdi@gmail.com");
        studente.setTelefono("3351234567");
        studenteDAO.add(studente);
    }

    @After
    public void tearDown() {
        IStudenteDAO studenteDAO = StudenteDAO.getInstance();
        studenteDAO.removeById("33334444");
    }

    @Test
    public void findAllTest() {
        IStudenteDAO studenteDAO = StudenteDAO.getInstance();
        ArrayList<Studente> studenti = studenteDAO.findAll();
        Assert.assertEquals(3, studenti.size());
    }

    @Test
    public void findByIdTest() {
        IStudenteDAO studenteDAO = StudenteDAO.getInstance();
        Studente studente = studenteDAO.findById("33334444");
        Assert.assertEquals("Verdi", studente.getCognome());
    }

    @Test
    public void removeByIdTest() {
        IStudenteDAO studenteDAO = StudenteDAO.getInstance();
        int rowCount = studenteDAO.removeById("33334444");
        Assert.assertEquals(1, rowCount);
    }

    @Test
    public void updateTest() {
        IStudenteDAO studenteDAO = StudenteDAO.getInstance();
        Studente studente = new Studente();
        studente.setNome("Giuseppe");
        studente.setCognome("Verdi");
        studente.setMatricola("33334444");
        studente.setEmail("giuseppe.verdi@studenti.unisalento.it");
        studente.setTelefono("3347890123");
        studenteDAO.update(studente);
        studente = studenteDAO.findById("33334444");
        Assert.assertEquals("giuseppe.verdi@studenti.unisalento.it", studente.getEmail());
    }
}
