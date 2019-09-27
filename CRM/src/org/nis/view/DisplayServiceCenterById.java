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

import org.nis.controller.CompanyController;
import org.nis.controller.ServiceCenterController;
import org.nis.model.Admin;

/**
 * Servlet implementation class DisplayServiceCenterById
 */
@WebServlet("/DisplayServiceCenterById")
public class DisplayServiceCenterById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServiceCenterById() {
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
				ResultSet rs=ServiceCenterController.DisplayServiceCenterById(request.getParameter("scid"));
				
				if(rs.next())
				{
				out.println("<script src=asset/jquery-2.2.1.min.js></script>");
				out.println("<script src=asset/country.js></script>");
				out.println("<html>");
				out.println("<form action=ServiceCenterEditDelete method=post enctype='multipart/form-data'>'");
				out.println("<a href=DisplayAllServiceCenter>Display All Service Center's.......</a><br>");
				out.println("<table><tr><td>");
				out.println("<caption><b><i>Service Center Registration[Update]</i></b></caption>");
				
				out.println("<tr><td><b><i>Company Id :</i></b></td>");
				out.println("<td><input type=text name=cid placeholder='Company ID' size=30 value='"+rs.getString(1)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Service Center ID :</i></b></td>");
				out.println("<td><input type=text name=scname placeholder='Service Center ID' size=30 value='"+rs.getString(2)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Service Center Name :</i></b></td>");
				out.println("<td><input type=text name=scname placeholder='Service Center Name' value='"+rs.getString(3)+"'></td></tr>");

				out.println("<tr><td><b><i>Owner :</i></b></td>");
				out.println("<td><input type=text name=scowner placeholder='Owner' size=30 value='"+rs.getString(4)+"'></td></tr>");
				
				
				out.println("<tr><td><b><i>Country :</i></b></td>");
				out.println("<td><select name=ecountry id=ecountry></select>&nbsp;&nbsp;<input type=text name=ecountry1 value="+rs.getString(5)+" readonly=true></td></tr>");
				
				out.println("<tr><td><b><i>State :</i></b></td>");
				out.println("<td><select name=estate id=estate></select>&nbsp;&nbsp;<input type=text name=estate1 value='"+rs.getString(6)+"' readonly=true size=15></td></tr>");
				
				out.println("<tr><td><b><i>City :</i></b></td>");
				out.println("<td><select name=ecity id=ecity></select>&nbsp;&nbsp;<input type=text name=ecity1 value='"+rs.getString(7)+"' readonly=true size=15></td></tr>");
				
				out.println("<tr><td><b><i>Address :</i></b></td>");
				out.println("<td><textarea row=3 cols=30 name=scadd>"+rs.getString(8)+"</textarea></td></tr>");
				
				out.println("<tr><td><b><i>Email ID :</i></b></td>");
				out.println("<td><input type=email name=scemail placeholder='example@gmail.com' size=30 value='"+rs.getString(9)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Mobile No :</i></b></td>");
				out.println("<td><input type=text name=scmobile placeholder='Mobile No' size=30 value='"+rs.getString(10)+"'></td></tr>");
				
				out.println("<tr><td><input type=submit value=Edit name=btn></td>");
				out.println("<td><input type=submit value=Delete name=btn></td></tr>");
				
				
				out.println("</table>");
				out.println("</form></html>");
				
				
				}
				else{out.println("Record Not Found..........");}
									
				
			}
			catch(Exception e)
			{
				System.out.println("Display Service Center By ID :"+e);
			}
		
	}

}
