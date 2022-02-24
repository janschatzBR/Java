import Inhotel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class Reserva extends JFrame 
{
 
 // Objetos para acesso a banco de dados
 BeanReserva res1;	
 BeanAcomodacao acom1;
 BeanHospede hosp1;
 
 //Objeto para controlar listagem (prox/anterior)
 boolean clickProximoAnterior;
  
 //caixas de texto  
 private JTextField jThoraChegadaPrevista = new JTextField();
 private JTextField jTdataChegadaPrevista = new JTextField();
 private JTextField jTdataSaidaPrevista = new JTextField();
 private JTextField jThoraSaidaPrevista = new JTextField();
 private JTextField jTmulta = new JTextField();
 private JTextField jTdesconto = new JTextField();
 private JTextField jTcpfHosp = new JTextField();
 private JTextField jTcodigoAcomodacao = new JTextField();
 private JTextField jTprecoDaDiaria = new JTextField();
 private JTextField jTqtdeAcompanhante = new JTextField();
 
 //labels  
 private JLabel jLhoraChegadaPrevista = new JLabel();
 private JLabel jLdataChegadaPrevista = new JLabel();
 private JLabel jLdataSaidaPrevista = new JLabel();
 private JLabel jLhoraSaidaPrevista = new JLabel();
 private JLabel jLmulta = new JLabel();
 private JLabel jLdesconto = new JLabel();
 private JLabel jLcpfHosp = new JLabel();
 private JLabel jLcodigoAcomodacao = new JLabel();
 private JLabel jLprecoDaDiaria = new JLabel();
 private JLabel jLqtdeAcompanhante = new JLabel();
 
 //botoes 
 private JButton jBexcluir = new JButton();
 private JButton jBanterior = new JButton();
 private JButton jBproximo = new JButton();
 private JButton jBlimpar = new JButton();
 private JButton jBinserir = new JButton();
 private JButton jBalterar = new JButton();
 private JButton jBgerarEstadia = new JButton();
 private JButton jBacomodacao = new JButton();
 private JButton jBhospede = new JButton();
 private JButton jBverificaAcomodacao = new JButton();
 private JTextArea jTAaviso = new JTextArea();

 public Reserva() 
 {
	super("Menu de Opções - Reservas");
	
	try 
	{
	  jbInit();
	}
	catch(Exception e) 
	{
	  e.printStackTrace();
	}
 }

 private void jbInit() throws Exception 
 {
    this.setSize(new Dimension(620, 570) );
	this.setLocation( 250, 50 );
	this.addWindowListener(new Reserva_this_windowAdapter(this));
	this.getContentPane().setBackground(Color.gray);
	this.setLocale(java.util.Locale.getDefault());
	this.setResizable(false);
	this.getContentPane().setLayout(null);
	
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
	
	jLqtdeAcompanhante.setFont(new java.awt.Font("Serif", 1, 15));
	jLqtdeAcompanhante.setAlignmentX((float) 2.0);
	jLqtdeAcompanhante.setAlignmentY((float) 1.0);
	jLqtdeAcompanhante.setText("Qtde Acompanhantes");
	jLqtdeAcompanhante.setBounds(new Rectangle(25, 345, 170, 19));
	
	jThoraChegadaPrevista.setText("");
	jThoraChegadaPrevista.setBounds(new Rectangle(240, 30, 100, 26));
	
	jTdataChegadaPrevista.setBounds(new Rectangle(240, 65, 100, 26));
	jTdataChegadaPrevista.setText("");
	
	jTdataSaidaPrevista.setBounds(new Rectangle(240, 100, 100, 26));
	jTdataSaidaPrevista.setText("");
	
	jThoraSaidaPrevista.setBounds(new Rectangle(240, 135, 100, 26));
	jThoraSaidaPrevista.setText("");
		
	jTmulta.setBounds(new Rectangle(240, 170, 110, 26));
	jTmulta.setText("");

	jTdesconto.setBounds(new Rectangle(240, 205, 110, 26));
	jTdesconto.setText("");

	jTcpfHosp.setBounds(new Rectangle(240, 240, 150, 26));
	jTcpfHosp.setSelectedTextColor(Color.white);
	jTcpfHosp.setText("0");
		
	jTcodigoAcomodacao.setBounds(new Rectangle(240, 275, 100, 26));
	jTcodigoAcomodacao.setText("0");

	jTprecoDaDiaria.setBounds(new Rectangle(240, 310, 110, 26));
	jTprecoDaDiaria.setText("");
	
	jTqtdeAcompanhante.setBounds(new Rectangle(240,345, 110, 26));
	jTqtdeAcompanhante.setText("");
	
	jBgerarEstadia.setBounds(new Rectangle(450, 310, 140, 26));
	jBgerarEstadia.setText("Gerar Estadia");
	jBgerarEstadia.addActionListener(new Reserva_jBgerarEstadia_actionAdapter(this));
	
	jBinserir.setBounds(new Rectangle(48, 390, 73, 28));
	jBinserir.setText("Inserir");
	jBinserir.addActionListener(new Reserva_jBinserir_actionAdapter(this));
	
	jBexcluir.setBounds(new Rectangle(120, 390, 73, 28));
	jBexcluir.setAlignmentX((float) 0.0);
	jBexcluir.setAlignmentY((float) 0.5);
	jBexcluir.setText("Excluir");
	jBexcluir.addActionListener(new Reserva_jBexcluir_actionAdapter(this));
	
	jBanterior.setText("Anterior");
	jBanterior.addActionListener(new Reserva_jBanterior_actionAdapter(this));
	jBanterior.setBounds(new Rectangle(192, 390, 95, 28));
	jBanterior.setAlignmentX((float) 0.0);
	jBanterior.setAlignmentY((float) 0.5);
	
	jBproximo.setText("Próximo");
	jBproximo.addActionListener(new Reserva_jBproximo_actionAdapter(this));
	jBproximo.setBounds(new Rectangle(285, 390, 95, 28));
	jBproximo.setAlignmentX((float) 0.0);
	jBproximo.setAlignmentY((float) 0.5);
	
	jBalterar.setText("Alterar");
	jBalterar.setBounds(new Rectangle(378, 390, 73, 28));
	jBalterar.addActionListener(new Reserva_jBalterar_actionAdapter(this));
	
	jBlimpar.setText("Limpar");
	jBlimpar.addActionListener(new Reserva_jBlimpar_actionAdapter(this));
	jBlimpar.setBounds(new Rectangle(450, 390, 85, 28));
	jBlimpar.setAlignmentX((float) 0.0);
	jBlimpar.setAlignmentY((float) 0.5);
	
	jBacomodacao.setBounds(new Rectangle(450, 275, 140, 26));
	jBacomodacao.setText("Acomodacao");
	jBacomodacao.addActionListener(new Reserva_jBacomodacao_actionAdapter(this));
	
	jBhospede.setBounds(new Rectangle(450, 170, 120, 26));
	jBhospede.setText("Hospede");
	jBhospede.addActionListener(new Reserva_jBhospede_actionAdapter(this));
	
	jBverificaAcomodacao.setBounds(new Rectangle(425, 205, 162, 26));
	jBverificaAcomodacao.setText("Verificar Acomodacao");
	jBverificaAcomodacao.addActionListener(new Reserva_jBverificaAcomodacao_actionAdapter(this));
	
	jTAaviso.setBounds(new Rectangle(48, 422, 490, 78));
	
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
	this.getContentPane().add(jLqtdeAcompanhante, null);
	this.getContentPane().add(jTqtdeAcompanhante, null);
	
	this.getContentPane().add(jBproximo, null);
	this.getContentPane().add(jBexcluir, null);
	this.getContentPane().add(jBanterior, null);
	this.getContentPane().add(jBlimpar, null);
	this.getContentPane().add(jBinserir, null);
	this.getContentPane().add(jTAaviso, null);
	this.getContentPane().add(jBalterar, null);
	this.getContentPane().add(jBgerarEstadia, null);
	this.getContentPane().add(jBacomodacao, null);
	this.getContentPane().add(jBhospede, null);
	this.getContentPane().add(jBverificaAcomodacao, null);	
  }

  void fechar(WindowEvent e) {
	this.setVisible(false);
  }
  
  void verificaAcomodacao() throws SQLException
  {
  	
	acom1 = new BeanAcomodacao();
	acom1.setCodigoAcomodacao(Integer.parseInt(jTcodigoAcomodacao.getText()));
	String mensagem = acom1.VerificarAcomodacao();
	if (mensagem.equals("temvalor"))
		jTAaviso.setText("Acomodacao disponivel! ");
	else
		jTAaviso.setText("Acomodacao nao disponivel");
  }
  


  void inserir(ActionEvent e) {
  
	clickProximoAnterior=false;
	
		res1= new BeanReserva();
		res1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText()));
		res1.setDataChegadaPrevista(java.sql.Date.valueOf(jTdataChegadaPrevista.getText()));
		res1.setHoraChegadaPrevista(Integer.parseInt(jThoraChegadaPrevista.getText()));
		res1.setDataSaidaPrevista(java.sql.Date.valueOf(jTdataSaidaPrevista.getText()));
		res1.setHoraSaidaPrevista(Integer.parseInt(jThoraSaidaPrevista.getText()));
		res1.setMulta(Integer.parseInt(jTmulta.getText()));
		res1.setDesconto(Integer.parseInt(jTdesconto.getText()));
		res1.setCodigoAcomodacao(Integer.parseInt(jTcodigoAcomodacao.getText()));
		res1.setPrecoDaDiaria(Integer.parseInt(jTprecoDaDiaria.getText()));
		res1.setQtdeAcompanhante(Integer.parseInt(jTqtdeAcompanhante.getText()));
	
		jTAaviso.setText(res1.Efetuar_Reserva());

  }

  void excluir(ActionEvent e) {
	
	clickProximoAnterior=false;

    res1= new BeanReserva();
	jTAaviso.setText(res1.Remover_BeanReserva(Integer.parseInt(jTcpfHosp.getText())));
  }
  
  void alterar(ActionEvent e) {
	
	clickProximoAnterior=false;
	
	 res1= new BeanReserva();
	 res1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText()));
	 res1.setDataChegadaPrevista(java.sql.Date.valueOf(jTdataChegadaPrevista.getText()));
	 res1.setHoraChegadaPrevista(Integer.parseInt(jThoraChegadaPrevista.getText()));
	 res1.setDataSaidaPrevista(java.sql.Date.valueOf(jTdataSaidaPrevista.getText()));
	 res1.setHoraSaidaPrevista(Integer.parseInt(jThoraSaidaPrevista.getText()));
	 res1.setMulta(Integer.parseInt(jTmulta.getText()));
	 res1.setDesconto(Integer.parseInt(jTdesconto.getText()));
	 res1.setCodigoAcomodacao(Integer.parseInt(jTcodigoAcomodacao.getText()));
	 res1.setPrecoDaDiaria(Integer.parseInt(jTprecoDaDiaria.getText()));
	 res1.setQtdeAcompanhante(Integer.parseInt(jTqtdeAcompanhante.getText()));
	 jTAaviso.setText(res1.Alterar_Dados_BeanReserva());
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
	jTqtdeAcompanhante.setText("");
  }

 void proximo(ActionEvent e) {
  	if(!clickProximoAnterior)
  	{
  			res1 = new BeanReserva();
  			clickProximoAnterior=true;
  	}
  	
  	String mensagem = 	res1.Proximo();
  	if(mensagem.equals("Proximo ok")) 
  		exibirReserva();
  		
  	else
  		jTAaviso.setText(mensagem);
 }
 
   void anterior(ActionEvent e) {
	if(!clickProximoAnterior)
	{
		res1 = new  BeanReserva();
		clickProximoAnterior=true;
	}
	
  	String mensagem = 	res1.Anterior();
  	if(mensagem.equals("Anterior ok")) 
  		exibirReserva();
  	else
  		jTAaviso.setText(mensagem);

   }

  public void exibirReserva() {
	try {
	  jTcpfHosp.setText(""+res1.getCpfHosp() );
	  jTdataChegadaPrevista.setText(""+ res1.getDataChegadaPrevista() );
	  jThoraChegadaPrevista.setText(""+ res1.getHoraChegadaPrevista() );
	  jTdataSaidaPrevista.setText(""+ res1.getDataSaidaPrevista() );
	  jThoraSaidaPrevista.setText(""+ res1.getHoraSaidaPrevista()  );
	  jTqtdeAcompanhante.setText(""+ res1.getQtdeAcompanhante()  ); 
      jTcodigoAcomodacao.setText(""+ res1.getCodigoAcomodacao()  ); 
      jTprecoDaDiaria.setText(""+ res1.getPrecoDaDiaria() ); 
      jTdesconto.setText(""+ res1.getDesconto() )  ; 
      jTmulta.setText(""+ res1.getMulta() )  ; 
      
      jTAaviso.setText("");
	  	 	  
	}catch(Exception e1) {jTAaviso.setText("[ERROR]: Exibir Reserva: \n" + e1.getMessage());}
  }
	
	
	public void gerarEstadia() throws NumberFormatException, Exception
	{
		Estadia Estadia = new Estadia(Integer.parseInt(jTcpfHosp.getText())
		,Integer.parseInt(jTprecoDaDiaria.getText())
		,Integer.parseInt(jTdesconto.getText())
		,Integer.parseInt(jTcodigoAcomodacao.getText())
		,Integer.parseInt(jTqtdeAcompanhante.getText())
	    ,java.sql.Date.valueOf(jTdataSaidaPrevista.getText())
        ,Integer.parseInt(jThoraSaidaPrevista.getText())
		);
        Estadia.show();
		
	}
	
	
	void acomodacao(ActionEvent e) throws Exception 
	{
  	
    
  	clickProximoAnterior=false;
  	int teste2 =Integer.parseInt(jTcpfHosp.getText());
  	
  	int codigo= Integer.parseInt(jTcodigoAcomodacao.getText());
  	Acomodacao acomodacao = new Acomodacao(codigo);//teste2);
  	acomodacao.show();
//  	codigo = acomodacao.salvarNro();
  	jTcodigoAcomodacao.setText(""+codigo);

 	//System.out.println(teste);
  	
  	   
    }
    
 void hospede(ActionEvent e) 
	{
  	
   	hosp1 = new BeanHospede();
    hosp1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText()));
    String mensagem = hosp1.VerificaHospede();
    
    jTAaviso.setText(mensagem);
    if (mensagem.equals("temvalor"))
    	jTAaviso.setText("Hospede encontrado no banco de dados");
   else
   		jTAaviso.setText("Hospede nao cadastrado");
  	   
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
	adaptee.alterar(e);
  }
}



class Reserva_jBgerarEstadia_actionAdapter implements java.awt.event.ActionListener {
  Reserva adaptee;

  Reserva_jBgerarEstadia_actionAdapter(Reserva adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	try {
		adaptee.gerarEstadia();
	} catch (NumberFormatException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
  }
}

class Reserva_jBacomodacao_actionAdapter implements java.awt.event.ActionListener 
{
    Reserva adaptee;

    Reserva_jBacomodacao_actionAdapter(Reserva adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  try {
		adaptee.acomodacao(e);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    }
  }
  
class Reserva_jBhospede_actionAdapter implements java.awt.event.ActionListener 
{
    Reserva adaptee;

    Reserva_jBhospede_actionAdapter(Reserva adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  adaptee.hospede(e);
    }
  }
  
  
  
class Reserva_jBverificaAcomodacao_actionAdapter implements java.awt.event.ActionListener 
{
    Reserva adaptee;

    Reserva_jBverificaAcomodacao_actionAdapter(Reserva adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  try {
		adaptee.verificaAcomodacao();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    }
  }
  
    
}