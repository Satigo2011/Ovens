package co.edu.upb.ListaEnlazadaDoble;

import java.util.Iterator;

public class Node<T> implements NodeInterface<T> {
   private T object;
    public Node(){
        this.object = null;
    }
    public Node(T object){
        this.object = object;
    }
    @Override
    public boolean setObject(T object) {
        try {
            this.object = object;
            return true;
        }
        catch (Exception e){
            
            return false;
        }
    }

    @Override
    public T getObject() {
        return this.object;
    }

    @Override
    public boolean isEquals(T object) {
        try {
            return this.object.toString().equals(object.toString());
        }
        catch (Exception e){
            
            return false;
        }
    }


    public Node<T> getClone() {
        try{
            if(this.object !=null){
                return (Node<T>)this.clone();
            }
        }
        catch (CloneNotSupportedException e){
           
        }
        return null;
    }
    @Override
    public String toString(){
        return "Nodo [Obj="+ object+ "]";
    }
   
    
    
}
