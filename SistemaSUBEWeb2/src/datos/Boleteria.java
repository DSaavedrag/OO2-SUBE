package datos;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import negocio.CargaABM;
import negocio.Funciones;
import negocio.TarjetaABM;
import negocio.UsuarioABM;

public class Boleteria {
	private long idBoleteria;
	private String boleteria;
	private Set<Carga> cargas;
	
	public Boleteria (){}

	public Boleteria(String boleteria) {
		this.boleteria = boleteria;
	}

	public long getIdBoleteria() {
		return idBoleteria;
	}

	protected void setIdBoleteria(long idBoleteria) {
		this.idBoleteria = idBoleteria;
	}

	public String getBoleteria() {
		return boleteria;
	}

	public void setBoleteria(String boleteria) {
		this.boleteria = boleteria;
	}

	
	public Set<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(Set<Carga> cargas) {
		this.cargas = cargas;
	}
	
	public void cargarSaldo(Tarjeta tarjeta, double monto) throws Exception{
		if (tarjeta.isBaja())throw new Exception("La tarjeta fue dada de baja");
		UsuarioABM uabm = UsuarioABM.getInstanciaUsuarioABM();
		Usuario usuario = null;
		int diaBoletoEstudiantil = 5;
		boolean boletoEstudiantil=false;
		CargaABM cabm = CargaABM.getInstanciaCargaABM();
		TarjetaABM tabm = TarjetaABM.getInstanciaTarjetaABM();
		GregorianCalendar fechaHoraCarga = new GregorianCalendar();
		Carga cargaAux = null;
		Beneficio beneficio = null;	
		List<Carga> cargas = tabm.traerCargasDeTarjeta(tarjeta.getIdTarjeta());
		int fechaMesAux = 0;
		int fechaDiaAux = 0;
		if(!cargas.isEmpty()){
			cargaAux = cargas.get(cargas.size()-1);
			if(cargaAux!=null){
				fechaMesAux = Funciones.traerNumeroMes(cargaAux.getFechaHoraCarga());
				fechaDiaAux = Funciones.traerNumeroDiaMes(cargaAux.getFechaHoraCarga());
			}
			if(fechaMesAux<Funciones.traerNumeroMes(fechaHoraCarga)){
				if(fechaDiaAux>=diaBoletoEstudiantil){
					cargaAux.setBoletoEstudiantil(false);
					cabm.modificar(cargaAux);
				}
			}else{
				cargaAux.setBoletoEstudiantil(false);
				cabm.modificar(cargaAux);
			}
		}
		if(tarjeta.getUsuario()!=null){
			usuario = uabm.traerUsuarioYBeneficio(tarjeta.getUsuario().getIdUsuario());
			if(usuario!=null){
				beneficio = usuario.getBeneficio();	
			}
		}
		if(monto<0) {
		
			if(cargaAux==null){
				cargaAux= new Carga(null,null, null, 0, true);
			}
			if(cargaAux.isBoletoEstudiantil()){
				if(beneficio instanceof BoletoEstudiantil){
					if(fechaMesAux<=Funciones.traerNumeroMes(fechaHoraCarga)){
						if(fechaDiaAux<diaBoletoEstudiantil){
							monto=300;
							boletoEstudiantil=true;
						}else{
							throw new Exception("Aun no puedes solicitar el boleto estudiantil");
						}
					}else{
						throw new Exception("Aun no puedes solicitar el boleto estudiantil");
					}
				}else{
					throw new Exception("No eres beneficiario de Boleto Estudiantil");	
				}
			}else{
				throw new Exception("Ya has solicitado tu Boleto Estudiantil este mes");
			}
		}
		cabm.agregar(tarjeta, this, fechaHoraCarga, monto, boletoEstudiantil);
		double saldoNuevo = tarjeta.getSaldo()+monto;
		tarjeta.setSaldo(saldoNuevo);
		tabm.modificar(tarjeta);
	}
	@Override
	public String toString() {
		return "Boleteria [idBoleteria=" + idBoleteria + ", boleteria=" + boleteria + "]";
	}
	
	

}
