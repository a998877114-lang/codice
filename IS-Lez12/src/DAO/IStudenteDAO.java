package DAO;
import Model.Studente;

import java.util.ArrayList;

public interface IStudenteDAO {
    Studente findById(String matricola);
    ArrayList<Studente> findAll();
    int add(Studente studente);
    int removeById(String matricola);
    int update(Studente studente);
}
