/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.upb.ListaEnlazadadoblecircular;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author
 */
public class Enlazadadoblecircular<T> implements LinkedListInterface<T> {
    private SinglyList<T> head;
    private SinglyList<T> tail;
    private SinglyList<T> inode;
    private int size;

    public Enlazadadoblecircular() {
    }

    @Override
    public boolean add(T object) {
        if (object != null) {
            try {
                if (isEmpty()) {
                    tail = head = new SinglyList<>(object);
                    head.setNext(tail);
                    head.setPrev(tail);
                    tail.setNext(head);
                    tail.setPrev(head);
                } else {
                    SinglyList<T> newNode = new SinglyList<>(object);
                    newNode.setPrev(tail);
                    newNode.setNext(head);
                    tail.setNext(newNode);
                    head.setPrev(newNode);
                    tail = newNode;
                }
                size++;
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean add(NodeInterface<T> node, T object) {
        Iterator<NodeInterface<T>> iterator = iterator();
        SinglyList<T> nodeTemp;

        if (object != null) {
            try {
                if (isEmpty()) {
                    tail = head = new SinglyList<>(object);
                    tail.setNext(head);
                } else {
                    boolean nodeFound = false;
                    do {
                        nodeTemp = (SinglyList<T>) iterator.next();
                        if (nodeTemp.equals(node)) {
                            SinglyList<T> nodeToAdd = new SinglyList<>(object);
                            nodeToAdd.setNext(nodeTemp.getNext());
                            nodeTemp.setNext(nodeToAdd);
                            if (nodeTemp.equals(tail)) {
                                tail = nodeToAdd;
                            }
                            nodeFound = true;
                        }
                    } while (!nodeFound && iterator.hasNext());
                }
                size++;
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean removeNodeBefore(T object) {
        if (head == null || head.equals(object)) {
            return false;
        }

        SinglyList<T> current = head;
        SinglyList<T> previous = null;
        SinglyList<T> beforePrevious = null;

       
        while (current != null && !current.getNext().equals(object)) {
            beforePrevious = previous;
            previous = current;
            current = current.getNext();
        }

        if (current == null) {
            return false; 
        }

        if (beforePrevious == null) {
            return false; 
        }

        beforePrevious.setNext(current);
        return true;
    }

    public boolean removeNodeAfter(T target) {
        if (head == null) {
            return false; 
        }

        SinglyList<T> current = head;

        while (current != null && !current.getObject().equals(target)) {
            current = current.getNext();
        }

        if (current == null) {
            return false; 
        }

        SinglyList<T> nodeToRemove = current.getNext();
        if (nodeToRemove == null) {
            return false;
        }

        current.setNext(nodeToRemove.getNext());
        return true;
    }

    public T buscarNodo(T dato) {
        if (head == null) {
            return null;
        }

        SinglyList<T> current = head;
        do {
            if (current.getObject().equals(dato)) {
                return current.getObject();
            }
            current = current.getNext();
        } while (current != head);

        return null;
    }

    public static <T> void insertAtPosition(SinglyList<T> head, T value, int position) {
        if (position < 0) {
            System.out.println("Position cannot be negative.");
            return;
        }

        SinglyList<T> newNode = new SinglyList<>(value);

        if (position == 0) {
            newNode.setNext(head);
            head = newNode;
            return;
        }

        SinglyList<T> current = head;
        for (int i = 0; i < position - 1 && current != null; i++) {
            current = current.getNext();
        }

        if (current == null) {
            System.out.println("Position is out of bounds.");
            return;
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
    }

    public void insertarDespuesDe(SinglyList<T> nodoAnterior, T dato) {
        if (nodoAnterior == null) {
            return;
        }
        SinglyList<T> nuevoNodo = new SinglyList<>(dato);
        nuevoNodo.setNext(nodoAnterior.getNext());
        nodoAnterior.setNext(nuevoNodo);
    }

    @Override
    public boolean add(NodeInterface<T> node, NodeInterface<T> next) {
        Iterator<NodeInterface<T>> iterator = iterator();
        SinglyList<T> nodeTemp;

        if (node != null && next != null) {
            try {
                if (node.equals(tail)) {
                    tail.setNext((SinglyList<T>) next);
                    tail = tail.getNext();
                    tail.setNext(head);
                } else {
                    boolean nodeFound = false;
                    do {
                        nodeTemp = (SinglyList<T>) iterator.next();
                        if (nodeTemp.equals(node)) {
                            SinglyList<T> nodeToAdd = (SinglyList<T>) next;
                            nodeToAdd.setNext(nodeTemp.getNext());
                            nodeTemp.setNext(nodeToAdd);
                            if (nodeToAdd.getNext().equals(tail)) {
                                tail = nodeToAdd;
                            }
                            nodeFound = true;
                        }
                    } while (!nodeFound && iterator.hasNext());
                }
                size++;
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean add(T[] objects) {
        if (objects != null && objects.length > 0) {
            try {
                if (isEmpty()) {
                    head = tail = new SinglyList<>(objects[0]);
                    head.setNext(tail);
                    tail.setNext(head);
                    size++;
                }

                for (int i = 1; i < objects.length; i++) {
                    tail.setNext(new SinglyList<>(objects[i]));
                    tail = tail.getNext();
                    size++;
                }

                tail.setNext(head);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean add(NodeInterface<T> node, T[] objects) {
        if (objects != null && objects.length > 0 && node != null) {
            try {
                Iterator<NodeInterface<T>> iterator = iterator();
                while (iterator.hasNext()) {
                    SinglyList<T> temporal = (SinglyList<T>) iterator.next();
                    if (temporal.equals(node)) {
                        SinglyList<T> nodeToAdd = new SinglyList<>(objects[0]);
                        SinglyList<T> previousNode = temporal;
                        for (int i = 1; i < objects.length; i++) {
                            SinglyList<T> newNode = new SinglyList<>(objects[i]);
                            previousNode.setNext(newNode);
                            previousNode = newNode;
                            size++;
                        }
                        previousNode.setNext(temporal.getNext());
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean addOnHead(T object) {
        if (object != null) {
            try {
                if (isEmpty()) {
                    tail = head = new SinglyList<>(object);
                    tail.setNext(head);
                } else {
                    SinglyList<T> newNode = new SinglyList<>(object);
                    newNode.setNext(head);
                    tail.setNext(newNode);
                    head = newNode;
                    tail = tail.getNext();
                }
                size++;
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean addOnHead(T[] objects) {
        if (objects != null && objects.length > 0) {
            for (int i = objects.length - 1; i >= 0; i--) {
                SinglyList<T> newNode = new SinglyList<>(objects[i]);
                newNode.setNext(head);
                head = newNode;
            }

            tail.setNext(head);
            size += objects.length;

            return true;
        }
        return false;
    }

    @Override
    public boolean clear() {
        head = null;
        tail = null;
        size = 0;
        return true;
    }

    @Override
    public Enlazadadoblecircular<T> cloneList() {
        Enlazadadoblecircular<T> clonedList = new Enlazadadoblecircular<T>();

        try {
            if (!isEmpty()) {
                Iterator<NodeInterface<T>> iterator = iterator();
                while (iterator.hasNext()) {
                    clonedList.add(iterator.next().getObject());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return clonedList;
    }

    @Override
    public boolean contains(T object) {
        Iterator<NodeInterface<T>> iterator = iterator();
        while (iterator.hasNext()) {
            SinglyList<T> nodeTemp = (SinglyList<T>) iterator.next();
            if (nodeTemp.equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(T[] objects) {
        for (T obj : objects) {
            boolean found = false;
            SinglyList<T> carry = head;
            do {
                if (carry.getObject().equals(obj)) {
                    found = true;
                    break;
                }
                carry = carry.getNext();
            } while (carry != head);

            if (!found) {
                return false;
            }
        }
        return true;
    }

    @Override
    public NodeInterface<T> nodeOf(T object) {
        Iterator<NodeInterface<T>> iterator = iterator();
        while (iterator.hasNext()) {
            SinglyList<T> node = (SinglyList<T>) iterator.next();
            if (node.getObject().equals(object)) {
                return node;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public T get() {
        if (head == null) {
            throw new NoSuchElementException("La lista está vacía");
        }

        return head.getObject();
    }

    @Override
    public T[] get(int n) {
        if (n <= 0 || isEmpty()) {
            return null;
        }

        if (n > size) {
            n = size;
        }

        T[] result = (T[]) new Object[n];
        SinglyList<T> current = head;
        for (int i = 0; i < n; i++) {
            result[i] = current.getObject();
            current = current.getNext();
        }

        return result;
    }

    @Override
    public T getPrevious(NodeInterface<T> node) {
        if (isEmpty() || node == null || node.equals(head)) {
            return null;
        }

        SinglyList<T> currentNode = head;
        while (currentNode != null && currentNode.getNext() != null && !currentNode.getNext().equals(node)) {
            currentNode = currentNode.getNext();
        }

        if (currentNode != null) {
            return currentNode.getObject();
        } else {
            return null;
        }
    }

    @Override
    public T getFromEnd() {
        if (head == null) {
            throw new NoSuchElementException("Cola está vacía");
        }

        SinglyList<T> slow = head;
        SinglyList<T> fast = head;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return slow.getObject();
    }

    @Override
    public T[] getFromEnd(int n) {
        if (n < 0 || n > size) {
            throw new IllegalArgumentException("La posición está fuera de los límites");
        }

        T[] elementos = (T[]) new Object[n];
        SinglyList<T> currentNode = tail;

        for (int i = size - 1; i >= size - n; i--) {
            elementos[n - (size - 1 - i)] = currentNode.getObject();
            currentNode = currentNode.getPrev();
        }

        return elementos;
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T poppedValue = head.getObject();
            head = head.getNext();
            size--;
            if (isEmpty()) {
                tail = null;
            }
            return poppedValue;
        }
        throw new NoSuchElementException("La lista está vacía");
    }

    @Override
    public boolean remove(T object) {
        if (isEmpty()) {
            return false;
        }

        if (head.getObject().equals(object)) {
            head = head.getNext();
            size--;
            if (isEmpty()) {
                tail = null;
            }
            return true;
        }

        SinglyList<T> carry = head;
        while (carry.getNext() != null) {
            if (carry.getNext().getObject().equals(object)) {
                if (carry.getNext() == tail) {
                    tail = carry;
                }
                carry.setNext(carry.getNext().getNext());
                size--;
                return true;
            }
            carry = carry.getNext();
        }

        return false;
    }

    @Override
    public boolean remove(NodeInterface<T> node) {
        if (node == null) {
            return false;
        }

        SinglyList<T> previous = null;
        SinglyList<T> current = head;

        while (current != null) {
            if (current == node) {
                if (previous == null) {
                    head = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                size--;
                if (current == tail) {
                    tail = previous;
                }
                return true;
            }
            previous = current;
            current = current.getNext();
        }

        return false;
    }

    @Override
    public boolean removeAll(T[] objects) {
        if (isEmpty() || objects == null || objects.length == 0) {
            return false;
        }

        boolean listaModificada = false;
        SinglyList<T> nodoActual = head;
        SinglyList<T> nodoAnterior = null;

        while (nodoActual != null) {
            boolean removerObjeto = false;
            for (T objeto : objects) {
                if (nodoActual.getObject().equals(objeto)) {
                    removerObjeto = true;
                    break;
                }
            }

            if (removerObjeto) {
                if (nodoAnterior != null) {
                    nodoAnterior.setNext(nodoActual.getNext());
                } else {
                    head = nodoActual.getNext();
                }
                if (nodoActual == tail) {
                    tail = nodoAnterior;
                }
                size--;
                listaModificada = true;
            } else {
                nodoAnterior = nodoActual;
            }
            nodoActual = nodoActual.getNext();
        }

        return listaModificada;
    }

    @Override
    public boolean retainAll(T[] objects) {
        if (isEmpty() || objects == null || objects.length == 0) {
            return false;
        }

        boolean listaModificada = false;
        SinglyList<T> nodoActual = head;
        SinglyList<T> nodoAnterior = null;

        while (nodoActual != null) {
            boolean retenerObjeto = false;
            for (T objeto : objects) {
                if (nodoActual.getObject().equals(objeto)) {
                    retenerObjeto = true;
                    break;
                }
            }

            if (!retenerObjeto) {
                if (nodoAnterior != null) {
                    nodoAnterior.setNext(nodoActual.getNext());
                } else {
                    head = nodoActual.getNext();
                }
                if (nodoActual == tail) {
                    tail = nodoAnterior;
                }
                size--;
                listaModificada = true;
            } else {
                nodoAnterior = nodoActual;
            }
            nodoActual = nodoActual.getNext();
        }

        return listaModificada;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public LinkedListInterface<T> subList(NodeInterface<T> from, NodeInterface<T> to) {
        LinkedListInterface<T> subLista = new Enlazadadoblecircular<>();

        if (isEmpty() || from == null || to == null || from.equals(to)) {
            return subLista;
        }

        SinglyList<T> nodoActual = head;
        boolean encontradoNodoDesde = false;

        while (nodoActual != null) {
            if (nodoActual.equals(from)) {
                encontradoNodoDesde = true;
                break;
            }
            nodoActual = nodoActual.getNext();
        }

        if (!encontradoNodoDesde) {
            return subLista;
        }

        while (nodoActual != null && !nodoActual.equals(to)) {
            subLista.add(nodoActual.getObject());
            nodoActual = nodoActual.getNext();
        }

        if (nodoActual != null) {
            subLista.add(nodoActual.getObject());
        }

        return subLista;
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        SinglyList<T> currentNode = head;
        int i = 0;

        while (currentNode != null) {
            array[i++] = currentNode.getObject();
            if (currentNode == tail) {
                break;
            }
            currentNode = currentNode.getNext();
        }

        return array;
    }

    @Override
    public boolean sortObjectsBySize() {
        if (head == null || head.getNext() == null) {
            return true;
        }

        boolean swapped;
        do {
            swapped = false;
            SinglyList<T> current = head;
            SinglyList<T> previous = null;

            do {
                SinglyList<T> nextNode = current.getNext();
                if (compareNodeSizes(current, nextNode) > 0) {
                    swapped = true;
                    if (previous == null) {
                        head = nextNode;
                    } else {
                        previous.setNext(nextNode);
                    }

                    if (nextNode.getNext() != head) {
                        nextNode.getNext().setPrev(current);
                    } else {
                        tail = current;
                    }

                    current.setNext(nextNode.getNext());
                    nextNode.setNext(current);
                    current.setPrev(nextNode);

                    previous = nextNode;
                } else {
                    previous = current;
                    current = nextNode;
                }
            } while (current != head && current.getNext() != head);

        } while (swapped);

        return true;
    }

    private int compareNodeSizes(SinglyList<T> node1, SinglyList<T> node2) {
        String data1 = node1.getObject().toString();
        String data2 = node2.getObject().toString();

        return Integer.compare(data1.length(), data2.length());
    }

    @Override
    public Iterator<NodeInterface<T>> iterator() {
        if (isEmpty()) {
            return Collections.emptyIterator();
        }

        return new Iterator<NodeInterface<T>>() {
            private SinglyList<T> currentNode = head;
            private boolean firstNodeReturned = false;

            @Override
            public boolean hasNext() {
                return !firstNodeReturned || currentNode != head;
            }

            @Override
            public NodeInterface<T> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                NodeInterface<T> node = currentNode;
                currentNode = currentNode.getNext();
                if (!firstNodeReturned) {
                    firstNodeReturned = true;
                }
                return node;
            }
        };
    }

    @Override
    public void displayList() {
        if (isEmpty()) {
            System.out.println("La lista está vacía.");
            return;
        }

        SinglyList<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            System.out.print(currentNode.getObject() + " ");
            currentNode = currentNode.getNext();
        }

        System.out.println();
    }
}