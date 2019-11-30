<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.0/css/bootstrap.min.css" integrity="sha384-SI27wrMjH3ZZ89r4o+fGIJtnzkAnFs3E4qz9DIYioCQ5l9Rd/7UAa8DHcaL8jkWt" crossorigin="anonymous">
    
    <title>ARTISTS</title>
    
    <style>
    	body {
  			background-color: #f1f1f1;
 			margin-top: 4rem;
		}
    </style>
</head>

<body>
<div class="container">
  
<%@page language="java" import="java.sql.*,java.util.*"%>

<%
	Driver DriverRecordset1 = (Driver) Class.forName("org.postgresql.Driver").newInstance();
	String url = "jdbc:postgresql://localhost/burnable";
	Connection connection = DriverManager.getConnection(url);
	
	if (request.getMethod().equals("GET")){
		
		if (request.getParameter("all") != null){
			
			Statement st = connection.createStatement();	
			ResultSet rs = st.executeQuery("select * from artist");
%>

			<table border = "1">
				<%
					while (rs.next()) {
				%>
						<tr>
							<td><%=rs.getString(1)%></td>
							<td><%=rs.getString(2)%></td>
							<td><%=rs.getString(3)%></td>
							<td><%=rs.getString(4)%></td>
							<td><%=rs.getString(5)%></td>	
						</tr>
				<%
					}
				%>
			</table>

<%	
			rs.close();
			connection.close();
		}
		
		else if (request.getParameter("all") != null){
%>
		
		HELLO
			
<%
		}
		
		
	}
%>

</div>
</body>





