package it.presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import it.business.ContoCorrenteEJB;
import it.data.ContoCorrente;
import it.data.ContoCorrenteDAO;

/**
 * Servlet implementation class ServletLogin
 */
public class ServletVersamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	ContoCorrenteEJB contoSrv;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVersamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContoCorrente conto=new ContoCorrente();
		String operazione="versamento";
		//PrintWriter out=response.getWriter();
		Float quantita=Float.valueOf(request.getParameter("quantita"));
		Integer numConto= Integer.valueOf(request.getParameter("numConto"));
		Integer pinConto= Integer.valueOf(request.getParameter("pinConto"));
		HttpSession session=request.getSession();
		
		if (contoSrv.controllaOperazione(operazione, (float)0, pinConto, numConto)) {
		contoSrv.versa(numConto, quantita, pinConto);
		conto=contoSrv.getContoCorrente(pinConto,numConto);
		session.setAttribute("Conto", conto);
		
		session.setAttribute("Quantita",quantita);
		request.getServletContext().getRequestDispatcher("/conto.jsp").forward(request, response);
		}{
			operazione="sbagliato";
		}
		session.setAttribute("Operazione",operazione);
		
	}

}
