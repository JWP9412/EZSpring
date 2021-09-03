[Ebook]
접속 :  http://localhost:8090/EBooks/ebooks/ebooklist.jsp

(context.xml)
<Resource auth="Container" 
driverClassName="oracle.jdbc.OracleDriver" 
maxActive="50" 
maxWait="-1" 
name="jdbc/oracle" 
username="SHYUSER"
password="SHYUSER" 
type="javax.sql.DataSource" 
url="jdbc:oracle:thin:@localhost:1521:xe" 
/>