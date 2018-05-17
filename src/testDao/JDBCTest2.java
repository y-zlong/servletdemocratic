package testDao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 * 通过配置文件方式来优化JDBC程序
 * @author Administrator
 *
 */
public class JDBCTest2 {
	public static void main(String[] args) throws FileNotFoundException {
		FileReader reader = new FileReader("conf/jdbc.porperties");
		Properties properties = new Properties();
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		Connection connection = null;
		Statement statement  = null;
		ResultSet resultSet  = null;
		try {
			 connection = DriverManager.getConnection(url, user, password);
			String sql ="select name from e_name where id=2";
			 statement = connection.createStatement();
			 resultSet = statement.executeQuery(sql);
			while(resultSet.next()) {
				String name = resultSet.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block-
			e.printStackTrace();
		}finally {
			if(resultSet !=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(statement != null) {
				try {
					statement.close();
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
			}
		}
	}
}
