/*
 * http://localhost:8090/JServlet06/memberlist
 */
package members;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/memberlist")
public class MemberList extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("[MemberList] (/memberlist), init...");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MemberList] (/memberlist): GET");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[MemberList] (/memberlist): POST");
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MemberDBCP memberDBCP = new MemberDBCP();
		
		String command = request.getParameter("command");
		if(command != null) {
			
			if(command.equals("addMember")) {
				String mid   = request.getParameter("mid");
				String mname = request.getParameter("mname");
				String pwd   = request.getParameter("pwd");
				String email = request.getParameter("email");
				System.out.printf("[memberlist] addMember: (%s)(%s)(%s)(%s)%n", mid, mname, pwd, email);
				
				if(mid != null && mid.isEmpty() != true) { 
					MemberVO member = new MemberVO(mid, mname, pwd, email);
					memberDBCP.addMember(member);
				}
			}
			else if(command.equals("delMember")){
				String mid = request.getParameter("mid");
				System.out.printf("[memberlist] delMember: mid(%s)%n", mid);

				if(mid != null && mid.isEmpty() != true) { 
					memberDBCP.delMember(mid);
				}
			}
			else if(command.equals("editMember")) {
				String mid   = request.getParameter("mid");
				String mname = request.getParameter("mname");
				String pwd   = request.getParameter("pwd");
				String email = request.getParameter("email");
				System.out.printf("[memberlist] editMember: (%s)(%s)(%s)(%s)%n", mid, mname, pwd, email);
				
				if(mid != null && mid.isEmpty() != true) { 
					MemberVO member = new MemberVO(mid, mname, pwd, email);
					memberDBCP.updateMember(member);
				}
			}
		}		

		List<MemberVO> members = memberDBCP.getMembers();
		
		request.setAttribute("members", members);
		
		RequestDispatcher dispatch = request.getRequestDispatcher("memberview");
		dispatch.forward(request, response);
	}
}
