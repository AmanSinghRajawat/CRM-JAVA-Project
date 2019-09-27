package org.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.nis.model.Admin;



public class AdminController {
	
	private static String provider="jdbc:mysql://localhost:3306/CRM";
	private static String userid="root";
	private static String password="2811";
	
	public static Admin checkPassword(String aid,String pwd)
	{
		try{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection cn=DriverManager.getConnection(provider,userid,password);
		String query="select * from admin where adminid='"+aid+"' and password='"+pwd+"'";
		System.out.println(query);
		ResultSet rs=DBHelper.executeQuery(cn, query);
		if(rs.next())
		{
			Admin A=new Admin();
			A.setAdminid(rs.getString(1));
			A.setAdminname(rs.getString(2));
			return(A);
		}
		return(null);
		}
		catch(Exception e)
		{
			System.out.println("Admin Controller :"+e);
			return(null);
		}
		
	}
	

}
