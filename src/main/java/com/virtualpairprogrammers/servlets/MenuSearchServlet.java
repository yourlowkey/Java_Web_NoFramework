package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.data.MenuDao;
import com.virtualpairprogrammers.data.MenuDaoFactory;
import com.virtualpairprogrammers.domain.MenuItem;

@WebServlet("/searchResults.html")
public class MenuSearchServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html");
		
		String searchTerm = request.getParameter("searchTerm");		
		MenuDao menuDao = MenuDaoFactory.getMenuDao();
		List<MenuItem> menuItems = menuDao.find(searchTerm);
		request.setAttribute("menuItems", menuItems);
		
//		if (menuItems.size() > 0) {
//		
//			out.println("<html><body><h1>Ricky's Restaurant</h1>");
//			out.println("<h2>Dishes containing " + searchTerm + "</h2><ul>");
//			for (MenuItem menuItem : menuItems) {
//				out.println("<li>" + menuItem + " " + menuItem.getDescription() + "</li>");
//			}
//			
//			out.println("</ul></body></html>");
//		}
//		else {
//			out.println("<html><body><h1>Ricky's Restaurant</h1>");
//			out.println("<p>I'm sorry, there are no dishes containing " + searchTerm);
//			out.println("</p></body></html>");
//		}
//		out.close();
		ServletContext context = getServletContext();
		RequestDispatcher dispatch = context.getRequestDispatcher("/searchResults.jsp");
		dispatch.forward(request, response);
	}
		
}
