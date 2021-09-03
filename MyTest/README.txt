
[자바 프로젝트 생성 및 빌드 배포 과정]
Maven을 이용

1. mvn archetype:generate
2. mvn compile
3. mvn test
4. mvn package

5. mvn exec:java

(pom.xml)
 <build>
    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
	  
		<plugin>
        	<groupId>org.codehaus.mojo</groupId>
        	<artifactId>exec-maven-plugin</artifactId>
        	<version>1.5.0</version>
        	<configuration>
        		<mainClass>com.mytest.App</mainClass>
        	</configuration>
        </plugin>
	  	  
      </plugins>
    </pluginManagement>
</build>	  
	  