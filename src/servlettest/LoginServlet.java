package servlettest;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet implements Servlet {

	private ServletConfig servletConfig ;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return servletConfig;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		this.servletConfig = servletConfig;
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		//获取页面传递参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//获取web应用初始化参数
		/*ServletContext servletContext = servletConfig.getServletContext();
		String initUser = servletContext.getInitParameter("user");
		String initPassword = servletContext.getInitParameter("password");
		PrintWriter writer = response.getWriter();
		if(user.equals(initUser)&&password.equals(initPassword)) {
			writer.println("hello"+user);
		}else {
			writer.print("sorry"+user);
		}*/
		//通过reader加载文件
		FileReader reader = new FileReader("conf/jdbc.porperties");
		Properties properties = new Properties();
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String pwd = properties.getProperty("password");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = false;
		/**
		 * 使用PerparedStatement对象预编译sql
		 */
		try {
		 conn = DriverManager.getConnection(url, user, password);
		 String sql = "select name from t_name where name = ? and password = ?";
		 conn.setAutoCommit(false);
		 ps = conn.prepareStatement(sql);
		 ps.setString(1, username);
		 ps.setString(2, password);
		 rs = ps.executeQuery();
		 if(rs.next()) {
			 flag = true;
		 }
		 
		 conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}if(ps != null);
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(conn != null);
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
