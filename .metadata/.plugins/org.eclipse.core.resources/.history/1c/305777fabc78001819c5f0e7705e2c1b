package test;

import java.util.GregorianCalendar;

import datos.Usuario;
import negocio.TarjetaABM;
import negocio.UsuarioABM;

public class TestAgregarTarjeta {
	public static void main(String[] args) throws Exception {
		double saldo = 284.70;
		boolean redSUBE = false;
		int nivelRS = 0;
		boolean baja = false;
		GregorianCalendar inicioRS = new GregorianCalendar();
		TarjetaABM abm = TarjetaABM.getInstanciaTarjetaABM();
		UsuarioABM uabm = UsuarioABM.getInstanciaUsuarioABM();
		Usuario usuario = uabm.traerI(1);
		abm.agregar(saldo, nivelRS,inicioRS, baja,null);
		System.out.println("Cargado Exitosamente");
		abm.agregar(saldo, nivelRS,inicioRS, baja,usuario);
		System.out.println("Cargado Exitosamente");
		usuario = uabm.traerI(2);
		abm.agregar(saldo, nivelRS,inicioRS, baja,usuario);
		System.out.println("Cargado Exitosamente");
		abm.agregar(saldo, nivelRS,inicioRS, true,null);
		System.out.println("Cargado Exitosamente");
	}
}
