package pkgaeropuerto.modelo;

import java.util.*;

public class Aerolinea {

private String nombre;	
List<Vuelo> aerolinea = new ArrayList<Vuelo>();

public Aerolinea(String nombre){
	this.nombre = nombre;
}

public void addVuelo(Vuelo vuelo) {
	aerolinea.add(vuelo);
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public List<Vuelo> getAerolinea() {
	return aerolinea;
}

public void setAerolinea(List<Vuelo> aerolinea) {
	this.aerolinea = aerolinea;
}
	
public void sortVuelos() {
	Collections.sort(aerolinea, new Comparator<Vuelo>(){
		public int compare(Vuelo vuelo1, Vuelo vuelo2) {
			return vuelo1.getDestino().compareTo(vuelo2.getDestino());
		}
	});
}

public boolean getRegular() {
	for(Vuelo r : aerolinea) {
		
			return r instanceof Regular;
		}
	return false;
	}
public String getDestino() {
	for(Vuelo r:aerolinea) {
		return getDestino();
	}return "0";
}



public String toString() {
	StringBuilder sb = new StringBuilder();
	
	for(Vuelo e : aerolinea) {
		sb.append("\n"+e.toString());}
		sb.append("Nombre: ");
		sb.append(getNombre());
		return sb.toString();
	}




}
