package test;

import datos.Lector;
import datos.LectorSubte;
import datos.Tarjeta;
import negocio.BoletoABM;
import negocio.LectorABM;
import negocio.LectorSubteABM;
import negocio.TarjetaABM;

public class TestCrearBoletoSubte {
	public static void main(String[] args) throws Exception {
		LectorSubteABM labm = LectorSubteABM.getInstanciaLectorSubteABM();
		TarjetaABM tabm = TarjetaABM.getInstanciaTarjetaABM();
		Tarjeta tarjeta = tabm.traer(2);	
		LectorSubte lector = labm.traer(7);
		System.out.println(lector);
		lector.crearBoleto(tarjeta);

	}

}
