package DbInterface;

import java.sql.*;

public class TestConnection {
    public static void main(String[] args) {
        DbUser dbUser = DbUser.getInstance();
        try {
            Class cls = Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Ho caricato il diver jdbc per MySQL");
        } catch (ClassNotFoundException e) {
            System.out.println("Non riesco a trovare il driver");
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbUser.getSchemaName() + "?serverTimeZone=UTC", dbUser.getUserName(), dbUser.getPwd());
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT nome, cognome, matricola, email, telefono FROM studente;");
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
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                    System.out.println("SQL State: " + e.getSQLState());
                    System.out.println("Vendor Error: " + e.getErrorCode());
                }
                resultSet = null;
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                    System.out.println("SQL State: " + e.getSQLState());
                    System.out.println("Vendor Error: " + e.getErrorCode());
                }
                statement = null;
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("SQL Exception: " + e.getMessage());
                    System.out.println("SQL State: " + e.getSQLState());
                    System.out.println("Vendor Error: " + e.getErrorCode());
                }
                connection = null;
            }
        }
    }
}
