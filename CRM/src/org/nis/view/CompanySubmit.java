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

import org.nis.controller.CompanyController;
import org.nis.model.Admin;
import org.nis.model.Company;
import org.softech.FileUpload;

/**
 * Servlet implementation class CompanySubmit
 */
@WebServlet("/CompanySubmit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

public class CompanySubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanySubmit() {
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
			Company C=new Company();
				
				C.setCompanyid(request.getParameter("cid"));
				C.setCompanyname(request.getParameter("comname"));
				C.setOwner(request.getParameter("owner"));
				C.setAddress(request.getParameter("comadd"));
				C.setCountry(request.getParameter("ecountry"));
				C.setState(request.getParameter("estate"));
				C.setCity(request.getParameter("ecity"));
				C.setContactperson(request.getParameter("comcontact"));
				C.setEmailid(request.getParameter("comemail"));
				C.setMobileno(request.getParameter("commobile"));
				
				
				//file-upload
				Part part=request.getPart("logo");
				String path="C:/Users/Aman/workspace/CRM/WebContent/Images/company";
				FileUpload F=new FileUpload(part,path);
				C.setLogo(F.filename);
			
				boolean st=CompanyController.addNewCompanyRecord(C);
				if(st)
				{
					out.println("<font color=green><b>Record Submitted<br><a href=CompanyView>Add More Companies Profile....</a></b></font>");
				}
				else
				{
					out.println("<font color=red><b>Fail to Submit Record<br><a href=CompanyView>Add More Companies Profile...</a></b></font>");
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
			}
	}

}
