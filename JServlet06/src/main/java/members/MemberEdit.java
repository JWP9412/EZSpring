/*
 * http://localhost:8090/JServlet06/memberedit
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

@WebServlet("/memberedit")
public class MemberEdit extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("[MemeberEdit] (/memberedit), init...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MemeberEdit] (/memberedit): GET");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MemeberEdit] (/memberedit): POST");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String mid = request.getParameter("mid");

		MemberDBCP memberDBCP = new MemberDBCP();
		MemberVO member = memberDBCP.getMember(mid);
		
		PrintWriter out = response.getWriter();
		
		outHtmlHeader(out);
		outHtmlMember(out, member);
		outHtmlFooter(out);
	}
	
	static void outHtmlHeader(PrintWriter out) {
		out.print("<html><body>");
		out.print("<h1>멤버 수성</h1>");
		out.print("<hr>");
	}
	
	static void outHtmlMember(PrintWriter out, MemberVO member) {
		if(member == null) {
			return;
		}
		
		out.print("<form name='memberedit' method='post' action='memberlist'>");
		out.print("<table>");
		out.printf("<tr><td>아이디</td><td><input type='text' name='mid' value='%s' readonly></td></tr>", member.getMid());
		out.printf("<tr><td>이름</td><td><input type='text' name='mname' value='%s'></td></tr>", member.getMname());
		out.printf("<tr><td>비밀번호</td><td><input type='text' name='pwd' value='%s'></td></tr>", member.getPwd());
		out.printf("<tr><td>전자메일</td><td><input type='text' name='email' value='%s'></td></tr>", member.getEmail());
		out.print("<tr>");
		out.print("<td><input type='submit' value='멤버수정'></td>");
		out.print("<td><input type='reset' value='다시입력'></td>");
		out.print("</tr>");
		out.print("</table>");
		out.print("<input type='hidden' name='command' value='editMember'/>");
		out.print("</form>");
	}
	
	static void outHtmlFooter(PrintWriter out) {
		out.print("</body></html>");
	}

}
