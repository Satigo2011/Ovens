package co.edu.upb.Ovens;

import java.util.Scanner;

public class GestorUsuarios {
    private Operador operador;

    public GestorUsuarios(Operador operador) {
        this.operador = operador;
    }

    public void registrarNuevoUsuario(Scanner scanner) {
        System.out.println("Ingrese los datos del nuevo usuario:");

        System.out.print("Nombre: ");
        String nombre = scanner.next();
        scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.next();
        scanner.nextLine();

        System.out.print("Dirección: ");
        String direccion = scanner.next();
        scanner.nextLine();

    
        String tipoCliente;
        do {
            System.out.print("Tipo de cliente (Premium/Común): ");
            tipoCliente = scanner.next().toLowerCase(); // Convierte a minúsculas para ser insensible a mayúsculas

            if (!tipoCliente.equals("premium") && !tipoCliente.equals("común")) {
                System.out.println("Tipo de cliente no válido. Intente nuevamente.");
            }
        } while (!tipoCliente.equals("premium") && !tipoCliente.equals("común"));
        scanner.nextLine();

        System.out.print("Número de teléfono: ");
        String telefono = scanner.next();
        scanner.nextLine();

        // Crear un nuevo usuario y agregarlo a la base de datos
        Usuario nuevoUsuario = new Usuario(nombre, apellido, direccion, tipoCliente, telefono);
        operador.agregarUsuario(nuevoUsuario);

        System.out.println("Usuario registrado con éxito.");
    }
}