package mundo;

import estructuras.ListaDoble;
import estructuras.Pila;

public class Campus {

	private ListaDoble<Persona> personas;
	private Pila<Persona> eliminados;

	public Campus() {
		personas = new ListaDoble<>();
		eliminados = new Pila<>();
	}
	

	public Persona buscarPersona(String numeroDocumento) {

		for (int i = 0; i < personas.getTamanio(); i++) {

			Persona actual = personas.obtener(i);

			if (actual.getNumeroDocumento().equals(numeroDocumento)) {
				return actual;
			}
		}

		return null;
	}
	

	public void agregarPersona(Persona persona) throws CampusException {

		if (persona == null) {
			throw new DatoInvalidoException("La persona no puede ser nula");
		}

		if (buscarPersona(persona.getNumeroDocumento()) != null) {
			throw new RegistroDuplicadoException(
					"Ya existe una persona con el documento " + persona.getNumeroDocumento());
		}

		personas.agregar(persona);
	}
	

	public void actualizarPersona(String numeroDocumento, String nombre, String correo) throws CampusException {

		validarTexto(numeroDocumento, "El número de documento no puede estar vacío");

		validarTexto(nombre, "El nombre no puede estar vacío");

		validarTexto(correo, "El correo no puede estar vacío");

		Persona persona = buscarPersona(numeroDocumento);

		if (persona == null) {
			throw new CampusException("No existe una persona con el documento " + numeroDocumento);
		}

		persona.setNombre(nombre);
		persona.setCorreo(correo);
	}
	

	public void eliminarPersona(String numeroDocumento) throws CampusException {

		validarTexto(numeroDocumento, "El número de documento no puede estar vacío");

		Persona persona = buscarPersona(numeroDocumento);

		if (persona == null) {
			throw new CampusException("No existe una persona con el documento " + numeroDocumento);
		}

		personas.eliminar(persona);
		eliminados.apilar(persona);
	}
	

	public Persona restaurarUltimoEliminado() throws CampusException {

		if (eliminados.estaVacia()) {
			throw new CampusException("No hay personas eliminadas para restaurar");
		}

		Persona persona = eliminados.desapilar();

		personas.agregar(persona);

		return persona;
	}
	

	public Pila<Persona> darEliminados() {
		return eliminados;
	}
	

	public ListaDoble<Persona> darPersonas() {
		return personas;
	}
	

	public int darTotalEstudiantes() {

		int total = 0;

		for (int i = 0; i < personas.getTamanio(); i++) {

			if (personas.obtener(i) instanceof Estudiante) {
				total++;
			}
		}

		return total;
	}
	

	public int darTotalProfesores() {

		int total = 0;

		for (int i = 0; i < personas.getTamanio(); i++) {

			if (personas.obtener(i) instanceof Profesor) {
				total++;
			}
		}

		return total;
	}
	

	public int darTotalAdministrativos() {

		int total = 0;

		for (int i = 0; i < personas.getTamanio(); i++) {

			if (personas.obtener(i) instanceof Administrativo) {
				total++;
			}
		}

		return total;
	}
	

	public int darTotalDirectivos() {

		int total = 0;

		for (int i = 0; i < personas.getTamanio(); i++) {

			if (personas.obtener(i) instanceof Directivo) {
				total++;
			}
		}

		return total;
	}
	

	private void validarTexto(String texto, String mensaje) throws DatoInvalidoException {

		if (texto == null || texto.trim().isEmpty()) {
			throw new DatoInvalidoException(mensaje);
		}
	}
	
	public void ordenarPorNombre() {
		 for (int i = 0; i < personas.getTamanio() - 1; i++) {
			 for (int j = 0; j < personas.getTamanio() - i - 1; j ++) {
				 
				 Persona actual = personas.obtener(j);
				 Persona siguiente = personas.obtener(j + 1);
				 
				 if (actual.getNombre().compareToIgnoreCase(siguiente.getNombre()) > 0) {
					 personas.cambiar(j, siguiente);
					 personas.cambiar(j + 1, actual);
				 }
			 }
		 }
	}


	public int darTotalPersonas() {
		return personas.getTamanio();
	}


	public String darProgramaOArea(Persona persona) {

		if (persona instanceof Estudiante) {
			return ((Estudiante) persona).getPrograma();
		}

		if (persona instanceof Director) {
			return ((Director) persona).getPrograma();
		}

		if (persona instanceof Empleado) {
			return ((Empleado) persona).getArea();
		}

		return "";
	}


	public ListaDoble<Persona> filtrarPorProgramaOArea(String texto) throws CampusException {

		validarTexto(texto, "Debe indicar el programa o el área a filtrar");

		ListaDoble<Persona> filtradas = new ListaDoble<>();

		for (int i = 0; i < personas.getTamanio(); i++) {

			Persona actual = personas.obtener(i);

			if (darProgramaOArea(actual).equalsIgnoreCase(texto.trim())) {
				filtradas.agregar(actual);
			}
		}

		return filtradas;
	}
}