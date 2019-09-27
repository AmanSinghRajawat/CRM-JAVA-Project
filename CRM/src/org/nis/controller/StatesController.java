package org.nis.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;



public class StatesController {

		
		private static String provider="jdbc:mysql://localhost:3306/CRM";
		private static String userid="root";
		private static String password="2811";

		public static ResultSet DisplayAll()
		{ try{
		   Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
		   String query="select * from states";
		   ResultSet rs=DBHelper.executeQuery(cn, query);
		     return(rs);


		}catch(Exception e)
		{System.out.println(e);
		 return(null);
		}
		}
		
		public static ResultSet DisplayAllCityByStateId(String stateid)
		{
			try
			{
			Class.forName("com.mysql.jdbc.Driver").newInstance();	
			Connection cn=DriverManager.getConnection(provider,userid,password);
			 String query="select * from city where stateid='"+stateid+"'";
			ResultSet rs=DBHelper.executeQuery(cn,query);
			return(rs);
			}
			catch(Exception e)
			{
				System.out.println(e);
				return(null);
				
			}
			
		}
		
}


