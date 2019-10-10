package test;

import java.util.List;

import datos.Boleto;
import datos.LectorSubte;
import datos.Tarjeta;
import negocio.LectorSubteABM;
import negocio.TarjetaABM;

public class TestCrearBoletoSubte {
	public static void main(String[] args) throws Exception {
		LectorSubteABM labm = LectorSubteABM.getInstanciaLectorSubteABM();
		TarjetaABM tabm = TarjetaABM.getInstanciaTarjetaABM();
		Tarjeta tarjeta = tabm.traer(2);	
		LectorSubte lector = labm.traer(8);
		System.out.println(lector);
		lector.crearBoleto(tarjeta);
		List<Boleto> lista= tabm.traerBoletosDeTarjeta(tarjeta.getIdTarjeta());
		Boleto boletoAux = lista.get(lista.size()-1);
		System.out.println(boletoAux);

	}

}
