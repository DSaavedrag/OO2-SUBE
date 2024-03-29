package test;

import java.util.List;

import datos.Boleto;
import datos.LectorTren;
import datos.Tarjeta;
import negocio.LectorTrenABM;
import negocio.TarjetaABM;

public class TestCrearBoletoTren {
	public static void main(String[] args) throws Exception {
		LectorTrenABM labm = LectorTrenABM.getInstanciaLectorTrenABM();
		TarjetaABM tabm = TarjetaABM.getInstanciaTarjetaABM();
		Tarjeta tarjeta = tabm.traer(3);	
		LectorTren lector = labm.traer(10);
		System.out.println(lector);
		lector.crearBoleto(tarjeta);
		List<Boleto> lista= tabm.traerBoletosDeTarjeta(tarjeta.getIdTarjeta());
		Boleto boletoAux = lista.get(lista.size()-1);
		System.out.println(boletoAux);
	}

}
