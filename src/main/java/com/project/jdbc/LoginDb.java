package com.project.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

import com.project.model.Login;

public class LoginDb {
private DataSource datasource;
	
	public LoginDb(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public Login getLogin() throws Exception {		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		String mySql;
		
		try {
			myConn = datasource.getConnection();
			mySql = "SELECT username, password from login";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(mySql);
					
			String username = myRs.getString("username");
			String password = myRs.getString("password");
			
			Login login = new Login(username, password);

			return login;
		}
		finally {
			myRs.close();
			myStmt.close();
			myConn.close();
		}	
	}
}
