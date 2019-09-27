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
 * Servlet implementation class EngineersView
 */
@WebServlet("/EngineersView")
public class EngineersView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EngineersView() {
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
				
		
		
		out.println("<script src=asset/jquery-2.2.1.min.js></script>");
		out.println("<script src=asset/country.js></script>");
		
		out.println("<html>");
		out.println("<form action=EngineersSubmit method=post enctype='multipart/form-data'>");
		out.println("<a href=DisplayAllEngineers>Display All Engineers</a><br>");
		out.println("<table >");
		
		out.println("<tr><td><b><i>Company ID :</i></b></td>");
		out.println("<td><select name=cid id=cid></select></td></tr>");
		
		out.println("<tr><td><b><i>Service Center ID :</i></b></td>");
		out.println("<td><select name=scid id=scid></select></td></tr>");
		
		out.println("<tr><td><b><i>Enginner ID :</i></b></td>");
		out.println("<td><input type=text name=eid placeholder='Engineer ID' size=30></td></tr>");
		
		out.println("<tr><td><b><i>Engineer Name :</i></b></td>");
		out.println("<td><input type=text name=efn placeholder='First Name' size=30>&nbsp;&nbsp;<input type=text name=eln placeholder='Last Name' size=30></td></tr>");
		
		out.println("<tr><td><b><i>Engineer DOB :</i></b></td>");
		out.println("<td><input type=date name=dob size=30></td></tr>");
		
		out.println("<tr><td><b><i>Engineer Gender :</i></b></td>");
		out.println("<td><input type=radio name=eg value=Male>Male&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=radio name=eg value=Female>Female</td></tr>");
		
		out.println("<tr><td><b><i>Engineer Address :</i></b></td>");
		out.println("<td><textarea row=3 cols=30 name=eadd></textarea></td></tr>");
		
		out.println("<tr><td><b><i>Country :</i></b></td>");
		out.println("<td><select name=ecountry id=ecountry></select></td></tr>");
		
		out.println("<tr><td><b><i>State</i></b></td>");
		out.println("<td><select name=estate id=estate></select></td></tr>");
		
		out.println("<tr><td><b><i>City :</i></b></td>");
		out.println("<td><select name=ecity id=ecity></select></td></tr>");
		
		out.println("<tr><td><b><i>Mobile No :</i></b></td>");
		out.println("<td><input type=text name=emobile placeholder='Mobile No' size=30></td></tr>");
		
		out.println("<tr><td><b><i>Email ID :</i></b></td>");
		out.println("<td><input type=email name=em placeholder='example@gmail.com' size=30></td></tr>");
		
		out.println("<tr><td><b><i>Password :</i></b></td>");
		out.println("<td><input type=password name=pwd placeholder='Password ' size=30></td></tr>");
		
		out.println("<tr><td><b><i>Confirm Password :</i></b></td>");
		out.println("<td><input type=password name=cpwd placeholder='Confirm password' size=30></td></tr>");
		
		
		out.println("<tr><td><b><i>Profile Picture :</i></b></td>");
		out.println("<td><input type=file name=eph value='Profile Picture'></td></tr>");
		
		out.println("<tr><td><input type=submit></td>");
		out.println("<td><input type=reset ></td></tr>");
		
		out.println("</table></form>");
		out.println("</html>");
		out.flush();
			
		
	}
		
		
	}


