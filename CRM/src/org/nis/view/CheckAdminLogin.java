package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nis.controller.AdminController;
import org.nis.model.Admin;

/**
 * Servlet implementation class CheckAdminLogin
 */
@WebServlet("/CheckAdminLogin")
public class CheckAdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		try{
			PrintWriter out=response.getWriter();
		Admin A=AdminController.checkPassword(request.getParameter("aid"),request.getParameter("pwd"));	
		out.println("<html>");	
		if(A==null)
			{out.println("<font color=red>Invalid Userid/Password</font>");
			 	
			}
		else
		{
			HttpSession ses=request.getSession();
			   ses.putValue("SADMIN", A);
			   ses.putValue("SLTIME", new java.util.Date());
				response.sendRedirect("AdminHome");
		}
		}
		catch(Exception e)
		{System.out.println(e);
			
		}
		
		
		
	}

}
