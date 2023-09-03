package co.edu.upb.pilas;
/**
 *
 * @author 57314
 */
public class SinglyList<T> extends Node<T> {
    SinglyList<T> next;

    public SinglyList(){
        super();
        this.next = null;
    }
    public SinglyList(T object){
        super(object);
        this.next = null;
    }
    public SinglyList(T object, SinglyList<T> next){
        super(object);
        this.next = next;
    }
    public SinglyList<T> getNext(){
        return this.next;
    }
    public void setNext(SinglyList<T> next){
        this.next = next;
    }
}