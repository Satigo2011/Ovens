/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.upb.pilas;
/**
 *
 * @author 57314
 */
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author @Enmanuel
 */
public class LinkedList<T> implements LinkedListInterface<T> {

    private SinglyList<T> head;
    private SinglyList<T> tail;
    private SinglyList<T> inode;
    private int size;

    public LinkedList() {
    }

    @Override
    public boolean add(T object) {
        if (object != null) {
            try {
                if (isEmpty()) {
                    tail = head = new SinglyList<>(object);
                } else {
                    tail.setNext(new SinglyList<>(object));
                    tail = tail.getNext();
                }
                size++;
                return true;
            } catch (Exception e) {

            }
        }

        return false;
    }

    @Override
    public boolean add(NodeInterface<T> node, T object) { 
        Iterator iterator = iterator();
        SinglyList nodeTemp;

        if (object != null) {
            try {
                if (isEmpty()) {
                    tail = head = new SinglyList<>(object);
                }
                if (tail.equals(node)) {
                    tail.setNext(new SinglyList<>(object));
                    tail = tail.getNext();
                } else {
                    while (iterator.hasNext()) {
                        nodeTemp = (SinglyList) iterator.next();
                        if (nodeTemp.isEquals(node.getObject())) {
                            SinglyList nodeToAdd = new SinglyList<>(object);
                            nodeToAdd.setNext(nodeTemp.getNext()); 
                            nodeTemp.setNext(nodeToAdd); 
                        }
                    }
                }
                size++;
                return true;
            } catch (Exception e) {

            }
        }
        return false;
    }

    @Override
    public boolean add(NodeInterface<T> node, NodeInterface<T> next) { 
        Iterator iterator = iterator();
        if (node != null && next != null) {
            if (next.equals(tail)) {
                tail.setNext((SinglyList<T>) next);
                tail = tail.getNext();
            }
            try {
                while (iterator.hasNext()) {
                    SinglyList temporal = (SinglyList) iterator.next();
                    if (temporal.equals(node)) {
                        SinglyList nodeToAdd = (SinglyList) next;
                        nodeToAdd.setNext(temporal.getNext()); 
                        temporal.setNext(nodeToAdd); 
                    }
                }
                size++;
                return true;
            } catch (Exception e) {

            }
        }
        return false;
    }

    @Override
    public boolean add(T[] objects) {
        if (objects != null) {
            try {
                if (isEmpty()) {
                    for (int i = 0; i < objects.length; i++) {
                        if (head == null) {
                            tail = head = new SinglyList<>(objects[i]);
                            size++;
                        } else {
                            tail.setNext(new SinglyList<>(objects[i]));
                            tail = tail.getNext();
                            size++;
                        }
                    }
                } else {
                    for (int i = 0; i < objects.length; i++) {
                        tail.setNext(new SinglyList<>(objects[i]));
                        tail = tail.getNext();
                        size++;
                    }
                }
                return true;
            } catch (Exception e) {

            }
        }
        return false;
    }
    @Override
    public boolean add(NodeInterface<T> node, T[] objects) {
        if (objects != null) {
            try {
                if (isEmpty()) {
                    for (int i = 0; i < objects.length; i++) {
                        if (head == null) {
                            tail = head = new SinglyList<>(objects[i]);
                            size++;
                        } else {
                            tail.setNext(new SinglyList<>(objects[i]));
                            tail = tail.getNext();
                            size++;
                        }
                    }
                } else {
                    Iterator iterator = iterator();
                    while (iterator.hasNext()) {
                        SinglyList temporal = (SinglyList) iterator.next();
                        if (temporal.equals(node)) {
                            SinglyList nodeAdd = (SinglyList) node;
                            for (int i = 0; i < objects.length; i++) {
                                nodeAdd.setNext(new SinglyList<>(objects[i]));
                                nodeAdd = nodeAdd.getNext();
                                size++;
                            }
                        }
                    }
                }
                return true;
            } catch (Exception e) {

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
                } else {
                    SinglyList newNode = new SinglyList<>(object);
                    newNode.setNext(head);
                    head = newNode;
                }
                size++;
                return true;
            } catch (Exception e) {

            }
        }
        return false;
    }
    @Override
    public boolean addOnHead(T[] objects) {
        if (objects == null && objects.length == 0) {
            return false;
        }

        for (int i = objects.length - 1; i >= 0; i--) {
            SinglyList<T> order = new SinglyList<T>(objects[i]);
            order.setNext(head);
            head = order;
        }

        return true;

    }
    @Override
    public boolean clear() {
        head = null;
        size = 0;
        return true;
    }
    @Override
    public LinkedListInterface<T> cloneList() {
        try {
            if (!isEmpty()) {

                return (LinkedList<T>) this.clone();

            } else {
                return new LinkedList<T>();
            }

        } catch (CloneNotSupportedException ex) {
            java.util.logging.Logger.getLogger(LinkedList.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);

        }
        return null;

    }
    @Override
    public boolean contains(T object) {
        Iterator iter = iterator();
        while (iter.hasNext()) {
            SinglyList nodeTemp = (SinglyList) iter.next();
            if (nodeTemp.isEquals(object)) {
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
            while (carry != null) { 
                if (carry.getNext().equals(obj)) {
                    found = true;
                    break;
                }
                carry = carry.getNext();
            }
            if (!found) {
                return false; 
            }
        }
        return true;
    }
    @Override
    public NodeInterface<T> nodeOf(T object) {
        Iterator carry = iterator();
        if (object == null) {
            try {
                while (carry.hasNext()) {
                    SinglyList nodo = (SinglyList) carry.next();
                    if (nodo.isEquals(object)) {
                        return nodo;
                    }
                }
            } catch (Exception e) {

            }
        }
        return new SinglyList<>(null);
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

        int elementsToRetrieve = Math.min(n, size); 
        T[] dataArray = (T[]) new Object[elementsToRetrieve];
        SinglyList<T> currentNode = head;

        for (int i = 0; i < elementsToRetrieve; i++) {
            dataArray[i] = currentNode.getObject();
            currentNode = currentNode.getNext();
        }
        return dataArray;

    }

   @Override
    public T getPrevious(NodeInterface<T> node) {
        if (isEmpty() || node == null || node.equals(head)) {
            System.out.println("[ERROR]: No se puede obtener el anterior al primer elemento.");
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
            throw new NoSuchElementException("La cola esta vacia");
            
        }

        SinglyList<T> slow = head;
        SinglyList<T> fast = head;

        while (fast.getNext() != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        return slow.getObject();
    }
    @Override
    public T[] getFromEnd(int n) {
        if (n < 0 || n >= size) {
            throw new IllegalArgumentException("La posición está fuera de los límites");
        }

        List<T> elementos = new ArrayList<>();
        SinglyList<T> currentNode = tail;

        for (int i = size - 1; i >= size - n; i--) {
            elementos.add(currentNode.getObject());
            currentNode = currentNode.getNext();
        }

        return elementos.toArray((T[]) new Object[0]);
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
        return null; 
    }
    @Override
    public boolean remove(T object) {

        SinglyList<T> carry = head;
        if (head == null) {
            return false;
        }

        if (carry.getObject().equals(object)) {
            carry = carry.next;
            return true;
        }

        while (carry.next != null) {
            if (carry.next.getObject().equals(object)) {
                carry.next = carry.next.next;
                return true;
            }
            carry = carry.next;
        }
        return true;
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
                return true;
            }
            previous = current;
            current = current.getNext();
        }

        return false;
    }
    @Override
    public boolean removeAll(T[] objects) {
        if (isEmpty() || objects == null) {
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
                nodoActual = nodoActual.getNext();
                size--;
                listaModificada = true;
            } else {
                nodoAnterior = nodoActual;
                nodoActual = nodoActual.getNext();
            }
        }

        return listaModificada;
    }
    @Override
    public boolean retainAll(T[] objects) {
        if (isEmpty() || objects == null) {
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
                nodoActual = nodoActual.getNext();
                size--;
                listaModificada = true;
            } else {
                nodoAnterior = nodoActual;
                nodoActual = nodoActual.getNext();
            }
        }

        return listaModificada;
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public LinkedListInterface<T> subList(NodeInterface<T> from, NodeInterface<T> to) {
        LinkedListInterface<T> subLista = new LinkedList<>();

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
        SinglyList<T> nodo = head;
        T[] array = (T[]) new Object[size];
        Iterator iterator = iterator();
        int i = 0;
        while (iterator.hasNext()) {
            nodo = (SinglyList<T>) iterator.next();
            array[i++] = (T) nodo.getObject();

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

            while (current.getNext() != null) {
                SinglyList<T> nextNode = current.getNext();
                if (compareNodeSizes(current, nextNode) > 0) {
                    swapped = true;
                    if (previous == null) {
                        head = nextNode;
                    } else {
                        previous.setNext(nextNode);
                    }
                    current.setNext(nextNode.getNext());
                    nextNode.setNext(current);
                    previous = nextNode;
                } else {
                    previous = current;
                    current = nextNode;
                }
            }
        } while (swapped);

        return true;

    }
     public void reverseNodesAtDistance(int k) {
        if (k <= 0 || head == null || head.getNext() == null) {
            return; 
        }
        SinglyList<T> current = head;
        SinglyList<T> prevTail = null;
        boolean isFirstSection = true;

        while (current != null) {
            SinglyList<T> prev = null;
            SinglyList<T> nextSection = current;
            int count = 0;
            while (current != null && count < k) {
                SinglyList<T> next = current.getNext();
                current.setNext(prev);
                prev = current;
                current = next;
                count++;
            }

            if (isFirstSection) {
                head = prev; 
                isFirstSection = false;
            } else {
                prevTail.setNext(prev); 
            }

            prevTail = nextSection; 
        }

        tail = prevTail;
    }   
    private int compareNodeSizes(SinglyList<T> node1, SinglyList<T> node2) {
        String data1 = node1.getClass().toString();
        String data2 = node2.getClass().toString();

        return Integer.compare(data1.length(), data2.length());
    }    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        SinglyList<T> currentNode = head;
        while (currentNode != null) {
            sb.append(currentNode.getObject());
            if (currentNode.getNext() != null) {
                sb.append(", ");
            }
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }    
       public SinglyList<T> buscarNodo(T dato) {
        SinglyList<T> actual = head;
        while (actual != null) {
            if (actual.getObject().equals(dato)) {
                return actual;
            }
            actual = actual.getNext();
        }
        return null;
    }
    @Override
    public Iterator<NodeInterface<T>> iterator() {
        inode = head;
        return new Iterator<NodeInterface<T>>() {
            @Override
            public boolean hasNext() {
                return inode != null;
            }
            @Override
            public NodeInterface<T> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                NodeInterface<T> node = inode;
                inode = inode.getNext();
                return node;
            }

        };
    }
}
