package servletdemo;

import java.io.IOException;
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
		
		//获取web应用初始化参数
		ServletContext context = config.getServletContext();	//通过servletConfig对象获取ServletContext对象
		String driver = context.getInitParameter("driver");			//调用getintParameter(String name)方法获取参数值
			System.out.println(driver);
		//迭代获取
		Enumeration<String> name2 = context.getInitParameterNames();
		//while循环
		while(name2.hasMoreElements()) {
			String Name = name2.nextElement();
			System.out.println(Name);
			String vules1 = context.getInitParameter(Name);
			System.out.println(vules1);
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
