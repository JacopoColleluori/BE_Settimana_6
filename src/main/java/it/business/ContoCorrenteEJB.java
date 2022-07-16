package it.business;

import it.data.ContoCorrente;
import it.data.ContoCorrenteDAO;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

/**
 * Session Bean implementation class ContoCorrenteEJB
 */
@Stateless
@LocalBean
public class ContoCorrenteEJB {
	
private ContoCorrenteDAO contoSrv=new ContoCorrenteDAO();
	/**
	 * Default constructor.
	 */
	public ContoCorrenteEJB() {
		// TODO Auto-generated constructor stub
	}

public boolean controllaOperazione(String operazione,Float quantita,int pin,int numero) {
	ContoCorrente conto=contoSrv.getContoCorrente(pin, numero);
	if(!contoSrv.esiste(numero,pin)) {
		return false;
	}else if(quantita<0) {
		return false;
	}else if(!(operazione.equals("saldo")) && !(operazione.equals("prelievo")) && !(operazione.equals("versamento"))) {
		return false;
	}else if(quantita>conto.getSaldo()) {
		return false;
	}
	
	return true;
}

public boolean versa(int numero, float quantita,int pin) {
	return contoSrv.versa(numero, quantita, pin);
	}

public boolean preleva(int numero, double saldo,int pin) {
	return contoSrv.preleva(numero, saldo, pin);
}

public boolean esiste(int numero,int pin) {
	return contoSrv.esiste(numero,pin);
}

public ContoCorrente getContoCorrente(int pin, int numero) {
	return contoSrv.getContoCorrente(pin, numero);
}
}
