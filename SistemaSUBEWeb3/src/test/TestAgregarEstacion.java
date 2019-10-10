package test;

import negocio.EstacionABM;

public class TestAgregarEstacion {
	public static void main(String[] args) throws Exception {
		String estacion = "Glew";
		EstacionABM abm = EstacionABM.getInstanciaEstacionABM();
		abm.agregar(estacion);
		estacion = "Longchamps";
		abm.agregar(estacion);
		estacion = "Burzaco";
		abm.agregar(estacion);
		estacion = "Adrogue";
		abm.agregar(estacion);
		estacion = "Temperley";
		abm.agregar(estacion);
		estacion = "Lomas";
		abm.agregar(estacion);
		estacion = "Banfield";
		abm.agregar(estacion);
		estacion = "Escalada";
		abm.agregar(estacion);
		estacion = "Lanus";
		abm.agregar(estacion);
		estacion = "Gerli";
		abm.agregar(estacion);
		estacion = "Avellaneda";
		abm.agregar(estacion);
		estacion = "Irigoyen";
		abm.agregar(estacion);
		estacion = "Consti";
		abm.agregar(estacion);
		System.out.println("Cargado Exitosamente");
	}
}
