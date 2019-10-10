package controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import datos.Boleteria;
import datos.Tarjeta;
import negocio.BoleteriaABM;
import negocio.TarjetaABM;

public class ControladorCargarSaldo extends HttpServlet {
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
			int idTarjeta = Integer . parseInt ( request . getParameter ( "idTarjeta" ));
			int idBoleteria = Integer . parseInt ( request . getParameter ( "idBoleteria" ));
			double monto = Double.parseDouble(request . getParameter ( "monto" ));
			BoleteriaABM boleteriaAbm = BoleteriaABM.getInstanciaBoleteriaABM();
			TarjetaABM tarjetaAbm = TarjetaABM.getInstanciaTarjetaABM();
			Tarjeta tarjeta = tarjetaAbm.traerTarjetaYUsuario(idTarjeta);
			Boleteria boleteria = boleteriaAbm.traer(idBoleteria);
			if(tarjeta==null){
				tarjeta = tarjetaAbm.traer(idTarjeta);
			}
			double montoAnterior = tarjeta.getSaldo();
			boleteria.cargarSaldo(tarjeta, monto);
			double montoActual = tarjeta.getSaldo();
			session.setAttribute("Tarjeta", tarjeta);
			session.setAttribute("Boleteria", boleteria);
			session.setAttribute("montoAnterior", montoAnterior);
			session.setAttribute("montoActual", montoActual);
			request.getRequestDispatcher("carga.jsp").forward(request, response);
		}catch (Exception e) {
			response.sendError(500,e.getMessage());
		}
		
	}

}