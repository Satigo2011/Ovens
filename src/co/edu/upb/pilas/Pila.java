/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.upb.pilas;
import java.util.EmptyStackException;
/**
 *
 * @author 57314
 */
public class Pila<T> implements  StackIterface<T> {

    private LinkedList<T> list;

    public Pila() {
        list = new LinkedList<>();
    }

    public boolean clear() {
        return list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get();
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.pop();
    }

    public boolean push(T object) {
        return list.addOnHead(object);
    }

    public int size() {
        return list.size();
    }

    public boolean search(T object) {
        return list.contains(object);
    }

    public boolean sort() {
        return list.sortObjectsBySize();
    }

    public boolean reverse() {
        list.reverseNodesAtDistance(1);
        return true;
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public boolean searh(T object) {
        if (isEmpty()) {
            return false;
        }

        LinkedList<T> tempList = (LinkedList<T>) list.cloneList(); 

        while (!tempList.isEmpty()) {
            T poppedValue = tempList.pop();
            if (poppedValue.equals(object)) {
                return true; 
            }
        }

        return false; 
    }
    
}