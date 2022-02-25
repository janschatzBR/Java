package Inhotel;

import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class BeanReserva extends Bean {
 
	private Date dataChegadaPrevista;
	 
	private int horaChegadaPrevista;
	 
	private Date dataSaidaPrevista;
	 
	private int horaSaidaPrevista;
	 
	private int multa;
	 
	private int desconto;
	 
	private int cpfHosp;
	 
	private int codigoAcomodacao;
	 
	private int precoDaDiaria;
	
	private int qtdeAcompanhante;
	 

	boolean clickProximoAnterior;

	
	Connection con1;

	PreparedStatement ps1;

	Statement s1;

	ResultSet rs1;

	
	

	public void Conectar(String mensagem) {
		// usando odbc
		// é obrigatório o uso de try para conexões com bd's
		//inicializa variavel erro
		mensagem="";
		try {
		// metodo static, por isso independe da instanciação de um objeto
		DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
		// outra sintaxe é usando:
		// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		// fazendo a conexão
		con1 = DriverManager.getConnection( "jdbc:odbc:california","root","mysql" );
		}
		catch(Exception e1) {mensagem=("[ERROR]: Could not connect\nMessage: " + e1.getMessage());}
		}

	

	public void ExibirReserva()
	{
		try{System.out.println(""+rs1.getString("cpfHosp"));}
		catch(Exception e1) {System.out.println("[ERROR]: erro na exibicao\nMessage: " + e1.getMessage());}
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
				ps1 = con1.prepareStatement("SELECT * FROM reserva",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs1= ps1.executeQuery();
				clickProximoAnterior=true;
			}
			if (rs1.previous())
			{
				setCpfHosp(rs1.getInt("cpfHosp"));
				setHoraChegadaPrevista(rs1.getInt("horaChegadaPrevista"));
				setDataChegadaPrevista(rs1.getDate("dataChegadaPrevista"));
				setDataSaidaPrevista(rs1.getDate("dataSaidaPrevista"));
				setHoraSaidaPrevista(rs1.getInt("horaSaidaPrevista"));
				setMulta(rs1.getInt("multa"));
				setDesconto(rs1.getInt("desconto"));
				setCodigoAcomodacao(rs1.getInt("codigoAcomodacao"));
				setPrecoDaDiaria(rs1.getInt("precoDaDiaria"));
				setQtdeAcompanhante(rs1.getInt("qtdeAcompanhante"));
		    	return ("Anterior ok");
			}
			else 
			{ 
				rs1.next();
				return("Inicio da Tabela" );
			}
		}catch(Exception e1) 
		{ mensagem=("Erro no anterior:\n Could not show\nMessage: \n" + e1.getMessage());
		}	
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
		 	{	// ResultSet.TYPE_SCROLL_SENSITIVE permite navegação para registro anterior.
		   	    // Por default, só seria permitido navegar para o próximo registro.
		  	    // ResultSet.CONCUR_UPDATABLE permite atualizar o registro. Sem esse comando,
		    	// ele permite somente leitura.
		  	    ps1 = con1.prepareStatement("SELECT * FROM reserva", ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		    	// rs1 inicia apontando para a posição 0, por isso é necessário excluir
		   	    // dando o comando rs1.next().
		   	    rs1= ps1.executeQuery();
		   	    clickProximoAnterior=true;
		 	}
			 if (rs1.next() )
			 {
			 	setCpfHosp(rs1.getInt("cpfHosp"));
		 		setHoraChegadaPrevista(rs1.getInt("horaChegadaPrevista"));
		 		setDataChegadaPrevista(rs1.getDate("dataChegadaPrevista"));
		 		setDataSaidaPrevista(rs1.getDate("dataSaidaPrevista"));
		    	setHoraSaidaPrevista(rs1.getInt("horaSaidaPrevista"));
				setMulta(rs1.getInt("multa"));
				setDesconto(rs1.getInt("desconto"));
				setCodigoAcomodacao(rs1.getInt("codigoAcomodacao"));
				setPrecoDaDiaria(rs1.getInt("precoDaDiaria"));
				setQtdeAcompanhante(rs1.getInt("qtdeAcompanhante"));
				return("Proximo ok");
			} else { 
				rs1.previous();
				return( "Fim da tabela" );
		  }
		  } catch(Exception e1) {mensagem=("Erro no proximo: \n " + e1.getMessage());}
			return mensagem;
		}
	
	public String Efetuar_Reserva() 
	{	
		String mensagem="";
	    //Conectar(mensagem);
	    if(mensagem != "" )
	    	return mensagem;
	    	
		clickProximoAnterior=false;

		try{
		 // insert into Cliente(Cpf,Nome, Endereco,Telefone,Divida) values( ?,?,?,?,0)")
			
		 ps1=con1.prepareStatement("insert into reserva(cpfHosp, dataChegadaPrevista, horaChegadaPrevista, dataSaidaPrevista, horaSaidaPrevista, multa, desconto, codigoAcomodacao, precoDaDiaria, qtdeAcompanhante) values( ?,?,?,?,?,?,?,?,?,?)");
		 ps1.setString(1,""+getCpfHosp() );
		 ps1.setString(2,""+getDataChegadaPrevista() );
		 ps1.setString(3,""+getHoraChegadaPrevista() );
		 ps1.setString(4,""+getDataSaidaPrevista() );
		 ps1.setString(5,""+getHoraSaidaPrevista() );
		 ps1.setString(6,""+getMulta() );
		 ps1.setString(7,""+getDesconto() );
		 ps1.setString(8,""+getCodigoAcomodacao() );
		 ps1.setString(9,""+getPrecoDaDiaria() );
		 ps1.setString(10,""+getQtdeAcompanhante() );
		 		 
		 //executar a sql
	
		 
	     System.out.println(ps1.executeUpdate());
		 //caso nao esteja com autocommit igual a true,que é o default
		 //dar o comando con1.commit()'
		 mensagem=("Reserva salva com sucesso!");
		 //atualizar a interface chamando o metodo excluir
		 //excluir();
	
		}catch(Exception e1) {mensagem=("[ERROR]: Não conseguiu inserir reserva\nMessage: " + e1.getMessage());}
		return mensagem;	
	}
	
	public String Alterar_Dados_BeanReserva() 
	{	
		String mensagem="";
		//Conectar(mensagem);
		if(mensagem != "" )
			return mensagem;
		clickProximoAnterior = false;
	
	  
	    // rs1 inicia apontando para a posição 0, por isso é necessário excluir
		  // dando o comando rs1.next().
		
		try{
	
			 ps1=con1.prepareStatement("select * from reserva where cpfHosp= ? and codigoAcomodacao= ?");
			 	 		//	   ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		     ps1.setString(1,""+getCpfHosp() );
			 ps1.setString(2,""+getCodigoAcomodacao() );
		    
		     rs1= ps1.executeQuery();
		    
		    
			 if(!rs1.next()) 
			 	return ("Reserva nao encontrada na base de dados");
		
		
			 
			 ps1=con1.prepareStatement("update reserva set dataChegadaPrevista=?, horaChegadaPrevista=? , dataSaidaPrevista= ?,	horaSaidaPrevista= ?, precoDaDiaria= ?, desconto= ?, qtdeAcompanhante = ? where cpfHosp= ? and codigoAcomodacao= ?");
			 ps1.setString(1,""+getDataChegadaPrevista() );
			 ps1.setString(2,""+getHoraChegadaPrevista() );
			 ps1.setString(3,""+getDataSaidaPrevista() );
			 ps1.setString(4,""+getHoraSaidaPrevista() );
			 ps1.setString(5,""+getPrecoDaDiaria() );
			 ps1.setString(6,""+getDesconto() );
			 ps1.setString(7,""+getQtdeAcompanhante() );
			 ps1.setString(8,""+getCpfHosp() );
			 ps1.setString(9,""+getCodigoAcomodacao() );
				 
		    //System.out.println("execute update retornou"+ps1.executeUpdate());
			 if(ps1.executeUpdate() == 1 ) 
			     mensagem=("Reserva alterada com sucesso!");
			 else
				mensagem=("Reserva não recebeu nenhuma alteração!");
		}catch(Exception e1) {mensagem=("[ERROR]: Could not update\nMessage: " + e1.getMessage());}
			
			
			return mensagem;
			
			
		}
	public Date getDataChegadaPrevista() {      return dataChegadaPrevista; 	}
	public int getHoraChegadaPrevista() { 		return horaChegadaPrevista; 	}
	public Date getDataSaidaPrevista() {		return dataSaidaPrevista;	}
	public int getHoraSaidaPrevista() {	     	return horaSaidaPrevista;	}
	public int getCpfHosp() {					return cpfHosp;	}
	public int getQtdeAcompanhante() {			return qtdeAcompanhante;	}
	public int getCodigoAcomodacao() {			return codigoAcomodacao;	}
	public int getPrecoDaDiaria() {				return precoDaDiaria;	}
	public int getDesconto() {					return desconto;	}
	public int getMulta() {					    return multa;	}
	
	 
	public String Remover_BeanReserva(int cpfH) 
	{
		String mensagem="";
		//Conectar(mensagem);
		if(mensagem != "" )
			return mensagem;
		clickProximoAnterior=false;
		try{
			ps1=con1.prepareStatement("delete from reserva where cpfHosp = ?");
			ps1.setString(1,""+cpfH);
			if(ps1.executeUpdate() == 1 )
				return("Reserva excluida com sucesso!");
				else
					mensagem=("Reserva nao encontrada!");
			} catch(Exception e1) {mensagem=("[ERROR]: Could not delete\nMessage: " + e1.getMessage());}
		return mensagem;
	}

	public BeanReserva BeanReserva(Date dataChegadaPrevista, int horaChegadaPrevista, Date dataSaidaPrevista, int horaSaidaPrevista, int multa, int desconto, int cpfHosp, int codigoAcomodacao, int precoDaDiaria) 
	{
		return null;
	}

	public void BeanReserva()
	{  	
		clickProximoAnterior=false;
	}

	public void setDataChegadaPrevista(Date dataChegadaPrevista) 
	{
		this.dataChegadaPrevista = dataChegadaPrevista;
	}
	 
	public void setHoraChegadaPrevista(int horaChegadaPrevista) 
	{
		this.horaChegadaPrevista = horaChegadaPrevista;
	}
	
	public void setDataSaidaPrevista(Date dataSaidaPrevista) 
	{
		this.dataSaidaPrevista = dataSaidaPrevista;
	}
	 
	public void setMulta(int multa) 
	{
		this.multa = multa;
	}
	 
	public void setDesconto(int desconto) 
	{
		this.desconto = desconto;
	}
	 
	public void setCpfHosp(int cpfHosp) 
	{
		this.cpfHosp = cpfHosp;
	}
	 
	public void setCodigoAcomodacao(int codigoAcomodacao) 
	{
		this.codigoAcomodacao = codigoAcomodacao;
	}
	 
	public void setPrecoDaDiaria(int precoDaDiaria) 
	{
		this.precoDaDiaria = precoDaDiaria;
	}
	 
	public void setQtdeAcompanhante(int qtdeAcompanhante) 
	{
		this.qtdeAcompanhante = qtdeAcompanhante;
	}
	
	public void setHoraSaidaPrevista(int horaSaidaPrevista) 
	{
		this.horaSaidaPrevista = horaSaidaPrevista;
	}
	
	  
	public boolean verificarBeanReserva(int cpfHospede) 
	{
		return false;
	}
	 
}


 
