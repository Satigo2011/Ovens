package co.edu.upb.Operador;
import java.util.Scanner;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operador operador = new Operador();
        GestorUsuarios gestorUsuarios = new GestorUsuarios(operador);
        BaseDeDatosClientes.inicializarClientes(operador);

        while (true) {
            System.out.println("Bienvenido Operador, Este es el modulo de Ovens:");
            System.out.println("1 Ingrese el numero de telefono del cliente");
            System.out.println("2 Registrar un nuevo usuario");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    MenuOperador.buscarCliente(scanner, operador);
                    break;
                case 2:
                    gestorUsuarios.registrarNuevoUsuario(scanner);
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}