package AspectJ;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public aspect AspectExcecao 
{	
	pointcut metodos() : call(* *.*.*(..));
	
	after() throwing (Exception e): metodos() 
	{
		JOptionPane.showMessageDialog(null,"Erro");		
	}	
}