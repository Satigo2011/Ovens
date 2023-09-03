/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.upb.ListaEnlazadaDoble;
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
public class Enlazadadoble<T> implements LinkedListInterface<T> {

    private SinglyList<T> head;
    private SinglyList<T> tail;
    private SinglyList<T> inode;
    private int size;

    public Enlazadadoble() {
    }

    @Override
    public boolean add(T object) {
        SinglyList<T> newNode = new SinglyList<>(object);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.next = tail;
            tail = newNode;
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
                            if (nodeTemp.getNext() != null) {
                                nodeTemp.getNext().setNext(nodeToAdd);
                            }
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
                
            }
        }
        return false;
    }

    public boolean removeNodeBefore(T object) {
        SinglyList<T> current = head;
        SinglyList<T> previous = null;
        SinglyList<T> beforePrevious = null;

        while (current != null && !current.getNext().getObject().equals(object)) {
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
        current.setNext(beforePrevious);
        return true;
    }

    public boolean removeNodeAfter(T target) {
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
        if (nodeToRemove.getNext() != null) {
            nodeToRemove.getNext().setNext(current);
        }
        return true;
    }

    @Override
    public boolean add(NodeInterface<T> node, NodeInterface<T> next) {
        Iterator<NodeInterface<T>> iterator = iterator();
        SinglyList<T> nodeTemp;

        if (node != null && next != null) {
            try {
                if (next.equals(tail)) {
                    tail.setNext((SinglyList<T>) next);
                    tail = tail.getNext();
                    tail.setNext(head);
                    head.setPrev(tail);
                } else {
                    boolean nodeFound = false;
                    while (iterator.hasNext()) {
                        nodeTemp = (SinglyList<T>) iterator.next();
                        if (nodeTemp.equals(node)) {
                            SinglyList<T> nodeToAdd = (SinglyList<T>) next;
                            nodeToAdd.setNext(nodeTemp.getNext());
                            nodeToAdd.getNext().setPrev(nodeToAdd);
                            nodeTemp.setNext(nodeToAdd);
                            if (nodeTemp.getNext().equals(tail)) {
                                tail = nodeToAdd;
                            }
                            nodeFound = true;
                            break;
                        }
                    }
                    if (!nodeFound) {
                        tail.setNext((SinglyList<T>) next);
                        next = (NodeInterface<T>) tail;
                        tail = (SinglyList<T>) next;
                        tail.setNext(head);
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
        if (objects != null && objects.length > 0) {
            try {
                if (isEmpty()) {
                    head = tail = new SinglyList<>(objects[0]);
                    tail.setNext(head);
                    size++;
                }

                for (int i = 1; i < objects.length; i++) {
                    SinglyList<T> newNode = new SinglyList<>(objects[i]);
                    tail.setNext(newNode);
                    newNode.setNext(head);
                    tail = newNode;
                    size++;
                }

                return true;
            } catch (Exception e) {
                
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
                            newNode.setNext(previousNode);
                            previousNode.setNext(newNode);
                            previousNode = newNode;
                            size++;
                        }
                        previousNode.setNext(temporal.getNext());
                        if (temporal.getNext() != null) {
                            temporal.getNext().setNext(previousNode);
                        }
                        return true;
                    }
                }
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
                    tail.setNext(head);
                    head.setPrev(tail);
                } else {
                    SinglyList<T> newNode = new SinglyList<>(object);
                    newNode.setNext(head);
                    head.setPrev(newNode);
                    head = newNode;
                    tail.setNext(head);
                }
                size++;
                return true;
            } catch (Exception e) {
                
            }
        }
        return false;
    }

    @Override
    public LinkedListInterface<T> cloneList() {
        LinkedListInterface<T> clonedList = new Enlazadadoble<>();

        try {
            if (!isEmpty()) {
                Iterator<NodeInterface<T>> iterator = iterator();
                while (iterator.hasNext()) {
                    clonedList.add(iterator.next().getObject());
                }
            }
        } catch (Exception ex) {
            
        }

        return clonedList;
    }

    @Override
    public boolean contains(T object) {
        Iterator<NodeInterface<T>> iterator = iterator();
        while (iterator.hasNext()) {
            SinglyList<T> nodeTemp = (SinglyList<T>) iterator.next();
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
            SinglyList<T> current = head;
            while (current != null) {
                if (current.getObject().equals(obj)) {
                    found = true;
                    break;
                }
                current = current.getNext();
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public NodeInterface<T> nodeOf(T object) {
        Iterator<NodeInterface<T>> iterator = iterator();
        if (object != null) {
            try {
                while (iterator.hasNext()) {
                    NodeInterface<T> node = iterator.next();
                    if (node.getObject().equals(object)) {
                        return node;
                    }
                }
            } catch (Exception e) {
                
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
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

        SinglyList<T> currentNode = head.getNext();
        while (currentNode != null && !currentNode.equals(node)) {
            currentNode = currentNode.getNext();
        }

        if (currentNode != null && currentNode.getPrev() != null) {
            return currentNode.getPrev().getObject();
        } else {
            return null;
        }
    }

    @Override
    public T getFromEnd() {
        if (head == null) {
            throw new NoSuchElementException("La lista está vacía");
        }

        SinglyList<T> slow = head;
        SinglyList<T> fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow.getObject();
    }

    @Override
    public T[] getFromEnd(int n) {
        if (n <= 0 || n > size) {
            throw new IllegalArgumentException("Posición fuera de los límites");
        }
        T[] elements = (T[]) new Object[n];
        SinglyList<T> current = tail;
        for (int i = n - 1; i >= 0; i--) {
            elements[i] = current.getObject();
            current = current.getPrev();
        }
        return elements;
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T poppedValue = head.getObject();
            head = (SinglyList<T>) head.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }
            size--;
            return poppedValue;
        }
        return null;
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

        SinglyList<T> current = head;

        while (current != null) {
            if (current == node) {
                SinglyList<T> previous = current.getPrev();
                SinglyList<T> next = current.getNext();

                if (previous == null) {
                    head = next;
                } else {
                    previous.setNext(next);
                }

                if (next == null) {
                    tail = previous;
                } else {
                    next.setPrev(previous);
                }

                size--;
                return true;
            }
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
        if (isEmpty() || objects == null || objects.length == 0) {
            return false;
        }

        boolean listModified = false;
        SinglyList<T> currentNode = head;
        SinglyList<T> previousNode = null;

        while (currentNode != null) {
            boolean retainObject = false;
            for (T object : objects) {
                if (currentNode.getObject().equals(object)) {
                    retainObject = true;
                    break;
                }
            }

            if (!retainObject) {
                SinglyList<T> nextNode = currentNode.getNext();

                if (previousNode != null) {
                    previousNode.setNext(nextNode);
                } else {
                    head = nextNode;
                }

                if (nextNode != null) {
                    nextNode.setPrev(previousNode);
                } else {
                    tail = previousNode;
                }

                currentNode = nextNode;
                size--;
                listModified = true;
            } else {
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
        }

        return listModified;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public LinkedListInterface<T> subList(NodeInterface<T> from, NodeInterface<T> to) {
        LinkedListInterface<T> subList = new Enlazadadoble<>();

        if (isEmpty() || from == null || to == null || from.equals(to)) {
            return subList;
        }

        SinglyList<T> currentNode = head;
        boolean foundFromNode = false;

        while (currentNode != null) {
            if (currentNode == from) {
                foundFromNode = true;
                break;
            }
            currentNode = currentNode.getNext();
        }

        if (!foundFromNode) {
            return subList;
        }

        while (currentNode != null && currentNode != to) {
            subList.add(currentNode.getObject());
            currentNode = currentNode.getNext();
        }

        if (currentNode != null) {
            subList.add(currentNode.getObject());
        }

        return subList;
    }

    @Override
    public T[] toArray() {
        T[] array = (T[]) new Object[size];
        SinglyList<T> currentNode = head;
        int i = 0;

        while (currentNode != null) {
            array[i++] = currentNode.getObject();
            if (currentNode.getNext() == head) {
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
                return !firstNodeReturned || currentNode != null;
            }

            @Override
            public NodeInterface<T> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                NodeInterface<T> node = (NodeInterface<T>) currentNode;
                currentNode = currentNode.getNext();
                if (!firstNodeReturned) {
                    firstNodeReturned = true;
                }
                return node;
            }
        };
    }

    public void displayList() {
        SinglyList<T> current = head;
        while (current != null) {
            System.out.print(current.getObject() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    @Override
    public boolean addOnHead(T[] objects) {
        if (objects != null && objects.length > 0) {
            try {
                for (int i = objects.length - 1; i >= 0; i--) {
                    SinglyList<T> newNode = new SinglyList<>(objects[i]);
                    newNode.setNext(head);
                    if (head != null) {
                        head.setPrev(newNode);
                    }
                    head = newNode;
                    if (tail == null) {
                        tail = newNode;
                    }
                    size++;
                }
                return true;
            } catch (Exception e) {
                
            }
        }
        return false;
    }

    @Override
    public boolean clear() {
        if (isEmpty()) {
            return false;
        }

        head = null;
        tail = null;
        size = 0;
        return true;
    }

    @Override
    public T getPrevious(LinkedListInterface<T> node) {
        if (isEmpty() || node == null || node.equals(head)) {
            return null;
        }

        SinglyList<T> currentNode = head.getNext();
        while (currentNode != null && !currentNode.equals(node)) {
            currentNode = currentNode.getNext();
        }

        if (currentNode != null && currentNode.getPrev() != null) {
            return currentNode.getPrev().getObject();
        } else {
            return null;
        }
    }

    }
