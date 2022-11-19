package com.MarkrtingApp6.model;

import java.sql.ResultSet;

public interface DAOService {
	
	public void connectDB();
	
	public boolean varifrycredintial(String email,String password);
	
	public void saveRegistration(String name,String city,String email,String mobile);
	
	public ResultSet readRegistration();
	
	public void deleteregistration(String email);

	public void updateRegistration(String email, String mobile);

}
