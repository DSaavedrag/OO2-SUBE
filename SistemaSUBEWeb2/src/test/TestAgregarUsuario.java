package test;
import datos.Beneficio;
import negocio.BeneficioABM;
import negocio.UsuarioABM;

public class TestAgregarUsuario {
	public static void main(String[] args) throws Exception {
		String apellido= "Rios" ;
		String nombre= "Leandro" ;
		int documento=10555777;
		UsuarioABM abm= UsuarioABM.getInstanciaUsuarioABM();
		BeneficioABM tabm = BeneficioABM.getInstanciaBeneficioABM();
		Beneficio beneficio = tabm.traer(1);
		abm.agregar(apellido, nombre, documento,null);
		System.out.println("Cargado Exitosamente");
	}
}