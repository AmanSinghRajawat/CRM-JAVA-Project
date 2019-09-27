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
 * Servlet implementation class EngineersSubmit
 */
@WebServlet("/EngineersSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

public class EngineersSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EngineersSubmit() {
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
				Engineers E=new Engineers();
				
				E.setServicecenterid(request.getParameter("scid"));
				E.setEngineerid(request.getParameter("eid"));
				E.setEngineername(request.getParameter("efn")+" "+request.getParameter("eln"));
				E.setDob(request.getParameter("dob"));
				E.setGender(request.getParameter("eg"));
				E.setAddress(request.getParameter("eadd"));
				E.setCountry(request.getParameter("ecountry"));
				E.setState(request.getParameter("estate"));
				E.setCity(request.getParameter("ecity"));
				E.setEmailid(request.getParameter("em"));
				E.setPassword(request.getParameter("pwd"));
				E.setMobileno(request.getParameter("emobile"));
				
				
		//file Upload
				Part part=request.getPart("eph");
				String path="C:/Users/Aman/workspace/CRM/WebContent/Images/engineers";
				FileUpload F=new FileUpload(part,path);
				E.setPhotograph(F.filename);
				boolean st=EngineersController.addNewEngineersRecord(E);
				if(st)
				{
					  out.println("<font color=green><b>Record Submitted<br><a href=EngineersView>Add More Engineers</a></b></font>");
				}
				else
				{
					out.println("<font color=red><b>Fail to Submit Record<br><a href=EngineersView>Add More Engineers</a></b></font>");
				}
				
				
			}
			catch(Exception  e)
			{
				System.out.println("Enginners Submit :"+e);
			}
	
	
	}

}
