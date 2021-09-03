/*
 * http://localhost:8090/JServlet06/memberdetail
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

@WebServlet("/memberdetail")
public class MemberDetail extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("[MemeberDetail] (/memberedetail), init...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MemeberDetail] (/memberdetail): GET");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MemeberDetail] (/memberdetail): POST");
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
		out.print("<h1>멤버 상세보기</h1>");
		out.print("<hr>");
	}
	
	static void outHtmlMember(PrintWriter out, MemberVO member) {
		if(member == null) {
			return;
		}
		
		out.print("<table border=1>");
		out.printf("<tr><td>아이디</td><td>%s</td></tr>", member.getMid());
		out.printf("<tr><td>이름</td><td>%s</td></tr>", member.getMname());
		out.printf("<tr><td>비밀번호</td><td>%s</td></tr>", member.getPwd());
		out.printf("<tr><td>전자메일</td><td>%s</td></tr>", member.getEmail());
		out.print("</table>");
	}
	
	static void outHtmlFooter(PrintWriter out) {
		out.print("<a href='/JServlet06/memberlist'>멤버 리스트</a>");
		out.print("</body></html>");
	}

}
