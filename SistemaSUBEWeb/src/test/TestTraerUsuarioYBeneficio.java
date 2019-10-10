package test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import datos.Usuario;
import negocio.BoletoABM;
import negocio.LectorSubteABM;
import negocio.UsuarioABM;

public class TestTraerUsuarioYBeneficio {
	public static void main(String[] args) throws Exception{
		UsuarioABM abm = UsuarioABM.getInstanciaUsuarioABM();
		Usuario usuario = abm.traerUsuarioYBeneficio(1);
		GregorianCalendar fechaIni = new GregorianCalendar(2018,Calendar.JUNE, 0);
		GregorianCalendar fechaFin = new GregorianCalendar();
		System.out.println("\ntraer Usuario y Beneficio \n"+usuario+"\n"+usuario.getBeneficio());
		BoletoABM babm = BoletoABM.getInstanciaBoletoABM();
		System.out.println(babm.estadisticaPorTransporte(fechaIni,fechaFin));

	}
}
