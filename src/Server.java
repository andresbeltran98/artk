import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JDBCServer
 */
@WebServlet("/Server")
public class Server extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Server() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("org.postgresql.Driver");

			String url = "jdbc:postgresql://localhost/postgres";
			Properties props = new Properties();
			props.setProperty("user", "postgres");
			props.setProperty("password", "");
			conn = DriverManager.getConnection(url, props);
			String tablename = request.getParameter("tablechoice");
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("select * from " + tablename);
			
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<table border='1'>");
			while(rs.next()){
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body></html>");
			stat.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*try {
			Driver DriverRecordset1 = (Driver) Class.forName("org.postgresql.Driver").newInstance();
			Properties props = new Properties();
			props.setProperty("user", "postgres");
			props.setProperty("password", "");
			String url = "jdbc:postgresql://localhost/postgres";
			Connection Conn = DriverManager.getConnection(url);
			String tablename = request.getParameter("tablechoice");
			Statement st = Conn.createStatement();
			ResultSet rs = st.executeQuery("select * from " + tablename);
			
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<table border='1'>");
			while(rs.next()){
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body></html>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
