package org.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.nis.model.Employees;

public class EmployeesController {

	private static String provider="jdbc:mysql://localhost:3306/CRM";
	private static String userid="root";
	private static String password="2811";
	
	
	public static boolean addNewRecord(Employees E)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="insert into employees values('"+E.getEmployeeid()+"','"+E.getEmployeename()+"','"+E.getFathername()+"','"+E.getDob()+"','"+E.getGender()+"','"+E.getAddress()+"','"+E.getCountry()+"','"+E.getState()+"','"+E.getCity()+"','"+E.getEmailid()+"','"+E.getMobileno()+"','"+E.getDesignation()+"','"+E.getPassword()+"','"+E.getPhotograph()+"')";
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
		}catch(Exception e)
		{
			System.out.println("addNewRecord"+e);
			return(false);
			}
	     }


public static ResultSet DisplayAll()
{
	try{
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	Connection cn=DriverManager.getConnection(provider,userid,password);
	String query="select E.employeeid,E.employeename,E.fathername,E.dob,E.gender,E.address,(select C.countryname from country C where C.countryid=E.country),(select S.statename from states S where S.stateid=E.state),(select C.cityname from city C where C.cityid=E.city),E.emailid,E.mobileno,E.designation,E.password,E.photograph   from employees E";
	System.out.println(query);
	ResultSet rs=DBHelper.executeQuery(cn, query);
	return(rs);
		
	}
	catch(Exception e)
	{
		
		System.out.println("addNewRecord"+e);
		return(null);
		}
}

public static ResultSet DisplayById(String eid)
{
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,userid,password);
		String query="select E.employeeid,E.employeename,E.fathername,E.dob,E.gender,E.address,(select C.countryname from country C where C.countryid=E.country),(select S.statename from states S where S.stateid=E.state),(select C.cityname from city C where C.cityid=E.city),E.emailid,E.mobileno,E.designation,E.password,E.photograph   from employees E";
		System.out.println(query);
		ResultSet rs=DBHelper.executeQuery(cn,query);
		return(rs);
		
	}
	catch(Exception e)
	{
		System.out.println("addNewRecord"+e);
		return(null);
		}
}

public static boolean EditRecord(Employees E)
{
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,userid,password);
		String query="update employees set employeename='"+E.getEmployeename()+"',fathername='"+E.getFathername()+"', dob='"+E.getDob()+"',gender='"+E.getGender()+"',address='"+E.getAddress()+"',country='"+E.getCountry()+"',state='"+E.getState()+"',city='"+E.getCity()+"',emailid='"+E.getEmailid()+"',mobileno='"+E.getMobileno()+"',designation='"+E.getDesignation()+"' where employeeid='"+E.getEmployeeid()+"'";
		System.out.println(query);
		boolean st=DBHelper.executeUpdate(cn, query);
		return(st);
		
	}
	catch(Exception e)
	{
		System.out.println("EditRecord"+e);
		return(false);
	}
}

public static boolean DeleteRecord(String eid)
{
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn =DriverManager.getConnection(provider,userid,password);
		String query="delete from employees where employeeid='"+eid+"'";
		System.out.println(query);
		boolean st=DBHelper.executeUpdate(cn, query);
		return(st);
	}
	catch(Exception e)
	{
		System.out.println("DeleteRecord"+e);
		return(false);
	}
}


public static boolean EditPicture(String filename,String eid)
{
	try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,userid,password);
		String  query="update employees set photograph='"+filename+"'where employeeid='"+eid+"'";
		System.out.println(query);
		boolean st=DBHelper.executeUpdate(cn, query);
		return(st);
	}
	catch(Exception e)
	{
		System.out.println("EditPicture"+e);
		return(false);
	}
	
}
	
	
	
	
	public static Employees checkPassword(String eid,String epwd)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="select * from employees where employeeid='"+eid+"' and password='"+epwd+"'";
	     		 
	     ResultSet rs=DBHelper.executeQuery(cn, query);
	     if(rs.next())
	     { Employees E=new Employees();
	    	 E.setEmployeeid(rs.getString(1));
	    	 E.setEmployeename(rs.getString(2));
	    	 E.setDesignation(rs.getString(11));
	    	 E.setPhotograph(rs.getString(13));
	    	 
	    	 return(E);
	    	 
	     }
	    	 
	     return(null);


	}catch(Exception e)
	{System.out.println("checkpassword:"+e);
	 return(null);
	}
	
	
	
	}

}



