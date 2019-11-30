<%@page language="java" import="java.sql.*,java.util.*"%>

<%
	Driver DriverRecordset1 = (Driver) Class.forName("org.postgresql.Driver").newInstance();
	String url = "jdbc:postgresql://localhost/postgres";
	Connection Conn = DriverManager.getConnection(url);
	String tablename = request.getParameter("tablechoice");
	Statement st = Conn.createStatement();
	ResultSet rs = st.executeQuery("select * from " + tablename);
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
				
			</tr>
	<%
		}
	%>
</table>

<%
	rs.close();
	Conn.close();
%>

