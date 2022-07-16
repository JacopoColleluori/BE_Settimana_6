package it.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import it.business.ContoCorrenteEJB;
import it.data.ContoCorrente;

/**
 * Servlet implementation class ServletVisualizzaConto
 */
public class ServletVisualizzaConto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	ContoCorrenteEJB contoSrv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVisualizzaConto() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContoCorrente conto=new ContoCorrente();
		String operazione="saldo";
		Float  quantita=(float)0;
		//PrintWriter out=response.getWriter();
		Integer numConto= Integer.valueOf(request.getParameter("numConto"));
		Integer pinConto= Integer.valueOf(request.getParameter("pinConto"));
		HttpSession session=request.getSession();
		
		if (contoSrv.controllaOperazione(operazione, quantita, pinConto, numConto)) {
		conto=contoSrv.getContoCorrente(pinConto,numConto);
		System.out.println(conto.getInstestatario());
		session.setAttribute("Conto",conto);
		session.setAttribute("Operazione",operazione);
		session.setAttribute("Quantita",quantita);
		request.getServletContext().getRequestDispatcher("/conto.jsp").forward(request, response);
	}
	}
}
