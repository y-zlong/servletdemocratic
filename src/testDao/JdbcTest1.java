package testDao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest1 {
	public static void main (String[] args) {
		Connection connection = null;
		Statement tement = null;
		ResultSet resultSet = null;
		try {
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "123456";
			 connection = DriverManager.getConnection(url, user, password);
			 String sql = "select * from user where name = 'zhangsan',age = 12";
			  tement = connection.createStatement();
			  resultSet = tement.executeQuery(sql);
			  while(resultSet.next()) {
				  String name = resultSet.getString(1);
				  int age = resultSet.getInt(2);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}if(tement != null) {
			try {
				tement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
