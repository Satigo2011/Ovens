package co.edu.upb.Operador;

import java.util.Scanner;

public class BaseDeDatosClientes {
		Operador operador = new Operador();
    	public static void inicializarClientes(Operador operador) {
        
        Usuario cliente1 = new Usuario("Fernando Camilo", "Diaz Cote", "Carrera 4ta Nr° 4 #30-12", "Premium", "3155024924");
        Usuario cliente2 = new Usuario("Maria Antonella", "De las nieves", "Calle 10ma Nr° 12-21", "Común", "3145221367");
        Usuario cliente3 = new Usuario("Pedro Rias", "Gomez Lopez", "Calle 7ma #10-30", "Premium", "3163925653");

        operador.agregarUsuario(cliente1);
        operador.agregarUsuario(cliente2);
        operador.agregarUsuario(cliente3);
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el numero de telefono del Cliente:");
        String telefono = scanner.next();
        Usuario usuario = operador.buscarUsuarioPorTelefono(telefono);

        if (usuario != null) {
            System.out.println("Usuario encontrado:");
            mostrarInfoUsuario(usuario);
        } else {
            System.out.println("Usuario no encontrado.");
        }

        scanner.close();
    }

    private static void mostrarInfoUsuario(Usuario usuario) {
        System.out.println("Nombre:" + usuario.getNombre());
        System.out.println("Apellido:" + usuario.getApellido());
        System.out.println("Direccion:" + usuario.getDireccion());
        System.out.println("Tipo de cliente:" + usuario.getTipoCliente());
        System.out.println("Teléfono:" + usuario.getTelefono());
    }
}
