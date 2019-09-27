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
 * Servlet implementation class DisplayAllCompany
 */
@WebServlet("/DisplayAllCompany")
public class DisplayAllCompany extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllCompany() {
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
			ResultSet rs=CompanyController.DisplayAll();
			if(rs.next())
			{
				out.println("<html><a href=CompanyView>Add New Company Profile</a><br><center><table border=1 width=80%>");
				out.println("<caption><b><i>List Of Companies......</i></b></caption>");
				out.println("<tr><th>Name</th><th>Address</th><th>Contact Person</th><th>Contact<br>Details</th><th>Logo</th><th>Update</th></tr>");
				do
				{
					out.println("<tr align=center><td><i>"+rs.getString(1)+"<br>"+rs.getString(2)+"<br>"+rs.getString(3)+"</i></td><td><i>"+rs.getString(4)+"<br>"+rs.getString(7)+"<br>"+rs.getString(6)+"<br>"+rs.getString(5)+"</i></td><td><i>"+rs.getString(8)+"</i></td><td><i>"+rs.getString(9)+"<br>"+rs.getString(10)+"</i></td><td><img src=CRM/WebContent/Images/company/"+rs.getString(11)+" width=50 height=50><td><a href=DisplayCompanyById?cid="+rs.getString(1)+">[Edit/Delete]</a></td></tr>");
				}while(rs.next());
				
				out.println("</table></center></html>");
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println("Display All Company :"+e);
			}
	}

}
