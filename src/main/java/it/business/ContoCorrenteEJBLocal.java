package it.business;

import it.data.ContoCorrente;
import jakarta.ejb.Local;



@Local
public interface ContoCorrenteEJBLocal {
	public boolean controllaOperazione(String operazione,Float quantita,int pin,int numero);
	public boolean versa(int numero, float quantita,int pin);
	public boolean preleva(int numero, double saldo,int pin);
	public boolean esiste(int numero,int pin);
	public ContoCorrente getContoCorrente(int pin, int numero);
}
