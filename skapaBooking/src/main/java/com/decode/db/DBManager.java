package com.decode.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBManager {
	
	private Connection con = null; 

	//CONNECT TO DB
	public void connect() throws DBException { 
		
		String url = "jdbc:mysql://localhost:3306/";
    	String user = "root";
    	String password = "";
    	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, user, password);
			
		} catch (IllegalAccessException | InstantiationException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	//DISCONNECT FROM DB
	public void disconnect() throws DBException {
		try {
			con.close();
		} catch (SQLException e) {
			throw new DBException("Error cerrando la conexiÃ³n con la BD", e);
		}
	}
	
	//CREATE DB
	
	public void createDb() throws DBException{
		
		Statement stt;
		try {
			stt = con.createStatement();
			stt.execute("CREATE DATABASE IF NOT EXISTS test;");
	    	stt.execute("USE test");
	    	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public void testDb() throws DBException{
		
		Statement stt;
		try {
			stt = con.createStatement();
			stt.execute("CREATE TABLE IF NOT EXISTS people (id INTEGER)");
	    	
	    	stt.execute("INSERT INTO people (id) VALUES" + "(4), (6), (8)");
	    	
	    	ResultSet res = stt.executeQuery("SELECT * FROM people WHERE id = 4");
	    	
	    	while(res.next()) {
	    		System.out.println(res.getInt("id"));
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
