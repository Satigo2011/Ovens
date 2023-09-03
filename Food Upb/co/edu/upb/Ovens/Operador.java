package co.edu.upb.Ovens;

public class Operador {
	    private ListaUsuarios listaUsuarios;

	    // Constructor
	    public Operador() {
	        this.listaUsuarios = new ListaUsuarios();
	    }

	    // Método para agregar un nuevo usuario a la base de datos
	    public void agregarUsuario(Usuario nuevoUsuario) {
	        listaUsuarios.agregarUsuario(nuevoUsuario);
	    }

	    // Método para buscar un usuario por número de teléfono
	    public Usuario buscarUsuarioPorTelefono(String telefono) {
	        return listaUsuarios.buscarUsuarioPorTelefono(telefono);
	    }

	    // Método para registrar un pedido para un usuario
	    public void tomarPedido(String telefono, Pedido pedido) {
	        Usuario usuario = buscarUsuarioPorTelefono(telefono);

	        if (usuario != null) {
	            // Obtener la pila de pedidos del usuario
	            PilaPedidos pilaPedidos = usuario.getPilaPedidos();
	            if (pilaPedidos == null) {
	                pilaPedidos = new PilaPedidos();
	                usuario.setPilaPedidos(pilaPedidos);
	            }

	            // Apilar el pedido
	            pilaPedidos.apilarPedido(pedido);
	            System.out.println("Pedido registrado con éxito.");
	        } else {
	            System.out.println("Usuario no encontrado. Registre el número de teléfono primero.");
	        }
	    }

	    // Otros métodos según tus necesidades
	    // ...
	}
