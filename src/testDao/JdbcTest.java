package testDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JdbcTest {
	
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet query = null;
		try {
			//获取驱动对象
			Driver driver = new com.mysql.jdbc.Driver();
			//注册驱动
			DriverManager.registerDriver(driver);
			//获取数据库连接
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "123456";
			 connection = DriverManager.getConnection(url, user, password);
			//获取数据库操作对象
			 statement = connection.createStatement();
			//执行sql语句
			String sql = "select * from test";
				query = statement.executeQuery(sql);
			//处理返回结果集
			while(query.next()) {
				String name = query.getString(1);
				int password1 = query.getInt(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (query != null) {
				try {
					query.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	  }
	}
}
