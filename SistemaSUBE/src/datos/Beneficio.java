package datos;

import java.util.Set;

public class Beneficio {
	private long idBeneficio;
	private String beneficio;
	private Set<Usuario> usuarios;
	
	public Beneficio() {}

	public Beneficio(String beneficio) {
		super();
		this.beneficio = beneficio;
	}

	public long getIdBeneficio() {
		return idBeneficio;
	}

	protected void setIdBeneficio(long idBeneficio) {
		this.idBeneficio = idBeneficio;
	}

	public String getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Beneficio [idBeneficio=" + idBeneficio + ", beneficio=" + beneficio + "]";
	}


}
