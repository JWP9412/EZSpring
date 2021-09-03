/*
 * http://localhost:8090/JServlet06/memberview
 */
package members;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberview")
public class MemberView extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("[MemeberView] (/memberview), init...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MemeberView] (/memberview): GET");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MemeberView] (/memberview): POST");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		List<MemberVO> members = (List<MemberVO>)request.getAttribute("members");
		
		PrintWriter out = response.getWriter();
		
		outHtmlHeader(out);
		outHtmlMembers(out, members);
		outHtmlFooter(out);
	}
	
	static void outHtmlHeader(PrintWriter out) {
		out.print("<html><body>");
		out.print("<h1>멤버 리스트</h1><hr>");
		out.print("<table border=1>");
		out.print("<tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td>");
		out.print("<td>이름</td>");
		out.print("<td>비밀번호</td>");
		out.print("<td>이메일</td>");
		out.print("<td>등록일자</td>");
		out.print("<td>삭제</td>");
		out.print("<td>수정</td>");
		out.print("</tr>");
	}
	
	static void outHtmlMembers(PrintWriter out, List<MemberVO> members) {
		if(members == null) {
			return;
		}
		
		for(int cnt=0; cnt < members.size(); cnt++) {
			MemberVO member = (MemberVO)members.get(cnt);
			out.print("<tr>");
			out.printf("<td><a href='/JServlet06/memberdetail?mid=%s'>%s</a></td>", member.getMid(), member.getMid());
			out.printf("<td>%s</td>", member.getMname());
			out.printf("<td>%s</td>", member.getPwd());
			out.printf("<td>%s</td>", member.getEmail());
			out.printf("<td>%s</td>", member.getRegdate());
			out.printf("<td><a href='/JServlet06/memberlist?command=delMember&mid=%s'>삭제</a></td>", member.getMid());
			out.printf("<td><a href='/JServlet06/memberedit?mid=%s'>수정</a></td>", member.getMid());
			out.print("</tr>");
		}
	}
	
	static void outHtmlFooter(PrintWriter out) {
		out.print("</table>");
		out.print("<a href='/JServlet06/memberlist.html'>멤버등록</a>");
		out.print("</body></html>");
	}

}
