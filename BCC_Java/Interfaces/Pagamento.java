package Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pagamento extends JFrame {
  
  JLabel jLcpfCliente = new JLabel();
  JLabel jLmsgTipoPgto = new JLabel();
  JLabel jLvalorParcelas = new JLabel();
  JLabel jLdataParcela1 = new JLabel();
  JLabel jLdataParcela2 = new JLabel();
  JLabel jLdataParcela3 = new JLabel();
    
  JRadioButton jRaVista = new JRadioButton();
  JRadioButton jRcheque = new JRadioButton();
  JRadioButton jRcartao = new JRadioButton();  
  JRadioButton jR1vez = new JRadioButton();
  JRadioButton jR2vezes = new JRadioButton();
  JRadioButton jR3vezes = new JRadioButton();
    
  JTextField jTcpfCliente = new JTextField();  
  JTextField jTvalorParcelaOuCheque = new JTextField();  
  JTextField jTdataParcela1 = new JTextField();
  JTextField jTdataParcela2 = new JTextField();
  JTextField jTdataParcela3 = new JTextField();
      
  //JButton jBfechar = new JButton();
  
  public Pagamento() throws HeadlessException {
    super("Menu de Opções - Pagamento");
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
	public static void main(String[] args) {
    Pagamento pagamento = new Pagamento();
	pagamento.show();
  }

  private void jbInit() throws Exception {
    this.setSize(new Dimension(300, 300));
    this.setLocation( 250, 150 );
    this.getContentPane().setBackground(Color.white);
    this.getContentPane().setLayout(null);
    this.getContentPane().setLayout(null);
    this.setLocale(java.util.Locale.getDefault());
    
    jLcpfCliente.setText("CPF");
    jLcpfCliente.setBounds(new Rectangle(10, 30, 30, 26));
    
    jTcpfCliente.setEnabled(true);
    jTcpfCliente.setText("");
    jTcpfCliente.setBounds(new Rectangle(40, 35, 78, 17));
    
    jLmsgTipoPgto.setText("Escolha o tipo de pagamento:");
    jLmsgTipoPgto.setBounds(new Rectangle(10, 50, 188, 26));
    
    jRaVista.setBackground(Color.white);
    jRaVista.setText("À vista");
    jRaVista.setBounds(new Rectangle(45, 50+27, 91, 23));
    jRaVista.addActionListener(new Pagamento_jRaVista_actionAdapter(this));
          
    jRcheque.setBackground(Color.white);
    jRcheque.setText("Cheque");
    jRcheque.setBounds(new Rectangle(45, 50+47, 91, 18));
    jRcheque.addActionListener(new Pagamento_jRcheque_actionAdapter(this));
    
    jRcartao.setBackground(Color.white);
    jRcartao.setText("Cartão");
    jRcartao.setBounds(new Rectangle(45, 50+67, 91, 18));
    jRcartao.addActionListener(new Pagamento_jRcartao_actionAdapter(this));
    jR1vez.setBackground(Color.white);
    jR1vez.setText("1 X");
    jR1vez.setBounds(new Rectangle(45, 50+87, 91, 18));
    jR1vez.addActionListener(new Pagamento_jR1vez_actionAdapter(this));
    jR1vez.setVisible(false);
    jR2vezes.setBackground(Color.white);
    jR2vezes.setText("2 X");
    jR2vezes.setBounds(new Rectangle(137, 50+87, 91, 18));
    jR2vezes.addActionListener(new Pagamento_jR2vezes_actionAdapter(this));
    jR2vezes.setVisible(false);
    jR3vezes.setBackground(Color.white);
    jR3vezes.setText("3 X");
    jR3vezes.setBounds(new Rectangle(229, 50+87, 91, 18));
    jR3vezes.addActionListener(new Pagamento_jR3vezes_actionAdapter(this));
    jR3vezes.setVisible(false);
           
    jLvalorParcelas.setEnabled(false);
    jLvalorParcelas.setText("Valor Parcela(s):");
    jLvalorParcelas.setBounds(new Rectangle(45, 50+105, 99, 15));
    
    jTvalorParcelaOuCheque.setEnabled(true);
    jTvalorParcelaOuCheque.setText("");
    jTvalorParcelaOuCheque.setBounds(new Rectangle(145, 50+105, 58, 16));
        
    jLdataParcela1.setText("Data Parcela 1");
    jLdataParcela1.setBounds(new Rectangle(45, 50+130, 99, 15));
      
    jTdataParcela1.setText("");
    jTdataParcela1.setBounds(new Rectangle(145, 50+130, 58, 16));
   
    jLdataParcela2.setText("Data Parcela 2");
    jLdataParcela2.setBounds(new Rectangle(45, 50+150, 99, 15));
   
    jTdataParcela2.setText("");
    jTdataParcela2.setBounds(new Rectangle(145, 50+150, 58, 16));
    
    jLdataParcela3.setText("Data Parcela 3");
    jLdataParcela3.setBounds(new Rectangle(45, 50+170, 99, 15));
   
    jTdataParcela3.setText("");
    jTdataParcela3.setBounds(new Rectangle(145, 50+170, 58, 16));
   
     
    //jBfechar.setBounds(new Rectangle(225, 50+170, 73, 25));
    //jBfechar.setText("Fechar");
    //jBfechar.addActionListener(new Pagamento_jBfechar_actionAdapter(this));
    
    this.getContentPane().add(jLmsgTipoPgto, null);
    this.getContentPane().add(jLvalorParcelas, null);
    this.getContentPane().add(jRaVista, null);
    this.getContentPane().add(jRcheque, null);
    this.getContentPane().add(jRcartao, null);
    //this.getContentPane().add(jBfechar, null);
    this.getContentPane().add(jR1vez, null);
    this.getContentPane().add(jR2vezes, null);
    this.getContentPane().add(jR3vezes, null);      
    this.getContentPane().add(jTvalorParcelaOuCheque, null);     
    this.getContentPane().add(jLcpfCliente, null);     
    this.getContentPane().add(jTcpfCliente, null);
    this.getContentPane().add(jLdataParcela1, null);
    this.getContentPane().add(jTdataParcela1, null);
    this.getContentPane().add(jLdataParcela2, null);
    this.getContentPane().add(jTdataParcela2, null);
    this.getContentPane().add(jLdataParcela3, null);
    this.getContentPane().add(jTdataParcela3, null);
  }

  void jRcheque_actionPerformed(ActionEvent e) {
        
    jLvalorParcelas.setEnabled(true);
      
    jRcheque.setSelected(true);
    jRaVista.setSelected(false);
    jRcartao.setSelected(false);
    
    jR1vez.setVisible(true);
    jR2vezes.setVisible(true);
    jR3vezes.setVisible(true);
    
    jLdataParcela1.setVisible(true);
    jTdataParcela1.setVisible(true);
    jLdataParcela2.setVisible(false);
    jTdataParcela2.setVisible(false);
    jLdataParcela3.setVisible(false);
    jTdataParcela3.setVisible(false);
  }
  
  void jRcartao_actionPerformed(ActionEvent e) {

    jLvalorParcelas.setEnabled(true);
   
    
    jRaVista.setSelected(false);
    jRcheque.setSelected(false);
    jRcartao.setSelected(true);
    
    jR1vez.setVisible(true);
    jR2vezes.setVisible(true);
    jR3vezes.setVisible(true);
    
    jLdataParcela1.setVisible(true);
    jTdataParcela1.setVisible(true);
    jLdataParcela2.setVisible(false);
    jTdataParcela2.setVisible(false);
    jLdataParcela3.setVisible(false);
    jTdataParcela3.setVisible(false);
  }

  void jRaVista_actionPerformed(ActionEvent e) {
    
    jLvalorParcelas.setEnabled(true);  
    
    jRcheque.setSelected(false);
    jRcartao.setSelected(false);
    jRaVista.setSelected(true);
    
    jR1vez.setVisible(false);
    jR2vezes.setVisible(false);
    jR3vezes.setVisible(false);
     
 	jLdataParcela1.setVisible(false);
    jTdataParcela1.setVisible(false);
    jLdataParcela2.setVisible(false);
    jTdataParcela2.setVisible(false);
    jLdataParcela3.setVisible(false);
    jTdataParcela3.setVisible(false);
 }

 void jR1vez_actionPerformed(ActionEvent e) { 
 	jR1vez.setSelected(true);
 	jR2vezes.setSelected(false);
 	jR3vezes.setSelected(false);
 	jLdataParcela1.setVisible(true);
    jTdataParcela1.setVisible(true);
    jLdataParcela2.setVisible(false);
    jTdataParcela2.setVisible(false);
    jLdataParcela3.setVisible(false);
    jTdataParcela3.setVisible(false);
 }
 
 void jR2vezes_actionPerformed(ActionEvent e) { 
 	jR1vez.setSelected(false);
 	jR2vezes.setSelected(true);
 	jR3vezes.setSelected(false);
 
  	jLdataParcela1.setVisible(true);
    jTdataParcela1.setVisible(true);
    jLdataParcela2.setVisible(true);
    jTdataParcela2.setVisible(true);
    jLdataParcela3.setVisible(false);
    jTdataParcela3.setVisible(false);
  }
 
 void jR3vezes_actionPerformed(ActionEvent e) {
 	jR1vez.setSelected(false);
 	jR2vezes.setSelected(false);
 	jR3vezes.setSelected(true);
 		
 	jLdataParcela1.setVisible(true);
    jTdataParcela1.setVisible(true);
    jLdataParcela2.setVisible(true);
    jTdataParcela2.setVisible(true);
    jLdataParcela3.setVisible(true);
    jTdataParcela3.setVisible(true);
  }
    
  /*void jBfechar_actionPerformed(ActionEvent e) {
   this.setVisible(false);
  }
  */
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

class Pagamento_jRcartao_actionAdapter implements java.awt.event.ActionListener 
{  Pagamento adaptee;
  Pagamento_jRcartao_actionAdapter(Pagamento adaptee) {
    this.adaptee = adaptee;
  }
    
  public void actionPerformed(ActionEvent e) {
    adaptee.jRcartao_actionPerformed(e);
  }
}

class Pagamento_jR1vez_actionAdapter implements java.awt.event.ActionListener 
{  Pagamento adaptee;
  Pagamento_jR1vez_actionAdapter(Pagamento adaptee) {
    this.adaptee = adaptee;
  }
    
  public void actionPerformed(ActionEvent e) {
    adaptee.jR1vez_actionPerformed(e);
  }
}

class Pagamento_jR2vezes_actionAdapter implements java.awt.event.ActionListener 
{  Pagamento adaptee;
  Pagamento_jR2vezes_actionAdapter(Pagamento adaptee) {
    this.adaptee = adaptee;
  }
    
  public void actionPerformed(ActionEvent e) {
    adaptee.jR2vezes_actionPerformed(e);
  }
}

class Pagamento_jR3vezes_actionAdapter implements java.awt.event.ActionListener 
{  Pagamento adaptee;
  Pagamento_jR3vezes_actionAdapter(Pagamento adaptee) {
    this.adaptee = adaptee;
  }
    
  public void actionPerformed(ActionEvent e) {
    adaptee.jR3vezes_actionPerformed(e);
  }
}
/*
class Pagamento_jBfechar_actionAdapter implements java.awt.event.ActionListener {
  Pagamento adaptee;

  Pagamento_jBfechar_actionAdapter(Pagamento adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.jBfechar_actionPerformed(e);
  }
}
*/