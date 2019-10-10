package test;

import datos.Linea;
import datos.SaldoMinimo;
import negocio.LectorABM;
import negocio.LineaABM;
import negocio.SaldoMinimoABM;

public class TestAgregarLector {
	public static void main(String[] args) throws Exception {
		char tipoLector= 'a' ;
		SaldoMinimo saldoMinimo = SaldoMinimoABM.getInstanciaSaldoMinimoABM().traer(1);
		Linea linea = LineaABM.getInstanciaLineaABM().traer(1);
		LectorABM abm= LectorABM.getInstanciaLectorABM();
		abm.agregar(linea, saldoMinimo, tipoLector);
	
	}
}