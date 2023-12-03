

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","Dipali@12345");
			PreparedStatement ps=con.prepareStatement("update user set password=? where username=? and password=?");
			ps.setString(1,request.getParameter("t3"));
			ps.setString(2,request.getParameter("t1"));
			ps.setString(3,request.getParameter("t2"));
			
			ps.executeUpdate();
			out.println("<h1>Password update successfully</h1>");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
