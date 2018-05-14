package servletdemo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */ 
    public TestServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletConfig config = this.getServletConfig();
		String name = config.getInitParameter("user");
		System.out.println(name);
		Enumeration<String> names = config.getInitParameterNames();
		while (names.hasMoreElements()) {
			String names1 = (String) names.nextElement();
			String vules = config.getInitParameter(names1);
			System.out.println(names1);
			System.out.println(vules);
		}
		
		//��ȡwebӦ�ó�ʼ������
		ServletContext context = config.getServletContext();	//ͨ��servletConfig�����ȡServletContext����
		String driver = context.getInitParameter("driver");			//����getintParameter(String name)������ȡ����ֵ
			System.out.println(driver);
		//������ȡ
		Enumeration<String> name2 = context.getInitParameterNames();
		//whileѭ��
		while(name2.hasMoreElements()) {
			String Name = name2.nextElement();
			System.out.println(Name);
			String vules1 = context.getInitParameter(Name);
			System.out.println(vules1);
		}
		String realPath = context.getRealPath("/note.txt");
		//����E:\yangzelongworkspace\Demo\WebContent\note.txt
		//E:\yangzelongworkspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Demo\note.txt
		System.out.println(realPath);
		String contextPath = context.getContextPath();//��ȡ��ǰwebӦ�õ�����
		System.out.println(contextPath);
		try {
			InputStream is = context.getResourceAsStream("/WEB-INF/classes/jdbc.porperties");
			System.out.println(is);
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream is1 = classLoader.getResourceAsStream("jdbc.porperties");
			System.out.println(is1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
