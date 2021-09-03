<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%
  	request.setCharacterEncoding("utf-8");
  	int dan = Integer.parseInt(request.getParameter("dan"));
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
	<table border='1' width='400'>
		<tr align="center" bgcolor="FFFF77">
			<td colspan=2> <%=dan %>단 출력</td>
		</tr>
		<%for(int cnt=1; cnt<10; cnt++){%>
			<tr align="center">
				<td width="200"><%=dan %> * <%=cnt %></td>
				<td width="200"><%=dan*cnt %></td>
			</tr>
		<%}%>
	</table>
</body>
</html>