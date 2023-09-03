package co.edu.upb.Ovens;

import java.util.Scanner;

public class BaseDeDatosClientes {
    public static void main(String[] args) {
        Operador operador = new Operador();

        // Registrar tres clientes de prueba en la base de datos
        Usuario cliente1 = new Usuario("Juan", "Perez", "Calle A 123", "Premium", "111-111-1111");
        Usuario cliente2 = new Usuario("Maria", "Gomez", "Calle B 456", "Común", "222-222-2222");
        Usuario cliente3 = new Usuario("Pedro", "Lopez", "Calle C 789", "Premium", "333-333-3333");

        operador.agregarUsuario(cliente1);
        operador.agregarUsuario(cliente2);
        operador.agregarUsuario(cliente3);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de teléfono del usuario:");
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

    // Método para mostrar la información de un usuario
    private static void mostrarInfoUsuario(Usuario usuario) {
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellido: " + usuario.getApellido());
        System.out.println("Dirección: " + usuario.getDireccion());
        System.out.println("Tipo de cliente: " + usuario.getTipoCliente());
        System.out.println("Teléfono: " + usuario.getTelefono());
    }
}