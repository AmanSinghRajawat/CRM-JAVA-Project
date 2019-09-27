package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeesLogin
 */
@WebServlet("/EmployeesLogin")
public class EmployeesLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesLogin() {
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
		out.println("<form action=CheckEmployeesLogin method=post>");
		 
		out.print("<table>");
		out.println("<caption><b><i>Employees Login</i></b></caption>");
		
		
		
		out.println("<tr><td><b><i>Employee Id:</i></b></td>");
		out.println("<td><input type=text name=eid size=30></td></tr>");
		
		out.println("<tr><td><b><i>Password:</i></b></td>");
		out.println("<td><input type=password name=epwd size=30></td></tr>");

		out.println("<tr><td><input type=submit value='Login'></td>");
		out.println("<td>&nbsp;</td></tr>");
		
		
		
		
	}

}
