package Inhotel;

import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;


public class BeanEstadia extends Bean{      
 
	private Date dataCheckIn;
	 
	private int horaCheckIn;
	 
	private Date dataSaidaPrevista;
	 
	private int horaSaidaPrevista;
	 
	private int cpfHosp;
	 
	private int qtdeAcompanhante;
	 
	private int codigoAcomodacao;
	 
	private int precoDaDiaria;
	 
	private int desconto;
	 
	private Date dataCheckOut;
	 
	private int horaCheckOut;
	
	boolean clickProximoAnterior;
	
	String 	jaPagou;

  
	Connection con1;
	PreparedStatement ps1;
	Statement s1;
	ResultSet rs1;
	
	
	public String verificaCheckOut()
	{
		
		
		String mensagem="";
	    //onectar(mensagem);
	    if(mensagem != "" )
		   return mensagem;
	
		 try {
    
  	       
  	          ps1 = con1.prepareStatement("SELECT * FROM estadia where cpfHosp=? and dataCheckOut != ?");
              ps1.setString(1,""+getCpfHosp() );
              ps1.setString(2,"3000-01-01" );
              rs1= ps1.executeQuery();
  	          	             
    
 	          if(rs1.next())
 	      		return "Fez Check Out";
 	          else 	  return "Não Fez Check Out";
 	        
 	      }catch(Exception e1) { mensagem=("Erro no Verificar CheckOut:Could not show\nMessage: \n" + e1.getMessage());}
	      
	      return mensagem;
			
		
	}
	
    public String ExibirEstadia()
	{
	   String mensagem="";
	    //Conectar(mensagem);
	    if(mensagem != "" )
		   return mensagem;
		
		 try {
    
  	       
  	          ps1 = con1.prepareStatement("SELECT * FROM estadia where cpfHosp=?");
              ps1.setString(1,""+getCpfHosp() );
              rs1= ps1.executeQuery();
  	          	             
    
 	          rs1.next();
	       
	          setCpfHosp(rs1.getInt("cpfHosp"));
		      setHoraCheckIn(rs1.getInt("horaCheckIn"));
		      setDataCheckIn(rs1.getDate("dataCheckIn"));
		      setDataSaidaPrevista(rs1.getDate("dataSaidaPrevista"));
		      setHoraSaidaPrevista(rs1.getInt("horaSaidaPrevista"));
		      setQtdeAcompanhante(rs1.getInt("qtdeAcompanhante"));
		      setCodigoAcomodacao(rs1.getInt("codigoAcomodacao"));
		      setPrecoDaDiaria(rs1.getInt("precoDaDiaria"));
		      setDesconto(rs1.getInt("desconto"));
		      setHoraCheckOut(rs1.getInt("horaCheckOut"));
		      setDataCheckOut(rs1.getDate("dataCheckOut"));
		      setJaPagou(rs1.getString("jaPagou"));
		   return"Conseguiu carregar";
	       }catch(Exception e1) { mensagem=("Erro no Exibir Estadia:\n Could not show\nMessage: \n" + e1.getMessage());}
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
  	          ps1 = con1.prepareStatement("SELECT * FROM estadia",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
              rs1= ps1.executeQuery();
  	          clickProximoAnterior=true;
  	       }      
    
 	       if (rs1.previous()) 
	       {
	          setCpfHosp(rs1.getInt("cpfHosp"));
		      setHoraCheckIn(rs1.getInt("horaCheckIn"));
		      setDataCheckIn(rs1.getDate("dataCheckIn"));
		      setDataSaidaPrevista(rs1.getDate("dataSaidaPrevista"));
		      setHoraSaidaPrevista(rs1.getInt("horaSaidaPrevista"));
		      setQtdeAcompanhante(rs1.getInt("qtdeAcompanhante"));
		      setCodigoAcomodacao(rs1.getInt("codigoAcomodacao"));
		      setPrecoDaDiaria(rs1.getInt("precoDaDiaria"));
		      setDesconto(rs1.getInt("desconto"));
		      setHoraCheckOut(rs1.getInt("horaCheckOut"));
		      setDataCheckOut(rs1.getDate("dataCheckOut"));
		      setJaPagou(rs1.getString("jaPagou"));
		      return ("Anterior ok");
	       }
	       else {
	  	      rs1.next();
	  	      return("Inicio da Tabela" );
		   }
	    	}catch(Exception e1) { mensagem=("Erro no anterior:\n Could not show\nMessage: \n" + e1.getMessage());}
	
	    return mensagem;
	}
	
	public String Proximo()	{
		
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

	   ps1 = con1.prepareStatement("SELECT * FROM estadia",
	   ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    
    	// rs1 inicia apontando para a posição 0, por isso é necessário excluir
	  	// dando o comando rs1.next().
          rs1= ps1.executeQuery();
          clickProximoAnterior=true;
     }
      if (rs1.next() )
      {
      
		  	setCpfHosp(rs1.getInt("cpfHosp"));
			setHoraCheckIn(rs1.getInt("horaCheckIn"));
			setDataCheckIn(rs1.getDate("dataCheckIn"));
			setDataSaidaPrevista(rs1.getDate("dataSaidaPrevista"));
			setHoraSaidaPrevista(rs1.getInt("horaSaidaPrevista"));
			setQtdeAcompanhante(rs1.getInt("qtdeAcompanhante"));
			setCodigoAcomodacao(rs1.getInt("codigoAcomodacao"));
			setPrecoDaDiaria(rs1.getInt("precoDaDiaria"));
			setDesconto(rs1.getInt("desconto"));
			setHoraCheckOut(rs1.getInt("horaCheckOut"));
			setDataCheckOut(rs1.getDate("dataCheckOut"));
			 setJaPagou(rs1.getString("jaPagou"));
			return("Proximo ok");

	}	  	
			 	  
	  else {
			rs1.previous();
			return( "Fim da tabela" );
             }
    }        
      catch(Exception e1) {mensagem=("Erro no proximo: \n " + e1.getMessage());}
	
	return mensagem;
	}
	
	

	
	 
	public String Efetuar_CheckIn() {
	
		String mensagem="";
	    //Conectar(mensagem);
	    if(mensagem != "" )
	    	return mensagem;
	    	
		clickProximoAnterior=false;

		try{
		 // insert into Cliente(cpf,Nome, Endereco,Telefone,Divida) values( ?,?,?,?,0)")
		 ps1=con1.prepareStatement("insert into Estadia(cpfHosp,dataCheckIn,horaCheckIn,dataSaidaPrevista,horaSaidaPrevista,qtdeAcompanhante,codigoAcomodacao,precoDaDiaria,desconto,dataCheckOut,horaCheckOut,jaPagou) values( ?,?,?,?,?,?,?,?,?,?,?,?)");
		 ps1.setString(1,""+getCpfHosp() );
		 ps1.setString(2,""+getDataCheckIn() );
		 ps1.setString(3,""+getHoraCheckIn() );
		 ps1.setString(4,""+getDataSaidaPrevista() );
		 ps1.setString(5,""+getHoraSaidaPrevista() );
		 ps1.setString(6,""+getQtdeAcompanhante() );
		 ps1.setString(7,""+getCodigoAcomodacao() );
		 ps1.setString(8,""+getPrecoDaDiaria() );
		 ps1.setString(9,""+getDesconto() );
		 ps1.setString(10,""+getDataCheckOut() );
		 ps1.setString(11,""+getHoraCheckOut() );
		 ps1.setString(12,""+getJaPagou() );
		 
		 //executar a sql
	
		 
	     System.out.println(ps1.executeUpdate());
		 //caso nao esteja com autocommit igual a true,que é o default
		 //dar o comando con1.commit()'
		 mensagem=("Estadia salvo com sucesso!");
		 //atualizar a interface chamando o metodo excluir
		 //excluir();
	
		}catch(Exception e1) {mensagem=("[ERROR]: Não conseguiu inserir\nMessage: " + e1.getMessage());}
		return mensagem;	
	}
	 






	public String EfetuarCheckOut() 
	{
				
		String mensagem="";
		//Conectar(mensagem);
		if(mensagem != "" )
			return mensagem;
		clickProximoAnterior = false;
	
	  
	    // rs1 inicia apontando para a posição 0, por isso é necessário excluir
		  // dando o comando rs1.next().
		
		try{
	
			 ps1=con1.prepareStatement("select * from estadia where cpfHosp= ? and codigoAcomodacao= ?");
			 	 		//	   ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		     ps1.setString(1,""+getCpfHosp() );
			 ps1.setString(2,""+getCodigoAcomodacao() );
		    
		     rs1= ps1.executeQuery();
		    
		    
			 if(!rs1.next()) 
			 	return ("Estadia nao encontrada na base de dados");
					 
			 ps1=con1.prepareStatement("update estadia set dataCheckOut= ?, horaCheckOut= ?	where cpfHosp= ? and codigoAcomodacao= ?");
			 ps1.setString(1,""+getDataCheckOut() );
			 ps1.setString(2,""+getHoraCheckOut() );
			 ps1.setString(3,""+getCpfHosp() );
			 ps1.setString(4,""+getCodigoAcomodacao() );
				 
		    //System.out.println("execute update retornou"+ps1.executeUpdate());
			 if(ps1.executeUpdate() == 1 ) 
			     mensagem=("Check Out realizado com sucesso!");
			 else
				mensagem=("Check Out nao realizado!");
		}catch(Exception e1) {mensagem=("[ERROR]: Could not check out\nMessage: " + e1.getMessage());}
			
			
			return mensagem;
	}
		 
	public String Alterar_Dados_BeanEstadia( ) {
		
		
		
				
		String mensagem="";
		//Conectar(mensagem);
		if(mensagem != "" )
			return mensagem;
		clickProximoAnterior = false;
	
	  
	    // rs1 inicia apontando para a posição 0, por isso é necessário excluir
		  // dando o comando rs1.next().
		
		try{
	
			 ps1=con1.prepareStatement("select * from estadia where cpfHosp= ? and codigoAcomodacao= ?");
			 	 		//	   ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		     ps1.setString(1,""+getCpfHosp() );
			 ps1.setString(2,""+getCodigoAcomodacao() );
		    
		     rs1= ps1.executeQuery();
		    
		    
			 if(!rs1.next()) 
			 	return ("Estadia nao encontrada na base de dados");
					 
			 ps1=con1.prepareStatement("update estadia set dataCheckIn=?,horaCheckIn=? , dataSaidaPrevista= ?,		horaSaidaPrevista= ?, qtdeAcompanhante= ?,  precoDaDiaria= ?, desconto= ?,		dataCheckOut= ?, horaCheckOut= ?, jaPagou = ?		where cpfHosp= ? and codigoAcomodacao= ?");
			 ps1.setString(1,""+getDataCheckIn() );
			 ps1.setString(2,""+getHoraCheckIn() );
			 ps1.setString(3,""+getDataSaidaPrevista() );
			 ps1.setString(4,""+getHoraSaidaPrevista() );
			 ps1.setString(5,""+getQtdeAcompanhante() );
			 ps1.setString(6,""+getPrecoDaDiaria() );
			 ps1.setString(7,""+getDesconto() );
			 ps1.setString(8,""+getDataCheckOut() );
			 ps1.setString(9,""+getHoraCheckOut() );
			 ps1.setString(10,""+getJaPagou() );
			 ps1.setString(11,""+getCpfHosp() );
			 ps1.setString(12,""+getCodigoAcomodacao() );
				 
		    //System.out.println("execute update retornou"+ps1.executeUpdate());
			 if(ps1.executeUpdate() == 1 ) 
			     mensagem=("Estadia alterada com sucesso!");
			 else
				mensagem=("Estadia não recebeu nenhuma alteração!");
		}catch(Exception e1) {mensagem=("[ERROR]: Could not update\nMessage: " + e1.getMessage());}
			
			
			return mensagem;
		
		
		
	}
	 
	public Date getDataCheckIn() { 		        return dataCheckIn; 	}
	public int getHoraCheckIn() { 			    return horaCheckIn; 	}
	public Date getDataSaidaPrevista() {		return dataSaidaPrevista;	}
	public int getHoraSaidaPrevista() {	     	return horaSaidaPrevista;	}
	public int getCpfHosp() {					return cpfHosp;	}
	public int getQtdeAcompanhante() {			return qtdeAcompanhante;	}
	public int getCodigoAcomodacao() {			return codigoAcomodacao;	}
	public int getPrecoDaDiaria() {				return precoDaDiaria;	}
	public int getDesconto() {					return desconto;	}
	public Date getDataCheckOut() {				return dataCheckOut;	}
	public int getHoraCheckOut() {				return horaCheckOut;	}
	public String getJaPagou() {			    return jaPagou;	}
	 
	public BeanEstadia BeanEstadia(Date dataCheckIn, int horaCheckIn, Date dataSaidaPrevista, int horaSaidaPrevista, int cpfHosp, int qtdeAcompanhante, int codigoAcomodacao, int precoDaDiaria, int desconto, Date dataCheckOut, int horaChekOut) 
	{
			return null;
	}

	public void BeanEstadia()
	{  	
		clickProximoAnterior=false;
  	}
	 
	public void setDataCheckIn(Date dataCheckIn)
	{
		this.dataCheckIn=dataCheckIn;
	}
	 
	public void setHoraCheckIn(int horaCheckIn) {
		this.horaCheckIn=horaCheckIn;
	}
	 
	public void setDataSaidaPrevista(Date dataSaidaPrevista) {
		this.dataSaidaPrevista=dataSaidaPrevista;
	}
	 
	public void setHoraSaidaPrevista(int horaSaidaPrevista) {
		this.horaSaidaPrevista=horaSaidaPrevista;
	}
	 
	public void setCpfHosp(int cpfHosp) {
		this.cpfHosp = cpfHosp;
	}
	 
	public void setQtdeAcompanhante(int qtdeAcompanhante) {
		this.qtdeAcompanhante=qtdeAcompanhante;
	}
	 
	public void setCodigoAcomodacao(int codigoAcomodacao) {
		this.codigoAcomodacao=codigoAcomodacao;
	}
	 
	public void setPrecoDaDiaria(int precoDaDiaria) {
		this.precoDaDiaria=precoDaDiaria;
	}
	 
	public void setDesconto(int desconto) {
		this.desconto=desconto;
	}
	 
	public void setHoraCheckOut(int horaCheckOut) {
		this.horaCheckOut=horaCheckOut;
	}
	 
	public void setDataCheckOut(Date dataCheckOut) {
		this.dataCheckOut=dataCheckOut;
	}
	
	public void setJaPagou(String jaPagou)
	{
		this.jaPagou=jaPagou;
	}
	 
	public boolean VerificarBeanEstadia(int cpfHosp) {
		return false;
	}
	 
	public boolean VerificarCheckout(int cpfHosp) {
		return false;
	}
	 
	 
	 
	 
	public String Excluir(int cpf) {
	
			String mensagem="";
		    //onectar(mensagem);
		    if(mensagem != "" )
		    	return mensagem;
		    	
			clickProximoAnterior=false;
	
		try{
		 
			 
			 ps1=con1.prepareStatement("delete from Estadia where CPFHOSP = ?");
			 ps1.setString(1,""+cpf );
			 
			 if(ps1.executeUpdate() == 1 ) 
			     return("Estadia excluida com sucesso!");
			 else
				mensagem=("Estadia nao encontrada!");
			}
		
		catch(Exception e1) {mensagem=("[ERROR]: Could not delete\nMessage: " + e1.getMessage());}
		    return mensagem;
	  }	
}
 
