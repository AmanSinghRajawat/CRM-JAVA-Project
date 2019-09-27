package org.nis.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.nis.controller.CompanyController;
import org.nis.controller.EmployeesController;
import org.nis.model.Admin;
import org.nis.model.Company;
import org.softech.FileUpload;

/**
 * Servlet implementation class CompanyEditDelete
 */
@WebServlet("/CompanyEditDelete")
public class CompanyEditDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyEditDelete() {
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
			  Company C=new Company();
			  C.setCompanyid(request.getParameter("cid"));
			  C.setCompanyname(request.getParameter("companyname"));
			  C.setOwner(request.getParameter("owner"));
			  C.setAddress(request.getParameter("comadd"));
			
			  
			  if(request.getParameter("ecountry").equals("country"))
			  {
				  C.setCountry(request.getParameter("ecountry1"));
			  }
			  else
			  {
				  C.setCountry(request.getParameter("ecountry"));
			  }
			  
			  if(request.getParameter("estate").equals("state"))
				{
				C.setState(request.getParameter("estate1"));
				}
				else
				{
					C.setState(request.getParameter("estate"));
				}
				if(request.getParameter("ecity").equals("city"))
				{
					C.setCity(request.getParameter("ecity1"));
				}
				else
				{
					C.setCity(request.getParameter("ecity"));
				}
				
			  
			  
			  C.setEmailid(request.getParameter("comemail"));
			  C.setMobileno(request.getParameter("commobile"));
			  C.setLogo(request.getParameter("logo"));
				
				
				boolean st=CompanyController.EditRecord(C);
				response.sendRedirect("DisplayAllCompany");				
			}
			
			else if(btn.equals("EditPicture"))
			{
				
				//file Upload
				Part part=request.getPart("logo");
				String path="C:/Users/Aman/workspace/CRM/WebContent/Images/company";
				FileUpload F=new FileUpload(part,path);
				boolean st=EmployeesController.EditPicture(F.filename,request.getParameter("cid"));
				response.sendRedirect("DisplayAllCompany");				
			}
			
			else if(btn.equals("Delete"))
			{
				boolean st=CompanyController.DeleteRecord(request.getParameter("cid"));
				response.sendRedirect("DisplayAllCompany");
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			}
	}

}
