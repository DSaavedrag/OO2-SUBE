package test;

import java.util.List;

import datos.Boleto;
import datos.LectorColectivo;
import datos.Tarjeta;
import negocio.LectorColectivoABM;
import negocio.TarjetaABM;

public class TestCrearBoletoColectivo {
	public static void main(String[] args) throws Exception {
			LectorColectivoABM labm = LectorColectivoABM.getInstanciaLectorColectivoABM();
			TarjetaABM tabm = TarjetaABM.getInstanciaTarjetaABM();
			Tarjeta tarjeta = tabm.traer(3);	
			LectorColectivo lector = new LectorColectivo();
			lector=labm.traer(2);
			lector.setEstado(4); //1=10; 2=10.5; 3=10.75; 4=11//
			System.out.println(lector);
			lector.crearBoleto(tarjeta);
			List<Boleto> lista= tabm.traerBoletosDeTarjeta(tarjeta.getIdTarjeta());
			Boleto boletoAux = lista.get(lista.size()-1);
			System.out.println(boletoAux);

	}

}
