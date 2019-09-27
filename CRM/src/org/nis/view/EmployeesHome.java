package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nis.model.Employees;

/**
 * Servlet implementation class EmployeesHome
 */
@WebServlet("/EmployeesHome")
public class EmployeesHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		PrintWriter out=response.getWriter();
		  out.println("<html>");
		 //session management
		 HttpSession ses=request.getSession();
		 try{
			
		 String ltime=ses.getValue("SLTIME").toString();	
		Employees E=(Employees)(ses.getValue("SEMPLOYEES"));	
		
		 
     String nav="<i>"+E.getDesignation()+":"+E.getEmployeename()+"["+E.getEmployeeid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ltime+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=EmployeesLogout>Logout</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=images/employee/"+E.getPhotograph()+" width=30 height=30></i><br><hr>";		 
		 out.println(nav);
		}catch(Exception e){
			response.sendRedirect("EmployeesLogin");
			
		}
		/////////////////
		
		out.println("<html width=100%>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td valign=top>");
		out.println("<a href=ComplaintRegister target=mw>Complaint Register</a><br>");
		out.println("<a href=EmployeeChangePassword target=mw>Change Password</a><br>");
	
		
		
		
		/*out.println("<a href=CompaniesView target=mw>Companies Register</a><br>");
		out.println("<a href=DisplayAllCompanies target=mw>Update Companies</a><br>");
		out.println("<a href=ServiceCenterView target=mw>Service Register</a><br>");
		out.println("<a href=DisplayAllServiceCenter target=mw>Update Centers</a><br>");
		out.println("<a href=EngineersView target=mw>Engineers Register</a><br>");
		out.println("<a href=DisplayAllEngineers target=mw>Update Engineers</a><br>");*/
		out.println("</td>");
		out.println("<td>");
		out.println("<iframe width=600 height=700 frameborder=0 name=mw></iframe>");
	
		
		
	}

}
