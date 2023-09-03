/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.upb.pilas;
/**
 *
 * @author 57314
 */
public class MainPila {
    public static void main(String[] args) {
        Pila<Integer> stack = new Pila<>();

        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Size of stack: " + stack.size());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Size of stack: " + stack.size());

        System.out.println("Top element: " + stack.peek());

        System.out.println("Searching for 20: " + stack.search(20));
        System.out.println("Searching for 40: " + stack.search(40));

        System.out.println("Popping elements:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("Is stack empty? " + stack.isEmpty());
        System.out.println("Size of stack: " + stack.size());
    }
}
