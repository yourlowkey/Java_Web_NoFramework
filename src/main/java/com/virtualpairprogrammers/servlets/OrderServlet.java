package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import com.virtualpairprogrammers.data.MenuDao;
import com.virtualpairprogrammers.data.MenuDaoFactory;
import com.virtualpairprogrammers.domain.MenuItem;
@WebServlet("/order.html")
@ServletSecurity(@HttpConstraint(rolesAllowed= {"user"}))
public class OrderServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html");
//		out.println("<html><body><h1>Ricky's Restaurant</h1>");
//		out.println("<h2>Order your food</h2>");
//		
//		out.println("<form action='orderReceived.html' method='POST' >");
//		out.println("<ul>");
		
		MenuDao menuDao = MenuDaoFactory.getMenuDao();
		List<MenuItem> menuItems = menuDao.getFullMenu();
		request.setAttribute("menuItems", menuItems);
		
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/order.jsp");
		dispatcher.forward(request, response);
		System.out.println("items from sessons"+ menuItems);
//		for (MenuItem menuItem : menuItems) {
//			out.println("<li>" + menuItem + "<input type='text' name='item_" +menuItem.getId() +"' /> </li>");
//		}
//		
//		out.println("</ul>");
//		out.println("<input type='submit' />");
//		out.println("</form></body></html>");
//		out.close();
	}
}
