package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nis.controller.EngineersController;
import org.nis.model.Admin;

/**
 * Servlet implementation class DisplayEngineersById
 */
@WebServlet("/DisplayEngineersById")
public class DisplayEngineersById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayEngineersById() {
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
			ResultSet rs=EngineersController.DisplayEngineersById(request.getParameter("eid"));	
				
			if(rs.next())
			{
				out.println("<script src=asset/jquery-2.2.1.min.js></script>");
				out.println("<script src=asset/country.js></script>");
				
				
				out.println("<html>");
				out.println("<form action=EngineersEditDelete method=post enctype='multipart/form-data'>");
			
				
				out.println("<a href=DisplayAllEngineers>Display All Engineers</a><br>");
				out.println("<table><tr><td>");
				out.print("<table>");
				out.println("<caption><b><i>Engineer Register[Update]</i></b></caption>");
				
				out.println("<tr><td><b><i>Service center Id:</i></b></td>");
				out.println("<td><input type=text name=scid size=30 value='"+rs.getString(1)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Engineer Id:</i></b></td>");
				out.println("<td><input type=text name=eid size=30 value='"+rs.getString(2)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Name:</i></b></td>");
				String n=rs.getString(3);
				String en[]=n.split(" ");
				out.println("<td><input type=text name=efn placeholder='First Name' size=30 value='"+en[0]+"'><br><input type=text name=eln placeholder='Last Name' size=30 value='"+en[1]+"'><br><br></td></tr>");
				
				out.println("<tr><td><b><i>Date of Birth :</i></b></td>");
				out.println("<td><input type=date name=dob size=30 value='"+rs.getString(4)+"'></td></tr>");
				if(rs.getString(5).equals("Male"))
				{
				out.println("<tr><td><b><i>Gender:</i></b></td>");
				out.println("<td><input type=radio name=eg value=Male checked>Male<input type=radio name=eg value=Female>Female</td></tr>");
				}
				else
				{
					out.println("<tr><td><b><i>Gender :</i></b></td>");
					out.println("<td><input type=radio name=eg value=Male>Male<input type=radio name=eg value=Female checked>Female</td></tr>");	
				}
				out.println("<tr><td><b><i>Address:</i></b></td>");
				out.println("<td><textarea row=3 cols=30 name=eadd >"+rs.getString(6)+"</textarea></td></tr>");
				
				out.println("<tr><td><b><i>Country :</i></b></td>");
				out.println("<td><select name=ecountry id=ecountry></select>&nbsp;&nbsp;<input type=text name=estate1 value='"+rs.getString(7)+"' readonly=true size=15></td></tr>");
				
				out.println("<tr><td><b><i>State:</i></b></td>");
				out.println("<td><select name=estate id=estate></select>&nbsp;&nbsp;<input type=text name=estate1 value='"+rs.getString(8)+"' readonly=true size=15></td></tr>");
				
				out.println("<tr><td><b><i>City:</i></b></td>");
				out.println("<td><select name=ecity id=ecity></select>&nbsp;&nbsp;<input type=text name=ecity1 value='"+rs.getString(9)+"' readonly=true size=15></td></tr>");
				
				
				
				out.println("<tr><td><b><i>Mobile:</i></b></td>");
				out.println("<td><input type=text name=emobile size=30 value='"+rs.getString(10)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Email Id:</i></b></td>");
				out.println("<td><input type=email name=em size=30 value='"+rs.getString(11)+"'></td></tr>");
				
				
				
				out.println("<tr><td><input type=submit value=Edit name=btn></td>");
				out.println("<td><input type=submit value=Delete name=btn></td></tr>");
						out.println("</table></td>");
						
			   out.println("<th valign=top><img src=Images/engineers/"+rs.getString(13)+" width=225 height=250><br><br><input type=file name=eph>&nbsp;&nbsp;<input type=submit value='Edit Picture' name=btn></th></tr></table>");
			   out.println("</form></html>");
				 
			}
			else
			{
			out.println("Record Not Found....");	
			}
				
			}
			
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		
		
	}

}
