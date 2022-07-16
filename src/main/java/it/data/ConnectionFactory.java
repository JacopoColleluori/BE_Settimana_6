package it.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	 public static final String URL="jdbc:postgresql://localhost:5433/bancadb";
	    public static final String username="postgres";
	   public static final String password="Da74bB45s3";

	    public static Connection getConnection(){
	        Connection conn=null;
	        
	        try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try {
	        conn= DriverManager.getConnection(URL,username,password);
	            System.out.println("Connessione effettuata");
	        }catch (SQLException e){
	            System.out.println("Connessione non effettuata");
	            e.printStackTrace();
	        }
	        return conn;
	    }
}
