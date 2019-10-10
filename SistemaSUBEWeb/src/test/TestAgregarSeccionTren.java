package test;

import negocio.SeccionTrenABM;

public class TestAgregarSeccionTren {
	public static void main(String[] args) throws Exception {
		SeccionTrenABM abm = SeccionTrenABM.getInstanciaSeccionTrenABM();
		abm.agregar('1', 4);
		abm.agregar('2', 7);
		abm.agregar('3', 10);
		System.out.println("Cargado Exitosamente");
	}
}
