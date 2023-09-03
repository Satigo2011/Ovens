package co.edu.upb.ListaCircularDoblementeEnlazada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaCircularDoblementeEnlazada lista = new ListaCircularDoblementeEnlazada();
        Scanner scanner = new Scanner(System.in);
        
        int opcion;
        do {
            System.out.println("Menu:");
            System.out.println("1Insertar elemento");
            System.out.println("2Mostrar lista");
            System.out.println("3Buscar y modificar elemento");
            System.out.println("4Obtener tamano");
            System.out.println("0Salir");
            System.out.print("Ingrese su opcion:");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.print("elemento a insertar:");
                    int elemento = scanner.nextInt();
                    lista.insertar(elemento);
                    break;
                case 2:
                    System.out.println("Lista");
                    lista.mostrar();
                    break;
                case 3:
                    System.out.print("ingrese el elemento que quiere buscar y modificar");
                    int elementoBusqueda = scanner.nextInt();
                    System.out.print("nuevo valor:");
                    int nuevoValor = scanner.nextInt();
                    if (lista.buscarYModificar(elementoBusqueda, nuevoValor)) {
                        System.out.println("Elemento" + elementoBusqueda + " encontrado y modificado.");
                    } else {
                        System.out.println("Elemento " + elementoBusqueda + " no encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Tamaño:" + lista.obtenerTamano());
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
        
        scanner.close();
    }
}