import Inhotel.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class Acomodacao extends JFrame 
{
	BeanAcomodacao acom1;	
	boolean ClickProximoAnterior; 
	boolean clickProximoAnterior;
	int codigo;	
	private JTextField jTcodigoAcomodacao = new JTextField();
	private JTextField jTdescricaoAcomodacao = new JTextField();
	private JTextField jTprecoDaDiaria = new JTextField();
	private JTextField jTnroCamasSolteiro = new JTextField();
	private JTextField jTnroCamasCasal = new JTextField();
	private JTextField jTnroQuarto = new JTextField();
	private JTextField jTandar = new JTextField();
	private JTextField jTdescricaoReservaPeriodo = new JTextField();
  	private JLabel jLcodigoAcomodacao = new  JLabel();
	private JLabel jLdescricaoAcomodacao = new  JLabel();
	private JLabel jLprecoDaDiaria = new  JLabel();
	private JLabel jLnroCamasSolteiro = new  JLabel();
	private JLabel jLnroCamasCasal = new JLabel();
	private JLabel jLnroQuarto = new  JLabel();
	private JLabel jLandar = new  JLabel();
	private JLabel jLdescricaoReservaPeriodo = new JLabel(); 
	private JButton jBexcluir = new JButton();
	private JButton jBanterior = new JButton();
	private JButton jBproximo = new JButton();
	private JButton jBlimpar = new JButton();
	private JButton jBinserir = new JButton();
	private JButton jBalterar = new JButton();	
	private JTextArea jTAaviso = new JTextArea();

	public Acomodacao(int codigo) throws Exception 
	{
		super("Menu de Opções - Acomodações");
		this.codigo=codigo;
	
		jbInit(codigo);
	}

	private void jbInit(int codigo) throws Exception 
	{
		this.setSize(new Dimension(600, 530) );
		this.setLocation( 250, 50 );
		this.addWindowListener(new Acomodacao_this_windowAdapter(this));
		this.getContentPane().setBackground(Color.gray);
		this.setLocale(java.util.Locale.getDefault());
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		
		jTcodigoAcomodacao.setSelectedTextColor(Color.white);
		jTcodigoAcomodacao.setText(""+codigo);
		jTcodigoAcomodacao.setBounds(new Rectangle(240, 30, 100, 26));	
		jTdescricaoAcomodacao.setBounds(new Rectangle(240, 65, 100, 26));
		jTdescricaoAcomodacao.setSelectedTextColor(Color.white);
		jTdescricaoAcomodacao.setText("");		
		jTprecoDaDiaria.setBounds(new Rectangle(240, 100, 100, 26));
		jTprecoDaDiaria.setSelectedTextColor(Color.white);
		jTprecoDaDiaria.setText("");	
		jTnroCamasSolteiro.setBounds(new Rectangle(240, 135, 100, 26));
		jTnroCamasSolteiro.setSelectedTextColor(Color.white);
		jTnroCamasSolteiro.setText("");
		jTnroCamasCasal.setBounds(new Rectangle(240, 170, 110, 26));
		jTnroCamasCasal.setSelectedTextColor(Color.white);
		jTnroCamasCasal.setText("");
		jTnroQuarto.setBounds(new Rectangle(240, 205, 150, 26));
		jTnroQuarto.setSelectedTextColor(Color.white);
		jTnroQuarto.setText("");	
		jTandar.setBounds(new Rectangle(240, 240, 110, 26));
		jTandar.setSelectedTextColor(Color.white);
		jTandar.setText("");
		jTdescricaoReservaPeriodo.setBounds(new Rectangle(240, 275, 210, 56));
		jTdescricaoReservaPeriodo.setSelectedTextColor(Color.white);
		jTdescricaoReservaPeriodo.setText("");
		jLcodigoAcomodacao.setFont(new java.awt.Font("Serif", 1, 15));
		jLcodigoAcomodacao.setText("Codigo da Acomodacao");
		jLcodigoAcomodacao.setBounds(new Rectangle(25, 30, 170, 19));
		jLdescricaoAcomodacao.setFont(new java.awt.Font("Serif", 1, 15));
		jLdescricaoAcomodacao.setText("Descrição da Acomodação");
		jLdescricaoAcomodacao.setBounds(new Rectangle(25, 65, 170, 19));
		jLprecoDaDiaria.setFont(new java.awt.Font("Serif", 1, 15));
		jLprecoDaDiaria.setText("Preço da Diária");
		jLprecoDaDiaria.setBounds(new Rectangle(25, 100, 170, 19));
		jLnroCamasSolteiro.setFont(new java.awt.Font("Serif", 1, 15));
		jLnroCamasSolteiro.setText("Nro Camas Solteiro");
		jLnroCamasSolteiro.setBounds(new Rectangle(25, 135, 170, 19));
		jLnroCamasCasal.setFont(new java.awt.Font("Serif", 1, 15));
		jLnroCamasCasal.setText("Nro Camas Casal");
		jLnroCamasCasal.setBounds(new Rectangle(25, 170, 170, 19));
		jLnroQuarto.setFont(new java.awt.Font("Serif", 1, 15));
		jLnroQuarto.setText("Nro quarto");
		jLnroQuarto.setBounds(new Rectangle(25, 205, 170, 19));
		jLandar.setFont(new java.awt.Font("Serif", 1, 15));
		jLandar.setText("Andar");
		jLandar.setBounds(new Rectangle(25, 240, 170, 19));
		jLdescricaoReservaPeriodo.setFont(new java.awt.Font("Serif", 1, 15));
		jLdescricaoReservaPeriodo.setText("Período Indisponíveis");
		jLdescricaoReservaPeriodo.setBounds(new Rectangle(25, 275, 170, 19));
		jBinserir.setBounds(new Rectangle(48, 340, 73, 28));
		jBinserir.setText("Inserir");
		jBinserir.addActionListener(new Acomodacao_jBinserir_actionAdapter(this));
		jBexcluir.setBounds(new Rectangle(120, 340, 73, 28));
		jBexcluir.setText("Excluir");
		jBexcluir.addActionListener(new Acomodacao_jBexcluir_actionAdapter(this));
		jBanterior.setText("Anterior");
		jBanterior.addActionListener(new Acomodacao_jBanterior_actionAdapter(this));
		jBanterior.setBounds(new Rectangle(192, 340, 95, 28));
		jBproximo.setText("Próximo");
		jBproximo.addActionListener(new Acomodacao_jBproximo_actionAdapter(this));
		jBproximo.setBounds(new Rectangle(285, 340, 95, 28));
		jBalterar.setText("Alterar");
		jBalterar.setBounds(new Rectangle(378, 340, 73, 28));
		jBalterar.addActionListener(new Acomodacao_jBalterar_actionAdapter(this));
		jBlimpar.setText("Limpar");
		jBlimpar.addActionListener(new Acomodacao_jBlimpar_actionAdapter(this));
		jBlimpar.setBounds(new Rectangle(450, 340, 85, 28));
		jTAaviso.setBounds(new Rectangle(48, 392, 490, 78));
	
		this.getContentPane().add(jTcodigoAcomodacao, null);
		this.getContentPane().add(jLcodigoAcomodacao, null);
		this.getContentPane().add(jTdescricaoAcomodacao, null);
		this.getContentPane().add(jLdescricaoAcomodacao, null);
		this.getContentPane().add(jLprecoDaDiaria, null);
		this.getContentPane().add(jTprecoDaDiaria, null);
		this.getContentPane().add(jTnroCamasSolteiro, null);
		this.getContentPane().add(jLnroCamasSolteiro, null);
		this.getContentPane().add(jLnroCamasCasal, null);
		this.getContentPane().add(jTnroCamasCasal, null);
		this.getContentPane().add(jLnroQuarto, null);
		this.getContentPane().add(jTnroQuarto, null);
		this.getContentPane().add(jTandar, null);
		this.getContentPane().add(jLandar, null);
		this.getContentPane().add(jLdescricaoReservaPeriodo, null);
		this.getContentPane().add(jTdescricaoReservaPeriodo, null);
		this.getContentPane().add(jBproximo, null);
		this.getContentPane().add(jBexcluir, null);
		this.getContentPane().add(jBanterior, null);
		this.getContentPane().add(jBlimpar, null);
		this.getContentPane().add(jBinserir, null);
		this.getContentPane().add(jTAaviso, null);
		this.getContentPane().add(jBalterar, null);
	}

	void fechar(WindowEvent e) 
	{
		this.setVisible(false);
	}

	void inserir(ActionEvent e) throws SQLException 
	{  
		clickProximoAnterior=false;
		
		acom1= new BeanAcomodacao();
		acom1.setCodigoAcomodacao(Integer.parseInt(jTcodigoAcomodacao.getText()));
		acom1.setDescricaoAcomodacao(jTdescricaoAcomodacao.getText());
		acom1.setPrecoDaDiaria(Integer.parseInt(jTprecoDaDiaria.getText()));
		acom1.setNroCamasSolteiro(Integer.parseInt(jTnroCamasSolteiro.getText()));
		acom1.setNroCamasCasal(Integer.parseInt(jTnroCamasCasal.getText()));
		acom1.setNroQuarto(Integer.parseInt(jTnroQuarto.getText()));
		acom1.setAndar(Integer.parseInt(jTandar.getText()));
		acom1.setDescricaoReservaPeriodo(jTdescricaoReservaPeriodo.getText());
		
		jTAaviso.setText(acom1.Inserir_BeanAcomodacao());
	}
	
	void excluir(ActionEvent e) throws NumberFormatException, SQLException 
	{	
		clickProximoAnterior = false;

		acom1= new BeanAcomodacao();
		jTAaviso.setText(acom1.Remover_BeanAcomodacao(Integer.parseInt(jTcodigoAcomodacao.getText())));
	}
  
	void alterar(ActionEvent e) throws NumberFormatException, SQLException 
	{	
		clickProximoAnterior = false;
	
		acom1= new BeanAcomodacao();
		acom1.setCodigoAcomodacao(Integer.parseInt(jTcodigoAcomodacao.getText()));
		acom1.setDescricaoAcomodacao(jTdescricaoAcomodacao.getText());
		acom1.setPrecoDaDiaria(Integer.parseInt(jTprecoDaDiaria.getText()));
		acom1.setNroCamasSolteiro(Integer.parseInt(jTnroCamasSolteiro.getText()));
		acom1.setNroCamasCasal(Integer.parseInt(jTnroCamasCasal.getText()));
		acom1.setNroQuarto(Integer.parseInt(jTnroQuarto.getText()));
		acom1.setAndar(Integer.parseInt(jTandar.getText()));
		acom1.setDescricaoReservaPeriodo(jTdescricaoReservaPeriodo.getText());
		
		jTAaviso.setText(acom1.Alterar_Dados_BeanAcomodacao(Integer.parseInt(jTcodigoAcomodacao.getText())));
	}	
  
	void limpar(ActionEvent e) 
	{
		jTcodigoAcomodacao.setText( "" );
		jTdescricaoAcomodacao.setText( "" );
		jTprecoDaDiaria.setText("");
		jTnroCamasSolteiro.setText( "" );
		jTnroCamasCasal.setText( "" );
		jTnroQuarto.setText("");
		jTandar.setText("");
		jTdescricaoReservaPeriodo.setText("");
	}

	void proximo(ActionEvent e) throws SQLException 
	{
		if(!clickProximoAnterior)
		{
  			acom1 = new BeanAcomodacao();
  			clickProximoAnterior = true;
		}
  	
		String mensagem = acom1.Proximo();
  	
		if(mensagem.equals("Proximo ok")) 
  		{
			exibirAcomodacao();
  		}  		
		else
		{
			jTAaviso.setText(mensagem);
		}
	}
 
	void anterior(ActionEvent e) 
	{
		if(!clickProximoAnterior)
		{
			acom1 = new BeanAcomodacao();
			clickProximoAnterior = true;
		}
	
		String mensagem = acom1.Anterior();
		
		if(mensagem.equals("Anterior ok")) 
  		{
			exibirAcomodacao();
  		}
		else
			jTAaviso.setText(mensagem);

   }

	public void exibirAcomodacao() 
	{
		jTcodigoAcomodacao.setText(""+ acom1.getCodigoAcomodacao() );
		jTdescricaoAcomodacao.setText(""+ acom1.getDescricaoAcomodacao() );
		jTprecoDaDiaria.setText(""+ acom1.getPrecoDaDiaria()  ); 
		jTnroCamasSolteiro.setText(""+ acom1.getNroCamasSolteiro()  );
		jTnroCamasCasal.setText(""+ acom1.getNroCamasCasal() )  ; 
		jTnroQuarto.setText(""+acom1.getNroQuarto() );
		jTandar.setText(""+ acom1.getAndar() ); 
		jTdescricaoReservaPeriodo.setText(""+acom1.getDescricaoReservaPeriodo());
		jTAaviso.setText("");
	}
  
	public void verificarAcomodacao() throws SQLException
	{
		acom1 =  new BeanAcomodacao() ;
		acom1.setCodigoAcomodacao(Integer.parseInt(jTcodigoAcomodacao.getText()));
		acom1.VerificarAcomodacao();
	}
	
	private class Acomodacao_this_windowAdapter extends java.awt.event.WindowAdapter 
	{
		Acomodacao adaptee;
		
		Acomodacao_this_windowAdapter(Acomodacao adaptee) 
		{
			this.adaptee = adaptee;
		}
		
		public void windowClosing(WindowEvent e) 
		{
			adaptee.fechar(e);
		}
	}

	private class Acomodacao_jBexcluir_actionAdapter implements java.awt.event.ActionListener 
	{
		Acomodacao adaptee;

		Acomodacao_jBexcluir_actionAdapter(Acomodacao adaptee) 
		{
			this.adaptee = adaptee;
		}
  
		public void actionPerformed(ActionEvent e)  
		{
			try 
			{
				adaptee.excluir(e);
			} 
			catch (NumberFormatException e1) 
			{
				e1.printStackTrace();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
	}

	private class Acomodacao_jBlimpar_actionAdapter implements java.awt.event.ActionListener 
	{
		Acomodacao adaptee;

		Acomodacao_jBlimpar_actionAdapter(Acomodacao adaptee) 
		{
			this.adaptee = adaptee;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			adaptee.limpar(e);
		}	
	}

	private class Acomodacao_jBproximo_actionAdapter implements java.awt.event.ActionListener 
	{
		Acomodacao adaptee;

		Acomodacao_jBproximo_actionAdapter(Acomodacao adaptee) 
		{
			this.adaptee = adaptee;
		}
  
		public void actionPerformed(ActionEvent e)  
		{
			try 
			{
				adaptee.proximo(e);
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
	}

	private class Acomodacao_jBanterior_actionAdapter implements java.awt.event.ActionListener 
	{
		Acomodacao adaptee;

		Acomodacao_jBanterior_actionAdapter(Acomodacao adaptee) 
		{
			this.adaptee = adaptee;
		}
  
		public void actionPerformed(ActionEvent e) 
		{
			adaptee.anterior(e);
		}
	}

	private class Acomodacao_jBinserir_actionAdapter implements java.awt.event.ActionListener 
	{
		Acomodacao adaptee;

		Acomodacao_jBinserir_actionAdapter(Acomodacao adaptee) 
		{
			this.adaptee = adaptee;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				adaptee.inserir(e);
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
	}

	private class Acomodacao_jBalterar_actionAdapter implements java.awt.event.ActionListener 
	{
		Acomodacao adaptee;

		Acomodacao_jBalterar_actionAdapter(Acomodacao adaptee) 
		{
			this.adaptee = adaptee;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				adaptee.alterar(e);
			} 
			catch (NumberFormatException e1) 
			{
				e1.printStackTrace();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
	}

	private class Acomodacao_jBverificarAcomodacao_actionAdapter implements java.awt.event.ActionListener 
	{
		Acomodacao adaptee;

		Acomodacao_jBverificarAcomodacao_actionAdapter(Acomodacao adaptee) 
		{
			this.adaptee = adaptee;
		}
		
		public void actionPerformed(ActionEvent e) 
		{
			try 
			{
				adaptee.verificarAcomodacao();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
	}	
}