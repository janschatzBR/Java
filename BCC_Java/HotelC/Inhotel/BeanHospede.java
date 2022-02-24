package Inhotel;

import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BeanHospede extends Bean
{   
    private int cpfHosp;
	private String nomeHosp;
	private String email;
	private Date dataNascimento;
	private String nomeDosPais;
	private int ddd;
	private int telefone;
	private String rua;
	private int nro;
	private String compl;
	private String bairro;
	private String cidade;
	private String estado;
	private int cep;
	private String pais;
	Connection con1;
    PreparedStatement ps1;
    ResultSet rs1;	
	boolean clickProximoAnterior;
		
 
 	public String VerificaHospede()
 	{ 		
 		String mensagem="";
		
		if(mensagem != "" )
		{
			return mensagem;
		}
	
		try
		{ 	
			ps1 = con1.prepareStatement("SELECT * FROM hospede where cpfHosp=?");
			ps1.setString(1,""+getCpfHosp() );
			rs1= ps1.executeQuery();
  	
			if(rs1.next())
			{  	  
				setNomeHosp(rs1.getString("nomeHosp"));
				setEmail(rs1.getString("email"));
				setDataNascimento(rs1.getDate("dataNascimento"));
				setNomeDosPais(rs1.getString("nomeDosPais"));
				setDdd(rs1.getInt("ddd"));
				setTelefone(rs1.getInt("telefone"));
				setRua(rs1.getString("rua"));
				setNro(rs1.getInt("nro"));
				setCompl(rs1.getString("compl"));
				setBairro(rs1.getString("bairro"));
				setCidade(rs1.getString("cidade"));
				setEstado(rs1.getString("estado"));
				setCep(rs1.getInt("cep"));
				setPais(rs1.getString("pais"));
	  	        
				mensagem="temvalor";
			}	  
		}		
		catch(Exception e1) 
		{ 
			mensagem=("Hospede nao cadastrado para esse CPF:\n Could not show\nMessage: \n" + e1.getMessage());
		}
	
		return mensagem;
 	}
 
 	
	public String Inserir() throws SQLException 
	{
		String mensagem = "";
	    	    
		if( mensagem != "" )
	    {
	    	System.out.println(mensagem);
	    	return mensagem;
	    }
	    	
	    clickProximoAnterior=false;
	
	    /*try
	    {*/	    	
	    	ps1=con1.prepareStatement("insert into Hospede(cpfHosp,nomeHosp, nomeDosPais, email, dataNascimento,ddd ,telefone,rua, nro, compl,bairro ,cidade,estado,cep, pais) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	    	ps1.setString(1,""+getCpfHosp() );
	    	ps1.setString(2,""+getNomeHosp() );
	    	ps1.setString(3,""+getNomeDosPais() );
	    	ps1.setString(4,""+getEmail() );
	    	ps1.setString(5,""+getDataNascimento() );
	    	ps1.setString(6,""+getDdd() );
	    	ps1.setString(7,""+getTelefone() );
	    	ps1.setString(8,""+getRua() );
	    	ps1.setString(9,""+getNro() );
	    	ps1.setString(10,""+getCompl() );
	    	ps1.setString(11,""+getBairro() );
	    	ps1.setString(12,""+getCidade() );
	    	ps1.setString(13,""+getEstado() );
	    	ps1.setString(14,""+getCep() );
	    	ps1.setString(15,""+getPais() );
	    		 
	    	System.out.println(ps1.executeUpdate());
	
		 	mensagem=("Hospede salvo com sucesso!");	
		//}
	    /*catch (SQLException e1) 
	    {
	    	mensagem =("Não consegue inserir");
	    } */

		return mensagem;	
	}
	
	
	public String Alterar_Dados_BeanHospede() 
	{
		String mensagem="";
		//Conectar(mensagem);
		if(mensagem != "" )
			return mensagem;
		clickProximoAnterior = false;
	
	  
	    // rs1 inicia apontando para a posição 0, por isso é necessário excluir
		  // dando o comando rs1.next().
		
		try{
	
			 ps1=con1.prepareStatement("select * from hospede where cpfHosp= ? ");
			 	 		//	   ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		     ps1.setString(1,""+getCpfHosp() );
		    
		     rs1= ps1.executeQuery();
		    
		    
			 if(!rs1.next()) 
			 	return ("Hospede nao encontrada na base de dados");
		
		
			 
			 ps1=con1.prepareStatement("update hospede set nomeHosp=?,nomeDosPais=?  ,email= ? ,dataNascimento= ? , ddd=?,telefone=?, rua=?, nro=?,compl=?,bairro=?,cidade=?,estado=?,cep=?,pais=? where cpfHosp=?");
			 ps1.setString(1,""+getNomeHosp() );
			 ps1.setString(2,""+getNomeDosPais() );
			 ps1.setString(3,""+getEmail() );
			 ps1.setString(4,""+getDataNascimento() );
			 ps1.setString(5,""+getDdd() );
			 ps1.setString(6,""+getTelefone() );
			 ps1.setString(7,""+getRua() );
			 ps1.setString(8,""+getNro() );
			 ps1.setString(9,""+getCompl() );
			 ps1.setString(10,""+getBairro() );
			 ps1.setString(11,""+getCidade() );
			 ps1.setString(12,""+getEstado() );
			 ps1.setString(13,""+getCep() );
			 ps1.setString(14,""+getPais() );
			 ps1.setString(15,""+getCpfHosp());
     		 
			 		   
			 if( ps1.executeUpdate() != 1 )
			   			mensagem=("Hospede não recebeu nenhuma alteração!");
			  		else mensagem=("Hospede alterado com sucesso!");
			 }catch(Exception e1){mensagem=("Nao conseguiu alterar! \n"+  e1.getMessage());}
//			System.out.println(e1.getMessage());
			
			return mensagem;
	}

	
	public String Remover_BeanHospede(int cpf) 
	{
		
			String mensagem="";
		    //Conectar(mensagem);
		    if(mensagem != "" )
		    	return mensagem;
		    
		    	
			clickProximoAnterior=false;
		  
	
		try{
		 
		 			
			 		
		 
			 
			 ps1=con1.prepareStatement("delete from Hospede where cpfHosp = ?");
			 ps1.setString(1,""+cpf );
			 
			 
			 
			 
			 if(ps1.executeUpdate() == 1 ) 
			    { 
			        
			    	return("Hóspede excluido com sucesso!");
			    }
			     
			 else
				mensagem=("Hóspede não encontrado!");
			}
		catch(Exception e1) {mensagem=("Não conseguiu deletar");}
//		System.out.println(e1.getMessage());
		 return mensagem;
	 
		
	}
	
	
	public String Proximo()
	{
		
		String mensagem="";
		//Conectar(mensagem);
		if(mensagem != "" )
			return mensagem;
		
			
		
	try {
	


	
       //so entra aqui se o botao proximo estiver sendo clicado pela primeira vez		  
	  if (clickProximoAnterior == false)
	 {	  
	 	

	 
	 // ResultSet.TYPE_SCROLL_SENSITIVE permite navegação para registro anterior.
	  // Por default, só seria permitido navegar para o próximo registro.
	  // ResultSet.CONCUR_UPDATABLE permite atualizar o registro. Sem esse comando,
	  // ele permite somente leitura.

	    ps1 = con1.prepareStatement("SELECT * FROM hospede",
	    ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        
    
    	// rs1 inicia apontando para a posição 0, por isso é necessário excluir
	  	// dando o comando rs1.next().
          rs1= ps1.executeQuery();
          
          clickProximoAnterior=true;
     }
      if (rs1.next() )
      {
      //nao estou testando se rs1.next e rs1.next sao verdadeiros ou falsos
      //estou assumindo que os dados sao integros. Mesmo nro de linhas na tabela hospede, mesmo nro na tablea telefone e mesmo nro na tabela endereco
		  	setCpfHosp(rs1.getInt("cpfHosp"));
			setNomeHosp(rs1.getString("nomeHosp"));
			setEmail(rs1.getString("email"));
			setDataNascimento(rs1.getDate("dataNascimento"));
			setNomeDosPais(rs1.getString("nomeDosPais"));
			setDdd(rs1.getInt("ddd"));
			setTelefone(rs1.getInt("telefone"));
			setRua(rs1.getString("rua"));
			setNro(rs1.getInt("nro"));
			setCompl(rs1.getString("compl"));
			setBairro(rs1.getString("bairro"));
			setCidade(rs1.getString("cidade"));
			setEstado(rs1.getString("estado"));
			setCep(rs1.getInt("cep"));
			setPais(rs1.getString("pais"));
			
			return("Proximo ok");

	}	  	
			 	  
	  else {
       		rs1.previous();
			return( "Fim da tabela" );
             }
    }        
      catch(Exception e1) {mensagem=("Erro no proximo!");}
//	System.out.println(e1.getMessage());
	return mensagem;

		
		
	}
	
	
	public String Anterior()
	{
		
	String mensagem="";
	//Conectar(mensagem);
	if(mensagem != "" )
		return mensagem;
	
  try {
  
  	if(clickProximoAnterior== false)
  	{
  	  ps1 = con1.prepareStatement("SELECT * FROM hospede",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
  	  
  	  
 
      rs1= ps1.executeQuery();
  	  clickProximoAnterior=true;
  	}      
    
 	
	  if (rs1.previous()) 
	  {
	        
		  	setCpfHosp(rs1.getInt("cpfHosp"));
			setNomeHosp(rs1.getString("nomeHosp"));
			setEmail(rs1.getString("email"));
			setDataNascimento(rs1.getDate("dataNascimento"));
			setNomeDosPais(rs1.getString("nomeDosPais"));
			setDdd(rs1.getInt("ddd"));
			setTelefone(rs1.getInt("telefone"));
			setRua(rs1.getString("rua"));
			setNro(rs1.getInt("nro"));
			setCompl(rs1.getString("compl"));
			setBairro(rs1.getString("bairro"));
			setCidade(rs1.getString("cidade"));
			setEstado(rs1.getString("estado"));
			setCep(rs1.getInt("cep"));
			setPais(rs1.getString("pais"));
			
			
			return ("Anterior ok");
	  }
	  else {
		
	  	rs1.next();
	  	return("Inicio da Tabela" );
		
	  }
	
	}catch(Exception e1) { mensagem=("Erro no anterior!");}
//	 System.out.println(e1.getMessage());
	return mensagem;
		
		
		
	}
	
	
	public void setCpfHosp(int cpfHosp) 	{		this.cpfHosp = cpfHosp;		}

public void setNomeHosp(String nomeHosp) 	{		this.nomeHosp = nomeHosp;	}
	 
public void setEmail(String email) 	{		this.email = email;	}
	 
public void setDataNascimento(Date dataNascimento) 	{		this.dataNascimento = dataNascimento;	}
	 
public void setNomeDosPais(String nomeDosPais) 	{		this.nomeDosPais = nomeDosPais;	}
	
public void setDdd(int ddd) 	{ 		this.ddd= ddd;	}

public void setTelefone(int telefone) 	{		this.telefone= telefone;	}

public void setRua(String rua)	{		this.rua= rua;	}

public void setNro(int nro)	{		this.nro= nro;	}

public void setCompl(String compl)	{		this.compl= compl;	}

public void setBairro(String bairro)	{		this.bairro= bairro;	}

public void setCidade(String cidade)	{		this.cidade= cidade;	}

public void setEstado(String estado)	{		this.estado= estado;	}

public void setCep(int cep)	{		this.cep= cep;	}

public void setPais(String pais)	{		this.pais= pais;	} 
	 
public int getCpfHosp() {		return cpfHosp;	}
	 
public String getNomeHosp() 	{		return nomeHosp;	}
	 
public String getEmail()	{		return email;	} 
	
public Date getDataNascimento() 	{		return dataNascimento;	}
	 
public String getNomeDosPais() {		return nomeDosPais;	}	 
 
public int getDdd() 	{ 		return ddd;	}

public int getTelefone() 	{		return telefone;	}

public String getRua()	{		return rua;	}

public int getNro()	{		return nro;	}

public String getCompl()	{		return  compl;	}

public String getBairro()	{		return  bairro;	}

public String getCidade()	{		return cidade;	}

public String getEstado()	{		return estado;	}

public int getCep()	{		return cep;	}

public String getPais()	{		return pais;	} 
	 



	public void BeanHospede()
	{
		clickProximoAnterior=false;;	
	}
	
	 
 
	public boolean Verificar_Hospede(int cpfHosp) {
		return false;
	}
;	 
}
 
