import Inhotel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.Color;

import java.sql.*;

public class Pagamento extends JFrame {
  
  
  //Objetos para acesso a banco de dados
  BeanPagamento pag1;
    
  private JLabel jLcpfHosp = new JLabel();
  private JLabel jLmsgTipoPgto = new JLabel();
  private JLabel jLvalorPagamento = new JLabel();
  private JLabel jLdataPagamento = new JLabel();
  private JLabel jLformatoData = new JLabel();
    
  private JTextField jTcpfHosp = new JTextField();  
  private JTextField jTvalorPagamento = new JTextField(); 
  private JTextField jTdataPagamento = new JTextField();
       
  private JRadioButton jRaVista = new JRadioButton();
  private JRadioButton jRcheque = new JRadioButton();
  private JRadioButton jRcartao = new JRadioButton();  
   
  private JButton jBinserir = new JButton();
  private JButton jBalterar = new JButton();
  private JButton jBverificar = new JButton();
  
  private JTextArea jTAaviso = new JTextArea();
  
  private String tipoPagamento;
  private int cpf;  
   
     
  public Pagamento(int cpf){ //throws HeadlessException {
    super("Menu de Opções - Pagamento");
    this.cpf=cpf;
      
   
    try {
      jbInit(cpf);
         }
    catch(Exception e) {
      e.printStackTrace();
     
    }
    
  }
   
   
   
    public void VerificarPagamento()
   {
   	
   	 jTvalorPagamento.setText("");
     jTdataPagamento.setText("");
     jRaVista.setSelected(false);
    jRcheque.setSelected(false);
    jRcartao.setSelected(false);
     
     
      jBinserir.setEnabled(true);
      jBalterar.setEnabled(true);
   	pag1 = new BeanPagamento();
    pag1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText()));
   if(pag1.VerificaPagamento().equals("temvalor"))
      {
      
      ExibirPagamento();
        jLvalorPagamento.setEnabled(true);
       jLdataPagamento.setEnabled(true);
       jBinserir.setEnabled(true);
       jBalterar.setEnabled(true);
       }
       
   	else
   		{
   			tipoPagamento="nada";
   			
   			//carregar todo mundo com enabled falso		
   		}
   	  
   	  System.out.println(tipoPagamento);
   }
   
   
  public void ExibirPagamento()
   {
   	
   try {
	  jTdataPagamento.setText(""+ pag1.getDataPagamento() );
	  jTvalorPagamento.setText(""+ pag1.getValorPagamento() );
	  tipoPagamento = (""+ pag1.getTipoPagamento());
	  if(tipoPagamento.equals("avista"))
	  	 jRaVista.setSelected(true);
	  else if(tipoPagamento.equals("cheque"))
	  	      jRcheque.setSelected(true);
	  	      else if(tipoPagamento.equals("cartao"))
    				jRcartao.setSelected(true);  	
      jTAaviso.setText("");
	  	 	  
	}catch(Exception e1) {jTAaviso.setText("[ERROR]: Exibir Pgto: \n" + e1.getMessage());}
 	
   	
   }
   
    
  private void jbInit(int cpf) throws Exception {
    this.setSize(new Dimension(410, 410));
    this.setLocation(250, 150);
    
    this.getContentPane().setBackground(Color.gray);
    this.getContentPane().setLayout(null);
    this.getContentPane().setLayout(null);
    this.setLocale(java.util.Locale.getDefault());
    
    jLcpfHosp.setBounds(new Rectangle(15, 30, 30, 26));
    jLcpfHosp.setText("CPF");
    jLcpfHosp.setFont(new java.awt.Font("Serif", 1, 15));
            
    jLmsgTipoPgto.setBounds(new Rectangle(15, 65, 200, 26));
    jLmsgTipoPgto.setText("Escolha o tipo de pagamento:");
    jLmsgTipoPgto.setFont(new java.awt.Font("Serif", 1, 15));

    jLvalorPagamento.setBounds(new Rectangle(110, 210, 110, 15));    
    jLvalorPagamento.setText("Valor");
    jLvalorPagamento.setFont(new java.awt.Font("Serif", 1, 15));
    jLvalorPagamento.setEnabled(false);
    
    jLdataPagamento.setBounds(new Rectangle(110, 235, 110, 15));    
    jLdataPagamento.setText("Data)");
    jLdataPagamento.setFont(new java.awt.Font("Serif", 1, 15));
    jLdataPagamento.setEnabled(false);
    
    jLformatoData.setBounds(new Rectangle(105, 248, 110, 15));    
    jLformatoData.setText("(yyyy-mm-dd)");
    jLformatoData.setFont(new java.awt.Font("Serif", 1, 9));
    
    jTcpfHosp.setEnabled(true);
    jTcpfHosp.setBounds(new Rectangle(60, 37, 150, 17));
    jTcpfHosp.setText(""+cpf);
    
    jRaVista.setBounds(new Rectangle(45, 100, 91, 26));
    jRaVista.setBackground(Color.gray);
    jRaVista.setText("À vista");
    jRaVista.addActionListener(new Pagamento_jRaVista_actionAdapter(this));
      
    jRcheque.setBounds(new Rectangle(45, 135, 91, 26));      
    jRcheque.setBackground(Color.gray);
    jRcheque.setText("Cheque");
    jRcheque.addActionListener(new Pagamento_jRcheque_actionAdapter(this));
    
    jRcartao.setBounds(new Rectangle(45, 170, 91, 26));
    jRcartao.setBackground(Color.gray);
    jRcartao.setText("Cartão");
    jRcartao.addActionListener(new Pagamento_jRcartao_actionAdapter(this));
            
    jTvalorPagamento.setEnabled(true);
    jTvalorPagamento.setBounds(new Rectangle(160, 210, 110, 16));
    jTvalorPagamento.setText("");
    
    jTdataPagamento.setEnabled(true);
    jTdataPagamento.setBounds(new Rectangle(160, 235, 110, 16));
    jTdataPagamento.setText("");
    
    jBinserir.setBounds(new Rectangle(73, 265, 73, 25));
    jBinserir.setText("Inserir");
    jBinserir.addActionListener(new Pagamento_jBinserir_actionAdapter(this));
    jBinserir.setEnabled(false);
    
    jBalterar.setBounds(new Rectangle(145, 265, 73, 25));
    jBalterar.setText("Alterar");
    jBalterar.addActionListener(new Pagamento_jBalterar_actionAdapter(this));
    jBalterar.setEnabled(false);
    
    jBverificar.setBounds(new Rectangle(247, 265, 85, 25));
    jBverificar.setText("Verificar");
    jBverificar.addActionListener(new Pagamento_jBverificar_actionAdapter(this));
    jBverificar.setEnabled(true);
       
	jTAaviso.setBounds(new Rectangle(15, 300, 370, 50));
	jTAaviso.setBackground(Color.lightGray);
	
    this.getContentPane().add(jLmsgTipoPgto, null);
    this.getContentPane().add(jLvalorPagamento, null);
    this.getContentPane().add(jLdataPagamento, null);
    this.getContentPane().add(jLcpfHosp, null);     
    this.getContentPane().add(jLformatoData, null);     
      
    this.getContentPane().add(jTvalorPagamento, null);     
    this.getContentPane().add(jTcpfHosp, null);  
    this.getContentPane().add(jTdataPagamento, null);
    
    this.getContentPane().add(jRaVista, null);
    this.getContentPane().add(jRcheque, null);
    this.getContentPane().add(jRcartao, null);
    
    this.getContentPane().add(jBinserir, null);
    this.getContentPane().add(jBalterar, null);
    this.getContentPane().add(jBverificar, null);
    
    this.getContentPane().add(jTAaviso, null);
  
  
    VerificarPagamento();
  }

  void jRcheque_actionPerformed(ActionEvent e) {

    jLvalorPagamento.setEnabled(true);jTvalorPagamento.setEnabled(true);
    jLdataPagamento.setEnabled(true);jTdataPagamento.setEnabled(true);
    jBinserir.setEnabled(true); jBalterar.setEnabled(true);
      
    jRcheque.setSelected(true);
    jRaVista.setSelected(false);
    jRcartao.setSelected(false);
    tipoPagamento="cheque";
  }
  
  void jRcartao_actionPerformed(ActionEvent e) {

    jLvalorPagamento.setEnabled(true);jTvalorPagamento.setEnabled(true);
    jLdataPagamento.setEnabled(true);jTdataPagamento.setEnabled(true);
    jBinserir.setEnabled(true);jBalterar.setEnabled(true);
       
    jRaVista.setSelected(false);
    jRcheque.setSelected(false);
    jRcartao.setSelected(true);
    tipoPagamento="cartao";
  }

  void jRaVista_actionPerformed(ActionEvent e) {

    jLvalorPagamento.setEnabled(true);jTvalorPagamento.setEnabled(true);
    jLdataPagamento.setEnabled(true);jTdataPagamento.setEnabled(true);
    jBinserir.setEnabled(true);jBalterar.setEnabled(true);
    
    jRcheque.setSelected(false);
    jRcartao.setSelected(false);
    jRaVista.setSelected(true);
    tipoPagamento="avista";
  }

  //public static void main(String[] args) {
  //    Pagamento pagamento = new Pagamento(0);
  //  pagamento.show();
  //}
  

 
 public boolean JaPagou()
 {
    BeanPagamento pag1	= new BeanPagamento();
     
     String mensagem = pag1.VerificaPagamento();
     
     if (mensagem.equals("temvalor") )
 	    return true;
 	 else
 	   return false;
 	
 }
  void inserir(ActionEvent e) {
 
     pag1= new BeanPagamento();
	 pag1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText()));
	 pag1.setDataPagamento(java.sql.Date.valueOf(jTdataPagamento.getText()));
   	 pag1.setValorPagamento(Integer.parseInt( jTvalorPagamento.getText()));
   	 pag1.setTipoPagamento(tipoPagamento);
   	 jTAaviso.setText(pag1.Efetuar_Pagamento());
  }
 
  void alterar(ActionEvent e) {
	
	 pag1= new BeanPagamento();
	 pag1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText()));
	 pag1.setDataPagamento(java.sql.Date.valueOf(jTdataPagamento.getText()));
   	 pag1.setValorPagamento(Integer.parseInt( jTvalorPagamento.getText()));
	 pag1.setTipoPagamento(tipoPagamento);
   	 jTAaviso.setText(pag1.Alterar_Dados_BeanPagamento());
	 
  }	

  class Pagamento_jRcheque_actionAdapter implements java.awt.event.ActionListener {
    Pagamento adaptee;
    Pagamento_jRcheque_actionAdapter(Pagamento adaptee) {
      this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
      adaptee.jRcheque_actionPerformed(e);  }
  }

  class Pagamento_jRaVista_actionAdapter implements java.awt.event.ActionListener {
    Pagamento adaptee;

    Pagamento_jRaVista_actionAdapter(Pagamento adaptee) {
      this.adaptee = adaptee;  } 
   
    public void actionPerformed(ActionEvent e) {
      adaptee.jRaVista_actionPerformed(e);
    }
  }

  class Pagamento_jRcartao_actionAdapter implements java.awt.event.ActionListener{
    Pagamento adaptee;
    Pagamento_jRcartao_actionAdapter(Pagamento adaptee) {
      this.adaptee = adaptee;
    }
     
    public void actionPerformed(ActionEvent e) {
      adaptee.jRcartao_actionPerformed(e);
    }
  }
   
  class Pagamento_jBinserir_actionAdapter implements java.awt.event.ActionListener {
    Pagamento adaptee;

    Pagamento_jBinserir_actionAdapter(Pagamento adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  adaptee.inserir(e);
    }
  }
  
  class Pagamento_jBalterar_actionAdapter implements java.awt.event.ActionListener {
    Pagamento adaptee;

    Pagamento_jBalterar_actionAdapter(Pagamento adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  adaptee.alterar(e);
    }
  }
  
  
  
  class Pagamento_jBverificar_actionAdapter implements java.awt.event.ActionListener {
    Pagamento adaptee;

    Pagamento_jBverificar_actionAdapter(Pagamento adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  VerificarPagamento();  }
  }
  
}