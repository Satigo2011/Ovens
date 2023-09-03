package co.edu.upb.Ovens;
import java.util.Scanner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operador operador = new Operador();
        GestorUsuarios gestorUsuarios = new GestorUsuarios(operador);

        // Inicializar clientes de prueba
        InicializadorClientes.inicializarClientes(operador);

        while (true) {
            System.out.println("Bienvenido al módulo de operador. Elija una opción:");
            System.out.println("1. Buscar cliente por número de teléfono");
            System.out.println("2. Registrar un nuevo usuario");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    MenuOperador.buscarCliente(scanner, operador);
                    break;
                case 2:
                    gestorUsuarios.registrarNuevoUsuario(scanner);
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}