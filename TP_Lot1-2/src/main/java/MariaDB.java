import java.sql.*;

public class MariaDB {
    // JDBC driver name and database URL

    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://localhost:3307/testunit";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "";

    public String defineQuery(Client client) {
        //STEP 4: Write a query to execute
        System.out.println("Creating NEW CLIENT" + client.getNom() + " " + client.getPrenom() + " in given database...");
        String sql = "INSERT INTO clientsunit values"
                + "('"+client.getId()+"',"
                +  "'"+client.getPrenom()+"', "
                +  "'"+client.getNom()+"', "
                +  "'"+client.getAdresse()+"');";
        return sql;
    }

    public ResultSet talkToDataBase(String sql) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet resultat = null;

        try {
            //STEP 1: Register JDBC driver
            Class.forName("org.mariadb.jdbc.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3307/testunit", "root", "");
            System.out.println("Connected database successfully...");
            stmt = conn.createStatement();
            //STEP 3 : execute query
            resultat = stmt.executeQuery(sql);
            System.out.println("Created NEW CLIENT in given database...");

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();

        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        closeConnexion(stmt,conn);
        return resultat;
        //end try

    }//end main

    public void closeConnexion(Statement stmt, Connection conn) {
        try {
            if (stmt != null) {
                conn.close();
            }
        } catch (SQLException se) {
        }// do nothing
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }

    }
}
