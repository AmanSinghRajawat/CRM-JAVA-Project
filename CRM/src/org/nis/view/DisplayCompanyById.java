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
import org.nis.model.Admin;

/**
 * Servlet implementation class DisplayCompanyById
 */
@WebServlet("/DisplayCompanyById")
public class DisplayCompanyById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCompanyById() {
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
				ResultSet rs=CompanyController.DisplayByCompanyId(request.getParameter("cid"));
				
				if(rs.next())
				{
				out.println("<script src=asset/jquery-2.2.1.min.js></script>");
				out.println("<script src=asset/state.js></script>");
				out.println("<html>");
				out.println("<form action=CompanyEditDelete method=post enctype='multipart/form-data>'");
				out.println("<a href=DiplayAllCompany>Display All Companyies.......</a><br>");
				out.println("<table width=80%><tr><td>");
				out.println("<table>");
				out.println("<caption><b><i>Company Registretion[Update]</i></b></caption>");
				
				out.println("<tr><td><b><i>Company Id :</i></b></td>");
				out.println("<td><input type=text name=cid placeholder='Company ID' size=30 value='"+rs.getString(1)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Company Name :</i></b></td>");
				out.println("<td><input type=text name=companyname placeholder='Company Name' value='"+rs.getString(2)+"'></td></tr>");

				out.println("<tr><td><b><i>Owner :</i></b></td>");
				out.println("<td><input type=text name=owner placeholder='Owner' size=30 value='"+rs.getString(3)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Address :</i></b></td>");
				out.println("<td><textarea row=3 cols=30 name=comadd>"+rs.getString(4)+"</textarea></td></tr>");
				
				out.println("<tr><td><b><i>Country :</i></b></td>");
				out.println("<td><select name=ecountry id=ecountry></select>&nbsp;&nbsp;<input type=text name=ecountry1 value="+rs.getString(5)+" readonly=true size=15></td></tr>");
				
				out.println("<tr><td><b><i>State :</i></b></td>");
				out.println("<td><select name=estate id=estate></select>&nbsp;&nbsp;<input type=text name=estate1 value='"+rs.getString(6)+"' readonly=true size=15></td></tr>");
				
				out.println("<tr><td><b><i>City :</i></b></td>");
				out.println("<td><select name=ecity id=ecity></select>&nbsp;&nbsp;<input type=text name=ecity1 value='"+rs.getString(7)+"' readonly=true size=15></td></tr>");
				
				out.println("<tr><td><b><i>Contact Person :</i></b></td>");
				out.println("<td><select name=comcontact><option>Contact Person</option><option>Customer care</option><option>Owner</option><option>CEO</option><option>MD</option><option>Head</option><option>Manager</option><option>Worker</option></select>&nbsp;&nbsp;<input type=text name=comcontact value="+rs.getString(8)+"></td></tr>");
				
				out.println("<tr><td><b><i>Email Id :</i></b></td>");
				out.println("<td><input type=email name=comemail placeholder='example@gmail.com' size=30 value='"+rs.getString(9)+"'></td></tr>");
				
				out.println("<tr><td><b><i>Mobile No :</i></b></td>");
				out.println("<td><input type=text name=commobile placeholder='Mobile No' size=30 value='"+rs.getString(10)+"'></td></tr>");
				
				out.println("<tr><td><input type=submit value=Edit name=btn></td>");
				out.println("<td><input type=submit value=Delete name=btn></td></tr>");
						out.println("</table></td>");
				

				out.println("<td valign=top><img src=CRM/WebContent/Images/company/="+rs.getString(11)+" width=230 height=230><br><br><input type=file name=logo>&nbsp;&nbsp;<input type=submit value='Edit Picture' name=btn></td></tr></table>");
				
				out.println("</form></html>");
				
				
				}
				else{out.println("Record Not Found..........");}
										
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			out.flush();
	}

}
