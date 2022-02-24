package AspectJ;

import Inhotel.*;

public aspect AspectConnection 
{
	pointcut metodos() : call (* *.Proximo(..)) ||
	 					 call (* *.Anterior(..)) ||
					 	 call (* BeanHospede.Inserir(..) ) ||
						 call (* BeanHospede.VerificaHospede(..)) ||
						 call (* BeanHospede.Alterar_Dados_BeanHospede(..)) ||
						 call (* BeanHospede.Remover_BeanHospede(..)) ||
						 call (* BeanEstadia.verificaCheckOut(..)) ||
						 call (* BeanEstadia.ExibirEstadia(..)) ||
						 call (* BeanEstadia.Efetuar_CheckIn(..)) ||
						 call (* BeanEstadia.Efetuar_CheckOut(..)) ||
						 call (* BeanEstadia.Alterar_Dados_BeanEstadia(..)) ||
						 call (* BeanAcomodacao.Inserir_BeanAcomodacao(..)) ||
						 call (* BeanAcomodacao.Alterar_Dados_BeanAcomodacao(..)) ||
						 call (* BeanAcomodacao.VerificarAcomodacao(..)) ||
						 call (* BeanAcomodacao.Remover_BeanAcomodacao(..)) ||
						 call (* BeanPagamento.Efetuar_Pagamento(..)) ||
						 call (* BeanPagamento.Alterar_Dados_BeanPagamento(..)) ||
						 call (* BeanPagamento.VerificaPagamento(..)) ||
						 call (* BeanReserva.Efetuar_Reserva(..)) ||
						 call (* BeanReserva.Alterar_Dados_BeanReserva(..)) ||
						 call (* BeanReserva.Remover_BeanReserva(..)) ;
	
	before() : metodos()
	{
		BeanHospede.Conectar();
	}	
}