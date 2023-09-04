package co.edu.upb.Operador;

import java.util.Scanner;

public class MenuOperador {
    public static void buscarCliente(Scanner scanner, Operador operador) {
        System.out.println("Ingrese el número de teléfono del cliente:");
        String telefono = scanner.next();

        Usuario cliente = operador.buscarUsuarioPorTelefono(telefono);

        if (cliente != null) {
            System.out.println("Cliente encontrado:");
            mostrarInfoUsuario(cliente);

            System.out.println("\n¿Qué desea hacer?");
            System.out.println("1 Tomar un pedido");
            System.out.println("2 Volver al menu");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    tomarPedido(scanner, operador, cliente);
                    break;
                case 2:
                    break; 
                default:
                    System.out.println("Opción no válida. Volviendo al menú principal.");
            }
        } else {
            System.out.println("Cliente no encontrado. Intente de nuevo.");
        }
    }

    public static void tomarPedido(Scanner scanner, Operador operador, Usuario cliente) {
    }

    private static void mostrarInfoUsuario(Usuario usuario) {
        System.out.println("Nombre: " + usuario.getNombre());
        System.out.println("Apellido: " + usuario.getApellido());
        System.out.println("Dirección: " + usuario.getDireccion());
        System.out.println("Tipo de cliente: " + usuario.getTipoCliente());
        System.out.println("Teléfono: " + usuario.getTelefono());
    }
}
