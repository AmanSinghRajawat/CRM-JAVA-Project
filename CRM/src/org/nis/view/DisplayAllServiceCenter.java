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

import org.nis.controller.ServiceCenterController;
import org.nis.model.Admin;

/**
 * Servlet implementation class DisplayAllServiceCenter
 */
@WebServlet("/DisplayAllServiceCenter")
public class DisplayAllServiceCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllServiceCenter() {
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
				
				ResultSet rs=ServiceCenterController.DisplayAll();
				if(rs.next())
				{
					out.println("<html>");
					out.println("<a href=ServiceCenterView>Add New Service Center</a><br><center><table border=1 width=80%>");
					out.println("<caption><b><i>List Of Service Center's......</i></b></caption>");
					out.println("<tr><th>Name</th><th>Address</th><th>Contact<br>Details</th><th>[UPDATE]</th></tr>");
				do
				{
					out.println("<tr><td><i>C.ID &nbsp;:&nbsp;&nbsp;&nbsp;"+rs.getString(1)+"&nbsp;&nbsp;&nbsp;&nbsp;SC.ID&nbsp; :&nbsp;&nbsp;&nbsp;"+rs.getString(2)+"<br>NAME&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;"+rs.getString(3)+"<br>OWNER &nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;"+rs.getString(4)+"</i></td><td><i>"+rs.getString(8)+"<br>"+rs.getString(7)+"<br>"+rs.getString(6)+"<br>"+rs.getString(5)+"</i></td><td><i>"+rs.getString(10)+"<br>"+rs.getString(9)+"</i></td><td align=center><a href=DisplayServiceCenterById?scid="+rs.getString(2)+">[Edit/Delete]</a></td></tr>");
					
				}while(rs.next());
					
				out.println("</table></center></html>");
				}
				
				
				
			}
			
			catch(Exception e)
			{
				System.out.println("Display All Service Centers :"+e);
				
			}
			
		
	}

}
