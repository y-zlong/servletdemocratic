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
			//第一种方式加载驱动
		/*	Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);*/
			//第二种直接加载mysql驱动
			//通过java反射机制
			Class.forName("com.mysql.jdbc,Deriver");
			
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
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
/**
 *通过static静态代码块加载注册驱动
 * @author Administrator
 *
 */
class DriverMannager{
	static {
		try {
			Driver driver = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(driver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
