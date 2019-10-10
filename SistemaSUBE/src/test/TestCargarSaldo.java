package test;

import java.util.List;

import datos.Boleteria;
import datos.Carga;
import datos.Tarjeta;
import negocio.BoleteriaABM;
import negocio.TarjetaABM;

public class TestCargarSaldo {
	public static void main(String[] args) throws Exception {
		BoleteriaABM babm = BoleteriaABM.getInstanciaBoleteriaABM();
		TarjetaABM tabm = TarjetaABM.getInstanciaTarjetaABM();
		Tarjeta tarjeta = tabm.traer(2);	
		Boleteria boleteria = babm.traer(1);
		System.out.println(boleteria);
		//SI MANDAN VALORES NEGATIVOS EN EL MONTO, SE ENTIENDE QUE ESTAN QUERIENDO CARGAR UN BOLETO ESTUDIANTIL
		boleteria.cargarSaldo(tarjeta,-10);
		List<Carga> lista= tabm.traerCargasDeTarjeta(tarjeta.getIdTarjeta());
		Carga CargaAux = lista.get(lista.size()-1);
		System.out.println(CargaAux);

	}

}
