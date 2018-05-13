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

