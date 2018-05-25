package ServletMVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
	
	public List<studentBean> getListAll(){
		List<studentBean> stu = new  ArrayList<studentBean>();
		Connection connection = null;
		PreparedStatement ps  = null;
		ResultSet resultSet = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/user";
		String user = "root";
		String password = "123456";
		try {
			Class.forName(driver); 
			connection = DriverManager.getConnection(url, user, password);
			String sql ="select id,name,number,dress from student";
			ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				int stu_id = resultSet.getInt(1);
				String stu_name = resultSet.getString(2);
				int stu_num = resultSet.getInt(3);
				String stu_dress = resultSet.getString(4);
				studentBean student = new studentBean(stu_id, stu_name, stu_num, stu_dress);
				stu.add(student);
				}
			} catch (Exception e) {
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
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} 	if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		return stu;
		}

}
