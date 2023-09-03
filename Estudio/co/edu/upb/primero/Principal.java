package co.edu.upb.primero;

public class Principal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int arreglo[] = {1,4,8,20,100};
	
	System.out.println(arreglo[4]);
	
	System.out.println("busqueda de numero");
	
	for (int i=0;i < arreglo.length; i++) {
		if(arreglo[i]==20) {
			System.out.println("El numero 20 esta en el arreglo");
		}
		else {
			System.out.println("No se encuentra");
		}
	}
	
	
	
	
	
	
	}
}
