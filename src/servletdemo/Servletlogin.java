package servletdemo;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Servletlogin implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
			//����nameֵ��ȡ���������ֵ
			String user = request.getParameter("user");	
			String passworld = request.getParameter("password");
			System.out.println(user);
			System.out.println(passworld);
			//����������������֣�����String���͵��ַ�������
			String[] likes = request.getParameterValues("LIKE");
			//foreach��������
			for (String like : likes) {
				System.out.println(like);
			}
			System.out.println("==================");
			Enumeration<String> names = request.getParameterNames();
			while(names.hasMoreElements()) {
				String name = names.nextElement();
				String val = request.getParameter(name);
				System.out.println(name);
				System.out.println(val);
			}
	}

}
