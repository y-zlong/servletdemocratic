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
			//��ȡ��������
			Driver driver = new com.mysql.jdbc.Driver();
			//ע������
			DriverManager.registerDriver(driver);
			//��ȡ���ݿ�����
			String url = "jdbc:mysql://localhost:3306/test";
			String user = "root";
			String password = "123456";
			 connection = DriverManager.getConnection(url, user, password);
			//��ȡ���ݿ��������
			 statement = connection.createStatement();
			//ִ��sql���
			String sql = "select * from test";
				query = statement.executeQuery(sql);
			//�����ؽ����
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
