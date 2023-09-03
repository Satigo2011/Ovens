package co.edu.upb.priorityqeue;
import java.util.PriorityQueue;

public class main {

	public static void main(String[] args) {
	PriorityQueue<Integer> pq = new PriorityQueue<Integer>() ;
	
	pq.add(5);
	pq.add(1);
	pq.add(7);
	pq.add(3);
	pq.add(9);
	pq.add(8);
	pq.add(4);

	System.out.println(pq);
	
	pq.poll();
	pq.add(10);
	pq.add(11);

	System.out.println(pq);
	}
}
