package co.edu.upb.Operador;

public class NodoUsuario {
    private Usuario usuario;
    private NodoUsuario siguiente;

    // Constructor
    public NodoUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.siguiente = null;
       
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public NodoUsuario getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoUsuario siguiente) {
		this.siguiente = siguiente;
	}
}
