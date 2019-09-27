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

import org.nis.controller.EmployeesController;
import org.nis.model.Admin;
import org.nis.model.Employees;
import org.softech.FileUpload;

/**
 * Servlet implementation class EmployeeSubmit
 */
@WebServlet("/EmployeeSubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

public class EmployeeSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSubmit() {
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
   Employees E=new Employees();
   E.setEmployeeid(request.getParameter("eid"));
   E.setEmployeename(request.getParameter("efn")+" "+request.getParameter("eln"));
   E.setFathername(request.getParameter("effn")+" "+request.getParameter("efln"));
   E.setDob(request.getParameter("ebd"));
   E.setGender(request.getParameter("eg"));
   E.setAddress(request.getParameter("eadd"));
   E.setCountry(request.getParameter("ecountry"));
E.setState(request.getParameter("estate"));
E.setCity(request.getParameter("ecity"));
E.setEmailid(request.getParameter("em"));
E.setMobileno(request.getParameter("emobile"));
E.setDesignation(request.getParameter("edes"));
E.setPassword(request.getParameter("epwd"));

//fileupload
Part part=request.getPart("eph");
String path="C:/Users/Aman/workspace/CRM/WebContent/Images/employee";
FileUpload F=new FileUpload(part,path);
E.setPhotograph(F.filename);
boolean st=EmployeesController.addNewRecord(E);
   if(st)
   {
	   
	   out.println("<font color=green><b>Record Submitted<br><a href=EmployeesView>Add More Employees</a></b></font>");
	   
   }
   else
   {
	   out.println("<font color=red><b>Fail to Submit Record<br><a href=EmployeesView>Add More Employees</a></b></font>");	   
   }
      
    	
    	
    	
    	
    }catch(Exception e)
    {System.out.println(e);
    	
    }
    }
	
	
	}


