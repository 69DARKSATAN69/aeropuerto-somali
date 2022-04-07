package pkgaeropuerto.modelo;

import java.time.LocalTime;

public class Regular extends Vuelo {

	private int plazasLibres;
	private LocalTime horario;

	public Regular(String destino, String avion, int plazas, int plazasRestantes) {
		super(destino, avion, plazas);
		plazasLibres = plazasRestantes;

	}

	public int getPlazasLibres() {
		return plazasLibres;
	}

	public void setPlazasLibress(int plazasRestantes) {
		this.plazasLibres = plazasRestantes;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("\nPlazas Libres: ");
		sb.append(plazasLibres);
		return sb.toString();
	}

}
