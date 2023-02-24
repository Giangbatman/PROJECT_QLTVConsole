package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlConnection {
	public static String DB_URL = "jdbc:sqlserver://ADMIN;DatabaseName=FPTULibraryManagement;encrypt=true;trustServerCertificate=true";
	public static String USER_NAME = "sa";
    public static String PASSWORD = "";
	public static ResultSet executeQuery(String sql){
        try {
            
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            
            Statement stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery(sql);
    
            return rs;
        } catch (SQLException ex) {
        }
        return null;
    }
	
	public static void executeUpdate(String sql){
        try {
            
            try ( // connect database
                Connection conn = getConnection(DB_URL, USER_NAME,PASSWORD)) {
                // create statement
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(sql);
               
            }
        } catch (SQLException ex) {
        }
        
    }
	
	public static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("connect failure!");
        }
        return conn;
    }
	
	public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try {
                conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
                System.out.println("connect successfully!");
            } catch (SQLException ex) {
                Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.out.println("connect failure!");
        }
        return conn;
    }

}
