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
 * Servlet implementation class ServiceCenterEditDelete
 */
@WebServlet("/ServiceCenterEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)


public class ServiceCenterEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceCenterEditDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			String btn=request.getParameter("btn");
			
			if(btn.equals("Edit"))
			{
				
				ServiceCenter SC=new ServiceCenter();
				
				SC.setCompanyid(request.getParameter("cid"));
				SC.setServicecenterid(request.getParameter("scid"));
				SC.setServicecentername(request.getParameter("scname"));
				SC.setOwner(request.getParameter("scowner"));
			
				   if(request.getParameter("ecountry").equals("Country"))
				   SC.setState(request.getParameter("ecountry1"));
				   else
				   SC.setState(request.getParameter("ecountry"));
				  
				   
				   if(request.getParameter("estate").equals("State"))
				   SC.setState(request.getParameter("estate1"));
				   else
				   SC.setState(request.getParameter("estate"));
				  
				   if(request.getParameter("ecity").equals("City"))  
				   SC.setCity(request.getParameter("ecity1"));
				   else 
					 SC.setCity(request.getParameter("ecity"));
				
					
				
				
				SC.setAddress(request.getParameter("scadd"));
				SC.setEmail(request.getParameter("scemail"));
				SC.setMobileno(request.getParameter("scmobile"));
				
			}
			else if(btn.equals("Delete"))
			{

				boolean st=ServiceCenterController.DeleteRecord(request.getParameter("scid"));
				response.sendRedirect("DisplayAllServiceCenter");
			
			}
		
			
			
		}
		catch(Exception e)
		{
			System.out.println("Service Center Edit & Delete :"+e);
		}
		
	}

}
