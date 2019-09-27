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

import org.nis.controller.EmployeesController;
import org.nis.model.Admin;

/**
 * Servlet implementation class DisplayAllEmployee
 */
@WebServlet("/DisplayAllEmployee")
public class DisplayAllEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayAllEmployee() {
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
			ResultSet rs=EmployeesController.DisplayAll();
			if(rs.next())
			{
				out.println("<html><a href=EmployeesView>Add New Employee</a><br><center><table border=1>");
				out.println("<caption><b><i>List of Employees</i></b></caption>");
				out.println("<tr><th>Name</th><th>Gender<br>/DOB</th><th>Address</th><th>Contact<br>Details</th><th>Photograph</th><th>Update</th></tr>");		
			    do
			    {
			    	out.println("<tr><td><i>"+rs.getString(1)+"<br>"+rs.getString(2)+"<br>F'Name:"+rs.getString(3)+"</i></td><td><i>"+rs.getString(4)+"<br>"+rs.getString(5)+"</i></td><td><i>"+rs.getString(6)+"<br>"+rs.getString(9)+"<br>"+rs.getString(8)+"<br>"+rs.getString(7)+"</i></td><td><i>"+rs.getString(10)+"<br>"+rs.getString(11)+"</i></td><td><i><img src=Images/employee/"+rs.getString(14)+" width=50 height=50><br>"+rs.getString(12)+"</i></td><td><a href=DisplayEmployeeById?eid="+rs.getString(1)+">[Edit/Delete]</a></td></tr>");
			    }while(rs.next());
				
			    out.println("</table></center></html>");
			}
			
		else
		{
			out.println("Record Not Found");		
			}
			
		
	}
		catch(Exception e)
		{

			out.println("Display All Employee :"+e);}
	}

}
