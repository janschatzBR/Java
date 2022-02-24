import Inhotel.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class Estadia extends JFrame 
{
	BeanEstadia est1;
	BeanHospede hosp1;
	BeanAcomodacao acom1;
	boolean clickProximoAnterior;
	private JTextField jTdataCheckIn = new JTextField();
	private JTextField jThoraCheckIn = new JTextField();
	private JTextField jTdataSaidaPrevista = new JTextField();
	private JTextField jThoraSaidaPrevista = new JTextField();
	private JTextField jTcpfHosp = new JTextField();
	private JTextField jTqtdeAcompanhante = new JTextField();
	private JTextField jTcodigoAcomodacao = new JTextField();
	private JTextField jTprecoDaDiaria = new JTextField();
	private JTextField jTdesconto = new JTextField();
	private JTextField jTdataCheckOut = new JTextField();
	private JTextField jThoraCheckOut = new JTextField();
	private JTextField jTjaPagou = new JTextField();
	private JTextField jThospExiste = new JTextField();	
	private JLabel jLdataCheckIn = new JLabel();
	private JLabel jLhoraCheckIn = new JLabel();
	private JLabel jLdataSaidaPrevista = new JLabel();
	private JLabel jLhoraSaidaPrevista = new JLabel();
	private JLabel jLcpfHosp = new JLabel();
	private JLabel jLqtdeAcompanhante = new JLabel();
	private JLabel jLcodigoAcomodacao = new JLabel();
	private JLabel jLprecoDaDiaria = new JLabel();
	private JLabel jLdesconto = new JLabel(); 
	private JLabel jLdataCheckOut = new JLabel();
	private JLabel jLhoraCheckOut = new JLabel();
	private JLabel jLjaPagou = new JLabel();
	private JLabel jLhospExiste = new JLabel(); 
	private JButton jBefetuarCheckIn = new JButton();
	private JButton jBexcluir = new JButton();
	private JButton jBanterior = new JButton();
	private JButton jBproximo = new JButton();
	private JButton jBlimpar = new JButton();
	private JButton jBalterar = new JButton();
	private JButton jBpagamento = new JButton();
	private JButton jBefetuarCheckOut = new JButton();
	private JButton jBverificarCheckOut = new JButton();
	private JButton jBacomodacao = new JButton();
	private JButton jBverificarHospede = new JButton();
	private JButton jBverificarAcomodacao = new JButton();          	
	private JTextArea jTAaviso = new JTextArea();

	public Estadia(int cpfHosp,int precoDaDiaria, int desconto,int codigoAcomodacao,int qtdeAcompanhante,Date  dataPrevistaCheckOut, int horaPrevistaCheckOut) throws Exception 
	{
		super("Menu de Opções - Estadias");
		
		jbInit(cpfHosp,precoDaDiaria,desconto,codigoAcomodacao,qtdeAcompanhante, dataPrevistaCheckOut, horaPrevistaCheckOut);
	}
	
	public Estadia()
	{
		jTdataCheckIn.setText( "" );
		jThoraCheckIn.setText( "" );
		jTdataSaidaPrevista.setText( "" );
		jThoraSaidaPrevista.setText( "" );
		jTcpfHosp.setText( "" );
		jTqtdeAcompanhante.setText( "" );
		jTcodigoAcomodacao.setText( "" );
		jTprecoDaDiaria.setText( "" );
		jTdesconto.setText( "" );
		jTdataCheckOut.setText( "3000-01-01" );
		jThoraCheckOut.setText( "9999" );
		jTjaPagou.setText("Não");
		jThospExiste.setText("Não");
	}
  
	private void jbInit(int cpfHosp,int precoDaDiaria, int desconto,int codigoAcomodacao,int qtdeAcompanhante, Date dataPrevistaCheckOut, int horaPrevistaCheckOut) throws Exception 
	{
		this.setSize(new Dimension(550, 700));
		this.setLocation( 250, 20 );
		this.getContentPane().setBackground(Color.gray);
		this.setLocale(java.util.Locale.getDefault());
		this.setResizable(false);
		this.getContentPane().setLayout(null);
		
		jLdataCheckIn.setBounds(new Rectangle(25, 30, 170, 19));
		jLdataCheckIn.setText("Data do check-in");	
		jLdataCheckIn.setFont(new java.awt.Font("Serif", 1, 15));
		jLhoraCheckIn.setBounds(new Rectangle(25, 65, 170, 19));		
		jLhoraCheckIn.setText("Hora do check-in");
		jLhoraCheckIn.setFont(new java.awt.Font("Serif", 1, 15));
		jLdataSaidaPrevista.setBounds(new Rectangle(25, 100, 170, 19));
		jLdataSaidaPrevista.setText("Data de saída prevista");
		jLdataSaidaPrevista.setFont(new java.awt.Font("Serif", 1, 15));
		jLhoraSaidaPrevista.setBounds(new Rectangle(25, 135, 170, 19));
		jLhoraSaidaPrevista.setText("Hora de saída prevista");
		jLhoraSaidaPrevista.setFont(new java.awt.Font("Serif", 1, 15));
		jLcpfHosp.setBounds(new Rectangle(25, 170, 170, 19));
		jLcpfHosp.setText("CPF do hóspede");	
		jLcpfHosp.setFont(new java.awt.Font("Serif", 1, 15));
		jLqtdeAcompanhante.setBounds(new Rectangle(25, 205, 200, 19));
		jLqtdeAcompanhante.setText("Quantidade de acompanhantes");
		jLqtdeAcompanhante.setFont(new java.awt.Font("Serif", 1, 15));
		jLcodigoAcomodacao.setBounds(new Rectangle(25, 240, 170, 19));
		jLcodigoAcomodacao.setText("Código da acomodação");	
		jLcodigoAcomodacao.setFont(new java.awt.Font("Serif", 1, 15));
		jLprecoDaDiaria.setBounds(new Rectangle(25, 275, 170, 19));
		jLprecoDaDiaria.setText("Preço da diária");	
		jLprecoDaDiaria.setFont(new java.awt.Font("Serif", 1, 15));
		jLdesconto.setBounds(new Rectangle(25, 310, 170, 19));
		jLdesconto.setText("Desconto");
		jLdesconto.setFont(new java.awt.Font("Serif", 1, 15));
		jLdataCheckOut.setBounds(new Rectangle(25, 345, 170, 19));
		jLdataCheckOut.setText("Data do check-out");
		jLdataCheckOut.setFont(new java.awt.Font("Serif", 1, 15));
		jLhoraCheckOut.setBounds(new Rectangle(25, 380, 170, 19));
		jLhoraCheckOut.setText("Hora do check-out");	
		jLhoraCheckOut.setFont(new java.awt.Font("Serif", 1, 15));
		jLjaPagou.setBounds(new Rectangle(25, 415, 170, 19));
		jLjaPagou.setText("Pagamento realizado?");	
		jLjaPagou.setFont(new java.awt.Font("Serif", 1, 15));
		jLhospExiste.setBounds(new Rectangle(25, 450, 170, 19));
		jLhospExiste.setText("Hospede existe?");	
		jLhospExiste.setFont(new java.awt.Font("Serif", 1, 15));
		jTdataCheckIn.setBounds(new Rectangle(240, 30, 100, 26));
		jTdataCheckIn.setSelectedTextColor(Color.white);
		jTdataCheckIn.setText("");
		jThoraCheckIn.setBounds(new Rectangle(240, 65, 50, 26));
		jThoraCheckIn.setSelectedTextColor(Color.white);
		jThoraCheckIn.setText("");
		jTdataSaidaPrevista.setBounds(new Rectangle(240, 100, 100, 26));
		jTdataSaidaPrevista.setSelectedTextColor(Color.white);
		jTdataSaidaPrevista.setText(""+dataPrevistaCheckOut);
		jThoraSaidaPrevista.setBounds(new Rectangle(240, 135, 50, 26));
		jThoraSaidaPrevista.setSelectedTextColor(Color.white);
		jThoraSaidaPrevista.setText(""+horaPrevistaCheckOut);
		jTcpfHosp.setBounds(new Rectangle(240, 170, 150, 26));
		jTcpfHosp.setSelectedTextColor(Color.white);
		jTcpfHosp.setText(""+cpfHosp);
		jTqtdeAcompanhante.setBounds(new Rectangle(240, 205, 50, 26));
		jTqtdeAcompanhante.setSelectedTextColor(Color.white);
		jTqtdeAcompanhante.setText(""+qtdeAcompanhante);
		jTcodigoAcomodacao.setBounds(new Rectangle(240, 240, 100, 26));
		jTcodigoAcomodacao.setSelectedTextColor(Color.white);
		jTcodigoAcomodacao.setText(""+codigoAcomodacao);
		jTprecoDaDiaria.setBounds(new Rectangle(240, 275, 110, 26));
		jTprecoDaDiaria.setSelectedTextColor(Color.white);
		jTprecoDaDiaria.setText(""+precoDaDiaria);
		jTdesconto.setBounds(new Rectangle(240, 310, 110, 26));
		jTdesconto.setSelectedTextColor(Color.white);
		jTdesconto.setText(""+desconto);
		jTdataCheckOut.setBounds(new Rectangle(240, 345, 100, 26));
		jTdataCheckOut.setSelectedTextColor(Color.white);
		jTdataCheckOut.setText("3000-01-01");
		jThoraCheckOut.setBounds(new Rectangle(240, 380, 50, 26));
		jThoraCheckOut.setSelectedTextColor(Color.white);
		jThoraCheckOut.setText("9999");
		jTjaPagou.setBounds(new Rectangle(240, 415, 50, 26));
		jTjaPagou.setSelectedTextColor(Color.white);
		jTjaPagou.setText("Não");
		jTjaPagou.setEditable(false);
		jThospExiste.setBounds(new Rectangle(240, 450, 50, 26));
		jThospExiste.setSelectedTextColor(Color.white);
		jThospExiste.setText("Não");
		jThospExiste.setEditable(false);
		jBefetuarCheckIn.setBounds(new Rectangle(14, 500, 150, 28));
		jBefetuarCheckIn.setText("Efetuar CheckIn");
		jBefetuarCheckIn.addActionListener(new Estadia_jBefetuarCheckIn_actionAdapter(this));
		jBexcluir.setBounds(new Rectangle(89, 550, 82, 28));
		jBexcluir.setText("Excluir");
		jBexcluir.addActionListener(new Estadia_jBexcluir_actionAdapter(this));
		jBanterior.setBounds(new Rectangle(166, 550, 82, 28));
		jBanterior.setText("Anterior");
		jBanterior.addActionListener(new Estadia_jBanterior_actionAdapter(this));
		jBproximo.setBounds(new Rectangle(237, 550, 82, 28));
		jBproximo.setText("Próximo");
		jBproximo.addActionListener(new Estadia_jBproximo_actionAdapter(this));
		jBlimpar.setBounds(new Rectangle(318, 550, 82, 28));
		jBlimpar.setText("Limpar");
		jBlimpar.addActionListener(new Estadia_jBlimpar_actionAdapter(this));
		jBalterar.setBounds(new Rectangle(399, 550, 82, 28));
		jBalterar.setText("Alterar");
		jBalterar.addActionListener(new Estadia_jBalterar_actionAdapter(this));
		jBverificarHospede.setBounds(new Rectangle(400, 170, 140, 28));
		jBverificarHospede.setText("Verificar Hóspede");
		jBverificarHospede.addActionListener(new Estadia_jBverificarHospede_actionAdapter(this));
		jBacomodacao.setBounds(new Rectangle(400, 240, 120, 28));
		jBacomodacao.setText("Acomodação");
		jBacomodacao.addActionListener(new Estadia_jBacomodacao_actionAdapter(this));
		jBverificarAcomodacao.setBounds(new Rectangle(375, 275, 165, 28));
		jBverificarAcomodacao.setText("Verificar Acomodação");
		jBverificarAcomodacao.addActionListener(new Estadia_jBverificarAcomodacao_actionAdapter(this));
		jBefetuarCheckOut.setBounds(new Rectangle(380, 345, 150, 28));
		jBefetuarCheckOut.setText("Efetuar CheckOut");
		jBefetuarCheckOut.addActionListener(new Estadia_jBefetuarCheckOut_actionAdapter(this));
		jBverificarCheckOut.setBounds(new Rectangle(380, 380, 150, 28));
		jBverificarCheckOut.setText("Verificar CheckOut");
		jBverificarCheckOut.addActionListener(new Estadia_jBverificarCheckOut_actionAdapter(this));
		jBpagamento.setBounds(new Rectangle(410, 415, 105, 28));
		jBpagamento.setText("Pagamento");
		jBpagamento.addActionListener(new Estadia_jBpagamento_actionAdapter(this));
		jBpagamento.setVisible(false);
	
		jTAaviso.setBounds(new Rectangle(89, 580, 390, 50));
		
		this.getContentPane().add(jLdataCheckIn, null);
		this.getContentPane().add(jTdataCheckIn, null);
		this.getContentPane().add(jThoraCheckIn, null);
		this.getContentPane().add(jLhoraCheckIn, null);
		this.getContentPane().add(jLdataSaidaPrevista, null);
		this.getContentPane().add(jTdataSaidaPrevista, null);
		this.getContentPane().add(jLhoraSaidaPrevista, null);
		this.getContentPane().add(jThoraSaidaPrevista, null);
		this.getContentPane().add(jLcpfHosp, null);
		this.getContentPane().add(jTcpfHosp, null);
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
		this.getContentPane().add(jTjaPagou, null);
		this.getContentPane().add(jLjaPagou, null);
		this.getContentPane().add(jThospExiste, null);
		this.getContentPane().add(jLhospExiste, null);
		this.getContentPane().add(jBefetuarCheckIn, null);
		this.getContentPane().add(jBexcluir, null);
		this.getContentPane().add(jBanterior, null);
		this.getContentPane().add(jBproximo, null);
		this.getContentPane().add(jBlimpar, null);
		this.getContentPane().add(jBalterar, null);
		this.getContentPane().add(jBpagamento, null);
		this.getContentPane().add(jBefetuarCheckOut, null);
		this.getContentPane().add(jBverificarCheckOut, null);
		this.getContentPane().add(jBacomodacao, null);
		this.getContentPane().add(jBverificarHospede, null);
		this.getContentPane().add(jBverificarAcomodacao, null);
		this.getContentPane().add(jTAaviso, null);		
	}

	void fechar(WindowEvent e) 
	{
		this.setVisible(false);
	}
  
	public void VerificarHospede()
	{   	
		hosp1 = new BeanHospede();
		hosp1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText()));
		String mensagem = hosp1.VerificaHospede();
    
		jTAaviso.setText(mensagem);
		
		if (mensagem.equals("temvalor"))
    	{
    		jTAaviso.setText("Hospede encontrado no banco de dados");
    		jThospExiste.setText("Sim");
    	}
		else
			jTAaviso.setText("Hospede nao cadastrado");
	}

	void inserir(ActionEvent e) 
	{ 
		clickProximoAnterior=false;
	
		est1= new BeanEstadia();
		est1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText()));
		est1.setDataCheckIn(java.sql.Date.valueOf(jTdataCheckIn.getText()) );
		est1.setHoraCheckIn(Integer.parseInt(jThoraCheckIn.getText()) );
		est1.setDataSaidaPrevista(java.sql.Date.valueOf(jTdataSaidaPrevista.getText() ) );
		est1.setHoraSaidaPrevista(Integer.parseInt(jThoraSaidaPrevista.getText()) );
		est1.setQtdeAcompanhante(Integer.parseInt(jTqtdeAcompanhante.getText() ));
		est1.setCodigoAcomodacao(Integer.parseInt(jTcodigoAcomodacao.getText()) );
		est1.setPrecoDaDiaria(Integer.parseInt(jTprecoDaDiaria.getText()) );
		est1.setDesconto(Integer.parseInt(jTdesconto.getText()) );
		est1.setDataCheckOut(java.sql.Date.valueOf(jTdataCheckOut.getText() ));
		est1.setHoraCheckOut(Integer.parseInt(jThoraCheckOut.getText()) );
		est1.setJaPagou(jTjaPagou.getText() );
	
		String mensagem =  est1.Efetuar_CheckIn();
		jTAaviso.setText(mensagem);
		jBefetuarCheckOut.setVisible(true);
		jBverificarCheckOut.setVisible(true);	
		jBpagamento.setVisible(false);
	}

	void excluir(ActionEvent e) 
	{
		clickProximoAnterior=false;

		est1= new BeanEstadia();
		jTAaviso.setText(est1.Excluir(Integer.parseInt(jTcpfHosp.getText() )));
	}

	void alterar(ActionEvent e) 
	{
		clickProximoAnterior = false;

		est1= new BeanEstadia();
		est1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText()));
		est1.setDataCheckIn(java.sql.Date.valueOf(jTdataCheckIn.getText()) );
		est1.setHoraCheckIn(Integer.parseInt( jThoraCheckIn.getText()) );
		est1.setDataSaidaPrevista(java.sql.Date.valueOf(jTdataSaidaPrevista.getText() ) );
		est1.setHoraSaidaPrevista(Integer.parseInt(jThoraSaidaPrevista.getText()) );
		est1.setQtdeAcompanhante(Integer.parseInt(jTqtdeAcompanhante.getText() ));
		est1.setCodigoAcomodacao(Integer.parseInt(jTcodigoAcomodacao.getText()) );
		est1.setPrecoDaDiaria(Integer.parseInt(jTprecoDaDiaria.getText()) );
		est1.setDesconto(Integer.parseInt(jTdesconto.getText()) );
		est1.setDataCheckOut(java.sql.Date.valueOf(jTdataCheckOut.getText() ));
		est1.setHoraCheckOut(Integer.parseInt(jThoraCheckOut.getText()) );
		est1.setJaPagou(jTjaPagou.getText() );
		jTAaviso.setText(est1.Alterar_Dados_BeanEstadia( ));
	}		

	void limpar(ActionEvent e) 
	{
		jTdataCheckIn.setText( "" );
		jThoraCheckIn.setText( "" );
		jTdataSaidaPrevista.setText( "" );
		jThoraSaidaPrevista.setText( "" );
		jTcpfHosp.setText( "" );
		jTqtdeAcompanhante.setText( "" );
		jTcodigoAcomodacao.setText( "" );
		jTprecoDaDiaria.setText( "" );
		jTdesconto.setText( "" );
		jTdataCheckOut.setText( "3000-01-01" );
		jThoraCheckOut.setText( "9999" );
		jTjaPagou.setText("Não");
	}

	void Proximo(ActionEvent e) 
	{
		if(!clickProximoAnterior)
		{
			est1 = new BeanEstadia();
			clickProximoAnterior=true;
		}
  	
		String mensagem = est1.Proximo();
		
		if(mensagem.equals("Proximo ok"))
		{
			exibirEstadia();
		}
  		else
  			jTAaviso.setText(mensagem);
	}
    
	void Anterior(ActionEvent e) 
	{
		if(!clickProximoAnterior)
		{
			est1 = new  BeanEstadia();
			clickProximoAnterior=true;
		}
	
		String mensagem = 	est1.Anterior();
  	
		if(mensagem.equals("Anterior ok")) 
  		{
			exibirEstadia();
  		} 		
		else
			jTAaviso.setText(mensagem);
	}

	public void exibirEstadia() 
	{
		jTcpfHosp.setText(""+est1.getCpfHosp() );
		jTdataCheckIn.setText(""+ est1.getDataCheckIn() );	
		jThoraCheckIn.setText(""+ est1.getHoraCheckIn() );
		jTdataSaidaPrevista.setText(""+ est1.getDataSaidaPrevista() );
		jThoraSaidaPrevista.setText(""+ est1.getHoraSaidaPrevista()  );
		jTqtdeAcompanhante.setText(""+ est1.getQtdeAcompanhante()  ); 
		jTcodigoAcomodacao.setText(""+ est1.getCodigoAcomodacao()  ); 
		jTprecoDaDiaria.setText(""+ est1.getPrecoDaDiaria() ); 
		jTdesconto.setText(""+ est1.getDesconto() )  ; 
		jTdataCheckOut.setText(""+ est1.getDataCheckOut()   ); 
		jThoraCheckOut.setText(""+ est1.getHoraCheckOut() );
		jTjaPagou.setText(""+est1.getJaPagou()); 
		jTAaviso.setText("");
      
		String mensagem = jTdataCheckOut.getText();
       
		if(!mensagem.equals("3000-01-01"))
		{
			jBpagamento.setVisible(true);
		}
	   	else
	   	{
	   		jBpagamento.setVisible(false);
	   	}
	}
  
  
  
  
  void efetuarCheckOut(ActionEvent e)
  {
  	
  	clickProximoAnterior=false;
	try{
	
    est1= new BeanEstadia();
    est1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText()));
    est1.setDataCheckOut(java.sql.Date.valueOf(jTdataCheckOut.getText() ));
	est1.setHoraCheckOut(Integer.parseInt(jThoraCheckOut.getText()) );
	est1.setCodigoAcomodacao(Integer.parseInt(jTcodigoAcomodacao.getText()) );
	String mensagem = est1.EfetuarCheckOut();
	jTAaviso.setText(mensagem);
	if( mensagem.equals("Check Out realizado com sucesso!"))
		jBpagamento.setVisible(true);
	}catch(Exception e1) {jTAaviso.setText("Check out nao realizado");}
	
  }

void verificarCheckOut(ActionEvent e)
{
	clickProximoAnterior=false;
	
    est1= new BeanEstadia();
    est1.setCpfHosp(Integer.parseInt(jTcpfHosp.getText()));
    est1.setDataCheckOut(java.sql.Date.valueOf(jTdataCheckOut.getText() ));
	est1.setHoraCheckOut(Integer.parseInt(jThoraCheckOut.getText()) );
	
	String mensagem =est1.verificaCheckOut();
	jTAaviso.setText(mensagem);
	if (mensagem.equals("Fez Check Out") )
		jBpagamento.setVisible(true);
		
	
	
 }

    //LINKA PARA OUTRA INTERFACE
 void pagamento(ActionEvent e) {
  	clickProximoAnterior=false;
  	int teste =Integer.parseInt(jTcpfHosp.getText());
  	Pagamento pagamento = new Pagamento(teste);
  	
  	pagamento.show();
  	if (pagamento.JaPagou())
         jTjaPagou.setText("Sim");
 	System.out.println(teste);
  	   
  }
  
  void acomodacao(ActionEvent e) {
  	clickProximoAnterior=false;
  	int teste2 =Integer.parseInt(jTcpfHosp.getText());
  	
  	int codigo= Integer.parseInt(jTcodigoAcomodacao.getText());
  	Acomodacao acomodacao = null;
	try {
		acomodacao = new Acomodacao(codigo);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}//teste2);
  	acomodacao.show();
//  	codigo = acomodacao.salvarNro();
  	jTcodigoAcomodacao.setText(""+codigo);

 	//System.out.println(teste);
  	   
  }
  
  void VerificarAcomodacao() throws SQLException
  {
  	
	acom1 = new BeanAcomodacao();
	acom1.setCodigoAcomodacao(Integer.parseInt(jTcodigoAcomodacao.getText()));
	String mensagem = acom1.VerificarAcomodacao();
	if (mensagem.equals("temvalor"))
		jTAaviso.setText("Acomodacao disponivel! ");
	else
		jTAaviso.setText("Acomodacao nao disponivel");
  }
  
  
  
  
 // void hospede(ActionEvent e) {
  	//clickProximoAnterior=false;
  	//int teste3 =Integer.parseInt(jTcpfHosp.getText());
  //	Hospede hospede = new Hospede(teste3);
  //	hospede.show();
  	//System.out.println(teste);
      	   
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

  class Estadia_jBefetuarCheckIn_actionAdapter implements java.awt.event.ActionListener {
    Estadia adaptee;

    Estadia_jBefetuarCheckIn_actionAdapter(Estadia adaptee) {
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
	  adaptee.excluir(e);
    }
  }

  class Estadia_jBanterior_actionAdapter implements java.awt.event.ActionListener {
    Estadia adaptee;

    Estadia_jBanterior_actionAdapter(Estadia adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  adaptee.Anterior(e);
    }
  }

  class Estadia_jBproximo_actionAdapter implements java.awt.event.ActionListener {
    Estadia adaptee;

    Estadia_jBproximo_actionAdapter(Estadia adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  adaptee.Proximo(e);
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

  class Estadia_jBalterar_actionAdapter implements java.awt.event.ActionListener {
    Estadia adaptee;

    Estadia_jBalterar_actionAdapter(Estadia adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  adaptee.alterar(e);
    }
  }
  
  class Estadia_jBpagamento_actionAdapter implements java.awt.event.ActionListener {
    Estadia adaptee;

    Estadia_jBpagamento_actionAdapter(Estadia adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  adaptee.pagamento(e);
    }
  }


class Estadia_jBverificarCheckOut_actionAdapter implements java.awt.event.ActionListener {
    Estadia adaptee;

    Estadia_jBverificarCheckOut_actionAdapter(Estadia adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  adaptee.verificarCheckOut(e);
    }
  }


class Estadia_jBefetuarCheckOut_actionAdapter implements java.awt.event.ActionListener {
    Estadia adaptee;

    Estadia_jBefetuarCheckOut_actionAdapter(Estadia adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  adaptee.efetuarCheckOut(e);
    }
  }

  class Estadia_jBacomodacao_actionAdapter implements java.awt.event.ActionListener {
    Estadia adaptee;

    Estadia_jBacomodacao_actionAdapter(Estadia adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  adaptee.acomodacao(e);
    }
  }
  
  class Estadia_jBverificarHospede_actionAdapter implements java.awt.event.ActionListener {
    Estadia adaptee;

    Estadia_jBverificarHospede_actionAdapter(Estadia adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  adaptee.VerificarHospede();
    }
  }
  
  
  
  class Estadia_jBverificarAcomodacao_actionAdapter implements java.awt.event.ActionListener {
    Estadia adaptee;

    Estadia_jBverificarAcomodacao_actionAdapter(Estadia adaptee) {
	  this.adaptee = adaptee;
    }
    public void actionPerformed(ActionEvent e) {
	  try {
		adaptee.VerificarAcomodacao();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    }
  }


