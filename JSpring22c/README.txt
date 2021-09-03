[JSpring22c]

Oracle JDBC
Spring JDBC


(pom.xml)
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-jdbc</artifactId>
	    <version>4.1.1.RELEASE</version>
	</dependency>
			
	
			<!-- https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc6 -->
	<dependency>
	    <groupId>com.oracle.database.jdbc</groupId>
	    <artifactId>ojdbc6</artifactId>
	    <version>11.2.0.4</version>
	</dependency>
		
(실행)
1. http://localhost:8090/JSpring22c/member/listMembers.do
2. MemberControllerImpl.listMembers()
3. MemberServiceImpl.listMember()
4. views/listMembers.jsp
