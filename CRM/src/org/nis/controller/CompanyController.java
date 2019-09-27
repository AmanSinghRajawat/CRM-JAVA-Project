package org.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.nis.model.Company;

public class CompanyController {
	
		private static String provider="jdbc:mysql://localhost:3306/CRM";
		private static String userid="root";
		private static String password="2811";
		
		public static boolean addNewCompanyRecord(Company C)
		{
			try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection cn=DriverManager.getConnection(provider,userid,password);
				String query="insert into company values('"+C.getCompanyid()+"','"+C.getCompanyname()+"','"+C.getOwner()+"','"+C.getAddress()+"','"+C.getCountry()+"','"+C.getState()+"','"+C.getCity()+"','"+C.getContactperson()+"','"+C.getEmailid()+"','"+C.getMobileno()+"','"+C.getLogo()+"')";
					System.out.println(query);
				boolean st=DBHelper.executeUpdate(cn, query);
				return(st);	
			}
			catch(Exception e)
			{
				System.out.println("addNewCompanyRecord"+e);
				return(false);
				}
			
		}
		
		public static ResultSet DisplayAll()
		{
			try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection cn=DriverManager.getConnection(provider,userid,password);
				String query="select * from company";
				ResultSet rs=DBHelper.executeQuery(cn,query);
				return(rs);
			}
			catch(Exception e)
			{
				System.out.println("addNewCompanyRecord"+e);
				return(null);
			}
		}
		
		public static ResultSet DisplayByCompanyId(String cid)
		{
			try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection cn=DriverManager.getConnection(provider,userid,password);
			String query="select * from company where companyid='"+cid+"'";
			
			ResultSet rs=DBHelper.executeQuery(cn, query);
			return(rs);
			}
			catch(Exception e)
			{
				System.out.println("addNewCompanyRecord"+e);
				return(null);
				}
		}
		
		
		public static boolean EditRecord(Company C)
		{
			try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection cn=DriverManager.getConnection(provider,userid,password);
				String query="update company set  companyname='"+C.getCompanyname()+"',owner='"+C.getOwner()+"',address'"+C.getAddress()+"',country='"+C.getCountry()+"',state='"+C.getState()+"',city='"+C.getCity()+"',contactperson='"+C.getContactperson()+"',emailid='"+C.getEmailid()+"',mobileno='"+C.getMobileno()+"',logo='"+C.getLogo()+"'";
				System.out.println(query);
				boolean st=DBHelper.executeUpdate(cn, query);
				return(st);
		}
			catch(Exception e)
			{
				System.out.println(e);
				return(false);
			}
			}
		
		
		public static boolean DeleteRecord(String cid)
		{
			try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection cn =DriverManager.getConnection(provider,userid,password);
				String query="delete from company where companyid='"+cid+"'";
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
		
		
		
		public static boolean EditPicture(String filename,String cid)
		{
			try{
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection cn=DriverManager.getConnection(provider,userid,password);
				String  query="update company set logo='"+filename+"'where companyid='"+cid+"'";
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

		
		
	}


