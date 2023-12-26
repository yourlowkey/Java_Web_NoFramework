<%@ page import = "com.virtualpairprogrammers.domain.MenuItem" %>
<%@ page import = "java.util.List" %>
<html>
	<body>
		<h1>Ricky's Restaurant</h1>
		<h2>Order your food</h2>
		<form action='/orderReceived.html' method='POST' >
			<ul>
			<% 
			List<MenuItem> menuItems = (List<MenuItem>)request.getAttribute("menuItems");
			for (MenuItem menuItem : menuItems) {
				out.println("<li>" + menuItem + "<input type='text' name='item_" +menuItem.getId() +"' /> </li>");
			}
			%>
			</ul>
			<input type='submit' />
		</form>
	</body>
</html>