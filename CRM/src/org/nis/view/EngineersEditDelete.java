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
import javax.servlet.http.Part;

import org.nis.controller.EngineersController;
import org.nis.model.Admin;
import org.nis.model.Engineers;
import org.softech.FileUpload;

/**
 * Servlet implementation class EngineersEditDelete
 */
@WebServlet("/EngineersEditDelete")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)




public class EngineersEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EngineersEditDelete() {
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
	    	
	    	Engineers E=new Engineers();
	   E.setServicecenterid(request.getParameter("scid")); 	
	   E.setEngineerid(request.getParameter("eid"));
	   E.setEngineername(request.getParameter("efn")+" "+request.getParameter("eln"));
	   E.setDob(request.getParameter("dob"));
	   E.setGender(request.getParameter("eg"));
	   E.setAddress(request.getParameter("eadd"));
	   

	   if(request.getParameter("ecountry").equals("Country"))
	   E.setState(request.getParameter("ecountry1"));
	   else
	   E.setState(request.getParameter("ecountry"));
	  
	   
	   if(request.getParameter("estate").equals("State"))
	   E.setState(request.getParameter("estate1"));
	   else
	   E.setState(request.getParameter("estate"));
	  
	   if(request.getParameter("ecity").equals("City"))  
	   E.setCity(request.getParameter("ecity1"));
	   else 
		 E.setCity(request.getParameter("ecity"));
	
	E.setMobileno(request.getParameter("emobile"));
	E.setEmailid(request.getParameter("em"));
	 boolean st=EngineersController.EditRecord(E);
	 response.sendRedirect("DisplayAllEngineers");
	    
	    
	    }
	    else if(btn.equals("Edit Picture"))
	    {
	    
	//fileupload
	Part part=request.getPart("eph");
	String path="C:/Users/Aman/workspace/CRM/WebContent/Images/engineers";
	FileUpload F=new FileUpload(part,path);
	 	boolean st=EngineersController.EditPicture(F.filename, request.getParameter("eid"));
	 	response.sendRedirect("DisplayAllEngineers");
	    }	
	    else if(btn.equals("Delete"))
	    {
	    boolean st=EngineersController.DeleteRecord(request.getParameter("eid")); 	
	    response.sendRedirect("DisplayAllEngineers");
	    }
	    	
	    	
	    }catch(Exception e)
	    {System.out.println(e);
	    	
	    }

	
		
		
		
	}

}
