package ebooks;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import members.MemberVO;


@WebServlet("/ebook/*")
public class EbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EbookDAO ebookDAO;
    
	
	public void init() throws ServletException {
		ebookDAO = new EbookDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		System.out.printf("@ ebooks.EbookController.doHanldle(%s)",request.getMethod());
		
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		
		System.out.println("@@ action : "+action);
		
		if(action == null || action.equals("/ebookList.do")) {
			List<EbookVO> ebooksList = ebookDAO.getEbooks();
			request.setAttribute("ebooksList", ebooksList);
			nextPage = "/ebooks/ebookList.jsp";
		}
		else if (action.equals("/insertEbook.do")) {
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			Integer price = Integer.parseInt(request.getParameter("price"));
//			Integer price = request.getParameter("price");
			Integer qty = Integer.parseInt(request.getParameter("qty"));
			EbookVO ebookVO = new EbookVO(title, author, price, qty);
			ebookDAO.insertEbook(ebookVO);
			nextPage = "/ebook/ebookList.do";
			request.setAttribute("msg", "insertEbook");
			
		}
		else if (action.equals("/ebookForm.do")) {
			nextPage = "/ebooks/ebookForm.jsp";
		}
		else if(action.equals("/ebookEditForm.do")){
		     Integer serial = Integer.parseInt(request.getParameter("serial"));
		     EbookVO ebookInfo = ebookDAO.getEbook(serial);
		     request.setAttribute("ebookInfo", ebookInfo);
		     nextPage="/ebooks/ebookEditForm.jsp";
		}
		else if(action.equals("/editEbook.do")){
			Integer serial = Integer.parseInt(request.getParameter("serial"));
			String title = request.getParameter("title");
			String author = request.getParameter("author");
			Integer price = Integer.parseInt(request.getParameter("price"));
			Integer qty = Integer.parseInt(request.getParameter("qty"));
			EbookVO ebookVO = new EbookVO(title, author, price, qty, serial);
			ebookDAO.updateBook(ebookVO);
			request.setAttribute("msg", "modified");
			nextPage = "/ebook/ebookList.do";
		}
		
		else if(action.equals("/delEbook.do")){
			Integer serial = Integer.parseInt(request.getParameter("serial"));
		     ebookDAO.delEbook(serial);
		     request.setAttribute("msg", "deleted");
		     nextPage = "/ebook/ebookList.do";
		}
		else{
			List<EbookVO> ebooksList = ebookDAO.getEbooks();
			request.setAttribute("ebooksList", ebooksList);
			nextPage = "/ebooks/ebookList.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
}
