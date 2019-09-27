package org.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.nis.model.Engineers;

public class EngineersController {
	private static String provider="jdbc:mysql://localhost:3306/CRM";
	private static String userid="root";
	private static String password="2811";
	
	public  static boolean addNewEngineersRecord(Engineers E)
	{
		try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,userid,password);
		String query="insert into engineers values('"+E.getServicecenterid()+"','"+E.getEngineerid()+"','"+E.getEngineername()+"','"+E.getDob()+"','"+E.getGender()+"','"+E.getAddress()+"','"+E.getCountry()+"','"+E.getState()+"','"+E.getCity()+"','"+E.getMobileno()+"','"+E.getEmailid()+"','"+E.getPassword()+"','"+E.getPhotograph()+"')";
		System.out.println(query);
		boolean st=DBHelper.executeUpdate(cn, query);
		return(st);
		}
		catch(Exception e)
		{
			System.out.println("add New Engineers Record :"+e);
			return(false);		}
		
	}
	
	

	public static ResultSet DisplayAll()
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="select E.servicecenterid,E.engineerid,E.engineername,E.dob,E.gender,E.address,(select C.countryname from country C where C.countryid=E.country),(select S.statename from states S where S.stateid=E.state),(select C.cityname from city C where C.cityid=E.city),E.mobileno,E.emailid,E.password,E.photograph   from engineers E"; 
	     ResultSet rs=DBHelper.executeQuery(cn, query);
	     return(rs);


	}catch(Exception e)
	{System.out.println("add New Engineers Record :"+e);
	 return(null);
	}
	}

	public static ResultSet DisplayEngineersById(String eid)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
	     String query="select E.servicecenterid,E.engineerid,E.engineername,E.dob,E.gender,E.address,(select C.countryname from country C where C.countryid=E.country),(select S.statename from states S where S.stateid=E.state),(select C.cityname from city C where C.cityid=E.city),E.mobileno,E.emailid,E.password,E.photograph   from engineers E where engineerid='"+eid+"'"; 
	     ResultSet rs=DBHelper.executeQuery(cn, query);
	     return(rs);


	}catch(Exception e)
	{System.out.println("addNewRecord:"+e);
	 return(null);
	}
	}
	
	
	public static boolean EditRecord(Engineers E)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
		  
	     String query="update  engineers set engineername='"+E.getEngineername()+"', dob='"+E.getDob()+"',gender='"+E.getGender()+"',address='"+E.getAddress()+"',country='"+E.getCountry()+"',city='"+E.getCity()+"',state='"+E.getState()+"',mobileno='"+E.getMobileno()+"',emailid='"+E.getEmailid()+"' where engineerid='"+E.getEngineerid()+"'";
	     System.out.println(query);
	     boolean st=DBHelper.executeUpdate(cn, query);
	     return(st);


	}catch(Exception e)
	{System.out.println("EditRecord:"+e);
	 return(false);
	}
	}
	
	public static boolean DeleteRecord(String eid)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
		  
	     String query="delete from engineers  where engineerid='"+eid+"'";
	     System.out.println(query);
	     boolean st=DBHelper.executeUpdate(cn, query);
	     return(st);


	}catch(Exception e)
	{System.out.println("DeleteRecord:"+e);
	 return(false);
	}
	}
	
	
	public static boolean EditPicture(String filename,String eid)
	{ try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance();	
		Connection cn=DriverManager.getConnection(provider,userid,password);
		  
	     String query="update  engineers set photograph='"+filename+"' where engineerid='"+ eid+"'";
	     System.out.println(query);
	     boolean st=DBHelper.executeUpdate(cn, query);
	     return(st);


	}catch(Exception e)
	{System.out.println("EditPicture:"+e);
	 return(false);
	}
	}

	
	
	

}
