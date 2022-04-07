package pkgaeropuerto.modelo;

import java.util.*;
import java.util.Map.Entry;

public class Aeropuerto {

	private String aerolinea;
	TreeMap<String, ArrayList<Vuelo>> aeropuerto;

	public Aeropuerto() {
		
		aeropuerto = new TreeMap<>();
	}

	/**
	 * Añade un vuelo a la aerolinea correspondiente solo en el caso de que el vuelo
	 * no estuviese ya introducido, si la aerolinea no existiese se añade tanto la
	 * aerolinea como el vuelo.
	 */
	public void addVuelo(String aerolinea, Vuelo vuelo) {

		if (aeropuerto.containsKey(aerolinea)) {
			aeropuerto.get(aerolinea).add(vuelo);
		}

		else {
			ArrayList<Vuelo> l = new ArrayList<>();
			l.add(vuelo);
			aeropuerto.put(aerolinea, l);

		}
	}

	/**
	 * public void sortAerolineas() { Collections.sort(aeropuerto, new
	 * Comparator<Aerolinea>() { public int compare(Aerolinea aerolinea1, Aerolinea
	 * aerolinea2) { return
	 * aerolinea1.getNombre().compareTo(aerolinea2.getNombre()); } }); }
	 **/

	/**
	 * Imprime los vuelos por cada aerolinea ordenados por destino, tanto aerolineas
	 * como vuelos estaran ordenados alfabeticamente (Ver resultados de ejecucion)
	 */
	public void ordenAerolineasAlfabetico() {
		Set<String> aerolineas = aeropuerto.keySet();

		for (String s : aerolineas) {
			System.out.println(s);
			aeropuerto.get(s).sort(new Comparator<Vuelo>() {
				public int compare(Vuelo vuelo1, Vuelo vuelo2) {
					return vuelo1.getDestino().compareTo(vuelo2.getDestino());
				}
			});
			System.out.println(aeropuerto.get(s).toString());
		}

	}

	/**
	 * Muestra los vuelos regulares de la aerolinea pasada por parametro, se
	 * visualizaran de mayor a menor segun el numero de plazas
	 * 
	 * @param aerolinea Aerolinea de la que se imprimiran los vuelos regulares
	 */
	public void regularPorPlazas(String aerolinea) {

		List<Vuelo> vuelos = new ArrayList<>();
		List<Regular> regulares = new ArrayList<>();
		vuelos = aeropuerto.get(aerolinea);
		for (Vuelo v : vuelos) {
			if (v instanceof Regular) {
				regulares.add((Regular) v);
			}
		}
		if (!regulares.isEmpty()) {
			regulares.sort(new Comparator<Regular>() {
				public int compare(Regular reg1, Regular reg2) {
					return reg1.getPlazas() - reg2.getPlazas();
				}
			});
			System.out.println(regulares.toString());
		} else {
			System.out.println("No había ningún vuelo regular");
		}

	}

	/**
	 * Devuelve una lista con vuelos regulares con plazas libres
	 * 
	 * 
	 */
	public List<Vuelo> plazasLibres() {

		List<Vuelo> vuelos = new ArrayList<>();
		List<Vuelo> regulares = new ArrayList<>();
		List<Vuelo> libres = new ArrayList<>();
		for (String s : aeropuerto.keySet()) {
			vuelos = aeropuerto.get(s);
			for (Vuelo v : vuelos) {
				if (v instanceof Regular) {
					regulares.add((Regular) v);
				}
			}
		}
		if (!regulares.isEmpty()) {
			for (Vuelo r : regulares) {
				if (((Regular) r).getPlazasLibres() > 0) {
					libres.add(r);
				}
			}
		} else {
			System.out.println("No había ningún vuelo regular");
		}
		return libres;
	}

	/**
	 * Muestra el numero de vuelos de cada aerolinea que llegan al destino pasado
	 * por parametro, ver resultados de ejecucion
	 * 
	 * @param destino Destino del que se debe sacar la estadistica
	 */
	public void estadisticaDestino(String destino) {
	
		int counter = 0;
		for(String s : aeropuerto.keySet()) {
			for(Vuelo v : aeropuerto.get(s)) {
				if(v.getDestino().equals(destino)) {
					counter++;
				}
			}System.out.println("Para la aerolinea: " + s + " hay " + counter + " vuelos que van hacia " + destino );
			counter = 0;
		}
	}

	/**
	 * Borra los vuelos reservados por una empresa y devuelve el numero de vuelos
	 * borrados, utiliza un conjunto de entradas
	 * 
	 * @param nifEmpresa
	 * @return numero de vuelos borrados
	 */
	public int borrarVuelosEmpresa(String nifEmpresa) {
/**		int counter = 0;
		for(String s : aeropuerto.keySet()) {
			for(Vuelo v : aeropuerto.get(s)) {
				if(v instanceof Charter) {
					if(((Charter) v).getNif().equals(nifEmpresa)){
						counter++;
						aeropuerto.get(s).remove(v);
					}
				}
			}
		}
		System.out.println("Total de vuelos borrados: " + counter);

return counter; **/		

int counter = 0;
for(String s : aeropuerto.keySet()) {
	Iterator<Vuelo> it = aeropuerto.get(s).iterator();
	while(it.hasNext()) {
		Vuelo v = it.next();
	if(v instanceof Charter) {
			if(((Charter) v).getNif().equals(nifEmpresa)) {
				counter++;
				it.remove();
			}
		}
	}}

return counter;
	}

	/**
	 * Imprime la lista de vuelos pasada por parametro
	 * 
	 * @param listaVuelos
	 */
	public void imprimirListaVuelos(List<Vuelo> listaVuelos) {
		System.out.println(listaVuelos.toString());

	}

	/**
	 * Represetación textual del mapa tal y como se muestra en el enunciado
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String s : aeropuerto.keySet()) {
			sb.append(s);
			sb.append("\n" + "================");
			for(Vuelo v : aeropuerto.get(s)) {
				sb.append("\n" + v.getClass());
				sb.append("\n----------------");
				/**sb.append("\nDestino: " + v.getDestino());
				sb.append("\nAvión: " + v.getModelo());
				sb.append("\nPlazas: " + v.getPlazas());
				if(v instanceof Regular) {
					sb.append("\nPlazas libres: " + ((Regular) v).getPlazasLibres());
				}else {
					sb.append("\nNIF Empresa: " + ((Charter) v).getNif());**/
					sb.append(v.toString());
				}
				
			}
		
		return sb.toString();

	}

	/**
	 * Rellena el mapa haciendo uso de un fichero de texto
	 */
	public void leerFicheroCursos() {
		Scanner entrada = null;
		try {
			entrada = new Scanner(this.getClass().getResourceAsStream("aviones.txt"));
			while (entrada.hasNextLine()) {
				String linea = entrada.nextLine();
				int pos = linea.indexOf(":");
				String aerolinea = linea.substring(0, pos);
				String[] vuelo = linea.substring(pos + 1).split(":");
				String destino = vuelo[1];
				String avion = vuelo[2];
				int plazas = Integer.parseInt(vuelo[3].trim());
				if (vuelo[0].equals("R")) {
					int plazasLibres = Integer.parseInt(vuelo[4].trim());
					this.addVuelo(aerolinea, new Regular(destino, avion, plazas, plazasLibres));
				} else {
					String nifEmpresa = vuelo[4];
					this.addVuelo(aerolinea, new Charter(destino, avion, plazas, nifEmpresa));
				}
			}

		}

		finally {
			try {
				entrada.close();
			} catch (NullPointerException e) {
				System.out.println("Error en IO , no se ha creado el fichero");
			}
		}

	}

}
