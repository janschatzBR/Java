package Inhotel;

import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

import java.util.List;

public class BeanAcomodacao extends Bean 
{ 
	private int codigoAcomodacao;
	private String descricaoAcomodacao;	 
	private int precoDaDiaria;	 
	private int nroCamasSolteiro;	 
	private int nroCamasCasal;	 
	private int nroQuarto;	 
	private int andar;
	private String descricaoReservaPeriodo;	
	Connection con1;
	PreparedStatement ps1;
	Statement s1;
	ResultSet rs1;
	boolean clickProximoAnterior;
	
	public String Proximo() throws SQLException 
	{
		String mensagem="";
		
		System.out.print("PPP");
	    
	    if(mensagem != "" )
	    {
	    	return mensagem;
	    }
	
	    if (clickProximoAnterior == false)
		{	 
			ps1 = con1.prepareStatement("SELECT * FROM acomodacao",
			ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs1 = ps1.executeQuery();
			clickProximoAnterior = true;
		}
			
		if ( rs1.next() )
		{      
			setCodigoAcomodacao(rs1.getInt("codigoAcomodacao"));
			setDescricaoAcomodacao(rs1.getString("descricaoAcomodacao"));
			setPrecoDaDiaria(rs1.getInt("precoDaDiaria"));
			setNroCamasSolteiro(rs1.getInt("nroCamasSolteiro"));
			setNroCamasCasal(rs1.getInt("nroCamasCasal"));
			setNroQuarto(rs1.getInt("nroQuarto"));
			setAndar(rs1.getInt("andar"));
			setDescricaoReservaPeriodo(rs1.getString("descricaoReservaPeriodo"));
			
			return("Proximo ok");
		}	  
		else 
		{
			rs1.previous();
		
			return( "Fim da tabela" );
        }
	}

	public String Anterior()
	{
	    String mensagem="";
	    
	    if(mensagem != "" )
	    {
	    	return mensagem;
	    }
	
        try 
        {
    	   if(clickProximoAnterior== false)
  	       {
  	          ps1 = con1.prepareStatement("SELECT * FROM acomodacao",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
              rs1= ps1.executeQuery();
  	          clickProximoAnterior=true;
  	       }      
    
 	       if (rs1.previous()) 
	       {
	          setCodigoAcomodacao(rs1.getInt("codigoAcomodacao"));
		      setDescricaoAcomodacao(rs1.getString("descricaoAcomodacao"));
		      setPrecoDaDiaria(rs1.getInt("precoDaDiaria"));
		      setNroCamasSolteiro(rs1.getInt("nroCamasSolteiro"));
		      setNroCamasCasal(rs1.getInt("nroCamasCasal"));
		      setNroQuarto(rs1.getInt("nroQuarto"));
		      setAndar(rs1.getInt("andar"));
		      setDescricaoReservaPeriodo(rs1.getString("descricaoReservaPeriodo"));
		      return ("Anterior ok");
	       }
	       else {
	  	      rs1.next();
	  	      return("Inicio da Tabela" );
		   }
	    	}catch(Exception e1) { mensagem=("Erro no anterior:\n Could not show\nMessage: \n" + e1.getMessage());}
	
	    return mensagem;
	
	}
	 
	public String Inserir_BeanAcomodacao() throws SQLException 
	{
		String mensagem="";
	
	    if(mensagem != "" )
	    {
	    	return mensagem;
	    }
	    	
		clickProximoAnterior = false;

		ps1=con1.prepareStatement("insert into Acomodacao(codigoAcomodacao,descricaoAcomodacao,precoDaDiaria,nroCamasSolteiro,nroCamasCasal,nroQuarto,andar,descricaoReservaPeriodo) values( ?,?,?,?,?,?,?,?)");
		ps1.setString(1,""+getCodigoAcomodacao() );
		ps1.setString(2,""+getDescricaoAcomodacao() );
		ps1.setString(3,""+getPrecoDaDiaria() );
		ps1.setString(4,""+getNroCamasSolteiro() );
		ps1.setString(5,""+getNroCamasCasal() );
		ps1.setString(6,""+getNroQuarto() );
		ps1.setString(7,""+getAndar() );
		ps1.setString(8,""+getDescricaoReservaPeriodo() );
		 
		System.out.println(ps1.executeUpdate());
		
		mensagem=("Acomodacao salva com sucesso!");
		
		return mensagem;
	}
	 
	public String Alterar_Dados_BeanAcomodacao(int codigoBeanAcomodacao) throws SQLException 
	{		
		String mensagem="";
		
		if(mensagem != "" )
		{
			return mensagem;
		}
		
		clickProximoAnterior = false;
	
	  	ps1 = con1.prepareStatement("select * from acomodacao where codigoAcomodacao= ? ");
		ps1.setString(1,""+getCodigoAcomodacao() );
		rs1= ps1.executeQuery();
		    
		if(!rs1.next()) 
		{
			return ("Acomodação nao encontrada na base de dados");
		}
		
		ps1=con1.prepareStatement("update acomodacao set descricaoAcomodacao=? ,precoDaDiaria= ? ,nroCamasSolteiro= ? , nroCamasCasal=?, nroQuarto=?, andar=?, descricaoReservaPeriodo =? where codigoAcomodacao=?");
		ps1.setString(1,""+getDescricaoAcomodacao() );
		ps1.setString(2,""+getPrecoDaDiaria() );
		ps1.setString(3,""+getNroCamasSolteiro() );
		ps1.setString(4,""+getNroCamasCasal() );
		ps1.setString(5,""+getNroQuarto() );
		ps1.setString(6,""+getAndar() );
		ps1.setString(7,""+getDescricaoReservaPeriodo() );
		ps1.setString(8,""+getCodigoAcomodacao() );
			 		   
		if( ps1.executeUpdate() != 1 )
		{
			mensagem=("Acomodacao não recebeu nenhuma alteração!");
		}
		else 
		{
			mensagem=("Acomodacao alterada com sucesso!");
		}
			
		return mensagem;		
	}
	
	public String VerificarAcomodacao() throws SQLException
	{
		String mensagem = "";
		
		if(mensagem != "" )
		{
			return mensagem;
		}
		
		ps1 = con1.prepareStatement("SELECT * FROM acomodacao where codigoAcomodacao=?");
		ps1.setString(1,""+getCodigoAcomodacao() );
		rs1= ps1.executeQuery();
  	
  	  	if(rs1.next())
  	  	{
  	  		mensagem="temvalor";
  	  	}	  
		
  	  	return mensagem;	 
	}
	 
	public String Remover_BeanAcomodacao(int codigoBeanAcomodacao) throws SQLException 
	{
		String mensagem="";
		
		if(mensagem != "" )
		{
			return mensagem;
		}
		    
		clickProximoAnterior = false;
		  
		ps1=con1.prepareStatement("delete from Acomodacao where codigoAcomodacao = ?");
		ps1.setString(1,""+codigoBeanAcomodacao );
				 
		if(ps1.executeUpdate() == 1 ) 
		{		        
			return("Acomodação excluida com sucesso!");
		}
		else
		{
			mensagem=("Acomodação não encontrada!");
		}
		
		return mensagem;
	 }
	 
	public int getCodigoAcomodacao() 
	{
		return codigoAcomodacao;
	}
	
	public String getDescricaoAcomodacao() 
	{
		return descricaoAcomodacao;
	}
	 
	public int getPrecoDaDiaria() 
	{
		return precoDaDiaria;
	}
	 
	public int getNroCamasSolteiro() 
	{
		return nroCamasSolteiro;
	}
	 
	public int getNroCamasCasal() 
	{
		return nroCamasCasal;
	}
	 
	public int getNroQuarto() 
	{
		return nroQuarto;
	}
	 
	public int getAndar() 
	{
		return andar;
	}
	
	public String getDescricaoReservaPeriodo() 
	{
		return descricaoReservaPeriodo;
	}
	
	public void setCodigoAcomodacao(int codigoAcomodacao) 
	{
		this.codigoAcomodacao= codigoAcomodacao;
	}
	 
	public void setDescricaoAcomodacao(String descricaoAcomodacao) 
	{
		this.descricaoAcomodacao= descricaoAcomodacao;
	}
	 
	public void setPrecoDaDiaria(int precoDaDiaria) 
	{
		this.precoDaDiaria=precoDaDiaria;
	}
	 
	public void setNroCamasSolteiro(int nroCamasSolteiro) 
	{
		this.nroCamasSolteiro = nroCamasSolteiro;
	}
	 
	public void setNroCamasCasal(int nroCamasCasal) 
	{
		this.nroCamasCasal = nroCamasCasal;
	}
	 
	public void setNroQuarto(int nroQuarto) 
	{
		this.nroQuarto = nroQuarto;
	}
	 
	public void setAndar(int andar) 
	{
		this.andar= andar;
	}
	
	public void setDescricaoReservaPeriodo(String descricaoReservaPeriodo) 
	{
		this.descricaoReservaPeriodo= descricaoReservaPeriodo;
	}	
	 
	public List Verificar_Acomodacao(int codigoAcomodacao) 
	{
		return null;
	}	 
}
 
