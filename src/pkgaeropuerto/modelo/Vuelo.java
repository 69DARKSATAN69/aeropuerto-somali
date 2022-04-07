package pkgaeropuerto.modelo;

import java.util.Objects;

public abstract class Vuelo implements Comparable<Vuelo> {

	private String destino;
	private String modelo;
	private int plazas;

	public Vuelo(String destino, String modelo, int plazas) {
		this.destino = destino;
		this.modelo = modelo;
		this.plazas = plazas;

	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(destino, modelo, plazas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Vuelo))
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(destino, other.destino) && Objects.equals(modelo, other.modelo) && plazas == other.plazas;
	}

	public int compareTo(Vuelo vuelo) {
		if (this.destino.compareTo(vuelo.getDestino()) > 0) {
			return -1;
		}
		if (this.destino.compareTo(vuelo.getDestino()) < 0) {
			return +1;
		}

		else {
			return 0;
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nDestino: ");
		sb.append(getDestino());
		sb.append("\nModelo: ");
		sb.append(getModelo());
		sb.append("\nPlazas: ");
		sb.append(getPlazas());
		return sb.toString();
	}

}
