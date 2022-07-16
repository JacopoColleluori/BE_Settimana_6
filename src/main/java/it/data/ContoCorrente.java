package it.data;

public class ContoCorrente {
private Integer pin;
private String instestatario;
private Double saldo;
private Integer numero;




public Integer getNumero() {
	return numero;
}

public void setNumero(Integer numero) {
	this.numero = numero;
}

public Integer getPin() {
	return pin;
}

public void setPin(Integer pin) {
	this.pin = pin;
}

public String getInstestatario() {
	return instestatario;
}
public void setInstestatario(String instestatario) {
	this.instestatario = instestatario;
}
public Double getSaldo() {
	return saldo;
}
public void setSaldo(Double saldo) {
	this.saldo = saldo;
}

@Override
public String toString() {
	return "ContoCorrente [pin=" + pin + ", instestatario=" + instestatario + ", saldo=" + saldo + ", numero=" + numero
			+ "]";
}

}
