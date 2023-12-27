package com.virtualpairprogrammers.servlets;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtualpairprogrammers.data.MenuDao;
import com.virtualpairprogrammers.data.MenuDaoFactory;
@WebServlet("/thankYou.html")
@ServletSecurity(@HttpConstraint(rolesAllowed= {"user"}))
public class ThankYouServlet extends HttpServlet {

	
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		
		HttpSession session = request.getSession();
		Long orderId = (Long) session.getAttribute("orderId");
		MenuDao dao = MenuDaoFactory.getMenuDao();
		Double total = dao.getOrderTotal(orderId);
		String status = dao.getOrder(orderId).getStatus();
		if (total == null) {
			response.sendRedirect("/order.html");
			return;
		}
		request.setAttribute("total", total);
		request.setAttribute("id", orderId);
		request.setAttribute("status", status);
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/thankyou.jsp");
		dispatcher.forward(request, response);
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html");
//
//		out.println("<html><body><h1>Ricky's Restaurant</h1>");
//		out.println("<h2>Order your food</h2>");
//		
//		out.println("Thank you - your order has been received. You need to pay $" + total);
//				
//		out.println("</body></html>");
//		out.close();
		
		
	}
}
