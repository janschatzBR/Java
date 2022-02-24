/*
 * Created on 01/06/2005
 *
 * author: Jan P. B. Schatz
 *
 */
 
package Inthotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class Estadia extends JFrame {


  // Objetos para acesso a banco de dados
  Connection con1;
  PreparedStatement ps1;
  ResultSet rs1;


  JTextField jTdataCheckIn = new JTextField();
  JTextField jThoraCheckIn = new JTextField();
  JTextField jTdataSaidaPrevista = new JTextField();
  JTextField jThoraSaidaPrevista = new JTextField();
  JTextField jTCPFHosp = new JTextField();
  JTextField jTqtdeAcompanhante = new JTextField();
  JTextField jTcodigoAcomodacao = new JTextField();
  JTextField jTprecoDaDiaria = new JTextField();
  JTextField jTdesconto = new JTextField();
  JTextField jTdataCheckOut = new JTextField();
  JTextField jThoraCheckOut = new JTextField();

  JLabel jLdataCheckIn = new JLabel();
  JLabel jLhoraCheckIn = new JLabel();
  JLabel jLdataSaidaPrevista = new JLabel();
  JLabel jLhoraSaidaPrevista = new JLabel();
  JLabel jLCPFHosp = new JLabel();
  JLabel jLqtdeAcompanhante = new JLabel();
  JLabel jLcodigoAcomodacao = new JLabel();
  JLabel jLprecoDaDiaria = new JLabel();
  JLabel jLdesconto = new JLabel();
  JLabel jLdataCheckOut = new JLabel();
  JLabel jLhoraCheckOut = new JLabel();

  JButton jBinserir = new JButton();
  JButton jBexcluir = new JButton();
  JButton jBanterior = new JButton();
  JButton jBproximo = new JButton();
  JButton jBlimpar = new JButton();

  JTextArea jTAaviso = new JTextArea();

  public Estadia() {
	super("Menu de Opções - Estadias");
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
      Estadia Estadia = new Estadia();
      Estadia.show();
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
	  System.out.println( "Erro de inicializacao" );
	}
  }

  private void jbInit() throws Exception {

	this.setSize(new Dimension(448, 663) );
	this.setLocation( 250, 50 );
	this.addWindowListener(new Estadia_this_windowAdapter(this));

	this.getContentPane().setBackground(Color.white);
	this.setLocale(java.util.Locale.getDefault());
	this.setResizable(false);
	this.getContentPane().setLayout(null);
	
	
	jLdataCheckIn.setFont(new java.awt.Font("Serif", 1, 15));
	jLdataCheckIn.setAlignmentX((float) 2.0);
	jLdataCheckIn.setAlignmentY((float) 1.0);
	jLdataCheckIn.setText("Data do check-in");
	jLdataCheckIn.setBounds(new Rectangle(25, 30, 170, 19));
		
	jLhoraCheckIn.setFont(new java.awt.Font("Serif", 1, 15));
	jLhoraCheckIn.setAlignmentX((float) 2.0);
	jLhoraCheckIn.setAlignmentY((float) 1.0);
	jLhoraCheckIn.setText("Hora do check-in");
	jLhoraCheckIn.setBounds(new Rectangle(25, 65, 170, 19));

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

	jLCPFHosp.setFont(new java.awt.Font("Serif", 1, 15));
	jLCPFHosp.setAlignmentX((float) 2.0);
	jLCPFHosp.setAlignmentY((float) 1.0);
	jLCPFHosp.setText("CPF do hóspede");
	jLCPFHosp.setBounds(new Rectangle(25, 170, 170, 19));

	jLqtdeAcompanhante.setFont(new java.awt.Font("Serif", 1, 15));
	jLqtdeAcompanhante.setAlignmentX((float) 2.0);
	jLqtdeAcompanhante.setAlignmentY((float) 1.0);
	jLqtdeAcompanhante.setText("Quantidade de acompanhantes");
	jLqtdeAcompanhante.setBounds(new Rectangle(25, 205, 200, 19));
	
	jLcodigoAcomodacao.setFont(new java.awt.Font("Serif", 1, 15));
	jLcodigoAcomodacao.setAlignmentX((float) 2.0);
	jLcodigoAcomodacao.setAlignmentY((float) 1.0);
	jLcodigoAcomodacao.setText("Código da acomodação");
	jLcodigoAcomodacao.setBounds(new Rectangle(25, 240, 170, 19));
	
	jLprecoDaDiaria.setFont(new java.awt.Font("Serif", 1, 15));
	jLprecoDaDiaria.setAlignmentX((float) 2.0);
	jLprecoDaDiaria.setAlignmentY((float) 1.0);
	jLprecoDaDiaria.setText("Preço da diária");
	jLprecoDaDiaria.setBounds(new Rectangle(25, 275, 170, 19));
	
	jLdesconto.setFont(new java.awt.Font("Serif", 1, 15));
	jLdesconto.setAlignmentX((float) 2.0);
	jLdesconto.setAlignmentY((float) 1.0);
	jLdesconto.setText("Desconto");
	jLdesconto.setBounds(new Rectangle(25, 310, 170, 19));
	
	jLdataCheckOut.setFont(new java.awt.Font("Serif", 1, 15));
	jLdataCheckOut.setAlignmentX((float) 2.0);
	jLdataCheckOut.setAlignmentY((float) 1.0);
	jLdataCheckOut.setText("Data do check-out");
	jLdataCheckOut.setBounds(new Rectangle(25, 345, 170, 19));
	
	jLhoraCheckOut.setFont(new java.awt.Font("Serif", 1, 15));
	jLhoraCheckOut.setAlignmentX((float) 2.0);
	jLhoraCheckOut.setAlignmentY((float) 1.0);
	jLhoraCheckOut.setText("Hora do check-out");
	jLhoraCheckOut.setBounds(new Rectangle(25, 380, 170, 19));
		
	
	jTdataCheckIn.setBounds(new Rectangle(240, 30, 100, 26));
	jTdataCheckIn.setSelectedTextColor(Color.white);
	jTdataCheckIn.setText("");
			
	jThoraCheckIn.setBounds(new Rectangle(240, 65, 50, 26));
	jThoraCheckIn.setSelectedTextColor(Color.white);
	jThoraCheckIn.setText("");
	
	jTdataSaidaPrevista.setBounds(new Rectangle(240, 100, 100, 26));
	jTdataSaidaPrevista.setSelectedTextColor(Color.white);
	jTdataSaidaPrevista.setText("");

	jThoraSaidaPrevista.setBounds(new Rectangle(240, 135, 50, 26));
    // jThoraSaidaPrevista.setEditable(false);
	jThoraSaidaPrevista.setSelectedTextColor(Color.white);
	jThoraSaidaPrevista.setText("");

	jTCPFHosp.setBounds(new Rectangle(240, 170, 150, 26));
	jTCPFHosp.setSelectedTextColor(Color.white);
	jTCPFHosp.setText("");

	jTqtdeAcompanhante.setBounds(new Rectangle(240, 205, 50, 26));
	jTqtdeAcompanhante.setSelectedTextColor(Color.white);
	jTqtdeAcompanhante.setText("");
	
	jTcodigoAcomodacao.setBounds(new Rectangle(240, 240, 100, 26));
	jTcodigoAcomodacao.setSelectedTextColor(Color.white);
	jTcodigoAcomodacao.setText("");

	jTprecoDaDiaria.setBounds(new Rectangle(240, 275, 110, 26));
	jTprecoDaDiaria.setSelectedTextColor(Color.white);
	jTprecoDaDiaria.setText("");

	jTdesconto.setBounds(new Rectangle(240, 310, 110, 26));
	jTdesconto.setSelectedTextColor(Color.white);
	jTdesconto.setText("");

	jTdataCheckOut.setBounds(new Rectangle(240, 345, 100, 26));
	jTdataCheckOut.setSelectedTextColor(Color.white);
	jTdataCheckOut.setText("");
	
	jThoraCheckOut.setBounds(new Rectangle(240, 380, 50, 26));
	jThoraCheckOut.setSelectedTextColor(Color.white);
	jThoraCheckOut.setText("");


	jBinserir.setBounds(new Rectangle(319, 522, 73, 28));
	jBinserir.setText("Inserir");
	jBinserir.addActionListener(new Estadia_jBinserir_actionAdapter(this));
	
	jBexcluir.setBackground(Color.lightGray);
	jBexcluir.setBounds(new Rectangle(28, 522, 73, 28));
	jBexcluir.setAlignmentX((float) 0.0);
	jBexcluir.setAlignmentY((float) 0.5);
	jBexcluir.setText("Excluir");
	jBexcluir.addActionListener(new Estadia_jBexcluir_actionAdapter(this));
	
	jBanterior.setText("Anterior");
	jBanterior.addActionListener(new Estadia_jBanterior_actionAdapter(this));
	jBanterior.setBackground(Color.lightGray);
	jBanterior.setBounds(new Rectangle(100, 522, 73, 28));
	jBanterior.setAlignmentX((float) 0.0);
	jBanterior.setAlignmentY((float) 0.5);
	
	jBproximo.setText("Próximo");
	jBproximo.addActionListener(new Estadia_jBproximo_actionAdapter(this));
	jBproximo.setBackground(Color.lightGray);
	jBproximo.setBounds(new Rectangle(172, 522, 73, 28));
	jBproximo.setAlignmentX((float) 0.0);
	jBproximo.setAlignmentY((float) 0.5);
	
	jBlimpar.setText("Limpar");
	jBlimpar.addActionListener(new Estadia_jBlimpar_actionAdapter(this));
	jBlimpar.setBackground(Color.lightGray);
	jBlimpar.setBounds(new Rectangle(245, 522, 73, 28));
	jBlimpar.setAlignmentX((float) 0.0);
	jBlimpar.setAlignmentY((float) 0.5);
		
	
	jTAaviso.setBounds(new Rectangle(28, 552, 365, 41));
	
	
	this.getContentPane().add(jLdataCheckIn, null);
	this.getContentPane().add(jTdataCheckIn, null);
	this.getContentPane().add(jThoraCheckIn, null);
	this.getContentPane().add(jLhoraCheckIn, null);
	
	this.getContentPane().add(jLdataSaidaPrevista, null);
	this.getContentPane().add(jTdataSaidaPrevista, null);
	this.getContentPane().add(jLhoraSaidaPrevista, null);
	this.getContentPane().add(jThoraSaidaPrevista, null);
	this.getContentPane().add(jLCPFHosp, null);
	this.getContentPane().add(jTCPFHosp, null);
	this.getContentPane().add(jLqtdeAcompanhante, null);
	this.getContentPane().add(jTqtdeAcompanhante, null);
	this.getContentPane().add(jLcodigoAcomodacao, null);
	this.getContentPane().add(jTcodigoAcomodacao, null);
	this.getContentPane().add(jLprecoDaDiaria, null);
	this.getContentPane().add(jTprecoDaDiaria, null);
	this.getContentPane().add(jLdesconto, null);
	this.getContentPane().add(jTdesconto, null);
	this.getContentPane().add(jLdataCheckOut, null);
	this.getContentPane().add(jTdataCheckOut, null);
	this.getContentPane().add(jThoraCheckOut, null);
	this.getContentPane().add(jLhoraCheckOut, null);

    this.getContentPane().add(jBinserir, null);
	this.getContentPane().add(jBexcluir, null);
	this.getContentPane().add(jBanterior, null);
	this.getContentPane().add(jBproximo, null);
	this.getContentPane().add(jBlimpar, null);
	this.getContentPane().add(jTAaviso, null);
  }

  void fechar(WindowEvent e) {
	this.setVisible(false);
  }

  void inserir(ActionEvent e) {
	try{
	 // insert into Cliente(Cpf,Nome, Endereco,Telefone,Divida) values( ?,?,?,?,0)")
	 ps1=con1.prepareStatement("insert into Cliente(Cpf,Nome, Endereco,Telefone) values( ?,?,?,?)");
	 ps1.setString(1,jTdataCheckIn.getText() );
	 ps1.setString(2,jLhoraCheckIn.getText() );
	 ps1.setString(3,jTdataSaidaPrevista.getText() );
	 //executar a sql

	 ps1.executeUpdate();

	 //caso nao esteja com autocommit igual a true,que é o default
	 //dar o comando con1.commit()'
	 jTAaviso.setText("Estadia salvo com sucesso!");
	 //atualizar a interface chamando o metodo excluir
	 excluir();

	}catch(Exception e1) {jTAaviso.setText(" Erro no inserir: Estadia ja existe");}
  }

  void jBexcluir_actionPerformed(ActionEvent e) {

  }

  void limpar(ActionEvent e) {
	jTdataCheckIn.setText( "" );
	jThoraCheckIn.setText( "" );
	jTdataSaidaPrevista.setText( "" );
	jThoraSaidaPrevista.setText( "" );
  }

  void proximo(ActionEvent e) {
	try {
	  if (rs1.next()) {
		exibirEstadia();
	  }
	  else {
		jTAaviso.setText( "\nFim da tabela" );
		rs1.previous();
	  }
	}
	catch ( Exception e1 ) {
	}
  }

  public void exibirEstadia() {
	try {
	  jTdataCheckIn.setText( rs1.getString( "dataCheckIn" ) );
	  jThoraCheckIn.setText( rs1.getString( "horaCheckIn" ) );
	  jTdataSaidaPrevista.setText( rs1.getString( "Nro Serie" ) );
	  jThoraSaidaPrevista.setText( rs1.getString( "horaSaidaPrevista" )  );
	  jTCPFHosp.setText( rs1.getString( "Preco Diario" ) );
	}
	catch ( Exception e ) {
	}
  }

  void anterior(ActionEvent e) {
	try {
	  if (rs1.previous()) {
		exibirEstadia ();
	  }
	  else {
		jTAaviso.setText("\nInício da tabela.");
		rs1.next();
	  }
	}
	catch ( Exception e1 ) {
	}
  }
}

class Estadia_this_windowAdapter extends java.awt.event.WindowAdapter {
  Estadia adaptee;

  Estadia_this_windowAdapter(Estadia adaptee) {
	this.adaptee = adaptee;
  }
  public void windowClosing(WindowEvent e) {
	adaptee.fechar(e);
  }
}

class Estadia_jBinserir_actionAdapter implements java.awt.event.ActionListener {
  Estadia adaptee;

  Estadia_jBinserir_actionAdapter(Estadia adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.inserir(e);
  }
}

class Estadia_jBexcluir_actionAdapter implements java.awt.event.ActionListener {
  Estadia adaptee;

  Estadia_jBexcluir_actionAdapter(Estadia adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.jBexcluir_actionPerformed(e);
  }
}

class Estadia_jBanterior_actionAdapter implements java.awt.event.ActionListener {
  Estadia adaptee;

  Estadia_jBanterior_actionAdapter(Estadia adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.anterior(e);
  }
}

class Estadia_jBproximo_actionAdapter implements java.awt.event.ActionListener {
  Estadia adaptee;

  Estadia_jBproximo_actionAdapter(Estadia adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.proximo(e);
  }
}

class Estadia_jBlimpar_actionAdapter implements java.awt.event.ActionListener {
  Estadia adaptee;

  Estadia_jBlimpar_actionAdapter(Estadia adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.limpar(e);
  }
}




