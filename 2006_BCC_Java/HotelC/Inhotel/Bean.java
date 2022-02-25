package Inhotel;

import java.sql.Connection;
import java.sql.DriverManager;

abstract public class Bean 
{
	public static void Conectar() 
	{
		try 
		{
			DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
			Connection con = DriverManager.getConnection( "jdbc:odbc:california","root","mysql");
		}		
		catch(Exception e1) 
		{
			String mensagem=("[ERROR]: Could not connect\nMessage: " + e1.getMessage());
		}	
	}
}
