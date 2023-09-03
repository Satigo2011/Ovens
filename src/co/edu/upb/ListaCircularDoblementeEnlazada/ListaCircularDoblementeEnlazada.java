package co.edu.upb.ListaCircularDoblementeEnlazada;
public class ListaCircularDoblementeEnlazada {
    Nodo cabeza;
    int tamaño;

    public ListaCircularDoblementeEnlazada() {
        cabeza = null;
        tamaño = 0;
    }
    
    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            nuevo.siguiente = cabeza;
            nuevo.anterior = cabeza.anterior;
            cabeza.anterior.siguiente = nuevo;
            cabeza.anterior = nuevo;
        }
        tamaño++;
    }
    
    public void mostrar() {
        if (cabeza == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        
        Nodo actual = cabeza;
        do {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        } while (actual != cabeza);
        System.out.println();
    }
    
    public boolean buscarYModificar(int datoBuscado, int datoNuevo) {
        if (cabeza == null) {
            return false;
        }
        
        Nodo actual = cabeza;
        do {
            if (actual.dato == datoBuscado) {
                actual.dato = datoNuevo;
                return true;
            }
            actual = actual.siguiente;
        } while (actual != cabeza);
        
        return false;
    }
    
    public int obtenerTamano() {
        return tamaño;
    }
}