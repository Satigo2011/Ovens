/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.upb.pilas;
/**
 *
 * @author 57314
 */
public interface StackIterface<T> {
    
    public boolean clear();
    
    public boolean isEmpty();
    
    public T peek();
    
    public T pop();
    
    public boolean push(T object);
    
    public int size();
    
    public boolean searh(T object);
    
    public boolean sort();
    
    public boolean reverse();
    
    public String toString();
}