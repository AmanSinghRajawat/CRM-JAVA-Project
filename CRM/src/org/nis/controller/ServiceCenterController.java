package org.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.nis.model.ServiceCenter;


public class ServiceCenterController {
	
	private static String  provider="jdbc:mysql://localhost:3306/CRM";
	private static String userid="root";
	private static String password="2811";
	
	public static boolean addNewServiceCenter(ServiceCenter SC)
	{
		try{
	      Class.forName("com.mysql.jdbc.Driver").newInstance();
	      Connection cn=DriverManager.getConnection(provider,userid,password);
	      String query="insert into servicecenter values('"+SC.getCompanyid()+"','"+SC.getServicecenterid()+"','"+SC.getServicecentername()+"','"+SC.getOwner()+"','"+SC.getCountry()+"','"+SC.getState()+"','"+SC.getCity()+"','"+SC.getAddress()+"','"+SC.getEmail()+"','"+SC.getMobileno()+"')";
	     System.out.println(query);
	      boolean st=DBHelper.executeUpdate(cn,query);
	      return(st);
	      
		}
		catch(Exception e)
		{
			System.out.println("Add New Service Center "+e);
			return(false);
		}
		
	}
	
	
	
	public static ResultSet DisplayAll()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="select SC.companyid,SC.servicecenterid,SC.servicecentername,SC.owner,(select C.countryname from country C where C.countryid=SC.country),(select S.statename from states S where S.stateid=SC.state),(select C.cityname from city C where C.cityid=SC.city),SC.address,SC.email,SC.mobileno  from servicecenter SC";
			System.out.println(query);
			ResultSet rs=DBHelper.executeQuery(cn, query);
			return(rs);
			
		}
		catch(Exception e)
		{
			System.out.println("Display All Service Center :"+e);
			return(null);
		}
	}
	
	
	
	public static ResultSet DisplayServiceCenterById(String scid)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="select SC.companyid, SC.servicecenterid,SC.servicecentername,SC.owner,(select C.countryname from country C where C.countryid=SC.country),(select S.statename from states S where S.stateid=SC.state),(select C.cityname from city C where C.cityid=SC.city),SC.address,SC.email,SC.mobileno  from servicecenter SC";
			System.out.println(query);
			ResultSet rs=DBHelper.executeQuery(cn, query);
			return(rs);
			
			
		}
		catch(Exception e)
		{
			System.out.println("Display Service Center By Id :"+e);
			return(null);
		}
	}
	
	
	
	public static  boolean EditRecord(ServiceCenter SC)
	{
		try{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="update servicecenter set servicecentername='"+SC.getServicecentername()+"',owner='"+SC.getOwner()+"',country='"+SC.getCountry()+"',state='"+SC.getState()+"',city='"+SC.getCity()+"',address='"+SC.getAddress()+"',email='"+SC.getEmail()+"',mobileno='"+SC.getMobileno()+"'";
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
		}
		
		catch(Exception e)
		{
			System.out.println("Edit Record :"+e);
			return(false);
		}
	}
	
	
	public static boolean DeleteRecord(String scid)
	{
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="delete from servicecenter where servicecenterid='"+scid+"'";
			System.out.println(query);
			boolean st=DBHelper.executeUpdate(cn, query);
			return(st);
			
		}
		catch(Exception e)
		{
			System.out.println("Delete Record "+e);
			return(false);
		}
	}
	
		public static ResultSet DisplayServiceCenterByCompanyId(String  cid)
		{
			try{
				
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection cn=DriverManager.getConnection(provider,userid,password);
				String query="select * from servicecenter where companyid='"+cid+"'";
				ResultSet rs=DBHelper.executeQuery(cn,query);
				return(rs);
				
			}
			catch(Exception e)
			{
				System.out.println("Display Service Center By Company ID :"+e);
				return(null);
			}
			
		}
	
	
	
		
	
	
	}
	
	
