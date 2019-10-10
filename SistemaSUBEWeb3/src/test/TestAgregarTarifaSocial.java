package test;
import negocio.TarifaSocialABM;

public class TestAgregarTarifaSocial {
	public static void main(String[] args) throws Exception {
		String beneficio= "Plan 2" ;
		double porcentajeDescuento = 0.45;
		TarifaSocialABM tabm = TarifaSocialABM.getInstanciaTarifaSocialABM();
		tabm.agregar(beneficio, porcentajeDescuento);
		System.out.println("Cargado Exitosamente");
	}
}