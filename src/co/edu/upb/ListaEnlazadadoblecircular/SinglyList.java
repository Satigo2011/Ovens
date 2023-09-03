package co.edu.upb.ListaEnlazadadoblecircular;
public class SinglyList<T> extends Node<T> {
    
	SinglyList<T> next;
    SinglyList<T> prev; 
    public SinglyList() {
        super();
        this.next = null;
        this.prev = null; 
    }

    public SinglyList(T object) {
        super(object);
        this.next = null;
        this.prev = null;
    }

    public SinglyList(T object, SinglyList<T> next) {
        super(object);
        this.next = next;
        this.prev = null;
    }

    public SinglyList<T> getNext() {
        return this.next;
    }

    public void setNext(SinglyList<T> next) {
        this.next = next;
    }

    public void setPrev(SinglyList<T> prev) {
        this.prev = prev;
    }

    public SinglyList<T> getPrev() {
        return this.prev;
    }
}