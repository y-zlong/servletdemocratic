package servletdemo;
/*
 * 1.дһ����ʵ��servlet�ӿ�
 * 2.��дservlet�ķ���
 * 3.��web.xml������servlet
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
		//��ȡservletConfig����
		//ͨ��this�ؼ�������ȡservletConfig����
		ServletConfig config = this.getServletConfig();
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
	
		System.out.println("service=======");
	}
	public ServletConfigTest() {
		System.out.println("����������========");
	}

}
