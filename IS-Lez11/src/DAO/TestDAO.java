package DAO;

import Model.Studente;

import java.util.ArrayList;
import java.util.Scanner;

public class TestDAO {
    public static void main(String[] args) {
        StudenteDAO studenteDAO = StudenteDAO.getInstance();
        System.out.println("Stampo tutti gli studenti");
        ArrayList<Studente> studenti = new ArrayList<>();
        studenti = studenteDAO.findAll();
        for (Studente s : studenti) {
            System.out.println(s);
        }

        System.out.print("Inserire la matricola dello studente voluto: ");
        Scanner in = new Scanner(System.in);
        String input = in.next();
        Studente studente = new Studente();
        studente = studenteDAO.findById(input);
        System.out.println("I dati dello studente con matricola " + input + " sono: ");
        System.out.println(studente);
    }
}
