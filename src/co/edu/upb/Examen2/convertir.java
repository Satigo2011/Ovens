package co.edu.upb.Examen2;

import java.util.Scanner;

public class convertir {

	// Función para convertir un número binario a su representación hexadecimal
    public static String binarioAHexadecimal(String numeroBinario) {
        int decimal = Integer.parseInt(numeroBinario, 2);
        return Integer.toHexString(decimal).toUpperCase();
    }

    // Función para convertir un número binario a su representación octal
    public static String binarioAOctal(String numeroBinario) {
        int decimal = Integer.parseInt(numeroBinario, 2);
        return Integer.toOctalString(decimal);
    }

    public static void main(String[] args) {
        // Número binario predefinido
        String numeroBinario = "011011010001";

        System.out.println("Número binario: " + numeroBinario);
        System.out.println("************************");

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Elija una opción:");
            System.out.println("1. Ver número en hexadecimal");
            System.out.println("2. Ver número en octal");
            System.out.println("3. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    String hexadecimal = binarioAHexadecimal(numeroBinario);
                    System.out.println("Número hexadecimal: " + hexadecimal);
                    break;
                case 2:
                    String octal = binarioAOctal(numeroBinario);
                    System.out.println("Número octal: " + octal);
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
            System.out.println();
        } while (opcion != 3);
    }
}
