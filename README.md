# servletdemocratic
servlet



ServletConfig：封装了是servlet配置信息，和获取servletconfig对象
	
	1.配置servlet的初始化参数

<servlet>
	<servlet-name>ServletConfigTest</servlet-name>
	<servlet-class>servletdemo.ServletConfigTest</servlet-class>
	<!-- 配置servlet初始化参数，且配置初始化参数一定要放在	<load-on-startup>1</load-on-startup>节点前面 -->
		<init-param>
			<!-- 参数名称 -->
			<param-name>user</param-name>
			<!-- 参数值 -->
			<param-value>name</param-value>
		</init-param>
		<init-param>
			<param-name>password</param-name>
			<param-value>1230</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
</servlet>
	<servlet-mapping>
		<servlet-name>ServletConfigTest</servlet-name>
		<url-pattern>/hello</url-pattern>
	</servlet-mapping>

2.获取初始化参数：

	>getinitpargetInitParameter(String name);获取指定参数名的初始化参数

	>getinitpargetInitParameterNames();获取参数名组成的Enumeration对象（获取当前Servlet所有初始化参数的名字组成的枚举）

	ServletContxt
	
	1.由servletconfig获取
	2.该对象代表web应用中配置信息，代表了当前的web应用，可以通过该方法获取当前web应用的各方面的信息。

	设置初始化参数：

	<!-- 位每个servlet设置初始化参数 -->
	  <context-param>
  		<param-name>driver</param-name>
  		<param-value>com.mysql.jdbc.driver</param-value>
 	 </context-param>
 	 <context-param>
 	 	<param-name>jdbcurl</param-name>
 	 	<param-value>jdbc:mysql:///user</param-value>
 	 </context-param>

	获取方法：
		getinitpargetInitParameter(String name);
		getinitpargetInitParameterNames();

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
	=======================================================================================================
		servletcontext获取：通过ServletContext servletContext = ServletConfig.getServletContext();
		
			ServletContext context = config.getServletContext();	//通	过servletConfig对象获取ServletContext对象
			String driver = context.getInitParameter("driver");	//调用getintParameter(String name)方法获取参数值
			System.out.println(driver);
			//迭代获取
			Enumeration<String> name2 = context.getInitParameterNames();
			//while循环
			while(name2.hasMoreElements()) {
			String Name = name2.nextElement();
			System.out.println(Name);
			String vules1 = context.getInitParameter(Name);
			System.out.println(vules1);


	>获取web应用某个文件在服务器上的路径（不是部署前的路径）：
		getRealPath(String path);
	代码：
		String realPath = context.getRealPath("/note.txt");
		//不是E:\yangzelongworkspace\Demo\WebContent\note.txt
		//E:\yangzelongworkspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Demo\note.txt
		System.out.println(realPath);
		
			
	>获取当前web应用的名称
		getContextPath();
	代码：
		String contextPath = context.getContextPath();//获取当前web应用的名称
		System.out.println(contextPath);
		
	>获取WEB应用中的文件对应的输入流
	getResourcesAsSteam(String path); path 的/表示当前WEB应用的根目录
		有两种方法获取
		try {
			//通过ServletContext获取
			InputStream is = context.getResourceAsStream("/WEB-INF/classes/jdbc.porperties");
			System.out.println(is);
			//通过ClassLoader获取
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream is1 = classLoader.getResourceAsStream("jdbc.porperties");
			System.out.println(is1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
			public void service(ServletRequest request, ServletResponse response) 
			
		ServletRequest对象封装了请求信息，可以通过该对象获取任何想要的请求信息
		
		ServletResponse对象封装了响应信息，可通过该对象获得响应信息
			
			Tips：ServletRequest和ServletResponse这两个接口的实现类都是服务器赋予的，并在服务器加载service()方法的
			时候传入
			
		方法：	
			servletRequest.getParamater(String name); //根据参数名获取数据
			//通过foreach遍历该字符串数组
			String[] names = servletRequest.getParamaterVaules(String name);//根据请求参数的名字，返回一个字符串数组
			
			
			
		JDBC的回顾：
			
				1.注册驱动
					Class.forName("com.mysql.jdbc,Deriver");
				2.获取数据库连接
				String url = "jdbc:mysql://localhost:3306/test";
				String user = "root";
				String password = "123456";
				3.获取数据库连接对象Connaction对象
				Connection connection = DriverManager.getConnection(url, user, password);
				4.获取数据操作对象statement对象
				Statement state = connection.createStatement();
				5.执行SQL语句
				String sql = "select ename form user";
				ResultSet rs = statement.executeQuery(sql);
				6.处理返回结果集
				while(rs.next()){
					String name = rs.gerString("ename");
				}
				7.关闭资源
							if (resultSet != null) {
						try {
							resultSet.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}if(tement != null) {
					try {
						tement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}if(connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}if(resultSet != null) {
					try {
						resultSet.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			
	jsp：forward	
	
		<%-----<%@ include file = "b.jsp" %>  -->
	<jsp:include page="b.jsp"/>
	 --%>
	 <%--转发   页面的仍然停在a.jsp,等价于request.getRequestDispatcher("/jsp/b.jsp").forward(request, response);
	 <jsp:forward page="/jsp/b.jsp"></jsp:forward>
	 <%
	 	request.getRequestDispatcher("/jsp/b.jsp").forward(request, response);
	 %>
	  --%>	
			
		//可以通过jsp:param子标签来传递参数给b.jsp
		b.jsp可以通过<%=request.getparamet("name")%>的形式来获取,同样也可以用在<jsp:include>;
			
		<jsp:forward page="/jsp/b.jsp">
	  	<jsp:param value="123456" name="username"/>
		 </jsp:forward>	
		 
		<h1>AAAAAAA</h1>
		<%=request.getParameter("username")%>	
		
		
		  <jsp:include page="/jsp/b.jsp">
	  		<jsp:param value="123589" name="name"/>	
		  </jsp:include>
		   <%=request.getParameter("name") %>
		   
		   在b.jsp页面可以通过request.getparamet("name")来获取传过来的参数
		   
		   
		   
		   乱码问题
		   
		   
		   
		    <%
 				request.setCharacterEncoding("utf-8");
			 %>
 				user:<%= request.getParameter("name")%>
 				
 				  <form action="b.jsp" method= "post">
			  			user:<input type="text" name="name"/>
			  			<input type="submit" value="Submit"/>
			  	  </form>
