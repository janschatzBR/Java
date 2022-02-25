/*
 * Created on 01/06/2005
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package Inthotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class Reserva extends JFrame {


  // Objetos para acesso a banco de dados
  Connection con1;
  PreparedStatement ps1;
  ResultSet rs1;

	 
	
 JTextField jThoraChegadaPrevista = new JTextField();
 JTextField jTdataChegadaPrevista = new JTextField();
 JTextField jTdataSaidaPrevista = new JTextField();
 JTextField jThoraSaidaPrevista = new JTextField();
 JTextField jTmulta = new JTextField();
 JTextField jTdesconto = new JTextField();
 JTextField jTcpfHosp = new JTextField();
 JTextField jTcodigoAcomodacao = new JTextField();
 JTextField jTprecoDaDiaria = new JTextField();

 JLabel jLhoraChegadaPrevista = new JLabel();
 JLabel jLdataChegadaPrevista = new JLabel();
 JLabel jLdataSaidaPrevista = new JLabel();
 JLabel jLhoraSaidaPrevista = new JLabel();
 JLabel jLmulta = new JLabel();
 JLabel jLdesconto = new JLabel();
 JLabel jLcpfHosp = new JLabel();
 JLabel jLcodigoAcomodacao = new JLabel();
 JLabel jLprecoDaDiaria = new JLabel();
  
 JButton jBexcluir = new JButton();
 JButton jBanterior = new JButton();
 JButton jBproximo = new JButton();
 JButton jBlimpar = new JButton();
 JButton jBinserir = new JButton();
  
 JTextArea jTAaviso = new JTextArea();
  
  

  public Reserva() {
	super("Menu de Opções - Reservas");
	try {
	  jbInit();
	  conectar();
	  excluir();
	}
	catch(Exception e) {
	  e.printStackTrace();
	}
  }

 public static void main(String[] args) {
     Reserva reserva = new Reserva();
     reserva.show();
 }

  public void conectar () {
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
  } // fim do método excluir

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

  private void jbInit() throws Exception {

	this.setSize(new Dimension(550, 663) );
	this.setLocation( 250, 50 );
	this.addWindowListener(new Reserva_this_windowAdapter(this));
	this.getContentPane().setBackground(Color.white);
	this.setLocale(java.util.Locale.getDefault());
	this.setResizable(false);
	this.getContentPane().setLayout(null);
	


	jThoraChegadaPrevista.setSelectedTextColor(Color.white);
	jThoraChegadaPrevista.setText("");
	jThoraChegadaPrevista.setBounds(new Rectangle(200, 30, 100, 26));
	
	
	jTdataChegadaPrevista.setBounds(new Rectangle(200, 65, 100, 26));
	jTdataChegadaPrevista.setSelectedTextColor(Color.white);
	jTdataChegadaPrevista.setText("");
	
	jTdataSaidaPrevista.setBounds(new Rectangle(200, 100, 100, 26));
	jTdataSaidaPrevista.setSelectedTextColor(Color.white);
	jTdataSaidaPrevista.setText("");
	
	jThoraSaidaPrevista.setBounds(new Rectangle(200, 135, 100, 26));
	jThoraSaidaPrevista.setSelectedTextColor(Color.white);
	jThoraSaidaPrevista.setText("");
	
	
	jTmulta.setBounds(new Rectangle(200, 170, 110, 26));
   // jTmulta.setEditable(false);
	jTmulta.setSelectedTextColor(Color.white);
	jTmulta.setText("");

	jTdesconto.setBounds(new Rectangle(200, 205, 110, 26));
	jTdesconto.setSelectedTextColor(Color.white);
	jTdesconto.setText("");

	jTcpfHosp.setBounds(new Rectangle(200, 240, 150, 26));
	jTcpfHosp.setSelectedTextColor(Color.white);
	jTcpfHosp.setText("");
	
	
	jTcodigoAcomodacao.setBounds(new Rectangle(200, 275, 100, 26));
	jTcodigoAcomodacao.setSelectedTextColor(Color.white);
	jTcodigoAcomodacao.setText("");


	jTprecoDaDiaria.setBounds(new Rectangle(200, 310, 110, 26));
	jTprecoDaDiaria.setSelectedTextColor(Color.white);
	jTprecoDaDiaria.setText("");

	
	jLhoraChegadaPrevista.setFont(new java.awt.Font("Serif", 1, 15));
	jLhoraChegadaPrevista.setAlignmentX((float) 2.0);
	jLhoraChegadaPrevista.setAlignmentY((float) 1.0);
	jLhoraChegadaPrevista.setText("Hora de chegada prevista: ");
	jLhoraChegadaPrevista.setBounds(new Rectangle(25, 30, 130, 19));
	
	
	jLdataChegadaPrevista.setFont(new java.awt.Font("Serif", 1, 15));
	jLdataChegadaPrevista.setAlignmentX((float) 2.0);
	jLdataChegadaPrevista.setAlignmentY((float) 1.0);
	jLdataChegadaPrevista.setText("Data de chegada prevista: ");
	jLdataChegadaPrevista.setBounds(new Rectangle(25, 65, 130, 19));

	jLdataSaidaPrevista.setFont(new java.awt.Font("Serif", 1, 15));
	jLdataSaidaPrevista.setAlignmentX((float) 2.0);
	jLdataSaidaPrevista.setAlignmentY((float) 1.0);
	jLdataSaidaPrevista.setText("Data de saída prevista: ");
	jLdataSaidaPrevista.setBounds(new Rectangle(25, 100, 130, 19));
	
	jLhoraSaidaPrevista.setFont(new java.awt.Font("Serif", 1, 15));
	jLhoraSaidaPrevista.setAlignmentX((float) 2.0);
	jLhoraSaidaPrevista.setAlignmentY((float) 1.0);
	jLhoraSaidaPrevista.setText("Hora de saída prevista: ");
	jLhoraSaidaPrevista.setBounds(new Rectangle(25, 135, 130, 19));

	jLmulta.setFont(new java.awt.Font("Serif", 1, 15));
	jLmulta.setAlignmentX((float) 2.0);
	jLmulta.setAlignmentY((float) 1.0);
	jLmulta.setText("Multa: ");
	jLmulta.setBounds(new Rectangle(25, 170, 130, 19));

	jLdesconto.setFont(new java.awt.Font("Serif", 1, 15));
	jLdesconto.setAlignmentX((float) 2.0);
	jLdesconto.setAlignmentY((float) 1.0);
	jLdesconto.setText("Desconto: ");
	jLdesconto.setBounds(new Rectangle(25, 205, 130, 19));

	jLcpfHosp.setFont(new java.awt.Font("Serif", 1, 15));
	jLcpfHosp.setAlignmentX((float) 2.0);
	jLcpfHosp.setAlignmentY((float) 1.0);
	jLcpfHosp.setText("CPF do hóspede");
	jLcpfHosp.setBounds(new Rectangle(25, 240, 130, 19));
	
	jLcodigoAcomodacao.setFont(new java.awt.Font("Serif", 1, 15));
	jLcodigoAcomodacao.setAlignmentX((float) 2.0);
	jLcodigoAcomodacao.setAlignmentY((float) 1.0);
	jLcodigoAcomodacao.setText("Código da acomodação: ");
	jLcodigoAcomodacao.setBounds(new Rectangle(25, 275, 130, 19));
	
	jLprecoDaDiaria.setFont(new java.awt.Font("Serif", 1, 15));
	jLprecoDaDiaria.setAlignmentX((float) 2.0);
	jLprecoDaDiaria.setAlignmentY((float) 1.0);
	jLprecoDaDiaria.setText("Preço da diária: ");
	jLprecoDaDiaria.setBounds(new Rectangle(25, 310, 130, 19));
	
	jBinserir.setBounds(new Rectangle(28, 522, 73, 28));
	jBinserir.setText("Inserir");
	jBinserir.addActionListener(new Reserva_jBinserir_actionAdapter(this));
	
	jBexcluir.setBackground(Color.lightGray);
	jBexcluir.setBounds(new Rectangle(100, 522, 73, 28));
	jBexcluir.setAlignmentX((float) 0.0);
	jBexcluir.setAlignmentY((float) 0.5);
	jBexcluir.setText("Excluir");
	jBexcluir.addActionListener(new Reserva_jBexcluir_actionAdapter(this));
	
	jBanterior.setText("Anterior");
	jBanterior.addActionListener(new Reserva_jBanterior_actionAdapter(this));
	jBanterior.setBackground(Color.lightGray);
	jBanterior.setBounds(new Rectangle(172, 522, 73, 28));
	jBanterior.setAlignmentX((float) 0.0);
	jBanterior.setAlignmentY((float) 0.5);
	
	jBproximo.setText("Próximo");
	jBproximo.addActionListener(new Reserva_jBproximo_actionAdapter(this));
	jBproximo.setBackground(Color.lightGray);
	jBproximo.setBounds(new Rectangle(245, 522, 73, 28));
	jBproximo.setAlignmentX((float) 0.0);
	jBproximo.setAlignmentY((float) 0.5);
	
	jBlimpar.setText("Limpar");
	jBlimpar.addActionListener(new Reserva_jBlimpar_actionAdapter(this));
	jBlimpar.setBackground(Color.lightGray);
	jBlimpar.setBounds(new Rectangle(319, 522, 73, 28));
	jBlimpar.setAlignmentX((float) 0.0);
	jBlimpar.setAlignmentY((float) 0.5);
	
	
	jTAaviso.setBounds(new Rectangle(28, 522, 73, 28));
	
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
	
	this.getContentPane().add(jBproximo, null);
	this.getContentPane().add(jBexcluir, null);
	this.getContentPane().add(jBanterior, null);
	this.getContentPane().add(jBlimpar, null);
	this.getContentPane().add(jTAaviso, null);
	this.getContentPane().add(jBinserir, null);
	
  }

  void fechar(WindowEvent e) {
	this.setVisible(false);
  }

  void jBexcluir_actionPerformed(ActionEvent e) {

  }

  void limpar(ActionEvent e) {
	jThoraChegadaPrevista.setText( "" );
	jTdataChegadaPrevista.setText( "" );
	jTdataSaidaPrevista.setText( "" );
	jThoraSaidaPrevista.setText( "" );
	jTmulta.setText( "" );
  }

  void proximo(ActionEvent e) {
	try {
	  if (rs1.next()) {
		exibirReserva();
	  }
	  else {
		jTAaviso.setText( "\nFim da tabela" );
		rs1.previous();
	  }
	}
	catch ( Exception e1 ) {
	}
  }

  public void exibirReserva() {
	try {
	  jThoraChegadaPrevista.setText( rs1.getString( "DataInstEquip" ) );
	  jTdataChegadaPrevista.setText( rs1.getString( "HoraInstEquip" ) );
	  jTdataSaidaPrevista.setText( rs1.getString( "Nro Serie" ) );
	  jThoraSaidaPrevista.setText( rs1.getString( "HoraRemEquip" ) );
	  jTmulta.setText( rs1.getString( "IdCliente" )  );
	  jTdesconto.setText( rs1.getString( "Preco Diario" ) );
	}
	catch ( Exception e ) {
	}
  }

  void anterior(ActionEvent e) {
	try {
	  if (rs1.previous()) {
		exibirReserva ();
	  }
	  else {
		jTAaviso.setText("\nInício da tabela.");
		rs1.next();
	  }
	}
	catch ( Exception e1 ) {
	}
  }

  void inserir(ActionEvent e) {
	try{
	 // insert into Cliente(Cpf,Nome, Endereco,Telefone,Divida) values( ?,?,?,?,0)")
	 ps1=con1.prepareStatement("insert into Cliente(Cpf,Nome, Endereco,Telefone) values( ?,?,?,?)");
	 ps1.setString(1,jThoraChegadaPrevista.getText() );
	 ps1.setString(2,jLdataChegadaPrevista.getText() );
	 ps1.setString(3,jTdataSaidaPrevista.getText() );
	 ps1.setString(4,jThoraSaidaPrevista.getText() );
	 //executar a sql

	 ps1.executeUpdate();

	 //caso nao esteja com autocommit igual a true,que é o default
	 //dar o comando con1.commit()'
	 jTAaviso.setText("Reserva salvo com sucesso!");
	 //atualizar a Inthotel chamando o metodo excluir
	 excluir();

	}catch(Exception e1) {jTAaviso.setText(" Erro no inserir: Reserva ja existe");}

  }

  void jButton1_actionPerformed(ActionEvent e) {
   this.setVisible(false);
  }
}

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
	adaptee.jBexcluir_actionPerformed(e);
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

class Reserva_jButton1_actionAdapter implements java.awt.event.ActionListener {
  Reserva adaptee;

  Reserva_jButton1_actionAdapter(Reserva adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.jButton1_actionPerformed(e);
  }
}




