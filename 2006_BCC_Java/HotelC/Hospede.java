//package Interface;
import Inhotel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class Hospede extends JFrame 
{
 
  // Objetos para acesso a banco de dados
  BeanHospede hosp1;
//  Connection con1;
//  PreparedStatement ps1;
//  ResultSet rs1;
  boolean clickProximoAnterior;
  
  private JLabel jLcpf = new JLabel();
  private JLabel jLemail = new JLabel();
  private JLabel jLdataNascimento = new JLabel();
  private JLabel jLnomeHosp = new JLabel();
  private JLabel jLnomeDosPais = new JLabel();
  private JLabel jLddd = new JLabel();
  private JLabel jLtelefone = new JLabel();
  private JLabel jLendereco = new JLabel();
  private JLabel jLrua = new JLabel();
  private JLabel jLnro = new JLabel();
  private JLabel jLcompl = new JLabel();
  private JLabel jLcidade = new JLabel();
  private JLabel jLpais = new JLabel();
  private JLabel jLestado = new JLabel();
  private JLabel jLcep = new JLabel();
  private JLabel jLbairro = new JLabel();
  private JLabel jLhospExiste = new JLabel();
  
  private JTextField jTcpfHosp = new JTextField();
  private JTextField jTnomeHosp = new JTextField();
  private JTextField jTemail = new JTextField();
  private JTextField jTdataNascimento = new JTextField();
  private JTextField jTnomeDosPais = new JTextField();
  private JTextField jTddd = new JTextField();
  private JTextField jTtelefone = new JTextField();
  private JTextField jTrua = new JTextField();
  private JTextField jTnro = new JTextField();
  private JTextField jTcompl = new JTextField();
  private JTextField jTbairro = new JTextField();
  private JTextField jTcidade = new JTextField();
  private JTextField jTestado = new JTextField();
  private JTextField jTcep = new JTextField();
  private JTextField jTpais = new JTextField();
  
  
  private JButton jBinserir = new JButton();
  private JButton jBalterar = new JButton();
  private JButton jBexcluir = new JButton();
  private JButton jBproximo = new JButton();
  private JButton jBanterior = new JButton();
  private JButton jBlimpar = new JButton();
  
  JTextArea jTaviso = new JTextArea();

  public Hospede(int cpfHosp) 
  {	super("Menu de Opções - Hospede");
	try {
	  jbInit(cpfHosp);
	}
	catch(Exception e) {
	  e.printStackTrace();
	}
  }
  
  public void VerificarHospede(){
  //	jTvalorPagamento.setText("");
  //   jTdataPagamento.setText("");
     
     
   // jBinserir.setEnabled(true);jBalterar.setEnabled(true);
   	hosp1 = new BeanHospede();
    hosp1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText()));
   if(hosp1.VerificaHospede().equals("temvalor"))
      {
      
      ExibirHospede();
      //jLvalorPagamento.setEnabled(true);
      // jLdataPagamento.setEnabled(true);
      // jBinserir.setEnabled(true);jBalterar.setEnabled(true);
       }
       
   	else
   		{
   	//		tipoPagamento="nada";
   			
   			//carregar todo mundo com enabled falso		
   		}
   	  
   	  //System.out.println(tipoPagamento);
  }
 
 public static void main(String[] args) {
    Hospede hospede = new Hospede(0);
    hospede.show();
 
 }
 private void jbInit(int cpfHosp) throws Exception {
	this.setSize(new Dimension(600, 620) );
	this.setLocation( 250, 50 );
	this.addWindowListener(new Hospede_this_windowAdapter(this)); 

	this.getContentPane().setBackground(Color.gray);
	this.setLocale(java.util.Locale.getDefault());
	this.setResizable(false);
	this.getContentPane().setLayout(null);
	
	jLcpf.setText("CPF");
	jLcpf.setBounds(new Rectangle(25, 45, 170, 19));
	jTcpfHosp.setText(""+ cpfHosp);
	jTcpfHosp.setBounds(new Rectangle(160, 45, 150, 26));
	
	jLnomeHosp.setBounds(new Rectangle(25, 80, 170, 19));
	jLnomeHosp.setText("Nome Hospede");
	jTnomeHosp.setBounds(new Rectangle(160, 80, 250, 26));
	jTnomeHosp.setText("");
		
	jLemail.setBounds(new Rectangle(25, 115, 170, 19));
	jLemail.setText("Email");
	jTemail.setBounds(new Rectangle(160, 115, 250, 26));
	jTemail.setText("");
	
	jLdataNascimento.setBounds(new Rectangle(25, 150, 170, 19));
	jLdataNascimento.setText("Data de Nascimento");
	jTdataNascimento.setBounds(new Rectangle(160, 150, 100, 26));
	jTdataNascimento.setText("");
	
	jLnomeDosPais.setText("Nome dos Pais");
	jLnomeDosPais.setBounds(new Rectangle(25, 185, 170, 19));
	jTnomeDosPais.setBounds(new Rectangle(160, 185, 350, 26));
	jTnomeDosPais.setText("");
	
	jLddd.setBounds(new Rectangle(25, 220, 70, 19));
	jLddd.setText("DDD(0XX)");
	jTddd.setText("");
	jTddd.setBounds(new Rectangle(90, 220, 60, 26));
	
	
	jLtelefone.setBounds(new Rectangle(165, 220, 170, 19));
	jLtelefone.setText("Telefone");
	jTtelefone.setText("");
	jTtelefone.setBounds(new Rectangle(220, 220, 100, 26));

	jLendereco.setText("Endereço");
	jLendereco.setBounds(new Rectangle(25, 255, 170, 19));
	
	jLrua.setBounds(new Rectangle(25, 290, 170, 19));
	jLrua.setText("Rua");
	jTrua.setText("");
	jTrua.setBounds(new Rectangle(50, 290, 100, 26));
	
	jLnro.setBounds(new Rectangle(180, 290, 170, 19));
	jLnro.setText("Numero");
	jTnro.setText("");
	jTnro.setBounds(new Rectangle(230, 290, 100, 26));
	
	jLcompl.setBounds(new Rectangle(360, 290, 170, 19));
	jLcompl.setText("Complemento");
	jTcompl.setText("");
	jTcompl.setBounds(new Rectangle(445, 290, 100, 26));
	
	jLbairro.setBounds(new Rectangle(25, 325, 170, 19));
	jLbairro.setText("Bairro");
	jTbairro.setText("");
	jTbairro.setBounds(new Rectangle(70, 325, 100, 26));
	
	jLcidade.setBounds(new Rectangle(180, 325, 170, 19));
	jLcidade.setText("Cidade");
	jTcidade.setText("");
	jTcidade.setBounds(new Rectangle(230, 325, 100, 26));
	
	jLestado.setBounds(new Rectangle(360, 325, 170, 19));
	jLestado.setText("Estado");
	jTestado.setText("");
	jTestado.setBounds(new Rectangle(445, 325, 100, 26));
	
	jLcep.setBounds(new Rectangle(25, 360, 170, 19));
	jLcep.setText("Cep");
	jTcep.setText("");
	jTcep.setBounds(new Rectangle(50, 360, 100, 26));
	
	jLpais.setBounds(new Rectangle(180, 360, 170, 19));
	jLpais.setText("Pais");
	jTpais.setText("");
	jTpais.setBounds(new Rectangle(230, 360, 100, 26));

	
	jBinserir.setText("Inserir");
	jBinserir.addActionListener(new Hospede_jBinserir_actionAdapter(this));
	jBinserir.setBounds(new Rectangle(48, 420, 73, 28));
	
	jBexcluir.setText("Excluir");
	jBexcluir.addActionListener(new Hospede_jBexcluir_actionAdapter(this));
	jBexcluir.setBounds(new Rectangle(120, 420, 73, 28));
	
	jBanterior.setText("Anterior");
	jBanterior.addActionListener(new Hospede_jBanterior_actionAdapter(this));
	jBanterior.setBounds(new Rectangle(192, 420, 95, 28));
	
	jBproximo.setText("Proximo");
	jBproximo.addActionListener(new Hospede_jBproximo_actionAdapter(this));
	jBproximo.setBounds(new Rectangle(285, 420, 95, 28));
	
	
	jBalterar.setText("Alterar");
	jBalterar.addActionListener(new Hospede_jBalterar_actionAdapter(this));
	jBalterar.setBounds(new Rectangle(378, 420, 73, 28));
	
	jBlimpar.setText("Limpar");
	jBlimpar.addActionListener(new Hospede_jBlimpar_actionAdapter(this));
	jBlimpar.setBounds(new Rectangle(450, 420, 85, 28));

	
	jTaviso.setBounds(new Rectangle(48, 460, 485, 80));
	
		
	this.setTitle("Menu de Opções - Hospedes");
	//this.setMenuBar(null);
	this.getContentPane().add(jTnomeHosp, null);
	this.getContentPane().add(jTcpfHosp, null);
	this.getContentPane().add(jLcpf, null);
	this.getContentPane().add(jLnomeHosp, null);
	this.getContentPane().add(jTemail, null);
	this.getContentPane().add(jLemail, null);
	this.getContentPane().add(jLdataNascimento, null);
	this.getContentPane().add(jTdataNascimento, null);
	this.getContentPane().add(jLnomeDosPais, null);
	this.getContentPane().add(jTnomeDosPais, null);
	this.getContentPane().add(jTtelefone, null);
	this.getContentPane().add(jLtelefone, null);
	this.getContentPane().add(jLendereco, null);
	this.getContentPane().add(jBinserir, null);
	this.getContentPane().add(jBalterar, null);
	this.getContentPane().add(jBexcluir, null);
	this.getContentPane().add(jBproximo, null);
	this.getContentPane().add(jBanterior, null);
	this.getContentPane().add(jBlimpar, null);
	this.getContentPane().add(jTaviso, null);
	this.getContentPane().add(jTrua, null);
	this.getContentPane().add(jLrua, null);
	this.getContentPane().add(jTnro, null);
	this.getContentPane().add(jLnro, null);
	this.getContentPane().add(jTcompl, null);
	this.getContentPane().add(jLcompl, null);
	this.getContentPane().add(jTbairro, null);
	this.getContentPane().add(jLbairro, null);
	this.getContentPane().add(jTcidade, null);
	this.getContentPane().add(jLcidade, null);
	this.getContentPane().add(jTestado, null);
	this.getContentPane().add(jLestado, null);
	this.getContentPane().add(jTcep, null);
	this.getContentPane().add(jLcep, null);
	this.getContentPane().add(jTpais, null);
	this.getContentPane().add(jLpais, null);
	this.getContentPane().add(jLddd, null);
	this.getContentPane().add(jTddd, null);
	
	
  }
 

  
  void Excluir(ActionEvent e) {
	
	 clickProximoAnterior=false;
	 hosp1= new BeanHospede();
	 jTaviso.setText(hosp1.Remover_BeanHospede(Integer.parseInt(jTcpfHosp.getText() )));
	 
}
  	
  void Proximo(ActionEvent e) {
  	
  	
  	if(!clickProximoAnterior)
  	{
  			hosp1 = new BeanHospede();
  			clickProximoAnterior=true;
  	}
  	
  	String mensagem = 	hosp1.Proximo();
  	if(mensagem.equals("Proximo ok")) 
  		ExibirHospede();
  		
  	else
  		jTaviso.setText(mensagem);
  		if (mensagem.equals("Fim da tabela"))
  				Limpar(e);
  		
		  }
    
   
  
  
  
  void Anterior(ActionEvent e) {

	if(!clickProximoAnterior)
	{
			hosp1 = new  BeanHospede();
			clickProximoAnterior=true;
	}
	
  	String mensagem = 	hosp1.Anterior();
  	if(mensagem.equals("Anterior ok")) 
  		ExibirHospede();
  		
  	else
  		jTaviso.setText(mensagem);
	
  	
  	  	
	
  }


	public void ExibirHospede() {
	try {
	  
	    jTcpfHosp.setText(""+hosp1.getCpfHosp() );
 		jTnomeHosp.setText(""+hosp1.getNomeHosp()); 
 		jTemail.setText(""+hosp1.getEmail()); 
		jTdataNascimento.setText(""+hosp1.getDataNascimento()); 
 		jTnomeDosPais.setText(""+hosp1.getNomeDosPais());
 		jTddd.setText(""+hosp1.getDdd());
 		jTtelefone.setText(""+hosp1.getTelefone() );
 		jTrua.setText(""+hosp1.getRua());
 		jTnro.setText(""+hosp1.getNro());
 		jTcompl.setText(""+hosp1.getCompl());
 		jTbairro.setText(""+hosp1.getBairro());
 		jTcidade.setText(""+hosp1.getCidade());
 		jTestado.setText(""+hosp1.getEstado());
 		jTcep.setText(""+hosp1.getCep());
 		jTpais.setText(""+hosp1.getPais());
 		
 		
        jTaviso.setText("");
	  	   
	  
	}catch(Exception e1) {jTaviso.setText("[ERROR]: Exibir Hospede: \n" + e1.getMessage());}
  }
  	
  	void fechar(WindowEvent e) {
	this.setVisible(false);
  }

  void Alterar(ActionEvent e) {
	
	clickProximoAnterior=false;

	
	 hosp1= new BeanHospede();
	 hosp1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText() ));
	 hosp1.setNomeHosp(jTnomeHosp.getText() );
   	 hosp1.setEmail(jTemail.getText());
	 hosp1.setDataNascimento(java.sql.Date.valueOf(jTdataNascimento.getText()));
	 hosp1.setNomeDosPais(jTnomeDosPais.getText());
	 hosp1.setDdd(Integer.parseInt(jTddd.getText()));
	 hosp1.setTelefone(Integer.parseInt(jTtelefone.getText() ));
	 hosp1.setRua(jTrua.getText());
	 hosp1.setNro(Integer.parseInt(jTnro.getText() ));
	 hosp1.setCompl(jTcompl.getText());
	 hosp1.setCidade(jTcidade.getText());
	 hosp1.setEstado(jTestado.getText());
	 hosp1.setCep(Integer.parseInt(jTcep.getText() ));
	 hosp1.setPais(jTpais.getText());
	 
	 jTaviso.setText(hosp1.Alterar_Dados_BeanHospede( ));
	 
  }	

	

  void Limpar(ActionEvent e) {
	jTcpfHosp.setText( "" );
	jTnomeHosp.setText( "" );
	jTemail.setText( "" );
	jTdataNascimento.setText( "" );
	jTnomeDosPais.setText( "" );
	jTddd.setText( "" );
	jTtelefone.setText( "" );
	jTrua.setText( "" );
	jTnro.setText( "" );
	jTcompl.setText( "" );
	jTbairro.setText( "" );
	jTcidade.setText( "" );
	jTestado.setText( "" );
	jTcep.setText( "" );
	jTpais.setText( "" );
  }

  

  void Inserir(ActionEvent e) 
  {
  	try{
  	
	clickProximoAnterior=false;
 
     hosp1 = new BeanHospede();
     
	 //hosp1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText() ));
	 hosp1.setNomeHosp(jTnomeHosp.getText());
   	 hosp1.setEmail(jTemail.getText());
	 //hosp1.setDataNascimento(java.sql.Date.valueOf(jTdataNascimento.getText() ) );
	 hosp1.setNomeDosPais(jTnomeDosPais.getText());
	 //hosp1.setDdd(Integer.parseInt(jTddd.getText() ));
	 //hosp1.setTelefone(Integer.parseInt(jTtelefone.getText() ));
	 hosp1.setRua(jTrua.getText() );
	// hosp1.setNro(Integer.parseInt(jTnro.getText() ));
	 hosp1.setCompl(jTcompl.getText() );
	 hosp1.setBairro(jTbairro.getText() );
	 hosp1.setCidade(jTcidade.getText() );
	 hosp1.setEstado(jTestado.getText() );
	// hosp1.setCep(Integer.parseInt(jTcep.getText() ));
	 hosp1.setPais(jTpais.getText() );
	 
	 jTaviso.setText(hosp1.Inserir());
	} catch(Exception e1) {jTaviso.setText("[ERROR]: dados inseridos incorretamente: \n" + e1.getMessage());}
	 
	
	 	 
  }

  void jButton1_actionPerformed(ActionEvent e) {
   this.setVisible(false);
  }
}



class Hospede_this_windowAdapter extends java.awt.event.WindowAdapter 
{
  Hospede adaptee;

  Hospede_this_windowAdapter(Hospede adaptee) {
	this.adaptee = adaptee;
  }
  public void windowClosing(WindowEvent e) {
	adaptee.fechar(e);
  }
}

class Hospede_jBexcluir_actionAdapter implements java.awt.event.ActionListener {
    Hospede adaptee;

    Hospede_jBexcluir_actionAdapter(Hospede adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  adaptee.Excluir(e);
    }
  }

class Hospede_jBlimpar_actionAdapter implements java.awt.event.ActionListener {
  Hospede adaptee;

  Hospede_jBlimpar_actionAdapter(Hospede adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.Limpar(e);
  }
}

class Hospede_jBproximo_actionAdapter implements java.awt.event.ActionListener {
  Hospede adaptee;

  Hospede_jBproximo_actionAdapter(Hospede adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.Proximo(e);
  }
}

class Hospede_jBanterior_actionAdapter implements java.awt.event.ActionListener {
  Hospede adaptee;

  Hospede_jBanterior_actionAdapter(Hospede adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.Anterior(e);
  }
}

class Hospede_jBinserir_actionAdapter implements java.awt.event.ActionListener {
  Hospede adaptee;

  Hospede_jBinserir_actionAdapter(Hospede adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.Inserir(e);
  }
}

class Hospede_jBalterar_actionAdapter implements java.awt.event.ActionListener 
{
  Hospede adaptee;

  Hospede_jBalterar_actionAdapter(Hospede adaptee) {
	this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
	adaptee.Alterar(e);
  }
}


