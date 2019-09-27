package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nis.model.Admin;

/**
 * Servlet implementation class EmployeesView
 */
@WebServlet("/EmployeesView")
public class EmployeesView extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EmployeesView() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		
		
		//session management
		 HttpSession ses=request.getSession();
		 try{
			
		 String ltime=ses.getValue("SLTIME").toString();	
		 Admin A=(Admin)(ses.getValue("SADMIN"));	
		
		 
        // String nav="<i>Admin:"+A.getAdminname()+"["+A.getAdminid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ltime+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a></i><br><hr>";		 
		// out.println(nav);
		}catch(Exception e){
			response.sendRedirect("AdminLogin");
			
		}
		/////////////////
		
		
		
		
		out.println("<script src=asset/jquery-2.2.1.min.js></script>");
		out.println("<script src=asset/country.js></script>");
		
		out.println("<html>");
		out.println("<form action=EmployeeSubmit method=post enctype='multipart/form-data'>");
		out.println("<a href=DisplayAllEmployee>Display All Employee</a><br>");
		out.print("<table>");
		out.println("<caption><b><i>Employee Register</i></b></caption>");

		out.println("<tr><td><b><i>Employee Id:</i></b></td>");
		out.println("<td><input type=text name=eid placeholder='Empployee ID' size=30></td></tr>");
		
		out.println("<tr><td><b><i>Name:</i></b></td>");
		out.println("<td><input type=text name=efn placeholder='First Name' size=30>&nbsp;&nbsp;<input type=text name=eln placeholder='Second Name' size=30></td></tr>");
	
		out.println("<tr><td><b><i>Father's Name:</i></b></td>");
		out.println("<td><input type=text name=effn placeholder='First Name' size=30>&nbsp;&nbsp;<input type=text name=efln placeholder='Second Name' size=30></td></tr>");
	 
		out.println("<tr><td><b><i>Birth Date:</i></b></td>");
		out.println("<td><input type=date name=ebd size=30></td></tr>");
		
		out.println("<tr><td><b><i>Gender:</i></b></td>");
		out.println("<td><input type=radio name=eg value=Male>Male<input type=radio name=eg value=Female>Female</td></tr>");
		
		out.println("<tr><td><b><i>Address:</i></b></td>");
		out.println("<td><textarea row=3 cols=30 name=eadd ></textarea></td></tr>");
		
		out.println("<tr><td><b><i>Country :</i></b></td>");
		out.println("<td><select name=ecountry id=ecountry></select></td></tr>");
		
		out.println("<tr><td><b><i>State:</i></b></td>");
		out.println("<td><select name=estate id=estate></select></td></tr>");
		
		out.println("<tr><td><b><i>City:</i></b></td>");
		out.println("<td><select name=ecity id=ecity></select></td></tr>");
		
		out.println("<tr><td><b><i>Email Id:</i></b></td>");
		out.println("<td><input type=email name=em size=30></td></tr>");
		
		out.println("<tr><td><b><i>Mobile:</i></b></td>");
		out.println("<td><input type=text name=emobile size=30></td></tr>");
		
		out.println("<tr><td><b><i>Designation:</i></b></td>");
		out.println("<td><input type=text name=edes size=30></td></tr>");
		
		
		out.println("<tr><td><b><i>Password:</i></b></td>");
		out.println("<td><input type=password name=epwd size=30></td></tr>");
		
		out.println("<tr><td><b><i>Confirm Password:</i></b></td>");
		out.println("<td><input type=password name=ecpwd size=30></td></tr>");
		
		
		out.println("<tr><td><b><i>Photograph:</i></b></td>");
		out.println("<td><input type=file name=eph size=30></td></tr>");
		
		out.println("<tr><td><input type=submit></td>");
		out.println("<td><input type=reset></td></tr>");
				out.println("</table></form></html>");
				out.flush();
	 	}

}
