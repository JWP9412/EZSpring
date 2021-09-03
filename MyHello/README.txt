[Maven]
	- https://maven.apache.org/download.cgi
	- version :	3.8.1
	- 환경 변수 설정 (Path 설정)
		- MAVEN_HOME : 설치위치 폴더
		- Path : %MAVEN_HOME%\bin
		
[자바 프로젝트 생성 및 빌드 배포 과정]
CMD, MAVEN을 이용

1.mvn archetype:generate 초기 설정(프로젝트 생성)

2.mvn compile 컴파일

3.mvn test 테스트

4.mvn package 배포 

5.mvn clean 삭제

6.mvn exec:java 실행 (pom.xml에 하단 플러그인 삽입)


(pom.xml)
	<plugin>
		<groupId>org.codehaus.mojo</groupId>
		<artifactId>exec-maven-plugin</artifactId>
		<version>1.5.0</version>
		<configuration>
			<mainClass>com.MyTest.App</mainClass>
		</configuration>
	</plugin>
		
[Eclipse - Spring]
	-eclipse.org/download
	- j2ee : Eclipse IDE for Enterprise Java 