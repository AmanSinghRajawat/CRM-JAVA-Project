package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nis.controller.ServiceCenterController;
import org.nis.model.Admin;
import org.nis.model.ServiceCenter;

/**
 * Servlet implementation class ServiceCenterSubmit
 */
@WebServlet("/ServiceCenterSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)



public class ServiceCenterSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceCenterSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
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

		PrintWriter out=response.getWriter();
		ServiceCenter SC=new ServiceCenter();
		
		SC.setCompanyid(request.getParameter("cid"));
		SC.setServicecenterid(request.getParameter("scid"));
		SC.setServicecentername(request.getParameter("scname"));
		SC.setOwner(request.getParameter("scowner"));
		SC.setCountry(request.getParameter("ecountry"));
		SC.setState(request.getParameter("estate"));
		SC.setCity(request.getParameter("ecity"));
		SC.setAddress(request.getParameter("scadd"));
		SC.setEmail(request.getParameter("scemail"));
		SC.setMobileno(request.getParameter("scmobile"));
		
		boolean st=ServiceCenterController.addNewServiceCenter(SC);
		if(st)
		{
			out.println("<font color=green><b>Record Submitted<br><a href=ServiceCenterView>Add More Service Centers....</a></b></font>");
		}
		else
		{
			out.println("<font color=red><b>Fail to Submit Record<br><a href=ServiceCenterView>Add More Service Centers...</a></b></font>");
		}
		
		}
		catch(Exception e)
		{
			System.out.println("Service Center Submit:"+e);
		}
		
	}

}
