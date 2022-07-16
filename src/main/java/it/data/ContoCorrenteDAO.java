package it.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ContoCorrenteDAO {

	public Double prelievo(ContoCorrente conto) {

		return conto.getSaldo();
	}

	public ContoCorrente getContoCorrente(int pin, int numero) {
		ContoCorrente conto = new ContoCorrente();
		Connection conn = ConnectionFactory.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			String q = "SELECT * from contocorrente where numero =" + numero + " AND pin =" + pin;

			st = conn.createStatement();
			rs = st.executeQuery(q);
			rs.next();
			conto.setInstestatario(rs.getString("intestatario"));
			conto.setNumero(rs.getInt("numero"));
			conto.setSaldo(rs.getDouble("saldo"));
			conto.setPin(rs.getInt("pin"));
			System.out.println("Presa Dati conto effettuata");
		} catch (SQLException ex) {
			System.out.println("Ricerca Dati Conto fallita");
			ex.printStackTrace();
			return conto;
		}
		return conto;
	}

	public boolean esiste(int numero,int pin) {
		boolean result = false;
		Connection conn = ConnectionFactory.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			String q = "SELECT EXISTS(SELECT * from contocorrente where numero = "+numero+" and pin="+pin+")";
			st = conn.createStatement();
			rs = st.executeQuery(q);
			rs.next();
			result = rs.getBoolean(1);
			System.out.println("Ricerca effettuata");
		} catch (SQLException ex) {
			System.out.println("Ricerca fallita");
			ex.printStackTrace();
		}

		return result;
	}

	public boolean preleva(int numero, double saldo,int pin) {
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement ps=null;
		
		int i=0;
		try {
			String q = "UPDATE contocorrente SET saldo= saldo -? WHERE numero=? AND pin = ?";
			ps= conn.prepareStatement(q);
			ps.setDouble(1, saldo);
			ps.setInt(2, numero);
			ps.setInt(3, pin);
			i=ps.executeUpdate();
			
			System.out.println("Ricerca effettuata");
		} catch (SQLException ex) {
			System.out.println("Ricerca fallita");
			ex.printStackTrace();
		}
		
		return i>0;
	}
	
	public boolean versa(int numero,float quantita,int pin) {
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement ps=null;
		
		int i=0;
		try {
			String q = "UPDATE contocorrente SET saldo= saldo +? WHERE numero=? AND pin = ?";
			ps= conn.prepareStatement(q);
			ps.setDouble(1, quantita);
			ps.setInt(2, numero);
			ps.setInt(3, pin);
			i=ps.executeUpdate();
			
			System.out.println("Ricerca effettuata");
		} catch (SQLException ex) {
			System.out.println("Ricerca fallita");
			ex.printStackTrace();
		}
		
		return i>0;
	}

}
