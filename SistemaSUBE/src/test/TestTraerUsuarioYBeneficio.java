package test;

import datos.Usuario;
import negocio.UsuarioABM;

public class TestTraerUsuarioYBeneficio {
	public static void main(String[] args) throws Exception{
		UsuarioABM abm = UsuarioABM.getInstanciaUsuarioABM();
		Usuario usuario = abm.traerUsuarioYBeneficio(1);
		System.out.println("\ntraer Usuario y Beneficio \n"+usuario+"\n"+usuario.getBeneficio());
	}
}
