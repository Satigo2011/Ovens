package co.edu.upb.pilas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {       
        
        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println("Lista original:" + list);
        
        
        
        

        int k = 3; //distancia k 
        list.reverseNodesAtDistance(k);;

        System.out.println("Lista despues de invertir nodos en grupos de " + k + ":");
        System.out.println(list);
    }
}