package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class getDBValues {
	
	
	@DataProvider(name="DP")
	public String[][] feedDP() throws ClassNotFoundException, SQLException{
		
		String[][] data = Dbvalues();
		return data;
		
	}
	
	
	                // method for retriving data from mysql using below method
public String[][] Dbvalues() throws ClassNotFoundException, SQLException{
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	
//	Parameters:
//		url a database url of the form jdbc:subprotocol:subname
//		user the database user on whose behalf the connection is being made
//		password the user's password
	
	  
	String url = "jdbc:mysql://localhost:3306/testdb";
	String username= "root";
	String password = "Sony@2417";
	
	Connection con = DriverManager.getConnection(url, username, password);
	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	  int value =  stmt.executeUpdate("INSERT INTO testdb.Login_table(userName, passWord) VALUES(\"Aruna27\", \"Anand08\")"); // inserting the rows of username and password through this executeUpdate
	  System.out.println("rows are updated:" + value);
	
	
	ResultSet result = stmt.executeQuery("SELECT * FROM testdb.Login_table"); // for retrieving data from table
	result.last();
	int rows = result.getRow(); // to get rows we have used getRow
	System.out.println("Number of rows:" + rows);
	
	ResultSetMetaData rsmd = result.getMetaData();
	int cols = rsmd.getColumnCount();
	System.out.println("Number of cols:" + cols);
	// printing the data from rows and cols
	
	
	
	String data[][]= new String[rows][cols];
	int i = 0;
	result.beforeFirst();
	while(result.next()) {
		for(int j=0; j<cols; j++) {
			data[i][j]= result.getString(j+1);
			System.out.println("data:" + data[i][j]);
		}
		i++;
	}
	return data;
	}
	
	
	
	

	
	
}
