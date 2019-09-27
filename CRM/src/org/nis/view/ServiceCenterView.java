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
 * Servlet implementation class ServiceCenterView
 */
@WebServlet("/ServiceCenterView")
public class ServiceCenterView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceCenterView() {
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
			out.println("<form action=ServiceCenterSubmit>");
			out.println("<center><a href=DisplayAllServiceCenter>Display All Service Center...</a><br>");
			out.println("<table>");
			out.println("<caption ><b><i>Service Center Registration...</i></b></caption>");
			
			out.println("<tr><td><b><i>Company ID :</i></b></td>");
			out.println("<td><select name=cid id=cid ></select></td></tr>");
			
			out.println("<tr><td><b><i>Service Center ID :</i></b></td>");
			out.println("<td><input type=text name=scid placeholder='Service Center ID' size=30></td></tr>");
			
			out.println("<tr><td><b><i>Service Center Name :</i></b></td>");
			out.println("<td><input type=text name=scname placeholder='Serice Center Name' size=30></td></tr>");
			
			out.println("<tr><td><b><i>Service Center Owner :</i></b></td>");
			out.println("<td><input type=text name=scowner placeholder='Owner Name' size=30></td></tr>");

			out.println("<tr><td><b><i>Country :</i></b></td>");
			out.println("<td><select name=ecountry id=ecountry></select></td></tr>");
			
			out.println("<tr><td><b><i>State :</i></b></td>");
			out.println("<td><select name=estate id=estate></select></td></tr>");
			

			out.println("<tr><td><b><i>City :</i></b></td>");
			out.println("<td><select name=ecity id=ecity></select></td></tr>");
			

			out.println("<tr><td><b><i>Service Center Address :</i></b></td>");
			out.println("<td><textarea row=3 cols=30 name=scadd></textarea></td></tr>");
			
			
			out.println("<tr><td><b><i>Email ID :</i></b></td>");
			out.println("<td><input type=email name=scemail placeholder='example@gmail.com' size=30></td></tr>");
			
			out.println("<tr><td><b><i>Mobile No :</i></b></td>");
			out.println("<td><input type=text name=scmobile placeholder='Mobile No' size=30></td></tr>");
			
			out.println("<tr><td><input type=submit></td>");
			out.println("<td><input type=reset ></td></tr>");
			
			out.println("</table></center></form>");
			out.println("</html>");
			
			
		}
		catch(Exception e)
		{
			out.println(e);
			
		}
		
		
		
		
	}

}
