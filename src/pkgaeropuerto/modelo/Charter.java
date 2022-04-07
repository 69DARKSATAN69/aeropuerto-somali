package pkgaeropuerto.modelo;

public class Charter extends Vuelo {

	private String nifEmpresa;

	public Charter(String destino, String modelo, int plazas, String nif) {
		super(destino, modelo, plazas);
		this.nifEmpresa = nif;

	}

	public String getNif() {
		return nifEmpresa;
	}

	public void setNif(String nif) {
		this.nifEmpresa = nif;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("\nNif Empresa: ");
		sb.append(nifEmpresa);
		return sb.toString();
	}

}
