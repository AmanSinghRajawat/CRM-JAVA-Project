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
 * Servlet implementation class CompanyView
 */
@WebServlet("/CompanyView")
public class CompanyView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyView() {
        super();
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
		
		
		
		
		
		
		try{
			
			out.println("<script src=asset/jquery-2.2.1.min.js></script>");
			out.println("<script src=asset/country.js></script>");
			
			
			out.println("<html>");
			out.println("<form action=CompanySubmit method=post enctype='multipart/form-data'>");
			out.println("<a href=DisplayAllCompany>Display All Company</a><br>");
			out.println("<table>");
			out.println("<caption ><b><i>Company Registration...</i></b></caption>");
			out.println("<tr><td><b><i>Company ID :</i></b></td>");
			out.println("<td><input type=text name=cid placeholder='Company ID' size=30></td></tr>");
			
			out.println("<tr><td><b><i>Company Name :</i></b></td>");
			out.println("<td><input type=text name=comname placeholder='Company Name' size=30></td></tr>");
			
			out.println("<tr><td><b><i>Company Owner :</i></b></td>");
			out.println("<td><input type=text name=owner placeholder='Company Owner' size=30></td></tr>");
			
			out.println("<tr><td><b><i>Address :</i></b></td>");
			out.println("<td><textarea rows=3 cols=30 name=comadd></textarea></td></tr>");
			
			out.println("<tr><td><b><i>Country :</i></b></td>");
			out.println("<td><select name=ecountry id=ecountry></select></td></tr>");
			
			out.println("<tr><td><b><i>State :</i></b></td>");
			out.println("<td><select name=estate id=estate></select></td></tr>");
			
			out.println("<tr><td><b><i>City :</i></b></td>");
			out.println("<td><select name=ecity id=ecity></select></td></tr>");
			
			out.println("<tr><td><b><i>Contact Person :</i></b></td>");
			out.println("<td><select name=comcontact><option>Contact Person</option><option>Customer care</option><option>Owner</option><option>CEO</option><option>MD</option><option>Head</option><option>Manager</option><option>Worker</option></select></td></tr>");
			
			out.println("<tr><td><b><i>Email Id :</i></b></td>");
			out.println("<td><input type=email name=comemail placeholder='example@gmail.com' size=30></td></tr>");
			
			out.println("<tr><td><b><i>Mobile No :</i></b></td>");
			out.println("<td><input type=text name=commobile placeholder='Mobile No' size=30></td></tr>");
			
			out.println("<tr><td><b><i>Logo :</i></b></td>");
			out.println("<td><input type=file name=logo ></td></tr>");
			
			out.println("<tr><td><input type=submit></td>");
			out.println("<td><input type=reset ></td></tr>");
			
			out.println("</table></form>");
			out.println("</html>");	
			
		}
		catch(Exception e)
		{
			out.println(e);
			}
		
		
		
	}

}
