package test;

import negocio.PrecioSubteABM;

public class TestAgregarPrecioSubte {
	public static void main(String[] args) throws Exception {
		double precio = 10;
		PrecioSubteABM pabm = PrecioSubteABM.getInstanciaPrecioSubteABM();
		pabm.agregar(precio);
		System.out.println("Cargado Exitosamente");
	}
}
