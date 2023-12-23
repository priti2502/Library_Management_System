package jdbc_library;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
public class UserCRUD{

	public Connection getConnection() throws Exception{
		FileReader reader=new FileReader("dbconfig.properties"); //<c> java.io
		Properties properties  = new Properties();//<c>java.util
		properties.load(reader);
		Class.forName(properties.getProperty("ClassName1"));
		Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
		return connection;
	}
     public void signUpUser(User user) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into user(userid,name,phone,address,email,password)values(?,?,?,?,?,?)");
		preparedStatement.setInt(1, user.getUserId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setLong(3,user.getPhone());
		preparedStatement.setString(4, user.getAddress());
		preparedStatement.setString(5, user.getEmail());
		preparedStatement.setString(6, user.getPassword());
		int result=preparedStatement.executeUpdate();
		if(result!=0)
		{
			System.out.println("Successfully registered");
		}
		else
		{
			System.out.println("Enter valid Details");
		}
		connection.close();
		
		
		
	}
     public boolean loginUser(String email,String password)throws Exception{
 		Connection connection=getConnection();
 		PreparedStatement preparedStatement=connection.prepareStatement("Select Password from user where email=? ");
 	     preparedStatement.setString(1,email);
 	     ResultSet  resultSet=preparedStatement.executeQuery();
 	    String dbPassword=null;
 	     while(resultSet.next()) {
 	    	 dbPassword=resultSet.getString("password");
 	    	 if(password .equals(dbPassword)) {
 	    		 return true;
 	    	 }
 	    	 else {
 	    		 return false;
 	    	 }
 	     }
 		return false;
 	     
 	    	 
 	     }
   
 		
 		
 	}
     


