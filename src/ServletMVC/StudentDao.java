package ServletMVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	
	public List<studentBean> getListAll() throws SQLException {
		List<studentBean> stu = new  ArrayList<studentBean>();
		Connection connection = null;
		PreparedStatement prepareStatement  = null;
		ResultSet resultSet = null;
		try {
			Class.forName("driver");
			String url = "com.mysql.jdbc.Driver";
			String user = "root";
			String password = "123456";
			connection = DriverManager.getConnection(url, user, password);
			String sql = "SELECT id,NAME,number,dress FROM student";
			prepareStatement = connection.prepareStatement(sql);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()) {
				int stu_id = resultSet.getInt(1);
				String stu_name = resultSet.getString(2);
				int stu_num = resultSet.getInt(3);
				String stu_dress = resultSet.getString(4);
				studentBean student = new studentBean(stu_id, stu_name, stu_num, stu_dress);
				stu.add(student);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			try {
				if(prepareStatement != null) {
					prepareStatement.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			try {
				if(connection != null) {
					connection.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		return stu;
	}
}
