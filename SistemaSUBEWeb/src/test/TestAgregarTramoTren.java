package test;

import datos.Estacion;
import datos.SeccionTren;
import negocio.EstacionABM;
import negocio.SeccionTrenABM;
import negocio.TramoTrenABM;

public class TestAgregarTramoTren {
	public static void main(String[] args) throws Exception {
		EstacionABM eabm = EstacionABM.getInstanciaEstacionABM();
		Estacion estacion1 = eabm.traer(1);
		Estacion estacion2 = eabm.traer(2);
		SeccionTrenABM sabm = SeccionTrenABM.getInstanciaSeccionTrenABM();
		SeccionTren seccionTren = sabm.traer(1);
		TramoTrenABM abm = TramoTrenABM.getInstanciaTramoTrenABM();
		abm.agregar(estacion1, estacion2, seccionTren);
		System.out.println("Cargado Exitosamente");
	}

}
