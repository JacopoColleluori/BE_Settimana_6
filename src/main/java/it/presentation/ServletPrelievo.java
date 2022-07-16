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
 * Servlet implementation class ServletPrelievo
 */
public class ServletPrelievo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	ContoCorrenteEJB contoSrv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrelievo() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContoCorrente conto=new ContoCorrente();
		String operazione="prelievo";
		//PrintWriter out=response.getWriter();
		Float quantPrelievo=Float.valueOf(request.getParameter("quantPrelievo"));
		Integer numConto= Integer.valueOf(request.getParameter("numConto"));
		Integer pinConto= Integer.valueOf(request.getParameter("pinConto"));
		HttpSession session=request.getSession();
		
		if (contoSrv.controllaOperazione(operazione, quantPrelievo, pinConto, numConto)) {
		contoSrv.preleva(numConto, quantPrelievo, pinConto);
		conto=contoSrv.getContoCorrente(pinConto,numConto);
		session.setAttribute("Quantita", quantPrelievo);
		session.setAttribute("Conto", conto);
		session.setAttribute("Operazione",operazione);
		request.getServletContext().getRequestDispatcher("/conto.jsp").forward(request, response);
		}

		
	}


}
