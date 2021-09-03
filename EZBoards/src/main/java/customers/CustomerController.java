
package customers;


import java.io.IOException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/customer/*")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerDAO customerDAO;

	public void init() throws ServletException {
		customerDAO = new CustomerDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		System.out.printf("@ customers.CustomerController.doHandle(%s)%n", request.getMethod());
		
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		
		System.out.println("@@ action:" + action);
		
		if (action == null || action.equals("/customerList.do")) {
			List<CustomerVO> customersList = customerDAO.getCustomers();
			request.setAttribute("customersList", customersList);
			nextPage = "/customers/customerList.jsp";
		} 
		else if (action.equals("/addCustomer.do")) {
			String num = request.getParameter("num");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			CustomerVO customerVO = new CustomerVO(num, name, tel, address);
			customerDAO.addCustomer(customerVO);
			request.setAttribute("msg", "addCustomer");
			nextPage = "/customer/customerList.do";
		} 
		else if (action.equals("/customerForm.do")) {
			nextPage = "/customers/customerForm.jsp";
		}
		else if(action.equals("/customerEditForm.do")){
		     String num = request.getParameter("num");
		     CustomerVO cusInfo = customerDAO.getCustomer(num);
		     request.setAttribute("cusInfo", cusInfo);
		     nextPage="/customers/customerEditForm.jsp";
		}
		else if(action.equals("/editCustomer.do")){
		     String num = request.getParameter("num");
		     String name = request.getParameter("name");
		     String tel = request.getParameter("tel");
	         String address = request.getParameter("address");
		     CustomerVO customerVO = new CustomerVO(num, name, tel, address);
		     customerDAO.updateCustomer(customerVO);
		     request.setAttribute("msg", "modified");
		     nextPage="/customer/customerList.do";
		}
		else if(action.equals("/delCustomer.do")){
		     String num = request.getParameter("num");
		     customerDAO.delCustomer(num);
		     request.setAttribute("msg", "deleted");
		     nextPage="/customer/customerList.do";
		}
		else if(action.equals("/customerDetailForm.do")){
		     String num = request.getParameter("num");
		     CustomerVO cusInfo = customerDAO.getCustomer(num);
		     request.setAttribute("cusInfo", cusInfo);
		     nextPage="/customers/customerDetailForm.jsp";
		}
		else {
			List<CustomerVO> customersList = customerDAO.getCustomers();
			request.setAttribute("customersList", customersList);
			nextPage = "/customers/customerList.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}

}
