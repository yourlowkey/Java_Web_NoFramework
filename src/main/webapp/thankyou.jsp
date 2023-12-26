<html>
	<body>
		<h1>Ricky's Restaurant</h1>
		<h2>Order your food</h2>
		
		<%Double total = (Double)request.getAttribute("total"); 
			out.println("Thank you - your order has been received. You need to pay $ " + total);
		%>
	</body>
</html>