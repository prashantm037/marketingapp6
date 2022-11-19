package com.MarkrtingApp6.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService {
	
	Connection con;
	Statement stmnt;
	
	@Override
	public void connectDB() {
		try {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (Exception e) {
					e.printStackTrace();
				}
			con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/marketingapp","root","8861560012@pm");
		stmnt=con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean varifrycredintial(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery
					("select * from login where email='"+email+"' and  password='"+password+"'");
		return result.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveRegistration(String name, String city, String email, String mobile) {
      try {
		stmnt.executeUpdate
		("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
	} catch (SQLException e) {
		e.printStackTrace();
	}		
	}

	@Override
	public ResultSet readRegistration() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteregistration(String email) {
		try {
			stmnt.executeUpdate("delete from registration where email='"+email+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateRegistration(String email, String mobile) {
		try {
			stmnt.executeUpdate("Update registration SET mobile='"+mobile+"' WHERE email='"+email+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
