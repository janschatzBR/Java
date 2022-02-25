import Inhotel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.Color;
import java.sql.*;


//package Inthotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class Reserva extends JFrame {


 // Objetos para acesso a banco de dados
 /* Connection con1;
 PreparedStatement ps1;
 ResultSet rs1;*/
 ReservaBean res1;	

 //Objeto para controlar listagem (prox/anterior)
  boolean clickProximoAnterior;
  
 //caixas de texto  
 JTextField jThoraChegadaPrevista = new JTextField();
 JTextField jTdataChegadaPrevista = new JTextField();
 JTextField jTdataSaidaPrevista = new JTextField();
 JTextField jThoraSaidaPrevista = new JTextField();
 JTextField jTmulta = new JTextField();
 JTextField jTdesconto = new JTextField();
 JTextField jTcpfHosp = new JTextField();
 JTextField jTcodigoAcomodacao = new JTextField();
 JTextField jTprecoDaDiaria = new JTextField();
// JTextField jTqtdeAcompanhante = new JTextField();
 
 //labels  
 JLabel jLhoraChegadaPrevista = new JLabel();
 JLabel jLdataChegadaPrevista = new JLabel();
 JLabel jLdataSaidaPrevista = new JLabel();
 JLabel jLhoraSaidaPrevista = new JLabel();
 JLabel jLmulta = new JLabel();
 JLabel jLdesconto = new JLabel();
 JLabel jLcpfHosp = new JLabel();
 JLabel jLcodigoAcomodacao = new JLabel();
 JLabel jLprecoDaDiaria = new JLabel();
// JLabel jLqtdeAcompanhante = new JLabel();
 
 //botoes 
 JButton jBexcluir = new JButton();
 JButton jBanterior = new JButton();
 JButton jBproximo = new JButton();
 JButton jBlimpar = new JButton();
 JButton jBinserir = new JButton();
 JButton jBalterar = new JButton();
  
 JTextArea jTAaviso = new JTextArea();

 public Reserva() {
	super("Menu de Opções - Reservas");
	try {
	  jbInit();
//	  conectar();
//	  excluir();
	}
	catch(Exception e) {
	  e.printStackTrace();
	}
  }

 public static void main(String[] args) {
     Reserva reserva = new Reserva();
     reserva.show();
 }

/*  public void conectar () {
	// usando odbc
	// é obrigatório o uso de try para conexões com bd's
	try {
	  // metodo static, por isso independe da instanciação de um objeto
	  DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
	  // outra sintaxe é usando:
	  // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

	  // fazendo a conexão
	  con1 = DriverManager.getConnection( "jdbc:odbc:bdcliente","dba","sql" );
	}
	catch( Exception e) {
	  System.out.println( "Erro de conexão com o BD" );
	}
  }

  public void excluir () {
	try {
	  // ResultSet.TYPE_SCROLL_SENSITIVE permite navegação para registro anterior.
	  // Por default, só seria permitido navegar para o próximo registro.
	  // ResultSet.CONCUR_UPDATABLE permite atualizar o registro. Sem esse comando,
	  // ele permite somente leitura.
	  ps1 = con1.prepareStatement( "Select * from Cliente order by Cpf asc",
								   ResultSet.TYPE_SCROLL_SENSITIVE,
								   ResultSet.CONCUR_UPDATABLE );

	  // rs1 inicia apontando para a posição 0, por isso é necessário excluir
	  // dando o comando rs1.next().
	  rs1 = ps1.executeQuery();
	  // limpando campos: null é usado pois a função espera um evento
	  limpar( null );
	  // exibe o primeiro registro
	  proximo( null );
	}
	catch (Exception e) {
	  System.out.println( "Erro de inicializaçao" );
	}
  }
*/
  private void jbInit() throws Exception {

	this.setSize(new Dimension(600, 530) );
	this.setLocation( 250, 50 );
	this.addWindowListener(new Reserva_this_windowAdapter(this));
	this.getContentPane().setBackground(Color.gray);
	this.setLocale(java.util.Locale.getDefault());
	this.setResizable(false);
	this.getContentPane().setLayout(null);
	
	
	jThoraChegadaPrevista.setSelectedTextColor(Color.white);
	jThoraChegadaPrevista.setText("");
	jThoraChegadaPrevista.setBounds(new Rectangle(240, 30, 100, 26));
	
	
	jTdataChegadaPrevista.setBounds(new Rectangle(240, 65, 100, 26));
	jTdataChegadaPrevista.setSelectedTextColor(Color.white);
	jTdataChegadaPrevista.setText("");
	
	jTdataSaidaPrevista.setBounds(new Rectangle(240, 100, 100, 26));
	jTdataSaidaPrevista.setSelectedTextColor(Color.white);
	jTdataSaidaPrevista.setText("");
	
	jThoraSaidaPrevista.setBounds(new Rectangle(240, 135, 100, 26));
	jThoraSaidaPrevista.setSelectedTextColor(Color.white);
	jThoraSaidaPrevista.setText("");
	
	
	jTmulta.setBounds(new Rectangle(240, 170, 110, 26));
   // jTmulta.setEditable(false);
	jTmulta.setSelectedTextColor(Color.white);
	jTmulta.setText("");

	jTdesconto.setBounds(new Rectangle(240, 205, 110, 26));
	jTdesconto.setSelectedTextColor(Color.white);
	jTdesconto.setText("");

	jTcpfHosp.setBounds(new Rectangle(240, 240, 150, 26));
	jTcpfHosp.setSelectedTextColor(Color.white);
	jTcpfHosp.setText("");
	
	
	jTcodigoAcomodacao.setBounds(new Rectangle(240, 275, 100, 26));
	jTcodigoAcomodacao.setSelectedTextColor(Color.white);
	jTcodigoAcomodacao.setText("");


	jTprecoDaDiaria.setBounds(new Rectangle(240, 310, 110, 26));
	jTprecoDaDiaria.setSelectedTextColor(Color.white);
	jTprecoDaDiaria.setText("");

	//Necessário incluir acompanhante!!! Verificar posicionamento e tamanho
//	jTqtdeAcompanhante.setBounds(new Rectangle(240, 170, 110, 26));
//	jTqtdeAcompanhante.setSelectedTextColor(Color.white);
//	jTqtdeAcompanhante.setText("");
		
	jLhoraChegadaPrevista.setFont(new java.awt.Font("Serif", 1, 15));
	jLhoraChegadaPrevista.setAlignmentX((float) 2.0);
	jLhoraChegadaPrevista.setAlignmentY((float) 1.0);
	jLhoraChegadaPrevista.setText("Hora chegada prevista");
	jLhoraChegadaPrevista.setBounds(new Rectangle(25, 30, 170, 19));
	
	
	jLdataChegadaPrevista.setFont(new java.awt.Font("Serif", 1, 15));
	jLdataChegadaPrevista.setAlignmentX((float) 2.0);
	jLdataChegadaPrevista.setAlignmentY((float) 1.0);
	jLdataChegadaPrevista.setText("Data chegada prevista");
	jLdataChegadaPrevista.setBounds(new Rectangle(25, 65, 170, 19));

	jLdataSaidaPrevista.setFont(new java.awt.Font("Serif", 1, 15));
	jLdataSaidaPrevista.setAlignmentX((float) 2.0);
	jLdataSaidaPrevista.setAlignmentY((float) 1.0);
	jLdataSaidaPrevista.setText("Data de saída prevista");
	jLdataSaidaPrevista.setBounds(new Rectangle(25, 100, 170, 19));
	
	jLhoraSaidaPrevista.setFont(new java.awt.Font("Serif", 1, 15));
	jLhoraSaidaPrevista.setAlignmentX((float) 2.0);
	jLhoraSaidaPrevista.setAlignmentY((float) 1.0);
	jLhoraSaidaPrevista.setText("Hora de saída prevista");
	jLhoraSaidaPrevista.setBounds(new Rectangle(25, 135, 170, 19));

	jLmulta.setFont(new java.awt.Font("Serif", 1, 15));
	jLmulta.setAlignmentX((float) 2.0);
	jLmulta.setAlignmentY((float) 1.0);
	jLmulta.setText("Multa");
	jLmulta.setBounds(new Rectangle(25, 170, 170, 19));

	jLdesconto.setFont(new java.awt.Font("Serif", 1, 15));
	jLdesconto.setAlignmentX((float) 2.0);
	jLdesconto.setAlignmentY((float) 1.0);
	jLdesconto.setText("Desconto");
	jLdesconto.setBounds(new Rectangle(25, 205, 170, 19));

	jLcpfHosp.setFont(new java.awt.Font("Serif", 1, 15));
	jLcpfHosp.setAlignmentX((float) 2.0);
	jLcpfHosp.setAlignmentY((float) 1.0);
	jLcpfHosp.setText("CPF do hóspede");
	jLcpfHosp.setBounds(new Rectangle(25, 240, 170, 19));
	
	jLcodigoAcomodacao.setFont(new java.awt.Font("Serif", 1, 15));
	jLcodigoAcomodacao.setAlignmentX((float) 2.0);
	jLcodigoAcomodacao.setAlignmentY((float) 1.0);
	jLcodigoAcomodacao.setText("Código da acomodação");
	jLcodigoAcomodacao.setBounds(new Rectangle(25, 275, 170, 19));
	
	jLprecoDaDiaria.setFont(new java.awt.Font("Serif", 1, 15));
	jLprecoDaDiaria.setAlignmentX((float) 2.0);
	jLprecoDaDiaria.setAlignmentY((float) 1.0);
	jLprecoDaDiaria.setText("Preço da diária");
	jLprecoDaDiaria.setBounds(new Rectangle(25, 310, 170, 19));
	
	//Verificar se posicionamento e tamanho está OK!!
//	jLqtdeAcompanhante.setFont(new java.awt.Font("Serif", 1, 15));
//	jLqtdeAcompanhante.setAlignmentX((float) 2.0);
//	jLqtdeAcompanhante.setAlignmentY((float) 1.0);
//	jLqtdeAcompanhante.setText("Quant. Acompanhante");
//	jLqtdeAcompanhante.setBounds(new Rectangle(25, 345, 170, 19));
	
	jBinserir.setBounds(new Rectangle(48, 370, 73, 28));
	jBinserir.setText("Inserir");
	jBinserir.addActionListener(new Reserva_jBinserir_actionAdapter(this));
	
	jBexcluir.setBounds(new Rectangle(120, 370, 73, 28));
	jBexcluir.setAlignmentX((float) 0.0);
	jBexcluir.setAlignmentY((float) 0.5);
	jBexcluir.setText("Excluir");
	jBexcluir.addActionListener(new Reserva_jBexcluir_actionAdapter(this));
	
	jBanterior.setText("Anterior");
	jBanterior.addActionListener(new Reserva_jBanterior_actionAdapter(this));
	jBanterior.setBounds(new Rectangle(192, 370, 95, 28));
	jBanterior.setAlignmentX((float) 0.0);
	jBanterior.setAlignmentY((float) 0.5);
	
	jBproximo.setText("Próximo");
	jBproximo.addActionListener(new Reserva_jBproximo_actionAdapter(this));
	jBproximo.setBounds(new Rectangle(285, 370, 95, 28));
	jBproximo.setAlignmentX((float) 0.0);
	jBproximo.setAlignmentY((float) 0.5);
	
	jBalterar.setText("Alterar");
	jBalterar.setBounds(new Rectangle(378, 370, 73, 28));
	
	jBlimpar.setText("Limpar");
	jBlimpar.addActionListener(new Reserva_jBlimpar_actionAdapter(this));
	jBlimpar.setBounds(new Rectangle(450, 370, 85, 28));
	jBlimpar.setAlignmentX((float) 0.0);
	jBlimpar.setAlignmentY((float) 0.5);
	
	
	jTAaviso.setBounds(new Rectangle(48, 422, 490, 28));
	
	this.getContentPane().add(jLhoraChegadaPrevista, null);
	this.getContentPane().add(jThoraChegadaPrevista, null);
	this.getContentPane().add(jTdataChegadaPrevista, null);
	this.getContentPane().add(jLdataChegadaPrevista, null);
	this.getContentPane().add(jLhoraSaidaPrevista, null);
	this.getContentPane().add(jThoraSaidaPrevista, null);
	this.getContentPane().add(jLdataSaidaPrevista, null);
	this.getContentPane().add(jTdataSaidaPrevista, null);
	this.getContentPane().add(jLmulta, null);
	this.getContentPane().add(jTmulta, null);
	this.getContentPane().add(jLdesconto, null);
	this.getContentPane().add(jTdesconto, null);
	this.getContentPane().add(jLcpfHosp, null);
	this.getContentPane().add(jTcpfHosp, null);
	this.getContentPane().add(jLcodigoAcomodacao, null);
	this.getContentPane().add(jTcodigoAcomodacao, null);
	this.getContentPane().add(jLprecoDaDiaria, null);
	this.getContentPane().add(jTprecoDaDiaria, null);	
//	this.getContentPane().add(jLqtdeAcompanhante, null);
//	this.getContentPane().add(jTqtdeAcompanhante, null);
	this.getContentPane().add(jBproximo, null);
	this.getContentPane().add(jBexcluir, null);
	this.getContentPane().add(jBanterior, null);
	this.getContentPane().add(jBlimpar, null);
	this.getContentPane().add(jBinserir, null);
	this.getContentPane().add(jTAaviso, null);
	this.getContentPane().add(jBalterar, null);
	
  }

  void fechar(WindowEvent e) {
	this.setVisible(false);
  }

  /* void jBexcluir_actionPerformed(ActionEvent e) {

  }*/

  void inserir(ActionEvent e) {
  
	clickProximoAnterior=false;
	
		res1= new ReservaBean();
		res1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText()));
		res1.setDataChegadaPrevista(java.sql.Date.valueOf(jTdataChegadaPrevista.getText()));
		res1.setHoraChegadaPrevista(Integer.parseInt(jThoraChegadaPrevista.getText()));
		res1.setDataSaidaPrevista(java.sql.Date.valueOf(jTdataSaidaPrevista.getText()));
		res1.setHoraSaidaPrevista(Integer.parseInt(jThoraSaidaPrevista.getText()));
		res1.setMulta(Integer.parseInt(jTmulta.getText()));
		res1.setDesconto(Integer.parseInt(jTdesconto.getText()));
		res1.setCodigoAcomodacao(Integer.parseInt(jTcodigoAcomodacao.getText()));
		res1.setPrecoDaDiaria(Integer.parseInt(jTprecoDaDiaria.getText()));
//		res1.setQtdeAcompanhante(Integer.parseInt(jTqtdeAcompanhante.getText()));
	
		jTAaviso.setText(res1.Efetuar_Reserva());

	/*try{
	 // insert into Reserva(horaChegadaPrevista,dataChegadaPrevista,horaSaidaPrevista,dataSaidaPrevista,multa,desconto,CPFHosp,codigoAcomodacao,precoDaDiaria) values( ?,?,?,?,?,?,?,?)")
	 ps1=con1.prepareStatement("insert into Inserir(horaChegadaPrevista,dataChegadaPrevista,horaSaidaPrevista,dataSaidaPrevista,multa,desconto,CPFHosp,codigoAcomodacao,precoDaDiaria) values( ?,?,?,?,?,?,?,?)");
	 ps1.setString(1,jThoraChegadaPrevista.getText() );
	 ps1.setString(2,jLdataChegadaPrevista.getText() );
	 ps1.setString(3,jTdataSaidaPrevista.getText() );
	 ps1.setString(4,jThoraSaidaPrevista.getText() );
	 ps1.setString(5,jTmulta.getText() );
	 ps1.setString(6,jTdesconto.getText() );
	 ps1.setString(7,jTcpfHosp.getText() );
	 ps1.setString(8,jTcodigoAcomodacao.getText() );
	 ps1.setString(9,jTprecoDaDiaria.getText() );
	 //executar a sql

	 ps1.executeUpdate();

	 //caso nao esteja com autocommit igual a true,que é o default
	 //dar o comando con1.commit()'
	 jTaviso.setText("Reserva salva com sucesso!");
	 //atualizar a Inthotel chamando o metodo excluir
	 excluir();

	}catch(Exception e1) {jTaviso.setText(" Erro no inserir: Reserva ja existe");}

  }

  void jButton1_actionPerformed(ActionEvent e) {
   this.setVisible(false);
  }*/
  }

  void excluir(ActionEvent e) {
	
	clickProximoAnterior=false;

    res1= new ReservaBean();
	jTAaviso.setText(res1.Remover_ReservaBean(Integer.parseInt(jTcpfHosp.getText())));
  }
  
  void alterar(ActionEvent e) {
	
	clickProximoAnterior=false;
	
	 res1= new ReservaBean();
	 res1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText()));
	 res1.setDataChegadaPrevista(java.sql.Date.valueOf(jTdataChegadaPrevista.getText()));
	 res1.setHoraChegadaPrevista(Integer.parseInt(jThoraChegadaPrevista.getText()));
	 res1.setDataSaidaPrevista(java.sql.Date.valueOf(jTdataSaidaPrevista.getText()));
	 res1.setHoraSaidaPrevista(Integer.parseInt(jThoraSaidaPrevista.getText()));
	 res1.setMulta(Integer.parseInt(jTmulta.getText()));
	 res1.setDesconto(Integer.parseInt(jTdesconto.getText()));
	 res1.setCodigoAcomodacao(Integer.parseInt(jTcodigoAcomodacao.getText()));
	 res1.setPrecoDaDiaria(Integer.parseInt(jTprecoDaDiaria.getText()));
	 //res1.setQtdeAcompanhante(Integer.parseInt(jTqtdeAcompanhante.getText()));
	 jTAaviso.setText(res1.Alterar_Dados_ReservaBean());
 }	
  
 void limpar(ActionEvent e) {
	jThoraChegadaPrevista.setText( "" );
	jTdataChegadaPrevista.setText( "" );
	jTdataSaidaPrevista.setText( "" );
	jThoraSaidaPrevista.setText( "" );
	jTmulta.setText( "" );
	jTdesconto.setText("");
	jTcpfHosp.setText("");
	jTcodigoAcomodacao.setText("");
	jTprecoDaDiaria.setText("");
//	jTqtdeAcompanhante.setText("");
  }

 void proximo(ActionEvent e) {
  	if(!clickProximoAnterior)
  	{
  			res1 = new ReservaBean();
  			clickProximoAnterior=true;
  	}
  	
  	String mensagem = 	res1.Proximo();
  	if(mensagem.equals("Proximo ok")) 
  		exibirReserva();
  		
  	else
  		jTAaviso.setText(mensagem);
 /*	try {
	  if (rs1.next()) {
		exibirReserva();
	  }
	  else {
		jTaviso.setText( "\nFim da tabela" );
		rs1.previous();
	  }
	}
	catch ( Exception e1 ) {
	}
  }*/
 }
 
   void anterior(ActionEvent e) {
	if(!clickProximoAnterior)
	{
		res1 = new  ReservaBean();
		clickProximoAnterior=true;
	}
	
  	String mensagem = 	res1.Anterior();
  	if(mensagem.equals("Anterior ok")) 
  		exibirReserva();
  		//PROCURAR EXIBIR RESERVA()
  	else
  		jTAaviso.setText(mensagem);

	/*try {
	  if (rs1.previous()) {
		exibirReserva ();
	  }
	  else {
		jTaviso.setText("\nInício da tabela.");
		rs1.next();
	  }
	}
	catch ( Exception e1 ) {
	}
   }*/
   }

  public void exibirReserva() {
	try {
	  jTcpfHosp.setText(""+res1.getCpfHosp() );
	  jTdataChegadaPrevista.setText(""+ res1.getDataChegadaPrevista() );
	  jThoraChegadaPrevista.setText(""+ res1.getHoraChegadaPrevista() );
	  jTdataSaidaPrevista.setText(""+ res1.getDataSaidaPrevista() );
	  jThoraSaidaPrevista.setText(""+ res1.getHoraSaidaPrevista()  );
	  //jTqtdeAcompanhante.setText(""+ est1.getQtdeAcompanhante()  ); 
      jTcodigoAcomodacao.setText(""+ res1.getCodigoAcomodacao()  ); 
      jTprecoDaDiaria.setText(""+ res1.getPrecoDaDiaria() ); 
      jTdesconto.setText(""+ res1.getDesconto() )  ; 
      jTAaviso.setText("");
	  	 	  
	}catch(Exception e1) {jTAaviso.setText("[ERROR]: Exibir Reserva: \n" + e1.getMessage());}
  }
	/*try {
	  jThoraChegadaPrevista.setText( rs1.getString( "HoraChegadaPrevista" ) );
	  jTdataChegadaPrevista.setText( rs1.getString( "DataChegadaPrevista" ) );
	  jTdataSaidaPrevista.setText( rs1.getString( "DataSaidaPrevista" ) );
	  jThoraSaidaPrevista.setText( rs1.getString( "HoraSaidaPrevista" ) );
	  jTmulta.setText( rs1.getString( "multa" )  );
	  jTdesconto.setText( rs1.getString( "desconto" ) );
	  jTcpfHosp.setText( rs1.getString( "CPFHospede" ) );
	  jTcodigoAcomodacao.setText("codigoAcomodacao");
	  jTprecoDaDiaria.setText("precoDaDiaria");
	}
	catch ( Exception e )  {
		jTAaviso.setText("[ERROR]: Exibir Reserva: \n" + e1.getMessage());}
 }*/


class Reserva_this_windowAdapter extends java.awt.event.WindowAdapter {
  Reserva adaptee;

  Reserva_this_windowAdapter(Reserva adaptee) {
	this.adaptee = adaptee;
  }
  public void windowClosing(WindowEvent e) {
	adaptee.fechar(e);
  }
}

class Reserva_jBexcluir_actionAdapter implements java.awt.event.ActionListener {
  Reserva adaptee;

  Reserva_jBexcluir_actionAdapter(Reserva adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.excluir(e);
  }
}

class Reserva_jBlimpar_actionAdapter implements java.awt.event.ActionListener {
  Reserva adaptee;

  Reserva_jBlimpar_actionAdapter(Reserva adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.limpar(e);
  }
}

class Reserva_jBproximo_actionAdapter implements java.awt.event.ActionListener {
  Reserva adaptee;

  Reserva_jBproximo_actionAdapter(Reserva adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.proximo(e);
  }
}

class Reserva_jBanterior_actionAdapter implements java.awt.event.ActionListener {
  Reserva adaptee;

  Reserva_jBanterior_actionAdapter(Reserva adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.anterior(e);
  }
}

class Reserva_jBinserir_actionAdapter implements java.awt.event.ActionListener {
  Reserva adaptee;

  Reserva_jBinserir_actionAdapter(Reserva adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.inserir(e);
  }
}

class Reserva_jBalterar_actionAdapter implements java.awt.event.ActionListener {
  Reserva adaptee;

  Reserva_jBalterar_actionAdapter(Reserva adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.inserir(e);
  }
}
}