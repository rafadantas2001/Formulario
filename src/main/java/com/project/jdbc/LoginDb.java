package com.project.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.project.model.Login;

public class LoginDb {
private DataSource datasource;
	
	public LoginDb(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public List<Login> getStudents() throws Exception {
		List<Login> login = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		String mySql;
		
		try {
			myConn = datasource.getConnection();
			mySql = "SELECT username, password from login";
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(mySql);
			
			while(myRs.next()) {
				String username = myRs.getString("username");
				String password = myRs.getString("password");
				
				Login tempLogin = new Login(username, password);
				login.add(tempLogin);
			}
			
			return login;
		}
		finally {
			myRs.close();
			myStmt.close();
			myConn.close();
		}	
	}
}
