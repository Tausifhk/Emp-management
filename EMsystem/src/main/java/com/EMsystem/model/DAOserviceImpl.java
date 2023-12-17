package com.EMsystem.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOserviceImpl implements DAOservice {
	private Connection con;
	private Statement stmnt;
	
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee","root","test");
			stmnt=con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean verifyCredentials(String Username, String Password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from user_credentials where email='"+Username+"' and password='"+Password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void saveDetails(String name, String email, String mobile, String city,String department, String designation, String date,String salary) {
		try {
			stmnt.executeUpdate("insert into employee (Ename, Email, Mobile, City) values('"+name+"','"+email+"','"+mobile+"','"+city+"')", Statement.RETURN_GENERATED_KEYS);
			 ResultSet rs = stmnt.getGeneratedKeys();
		        int generatedEId = -1;
		        if (rs.next()) {
		            generatedEId = rs.getInt(1);
		        }
		        stmnt.executeUpdate("INSERT INTO employment_details (EId, Department, Designation, DateOfJoining, Salary) VALUES ('" + generatedEId + "','" + department + "','" + designation + "','" + date + "','" + salary + "')");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet listEmp() {
		try {
			ResultSet result = stmnt.executeQuery("select * from employee");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteRec(String email) {
		try {
			stmnt.executeUpdate("delete from employment_details where EId=(select Eid from employee where Email='"+email+"')");
			stmnt.executeUpdate("delete from employee where Email='"+email+"'");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateData(String email, String mobile) {
		try {
			stmnt.executeUpdate("update employee set mobile='"+mobile+"' where email='"+email+"'");
		} catch (Exception e) {
		}
	}

	@Override
	public ResultSet findById(String id) {
		try {
			ResultSet result = stmnt.executeQuery("SELECT employee.*, employment_details.* FROM employee INNER JOIN employment_details ON employee.EID = employment_details.EID WHERE employee.EID = '"+id+"'");
			return result;
		} catch (Exception e) {
		}
		return null;
	}

}
