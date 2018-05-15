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
			//根据name值获取请求参数的值
			String user = request.getParameter("user");	
			String passworld = request.getParameter("password");
			System.out.println(user);
			System.out.println(passworld);
			//根据请求参数的名字，返回String类型的字符串数组
			String[] likes = request.getParameterValues("LIKE");
			//foreach遍历数组
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
			//因为HttpServletRequest是ServletRequert的子接口在此处必须要强转
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			//获取请求方法
			String method = httpServletRequest.getMethod();
			System.out.println(method);
			//获取get请求？后的字符串
			String queryString = httpServletRequest.getQueryString();
			System.out.println(queryString);
			//设置响应的类型
			response.setContentType("application/msword");
			//response.getWriter()向浏览器返回相应信息
			PrintWriter writer = response.getWriter();
			//调用printin()方法输出到客户端
			writer.println("nihao.....");
			
	}

}
