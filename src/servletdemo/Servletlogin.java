package servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

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
			Map<String, String[]> parameterMap = request.getParameterMap();
			System.out.println("========================================================");
			//��ΪHttpServletRequest��ServletRequert���ӽӿ��ڴ˴�����Ҫǿת
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			//��ȡ���󷽷�
			String method = httpServletRequest.getMethod();
			System.out.println(method);
			//��ȡget���󣿺���ַ���
			String queryString = httpServletRequest.getQueryString();
			System.out.println(queryString);
			//������Ӧ������
			response.setContentType("application/msword");
			//response.getWriter()�������������Ӧ��Ϣ
			PrintWriter writer = response.getWriter();
			//����printin()����������ͻ���
			writer.println("nihao.....");
			
	}

}
