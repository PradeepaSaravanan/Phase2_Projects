package Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ProductDetails")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		      
		Connection con=DBConnection.getConnection();
	        
	String str= "select * from Product";
    Statement stmt= con.createStatement();
    
    ResultSet rs=stmt.executeQuery(str); 
    PrintWriter out= response.getWriter();
   
    out.print("<table border=1 cellpadding=10 cellspacing=0> <thead><tr>");
    out.println("<caption><h1>Product Details</h1></caption>");
	out.print("<th>ProductId</th><th>ProductName</th><th>Price</th><th>Quantity</th>");
	out.print("<tr></thead>");
	out.print("<tbody>");
    while(rs.next())
    {
    	out.print("<tr>");
		
		out.print("<td>"+rs.getInt(1)+"</td>");
		out.print("<td>"+rs.getString(2)+"</td>");
		out.print("<td>"+rs.getFloat(3)+"</td>");
		out.print("<td>"+rs.getInt(4)+"</td>");
		out.print("</tr>");
    }
     con.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
