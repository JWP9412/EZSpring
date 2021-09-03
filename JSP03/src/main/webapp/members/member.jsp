<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, members.*"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");

	String mid = request.getParameter("mid");
	String mname = request.getParameter("mname");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	
	MemberVO member = new MemberVO(mid, mname, pwd, email);
	MemberDBCP memberDBCP = new MemberDBCP();
	memberDBCP.addMember(member);
	
	List<MemberVO> memberList = memberDBCP.getMembers();
%>    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>멤버 등록 및 조회</title>
</head>
<body>
	<table>
		<tr bgcolor="77bbcc">
			<td>아이디</td>
			<td>이름</td>
			<td>비밀번호</td>
			<td>이메일</td>
			<td>등록일자</td>
		<tr>
		
<%	
		for(int cnt=0; cnt < memberList.size(); cnt++) {
			MemberVO mem = (MemberVO)memberList.get(cnt);
%>		
			<tr>
				<td><%=mem.getMid()%></td>
				<td><%=mem.getMname()%></td>
				<td><%=mem.getPwd()%></td>
				<td><%=mem.getEmail()%></td>
				<td><%=mem.getRegdate()%></td>
			</tr>
<%
		}
%>		
	</table>

</body>
</html>