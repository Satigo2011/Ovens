package co.edu.upb.ListaEnlazadaDoble;
/**
 *
 * @author 57314
 */
public class SinglyList<T> extends co.edu.upb.ListaEnlazadadoblecircular.Node<T> {
    SinglyList<T> next;
    SinglyList<T> prev; // Cambiar 'Prev' a 'prev'

    public SinglyList() {
        super();
        this.next = null;
        this.prev = null; // Cambiar 'Prev' a 'prev'
    }

    public SinglyList(T object) {
        super(object);
        this.next = null;
        this.prev = null; // Cambiar 'Prev' a 'prev'
    }

    public SinglyList(T object, SinglyList<T> next) {
        super(object);
        this.next = next;
        this.prev = null; // Cambiar 'Prev' a 'prev'
    }

    public SinglyList<T> getNext() {
        return this.next;
    }

    public void setNext(SinglyList<T> next) {
        this.next = next;
    }
    public void setPrev(SinglyList<T> prev) {
        this.prev = prev; // Cambiar 'Prev' a 'prev'
    }

    public SinglyList<T> getPrev() {
        return this.prev; // Cambiar 'Prev' a 'prev'
    }
}