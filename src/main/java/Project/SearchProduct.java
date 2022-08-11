package Project;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchProduct() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int product_id= Integer.parseInt(request.getParameter("Prod_id"));
		try {
			Connection con=DBConnection.getConnection();
			
			String str="Select * from Product where Prod_id=?";
			PreparedStatement stmt= con.prepareStatement(str);
			stmt.setInt(1, product_id);
		
			ResultSet rs= stmt.executeQuery();
			PrintWriter out= response.getWriter();
			
			out.println("<table width=75% border=1>");
		     out.println("<caption><h1>Detail of the Required product</h1></caption>");
		     ResultSetMetaData rsmd=rs.getMetaData();
		     int totalcolumn=rsmd.getColumnCount();
		     out.print("<tr>");
		    
		     for(int i=1;i<=totalcolumn;i++)
		     {
		    	 out.print("<th>"+rsmd.getColumnName(i)+"</th>");
		    	 
		     }
		     out.print("<tr>");
		     while(rs.next())
		     {
		    	 out.print("<tr>");
		 		
		 		out.print("<td>"+rs.getInt(1)+"</td>");
		 		out.print("<td>"+rs.getString(2)+"</td>");
		 		out.print("<td>"+rs.getFloat(3)+"</td>");
		 		out.print("<td>"+rs.getFloat(4)+"</td>");
		 		out.print("</tr>");
		     }
		     out.print("</table>");
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
