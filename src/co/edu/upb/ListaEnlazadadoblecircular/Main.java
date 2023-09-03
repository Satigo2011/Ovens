package co.edu.upb.ListaEnlazadadoblecircular;

public class Main {
    public static void main(String[] args) {
        Enlazadadoblecircular<Integer> lista = new Enlazadadoblecircular<>();

        lista.add(10);
        lista.add(20);
        lista.add(30);
        lista.add(40);

        System.out.println("Lista original:");
        lista.displayList();

        System.out.println("Tamano de la lista: " + lista.size());
        System.out.println("El primer elemento es: " + lista.get());
        System.out.println("El ultimo elemento es: " + lista.getFromEnd());

        Integer[] array = lista.toArray();
        System.out.print("Array generado a partir de la lista: ");
        for (Integer num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        lista.sortObjectsBySize();
        System.out.println("Lista despues de ordenar:");
        lista.displayList();

        lista.pop();
        System.out.println("Lista despues de eliminar el primer elemento:");
        lista.displayList();

        lista.remove(30);
        System.out.println("Lista despues de eliminar el elemento 30:");
        lista.displayList();

        lista.addOnHead(5);
        lista.addOnHead(15);
        System.out.println("Lista despues de agregar elementos al principio:");
        lista.displayList();

        Integer[] subListArray = lista.subList(lista.nodeOf(20), lista.nodeOf(40)).toArray();
        System.out.print("Sublista generada a partir de los nodos 20 y 40: ");
        for (Integer num : subListArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        Integer[] getFromEndArray = lista.getFromEnd(3);
        System.out.print("Elementos obtenidos desde el final (3 elementos): ");
        for (Integer num : getFromEndArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        Integer[] removeArray = {5, 20};
        lista.removeAll(removeArray);
        System.out.println("Lista despues de eliminar elementos 5 y 20:");
        lista.displayList();

        Integer[] retainArray = {15, 40};
        lista.retainAll(retainArray);
        System.out.println("Lista despues de retener elementos 15 y 40:");
        lista.displayList();
    }
}