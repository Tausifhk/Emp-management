package com.EMsystem.model;

import java.sql.ResultSet;

public interface DAOservice {
	public void connectDB();
	public boolean verifyCredentials(String Username, String Password);
	public void saveDetails(String name, String email, String mobile, String city, String department, String designation, String date,String salary);
	public ResultSet listEmp();
	public void deleteRec(String email);
	public void updateData(String email, String mobile);
	public ResultSet findById(String id);
}
