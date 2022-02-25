package Interface;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hospede extends Frame {
  
  JLabel jLCpf = new JLabel();
  JTextField jTCpf = new JTextField();
  JLabel jLnomeHospede = new JLabel();
  JTextField jTnomeHospede = new JTextField();
  JTextField jTemail = new JTextField();
  JLabel jLemail = new JLabel();
  JLabel jLdataNascimento = new JLabel();
  JTextField jTdataNascimento = new JTextField();
  JLabel jLnomeDosPais = new JLabel();
  JTextField jTnomeDosPais = new JTextField();
  JLabel jLtelefone = new JLabel();
  JTextField jTtelefone = new JTextField();
  JLabel jLendereco = new JLabel();
  JTextField jTendereco = new JTextField();
  JButton jBinserir = new JButton();
  JButton jBalterar = new JButton();
  JButton jBexcluir = new JButton();
  JButton jBproximo = new JButton();
  JButton jBanterior = new JButton();
  JTextArea jTextArea1 = new JTextArea();
  

  public Hospede() {
	
	try {
	  jbInit();
	}
	catch(Exception e) {
	  e.printStackTrace();
	}
	
	
	}

	public static void main(String args[]) {
		System.out.println("Starting Hotel California...");
		Hospede mainFrame = new Hospede();
		mainFrame.setSize(650, 400);
		mainFrame.setTitle("Menu de Opções - Hospedes");
		mainFrame.setVisible(true);
	}
  	
  private void jbInit() throws Exception {
	this.setSize(500, 500);
	this.setLocation( 250, 50 );
	this.setBackground(Color.white);
	this.setLayout(null);
	
	jLCpf.setText("CPF");
	jLCpf.setBounds(new Rectangle(25, 45, 130, 19));
	jTCpf.setText("");
	jTCpf.setBounds(new Rectangle(200, 45, 150, 26));
	
	jLnomeHospede.setBounds(new Rectangle(25, 80, 130, 19));
	jLnomeHospede.setText("Nome Hospede");
	jTnomeHospede.setBounds(new Rectangle(200, 80, 250, 26));
	jTnomeHospede.setText("");
		
	jLemail.setBounds(new Rectangle(25, 115, 130, 19));
	jLemail.setText("Email");
	jTemail.setBounds(new Rectangle(200, 115, 250, 26));
	jTemail.setText("");
	
	jLdataNascimento.setBounds(new Rectangle(25, 150, 130, 19));
	jLdataNascimento.setText("Data de Nascimento");
	jTdataNascimento.setBounds(new Rectangle(200, 150, 100, 26));
	jTdataNascimento.setText("");
	
	jLnomeDosPais.setText("Nome dos Pais");
	jLnomeDosPais.setBounds(new Rectangle(25, 185, 130, 19));
	jTnomeDosPais.setBounds(new Rectangle(200, 185, 350, 26));
	jTnomeDosPais.setText("");
	
	jLtelefone.setBounds(new Rectangle(25, 220, 130, 19));
	jLtelefone.setText("Telefone");
	jTtelefone.setText("");
	jTtelefone.setBounds(new Rectangle(200, 220, 100, 26));
	
	jLendereco.setText("Endereço");
	jLendereco.setBounds(new Rectangle(25, 255, 130, 19));
	jTendereco.setBounds(new Rectangle(200, 255, 300, 26));
	jTendereco.setText("");
	
	jBinserir.setBackground(Color.white);
	jBinserir.setBounds(new Rectangle(48, 300, 73, 28));
	jBinserir.setText("Inserir");
	
	jBexcluir.setText("Excluir");
	jBexcluir.setBounds(new Rectangle(120, 300, 73, 28));
	
	jBanterior.setText("Anterior");
	jBanterior.setBounds(new Rectangle(192, 300, 73, 28));
	
	jBproximo.setBounds(new Rectangle(265, 300, 73, 28));
	jBproximo.setText("Proximo");
	
	jBalterar.setText("Alterar");
	jBalterar.setBounds(new Rectangle(333, 300, 73, 28));
	
		
	this.setTitle("Menu de Opções - Hospedes");
	this.setMenuBar(null);
	jTextArea1.setText("");
	jTextArea1.setBounds(new Rectangle(200, 373, 340, 66));
	this.add(jTnomeHospede, null);
	this.add(jTCpf, null);
	this.add(jLCpf, null);
	this.add(jLnomeHospede, null);
	this.add(jTemail, null);
	this.add(jLemail, null);
	this.add(jLdataNascimento, null);
	this.add(jTdataNascimento, null);
	this.add(jLnomeDosPais, null);
	this.add(jTnomeDosPais, null);
	this.add(jTtelefone, null);
	this.add(jLtelefone, null);
	this.add(jLendereco, null);
	this.add(jTendereco, null);
	this.add(jBinserir, null);
	this.add(jBalterar, null);
	this.add(jBexcluir, null);
	this.add(jBproximo, null);
	this.add(jBanterior, null);
	this.add(jTextArea1, null);
  }

}

  
  






