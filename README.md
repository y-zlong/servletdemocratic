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

