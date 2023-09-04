package co.edu.upb.Operador;

import java.util.Scanner;

public class GestorUsuarios {
    private Operador operador;

    public GestorUsuarios(Operador operador) {
        this.operador = operador;
    }

    public void registrarNuevoUsuario(Scanner scanner) {
        System.out.println("Registro del usuarip:");

        System.out.print("Nombre: ");
        String nombre = scanner.next();
        scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.next();
        scanner.nextLine();

        System.out.print("Direccion: ");
        String direccion = scanner.next();
        scanner.nextLine();

    
        String tipoCliente;
        do {
            System.out.print("Tipo de cliente (Premium/Comun): ");
            tipoCliente = scanner.next().toLowerCase(); 
            if (!tipoCliente.equals("premium") && !tipoCliente.equals("comun")) {
                System.out.println("Tipo de cliente no válido. Intente nuevamente.");
            }
        } while (!tipoCliente.equals("premium") && !tipoCliente.equals("comun"));
        scanner.nextLine();

        System.out.print("Numero de teléfono: ");
        String telefono = scanner.next();
        scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(nombre, apellido, direccion, tipoCliente, telefono);
        operador.agregarUsuario(nuevoUsuario);

        System.out.println("Usuario registrado.");
    }
}