package co.edu.upb.segundo;

import javax.swing.JOptionPane;

//codigo donde se pediran 6 calificaciones de un alumno 
		//se mostraran los que aprobaron y cuantos se aprobaron
public class Main {

	public static void main(String[] args) {
		
		double [] calificacion = new double [6];
		int contador = 0;
		System.out.println("ingrese las 6 calificaciones:\n");
		
		for(int i=0 ; i < calificacion.length ;i++)// i = 0
			{
			calificacion[i]= Double.parseDouble(JOptionPane.showInputDialog(null,"Ingresa la caliciacion" + (i + 1)));
		}
		System.out.println("mostrar calificaciones aprobadas:");
		for(int i=0 ; i < calificacion.length;i++) {
			if(calificacion[i]>=6) {
				System.out.println(calificacion[i]);
				contador++;
				}
			}
		System.out.println("Total de estudiantes que pasaron:" + contador);
		if(contador<=3) {
			JOptionPane.showMessageDialog(null,"Puede perder la materia","PELIGRO",JOptionPane.WARNING_MESSAGE);
		}
		}
	} 