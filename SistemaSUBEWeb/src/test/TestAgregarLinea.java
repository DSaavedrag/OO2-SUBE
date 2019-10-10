package test;

import negocio.LineaABM;

public class TestAgregarLinea {
	public static void main(String[] args) throws Exception {
		String linea1 = "SV-79";
		String linea2 = "SV-74";
		String linea3 = "160";
		String linea4 = "SUBTE";
		String linea5 = "LG.ROCA";
		LineaABM abm = LineaABM.getInstanciaLineaABM();
		abm.agregar(linea1);
		abm.agregar(linea2);
		abm.agregar(linea3);
		abm.agregar(linea4);
		abm.agregar(linea5);
		System.out.println("Cargado Exitosamente");
	}
}
