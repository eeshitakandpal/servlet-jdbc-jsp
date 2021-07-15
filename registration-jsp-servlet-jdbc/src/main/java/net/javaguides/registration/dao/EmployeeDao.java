package net.javaguides.registration.dao;

import java.sql.*;
import net.javaguides.registration.model.Employee;

public class EmployeeDao {
	
	public void registerEmployee(Employee employee) throws ClassNotFoundException{
		String INSERT_USERS_SQL = "INSERT INTO employee (id, first_name, last_name, username, password, address, contact) VALUES (?,?,?,?,?,?,?);";
		
		
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","eeshita");
		
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
				preparedStatement.setInt(1,1);
				preparedStatement.setString(2,employee.getFirstName());
				preparedStatement.setString(3,employee.getLastName());
				preparedStatement.setString(4,employee.getUsername());
				preparedStatement.setString(5,employee.getPassword());
				preparedStatement.setString(6,employee.getAddress());
				preparedStatement.setString(7,employee.getContact());
				
				preparedStatement.executeUpdate();
				
				
			}catch(SQLException e) {
				
				e.printStackTrace();
				
			}
			
				
	}
}
