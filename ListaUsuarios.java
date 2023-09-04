package co.edu.upb.Operador;

public class ListaUsuarios {
	    private NodoUsuario cabeza;
	    public ListaUsuarios() {
	        this.cabeza = null;
	    }
	    public void agregarUsuario(Usuario nuevoUsuario) {
	        NodoUsuario nuevoNodo = new NodoUsuario(nuevoUsuario);

	        if (cabeza == null) {
	            cabeza = nuevoNodo;
	        } else {
	            NodoUsuario actual = cabeza;
	            while (actual.getSiguiente() != null) {
	                actual = actual.getSiguiente();
	            }
	            actual.setSiguiente(nuevoNodo);
	        }
	    }

	    public Usuario buscarUsuarioPorTelefono(String telefono) {
	        NodoUsuario actual = cabeza;
	        while (actual != null) {
	            if (actual.getUsuario().getTelefono().equals(telefono)) {
	                return actual.getUsuario();
	            }
	            actual = actual.getSiguiente();
	        }
	        return null;
	    }
	    public void eliminarUsuarioPorTelefono(String telefono) {
	        if (cabeza == null) {
	            return;
	        }

	        if (cabeza.getUsuario().getTelefono().equals(telefono)) {
	            cabeza = cabeza.getSiguiente();
	            return;
	        }
	        NodoUsuario actual = cabeza;
	        NodoUsuario previo = null;

	        while (actual != null && !actual.getUsuario().getTelefono().equals(telefono)) {
	            previo = actual;
	            actual = actual.getSiguiente();
	        }

	        if (actual != null) {
	            previo.setSiguiente(actual.getSiguiente());
	        }
	    }
	}