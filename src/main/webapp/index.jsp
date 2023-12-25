<%@ page import = "com.virtualpairprogrammers.data.MenuDao" %>
<%@ page import = "com.virtualpairprogrammers.data.MenuDaoFactory" %>
<%@ page import = "com.virtualpairprogrammers.domain.MenuItem" %>
<%@ page import = "java.util.List" %>

<%
	MenuDao menuDao = MenuDaoFactory.getMenuDao();
	List<MenuItem> menuItems = menuDao.getFullMenu();
%>

<html>
	<body>
		<jsp:include page="/header.jsp" />
		<h2>Menu</h2>
		<ul>
			<%
			for (MenuItem menuItem : menuItems) {
			%>
				<li><%=menuItem %></li>	
			<%
				}
			%>
		</ul>
		
		<jsp:include page="/footer.jsp" />
	</body>
</html>