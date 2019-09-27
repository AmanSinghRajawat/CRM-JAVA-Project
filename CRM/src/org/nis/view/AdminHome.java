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
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHome() {
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

		///// Session Managment
		HttpSession ses=request.getSession();
		
		try{
			String ltime=ses.getValue("SLTIME").toString();
			Admin A=(Admin)(ses.getValue("SADMIN"));
			
			String nav="<i>Admin:"+A.getAdminname()+"["+A.getAdminid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ltime+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=AdminLogout>Logout</a></i><br><hr>";
			out.println(nav);
		}
		catch(Exception e)
		{
			response.sendRedirect("AdminLogin");
		}
		
		/////////////////
		 
		out.println("<html width=100%>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td valign=top>");
		out.println("<a href=EmployeesView target=mw>Employee Register</a><br>");
		out.println("<a href=DisplayAllEmployee target=mw>Update Employee</a><br>");
		out.println("<a href=CompanyView target=mw>Company Register</a><br>");
		out.println("<a href=DisplayAllCompany target=mw>Update Companies</a><br>");
		out.println("<a href=ServiceCenterView target=mw>Service Center Register</a><br>");
		out.println("<a href=DisplayAllServiceCenter target=mw>Update Service Centers</a><br>");
		out.println("<a href=EngineersView target=mw>Engineers Register</a><br>");
		out.println("<a href=DisplayAllEngineers target=mw>Update Engineers</a><br>");
		out.println("</td>");
		out.println("<td>");
		out.println("<iframe width=600 height=700 frameborder=0 name=mw></iframe>");
		
		
		
		
		
		
	}

}
