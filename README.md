# servletdemocratic
servlet



ServletConfig����װ����servlet������Ϣ���ͻ�ȡservletconfig����
	
	1.����servlet�ĳ�ʼ������

<servlet>
	<servlet-name>ServletConfigTest</servlet-name>
	<servlet-class>servletdemo.ServletConfigTest</servlet-class>
	<!-- ����servlet��ʼ�������������ó�ʼ������һ��Ҫ����	<load-on-startup>1</load-on-startup>�ڵ�ǰ�� -->
		<init-param>
			<!-- �������� -->
			<param-name>user</param-name>
			<!-- ����ֵ -->
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

2.��ȡ��ʼ��������

	>getinitpargetInitParameter(String name);��ȡָ���������ĳ�ʼ������

	>getinitpargetInitParameterNames();��ȡ��������ɵ�Enumeration���󣨻�ȡ��ǰServlet���г�ʼ��������������ɵ�ö�٣�

	ServletContxt
	
	1.��servletconfig��ȡ
	2.�ö������webӦ����������Ϣ�������˵�ǰ��webӦ�ã�����ͨ���÷�����ȡ��ǰwebӦ�õĸ��������Ϣ��

	���ó�ʼ��������

	<!-- λÿ��servlet���ó�ʼ������ -->
	  <context-param>
  		<param-name>driver</param-name>
  		<param-value>com.mysql.jdbc.driver</param-value>
 	 </context-param>
 	 <context-param>
 	 	<param-name>jdbcurl</param-name>
 	 	<param-value>jdbc:mysql:///user</param-value>
 	 </context-param>

	��ȡ������
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
		servletcontext��ȡ��ͨ��ServletContext servletContext = ServletConfig.getServletContext();
		
			ServletContext context = config.getServletContext();	//ͨ	��servletConfig�����ȡServletContext����
			String driver = context.getInitParameter("driver");	//����getintParameter(String name)������ȡ����ֵ
			System.out.println(driver);
			//������ȡ
			Enumeration<String> name2 = context.getInitParameterNames();
			//whileѭ��
			while(name2.hasMoreElements()) {
			String Name = name2.nextElement();
			System.out.println(Name);
			String vules1 = context.getInitParameter(Name);
			System.out.println(vules1);


	>��ȡwebӦ��ĳ���ļ��ڷ������ϵ�·�������ǲ���ǰ��·������
		getRealPath(String path);
	���룺
		String realPath = context.getRealPath("/note.txt");
		//����E:\yangzelongworkspace\Demo\WebContent\note.txt
		//E:\yangzelongworkspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Demo\note.txt
		System.out.println(realPath);
		
			
	>��ȡ��ǰwebӦ�õ�����
		getContextPath();
	���룺
		String contextPath = context.getContextPath();//��ȡ��ǰwebӦ�õ�����
		System.out.println(contextPath);
		
	>��ȡWEBӦ���е��ļ���Ӧ��������
	getResourcesAsSteam(String path); path ��/��ʾ��ǰWEBӦ�õĸ�Ŀ¼
		�����ַ�����ȡ
		try {
			//ͨ��ServletContext��ȡ
			InputStream is = context.getResourceAsStream("/WEB-INF/classes/jdbc.porperties");
			System.out.println(is);
			//ͨ��ClassLoader��ȡ
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream is1 = classLoader.getResourceAsStream("jdbc.porperties");
			System.out.println(is1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
			public void service(ServletRequest request, ServletResponse response) 
			
		ServletRequest�����װ��������Ϣ������ͨ���ö����ȡ�κ���Ҫ��������Ϣ
		
		ServletResponse�����װ����Ӧ��Ϣ����ͨ���ö�������Ӧ��Ϣ
			
			Tips��ServletRequest��ServletResponse�������ӿڵ�ʵ���඼�Ƿ���������ģ����ڷ���������service()������
			ʱ����
			
		������	
			servletRequest.getParamater(String name); //���ݲ�������ȡ����
			//ͨ��foreach�������ַ�������
			String[] names = servletRequest.getParamaterVaules(String name);//����������������֣�����һ���ַ�������
			
			
			
		JDBC�Ļعˣ�
			
				1.ע������
					Class.forName("com.mysql.jdbc,Deriver");
				2.��ȡ���ݿ�����
				String url = "jdbc:mysql://localhost:3306/test";
				String user = "root";
				String password = "123456";
				3.��ȡ���ݿ����Ӷ���Connaction����
				Connection connection = DriverManager.getConnection(url, user, password);
				4.��ȡ���ݲ�������statement����
				Statement state = connection.createStatement();
				5.ִ��SQL���
				String sql = "select ename form user";
				ResultSet rs = statement.executeQuery(sql);
				6.�����ؽ����
				while(rs.next()){
					String name = rs.gerString("ename");
				}
				7.�ر���Դ
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
			
	jsp��forward	
	
		<%-----<%@ include file = "b.jsp" %>  -->
	<jsp:include page="b.jsp"/>
	 --%>
	 <%--ת��   ҳ�����Ȼͣ��a.jsp,�ȼ���request.getRequestDispatcher("/jsp/b.jsp").forward(request, response);
	 <jsp:forward page="/jsp/b.jsp"></jsp:forward>
	 <%
	 	request.getRequestDispatcher("/jsp/b.jsp").forward(request, response);
	 %>
	  --%>	
			
		//����ͨ��jsp:param�ӱ�ǩ�����ݲ�����b.jsp
		b.jsp����ͨ��<%=request.getparamet("name")%>����ʽ����ȡ,ͬ��Ҳ��������<jsp:include>;
			
		<jsp:forward page="/jsp/b.jsp">
	  	<jsp:param value="123456" name="username"/>
		 </jsp:forward>	
		 
		<h1>AAAAAAA</h1>
		<%=request.getParameter("username")%>	
		
		
		  <jsp:include page="/jsp/b.jsp">
	  		<jsp:param value="123589" name="name"/>	
		  </jsp:include>
		   <%=request.getParameter("name") %>
		   
		   ��b.jspҳ�����ͨ��request.getparamet("name")����ȡ�������Ĳ���
		   
		   
		   
		   ��������
		   
		   
		   
		    <%
 				request.setCharacterEncoding("utf-8");
			 %>
 				user:<%= request.getParameter("name")%>
 				
 				  <form action="b.jsp" method= "post">
			  			user:<input type="text" name="name"/>
			  			<input type="submit" value="Submit"/>
			  	  </form>
