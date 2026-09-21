package DbInterface;

import java.sql.*;

public class TestDbConnection {
    public static void main(String[] args) {
        IDbConnection connection = DbConnection.getInstance();
        try {
            ResultSet resultSet = connection.executeQuery("SELECT nome, cognome, matricola, email, telefono FROM studente;");
            while (resultSet.next()) {
                System.out.print(resultSet.getString("nome") + "\t");
                System.out.print(resultSet.getString("cognome") + "\t");
                System.out.print(resultSet.getString("matricola") + "\t");
                System.out.print(resultSet.getString("email") + "\t");
                System.out.println(resultSet.getString("telefono"));
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Vendor Error: " + e.getErrorCode());
        } finally {
            connection.close();
        }
    }
}
