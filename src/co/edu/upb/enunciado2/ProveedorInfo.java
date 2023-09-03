package co.edu.upb.enunciado2;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ProveedorInfo {

    public static void main(String[] args) {
        Map<String, Proveedor> proveedores = new LinkedHashMap<>();
        agregarProveedor(proveedores, "bluray", "Piedecuesta", 266);
        agregarProveedor(proveedores, "popsy", "Cucuta", 59);
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Mostrar informacion del proveedor");
            System.out.println("2. Actualizar nombre de la ciudad");
            System.out.println("3. Actualizar numero de articulos");
            System.out.println("4. Agregar nuevo proveedor");
            System.out.println("5. Eliminar proveedor");
            System.out.println("6. Salir");
            System.out.print("\nIngrese la opcion deseada: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    mostrarInfo(proveedores, scanner);
                    break;
                case 2:
                    actualizarCiudad(proveedores, scanner);
                    break;
                case 3:
                    actualizarNumArticulos(proveedores, scanner);
                    break;
                case 4:
                    agregarNuevo(proveedores, scanner);
                    break;
                case 5:
                    eliminarProveedor(proveedores, scanner);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        } while (opcion != 6);
    }

    private static void agregarProveedor(Map<String, Proveedor> proveedores, String nombre, String ciudad, int numArticulos) {
        Proveedor proveedor = new Proveedor(nombre, ciudad, numArticulos);
        proveedores.put(nombre, proveedor);
    }
    
    private static void mostrarInfo(Map<String, Proveedor> proveedores, Scanner scanner) {
        System.out.print("Ingrese el nombre del proveedor: ");
        String nombreProveedor = scanner.nextLine();
        Proveedor proveedor = proveedores.get(nombreProveedor);
        if (proveedor != null) {
            System.out.println("Proveedor: " + nombreProveedor);
            System.out.println("Ciudad: " + proveedor.getCiudad());
            System.out.println("Numero de articulos: " + proveedor.getNumArticulos());
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }

    private static void actualizarCiudad(Map<String, Proveedor> proveedores, Scanner scanner) {
        System.out.print("Ingrese el nombre del proveedor: ");
        String nombreProveedor = scanner.nextLine();
        Proveedor proveedor = proveedores.get(nombreProveedor);
        if (proveedor != null) {
            System.out.print("Ingrese el nuevo nombre de la ciudad: ");
            String nuevaCiudad = scanner.nextLine();
            proveedor.setCiudad(nuevaCiudad);
            System.out.println("Ciudad actualizada.");
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }

    private static void actualizarNumArticulos(Map<String, Proveedor> proveedores, Scanner scanner) {
        System.out.print("Ingrese el nombre del proveedor: ");
        String nombreProveedor = scanner.nextLine();
        Proveedor proveedor = proveedores.get(nombreProveedor);
        if (proveedor != null) {
            System.out.print("Ingrese el nuevo numero de articulos: ");
            int nuevoNumArticulos = scanner.nextInt();
            proveedor.setNumArticulos(nuevoNumArticulos);
            System.out.println("Numero de articulos actualizado.");
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }

    private static void agregarNuevo(Map<String, Proveedor> proveedores, Scanner scanner) {
        System.out.print("Ingrese el nombre del proveedor: ");
        String nombreProveedor = scanner.nextLine();
        if (proveedores.containsKey(nombreProveedor)) {
            System.out.println("Error: El proveedor ya existe.");
        } else {
            System.out.print("Ingrese el nombre de la ciudad: ");
            String ciudad = scanner.nextLine();
            System.out.print("Ingrese el total de articulos: ");
            int numArticulos = scanner.nextInt();
            agregarProveedor(proveedores, nombreProveedor, ciudad, numArticulos);
            System.out.println("Proveedor agregado.");
        }
    }

    private static void eliminarProveedor(Map<String, Proveedor> proveedores, Scanner scanner) {
        System.out.print("Ingrese el nombre del proveedor a eliminar: ");
        String nombreProveedor = scanner.nextLine();
        if (proveedores.containsKey(nombreProveedor)) {
            proveedores.remove(nombreProveedor);
            System.out.println("Proveedor eliminado.");
        } else {
            System.out.println("Proveedor no encontrado.");
        }
    }
}