package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ComplaintRegister
 */
@WebServlet("/ComplaintRegister")
public class ComplaintRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplaintRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter out=response.getWriter();
		out.println("<script src=asset/jquery-2.2.1.min.js></script>");
		out.println("<script src=asset/country.js></script>");
		
		out.println("<html>");
		out.println("<form action=ComplaintRegisterSubmit>");
		 
		out.print("<table>");
		out.println("<caption><b><i>Complaint Register</i></b></caption>");
		out.println("<tr><td><b><i>Current Date:</i></b></td>");
		out.println("<td><input type=text name=cd size=30></td></tr>");
		
		out.println("<tr><td><b><i>Comapany:</i></b></td>");
		out.println("<td><select id=cid name=cid></select></td></tr>");
	
		out.println("<tr><td><b><i>Product<br>Information:</i></b></td>");
		out.println("<td><textarea name=pi rows=6 cols=30></textarea></td></tr></table>");
		out.println("<br><b><i>Customer Details</i><b><br><table>");
	 
		out.println("<tr><td><b><i>Name:</i></b></td>");
		out.println("<td><input type=text name=cname size=30></td></tr>");
	
		out.println("<tr><td><b><i>Mobile:</i></b></td>");
		out.println("<td><input type=text name=cmobile size=30></td></tr>");
		
		 out.println("<tr><td><b><i>Country :</i></b></td>");
		 out.println("<td><select name=ecountry id=ecountry></select></td></tr>");
		
		 
		out.println("<tr><td><b><i>State:</i></b></td>");
		out.println("<td><select name=estate id=estate></select></td></tr>");
		
		out.println("<tr><td><b><i>City:</i></b></td>");
		out.println("<td><select name=ecity id=ecity></select></td></tr>");
				
		out.println("<tr><td><b><i>Service Center:</i></b></td>");
		out.println("<td><select id=scid name=scid></select></td></tr>");
		out.println("<tr><td><b><i>Communication<br>details:</i></b></td>");
		out.println("<td><textarea name=pi rows=6 cols=30></textarea></td></tr>");
		 
		out.println("<tr><td><input type=submit></td>");
		out.println("<td><input type=reset></td></tr>");
				out.println("</table></form></html>");
				out.flush();
	}
			
}


