package co.edu.upb.ListaEnlazadaDoble;

public class Main {
    public static void main(String[] args) {
        Enlazadadoble<Object> list = new Enlazadadoble<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println("Lista original:");
        list.displayList();

        Integer[] headObjects = {10, 20, 30};
        list.addOnHead(headObjects);

        System.out.println("Lista después de agregar en la cabeza:");
        list.displayList();

        System.out.println("\nLista invertida:");
        list.displayList();

        list.sortObjectsBySize();

        System.out.println("Lista ordenada por tamaño:");
        list.displayList();

        Enlazadadoble<Object> clonedList = (Enlazadadoble<Object>) list.cloneList();

        System.out.println("Lista clonada:");
        clonedList.displayList();

        Integer target = 2;
        list.removeNodeAfter(target);

        System.out.println("Lista después de eliminar el nodo siguiente a " + target + ":");
        list.displayList();
    }
}