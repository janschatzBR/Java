package Inhotel;

import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;


public class BeanPagamento extends Bean{
 
	private int cpfHosp;
	 
	private Date dataPagamento;
	 
	private double valorPagamento;
	 
	private String tipoPagamento;
	 
	
	
	Connection con1;
	PreparedStatement ps1;
	Statement s1;
	ResultSet rs1;
	
	//public String CarregaJaPagou()
	//{
//		String mensagem="";
//	    Conectar(mensagem);
//	    if(mensagem != "" )
//	    	return mensagem;
//		
		
		
//	}
	 
	public String Efetuar_Pagamento() 
	{
		
		String mensagem="";
	    //Conectar(mensagem);
	    if(mensagem != "" )
	    	return mensagem;
	    	
	
		try{
		  
		 ps1=con1.prepareStatement("insert into Pagamento(cpfHosp,dataPagamento,valorPagamento,tipoPagamento) values( ?,?,?,?)");
		 ps1.setString(1,""+getCpfHosp() );
		 ps1.setString(2,""+getDataPagamento() );
		 ps1.setString(3,""+getValorPagamento() );
		 ps1.setString(4,""+getTipoPagamento() );
		  
		 
		 //executar a sql
	
		 
	     ps1.executeUpdate();
	     
	     
	     ps1=con1.prepareStatement("update estadia set jaPagou = ? where cpfHosp=?");
		 ps1.setString(1,"Sim" );
		 ps1.setString(2,""+getCpfHosp() );
		 
		 ps1.executeUpdate();
		 //caso nao esteja com autocommit igual a true,que � o default
		 //dar o comando con1.commit()'
		 mensagem=("Pagamento salvo com sucesso!");
		 //atualizar a interface chamando o metodo excluir
		 //excluir();
	
		}catch(Exception e1) {mensagem=("[ERROR]: N�o conseguiu inserir pagamento\nMessage: " + e1.getMessage());}
		return mensagem;	
		
	}
	
	
	public void Conectar(String mensagem)
	{
	    // usando odbc
		// � obrigat�rio o uso de try para conex�es com bd's
		
		//inicializa variavel erro
		mensagem="";
		try {
		  // metodo static, por isso independe da instancia��o de um objeto
		  DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
		  // outra sintaxe � usando:
		  // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	
		  // fazendo a conex�o
		  con1 = DriverManager.getConnection( "jdbc:odbc:california","root","mysql" );
		}
		
		catch(Exception e1) 
		{mensagem=("[ERROR]: Could not connect\nMessage: " + e1.getMessage());}
	}
	
	
	public String Alterar_Dados_BeanPagamento() 
	{
	
	String mensagem="";
		//Conectar(mensagem);
		if(mensagem != "" )
			return mensagem;
	
	  
	    // rs1 inicia apontando para a posi��o 0, por isso � necess�rio excluir
		  // dando o comando rs1.next().
		
		try{
	
			 ps1=con1.prepareStatement("select * from pagamento where cpfHosp= ?");
			 	 		//	   ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		     ps1.setString(1,""+getCpfHosp() );
			 		    
		     rs1= ps1.executeQuery();
		    
		    
			 if(!rs1.next()) 
			 	return ("Pagamento nao encontrado na base de dados");
					 
			 ps1=con1.prepareStatement("update pagamento set dataPagamento=?,valorPagamento=? , tipoPagamento= ?	where cpfHosp= ?");
			 ps1.setString(1,""+getDataPagamento() );
			 ps1.setString(2,""+getValorPagamento() );
			 ps1.setString(3,""+getTipoPagamento() );
			 ps1.setString(4,""+getCpfHosp() );
			 
				 
		    if(ps1.executeUpdate() == 1 ) 
			     mensagem=("Pagamento alterado com sucesso!");
			 else
				mensagem=("Pagamento n�o recebeu nenhuma altera��o!");
		}catch(Exception e1) {mensagem=("[ERROR]: Could not update pgto\nMessage: " + e1.getMessage());}
			
			
			return mensagem;

	
	
	
	
	}
	
	public void Pagamento()		{			}

	public BeanPagamento Pagamento(int cpfHosp, Date dataPagamento, int valorPagamento, String tipoPagamento) 
	{

		return null;
	}

	 
	public String VerificaPagamento() 	
	{	
	
	
	
	String mensagem="";
		//Conectar(mensagem);
		if(mensagem != "" )
			return mensagem;
	
	//System.out.println("executou");
	
		
	try{
	 	
      ps1 = con1.prepareStatement("SELECT * FROM pagamento where cpfHosp=?");
      ps1.setString(1,""+getCpfHosp() );
      rs1= ps1.executeQuery();
  	
  	  if(rs1.next())
  	  {
  	  
  	 // System.out.println("entrou");	  	        
  	         
	          setDataPagamento(rs1.getDate("dataPagamento"));
	          setValorPagamento(rs1.getInt("valorPagamento"));
	          setTipoPagamento(rs1.getString("tipoPagamento"));
	          mensagem="temvalor";
	   }	  
		 }
		 catch(Exception e1) { mensagem=("Pgto nao realizado para esse CPF:\n Could not show\nMessage: \n" + e1.getMessage());}
	return mensagem;	 
	 }
	 
	public int getCpfHosp() 	{		return cpfHosp;		}
	public Date getDataPagamento() 	{		return dataPagamento;	}
	public double getValorPagamento() 	{		return valorPagamento;	}
	public String getTipoPagamento() 	{		return tipoPagamento;	}
	 
	public void setCpfHosp(int cpfHosp) 	{		this.cpfHosp = cpfHosp;	}
	public void setDataPagamento(Date dataPagamento) 	{		this.dataPagamento = dataPagamento;	}
	public void setValorPagamento(int valorPagamento) 	{		this.valorPagamento = valorPagamento;	}
	public void setTipoPagamento(String tipoPagamento) 	{		this.tipoPagamento = tipoPagamento;	}
	 

}