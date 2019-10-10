package controladores;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datos.Tarjeta;
import negocio.TarjetaABM;

public class ControladorReportes extends HttpServlet {

	protected void doGet(HttpServletRequest request , HttpServletResponse response )
			throws ServletException, IOException {
		procesarPeticion( request , response );
	}
	protected void doPost(HttpServletRequest request , HttpServletResponse response )
			throws ServletException, IOException {
		procesarPeticion( request , response );
	}
	private void procesarPeticion(HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
		response .setContentType( "text/html;charset=UTF-8" );
		HttpSession session = request.getSession();
		try {
			
			request.getRequestDispatcher("reportes.jsp").forward(request, response);
			}
			catch (Exception e) {
			response.sendError(500, "Error" );
			}
		
	}

}