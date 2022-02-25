import Inhotel.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal extends JFrame 
{  
	private JPanel jContentPane = null;   
	JMenuBar jMenuBar1 = new JMenuBar();
	JMenu jMenu1 = new JMenu();
	JMenu jMenu2 = new JMenu();
	JMenuItem jMenuItem1 = new JMenuItem();
	JMenuItem jMenuItem2 = new JMenuItem();
	JMenuItem jMenuItem3 = new JMenuItem();
	JTextPane jTextPane1 = new JTextPane();
  
	  
	public Principal() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);    
 		setSize(680,470);    
 		
 		try
 		{   
 			jbInit(); 			
 		}	
 		catch(Exception e1) 
 		{
 			System.out.println("Erro na janela principal\nMessage: " + e1.getMessage());
 		}      
	}
  
		
	public static void main(String[] args)
	{
		System.out.println("*** Abrindo sistema Hotel California... ***\n ");
    	Principal principal = new Principal();		
    	principal.setTitle("HOTEL CALIFORNIA");
    	principal.setVisible(true);
    	
    	principal.setLocation(200, 100);
    }

	
	private void jbInit() throws Exception 
	{
    
		this.addWindowListener(new Principal_this_windowAdapter(this));
		this.setResizable(true);
		this.getContentPane().setLayout(null);
		
		jMenu1.setText("Hotel California");
		jMenu1.setMnemonic('c');    
		jMenuItem1.setText("Hospede");
		jMenuItem1.setMnemonic('h');
		jMenuItem1.addActionListener(new Principal_jMenuItem1_actionAdapter(this));
		jMenuItem2.setText("Estadia");
		jMenuItem2.setMnemonic('e');
		jMenuItem2.addActionListener(new Principal_jMenuItem2_actionAdapter(this));
		jMenuItem3.setText("Reserva");
		jMenuItem3.setMnemonic('r');
		jMenuItem3.addActionListener(new Principal_jMenuItem3_actionAdapter(this));
    
		 
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setJMenuBar(jMenuBar1);
    this.getContentPane().setLayout(null);

    
   
    jTextPane1.setBounds(new Rectangle(165, 145, 330, 100));
    //jTextPane1.setBackground(UIManager.getColor("window"));
    jTextPane1.setText("\n   Sistema Hotel California");
    jTextPane1.setFont(new java.awt.Font("Arial", 41, 25));
    jTextPane1.setBackground(Color.white);
    jTextPane1.setForeground(Color.blue);
    jTextPane1.setEditable(false);
   
    
    jMenuBar1.add(jMenu1);
    jMenuBar1.add(jMenu2);
    //jMenuBar1.add(jMenu3);
    
    jMenu1.add(jMenuItem1);
    jMenu1.add(jMenuItem2);
    jMenu1.add(jMenuItem3);
    

 	this.getContentPane().add(jTextPane1, null);
    
    
    
 	 };    
 	
    

  

 


  void jMenuItem1_actionPerformed(ActionEvent e) {
    Hospede hospede = new Hospede(0);
    hospede.show();
  }

  void jMenuItem2_actionPerformed(ActionEvent e) {
    Estadia estadia = null;
	try {
		estadia = new Estadia(0,0,0,0,0,null,0);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    estadia.show();
  }

  void jMenuItem3_actionPerformed(ActionEvent e) {
    Reserva reserva = new Reserva();
    reserva.show();
  }

/*
  void jMenu2_actionPerformed(ActionEvent e) {
    System.exit( 0 );
  }
*/
 void fechar(WindowEvent e) {
    System.exit( 0 );
  }
  
  class Principal_jMenuItem1_actionAdapter implements java.awt.event.ActionListener {
    Principal adaptee;

    Principal_jMenuItem1_actionAdapter(Principal adaptee) {
      this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuItem1_actionPerformed(e);
    }
  }

  class Principal_jMenuItem2_actionAdapter implements java.awt.event.ActionListener {
    Principal adaptee;

    Principal_jMenuItem2_actionAdapter(Principal adaptee) {
      this.adaptee = adaptee;
    }
  
    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuItem2_actionPerformed(e);
    }
  }

  class Principal_jMenuItem3_actionAdapter implements java.awt.event.ActionListener {
    Principal adaptee;

    Principal_jMenuItem3_actionAdapter(Principal adaptee) {
      this.adaptee = adaptee;
    }
  
    public void actionPerformed(ActionEvent e) {
      adaptee.jMenuItem3_actionPerformed(e);
    }
  }

/*
  class Principal_jMenu2_actionAdapter implements java.awt.event.ActionListener {
    Principal adaptee;

    Principal_jMenu2_actionAdapter(Principal adaptee) {
      this.adaptee = adaptee;
    }
  
    public void actionPerformed(ActionEvent e) {
      adaptee.jMenu2_actionPerformed(e);
    }
  }
*/

  class Principal_this_windowAdapter extends java.awt.event.WindowAdapter {
    Principal adaptee;

    Principal_this_windowAdapter(Principal adaptee) {
      this.adaptee = adaptee;
    }
    
    public void windowClosing(WindowEvent e) {
      adaptee.fechar(e);
    }
  }
}

