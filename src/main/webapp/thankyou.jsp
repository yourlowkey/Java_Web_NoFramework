<html>
	<head>
		<script type="text/javascript">
		function updateStatus(){
			const request = new XMLHttpRequest();
			request.open("GET","/updatedStatus?id=${id}",true);
			request.send();
		}
		</script>
	</head>
	<body>
		<h1>Ricky's Restaurant</h1>
		<h2>Order your food</h2>
		
		<%Double total = (Double)request.getAttribute("total"); 
			out.println("Thank you - your order has been received. You need to pay $ " + total);
		%>
		<p>The current status of your order is : 
		<% String status = (String) request.getAttribute("status");
		out.println("<span id=\"status\">"+ status +"</span>"); %>
		 <input type="button" value="refresh status" onclick="updateStatus()"></p>
	</body>
</html>