package servletdemo;
/*
 * 1.写一个类实现servlet接口
 * 2.重写servlet的方法
 * 3.在web.xml中配置servlet
 * =========================
 * servlet
 */
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletConfigTest implements Servlet {

	@Override
	public void destroy() {
		System.out.println("destory========");
		
	}

	@Override
	public javax.servlet.ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(javax.servlet.ServletConfig arg0) throws ServletException {
		System.out.println("init=============");
		//获取servletConfig对象
		//通过this关键字来获取servletConfig对象
		ServletConfig config = this.getServletConfig();
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
	
		System.out.println("service=======");
	}
	public ServletConfigTest() {
		System.out.println("构造器调用========");
	}

}
