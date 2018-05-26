package SelectTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	public List<UserBean> getAll() {
		List<UserBean> userBean = new ArrayList<UserBean>();
		Connection conn = null;
		PreparedStatement ps = null;	
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost:3306/user";
		String user = "root";
		String password = "123456";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url, user, password);
			String sql = "select * from student";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				int s_id = rs.getInt(1);
				String s_name = rs.getString(2);
				int s_num = rs.getInt(3);
				String s_dress = rs.getString(4);
				UserBean userbean = new UserBean(s_id, s_name, s_num, s_dress);
				userBean.add(userbean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(ps !=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return userBean;
		
	}

	public void delete(int userId) {
		Connection conn = null;
		PreparedStatement ps = null;	
		String url = "jdbc:mysql://localhost:3306/user";
		String user = "root";
		String password = "123456";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			conn= DriverManager.getConnection(url, user, password);
			String sql = "delete from user where id = ?";
			ps.setInt(1, userId);
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			}if(ps !=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
}
