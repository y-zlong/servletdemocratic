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

