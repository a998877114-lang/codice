package DAO;

import DbInterface.DbConnection;
import DbInterface.IDbConnection;
import Model.Studente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudenteDAO implements IStudenteDAO {
    private static StudenteDAO instance = new StudenteDAO();
    private Studente studente;
    private static IDbConnection connection = DbConnection.getInstance();
    private static ResultSet resultSet;

    private StudenteDAO() {
        studente = null;
        connection = null;
        resultSet = null;
    }

    public static StudenteDAO getInstance() {
        return instance;
    }

    @Override
    public Studente findById(String matricola) {
        connection = DbConnection.getInstance();
        resultSet = connection.executeQuery("SELECT nome, cognome, matricola, email, telefono FROM studente WHERE matricola = '" + matricola + "';");
        try {
            resultSet.next();
            if (resultSet.getRow() == 1) {
                studente = new Studente();
                studente.setNome(resultSet.getString("nome"));
                studente.setCognome(resultSet.getString("cognome"));
                studente.setMatricola(resultSet.getString("matricola"));
                studente.setEmail(resultSet.getString("email"));
                studente.setTelefono(resultSet.getString("telefono"));
                return studente;
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Vendor Error: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("Non trovo nessun utente con matricola = " + matricola);
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public ArrayList<Studente> findAll() {
        connection = DbConnection.getInstance();
        resultSet = connection.executeQuery("SELECT nome, cognome, matricola, email, telefono FROM studente;");
        ArrayList<Studente> studenti = new ArrayList<>();
        try {
            while (resultSet.next()) {
                studente = new Studente();
                studente.setNome(resultSet.getString("nome"));
                studente.setCognome(resultSet.getString("cognome"));
                studente.setMatricola(resultSet.getString("matricola"));
                studente.setEmail(resultSet.getString("email"));
                studente.setTelefono(resultSet.getString("telefono"));
                studenti.add(studente);
            }
            return studenti;
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Vendor Error: " + e.getErrorCode());
        } catch (NullPointerException e) {
            System.out.println("Non trovo nessuno studente nel database");
        } finally {
            connection.close();
        }
        return null;
    }

    @Override
    public int add(Studente studente) {
        connection = DbConnection.getInstance();
        int affectedRows = connection.executeUpdate("INSERT INTO studente (nome, cognome, matricola, email, telefono) VALUES ('" + studente.getNome() + "', '" + studente.getCognome() + "', '" + studente.getMatricola() + "', '" + studente.getEmail() + "', '" + studente.getTelefono() + "');");
        connection.close();
        return affectedRows;
    }

    @Override
    public int removeById(String matricola) {
        connection = DbConnection.getInstance();
        int affectedRows = connection.executeUpdate("DELETE FROM studente WHERE matricola = '" + matricola + "';");
        connection.close();
        return affectedRows;
    }

    @Override
    public int update(Studente studente) {
        connection = DbConnection.getInstance();
        int affectedRows = connection.executeUpdate("UPDATE studente SET nome = '" + studente.getNome() + "', cognome = '" + studente.getCognome() + "', matricola = '" + studente.getMatricola() + "', email = '" + studente.getEmail() + "', telefono = '" + studente.getTelefono() + "' WHERE matricola = '" + studente.getMatricola() + "';");
        connection.close();
        return affectedRows;
    }
}
