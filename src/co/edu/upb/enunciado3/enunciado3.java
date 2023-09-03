package co.edu.upb.enunciado3;
import java.util.Scanner;

public class enunciado3 {
    public static void main(String[] args) {
        int capacidadAvion = 18000;
        int limitePesoBulto = 500;
        int limitePeso1 = 25;
        int limitePeso2 = 300;
        double costoPeso1 = 0;
        double costoPeso2 = 1500;
        double costoPeso3 = 2500;
        double tasaCambioDolar = 4000;

        int[] pesosTabla = { 50, 100, 200, 400, 250, 150, 100, 30, 450, 100, 350, 300, 120, 50, 180 };
        int numeroBultos = pesosTabla.length;
        double pesoTotal = 0;
        double costoTotal = 0;
        double pesoMasPesado = 0;
        double pesoMasLiviano = Double.MAX_VALUE;

        for (int i = 0; i < numeroBultos; i++) {
            double pesoBulto = pesosTabla[i];
            if (pesoBulto <= limitePesoBulto && (pesoTotal + pesoBulto) <= capacidadAvion) {
                pesoTotal += pesoBulto;
                if (pesoBulto <= limitePeso1) {
                    costoTotal += pesoBulto * costoPeso1;
                } else if (pesoBulto <= limitePeso2) {
                    costoTotal += pesoBulto * costoPeso2;
                } else {
                    costoTotal += pesoBulto * costoPeso3;
                }
                pesoMasPesado = Math.max(pesoMasPesado, pesoBulto);
                pesoMasLiviano = Math.min(pesoMasLiviano, pesoBulto);
            } 
            
        }

        double ingresoPesos = costoTotal;
        double ingresoDolares = costoTotal / tasaCambioDolar;
        
        System.out.println("\nNumero total de bultos ingresados para el vuelo: " + numeroBultos);
        System.out.println("\nPeso total de los bultos: " + pesoTotal + " Kg");
        System.out.println("\nPeso promedio de los bultos: " + (pesoTotal / numeroBultos) + " Kg");
        System.out.println("\nPeso del bulto mas pesado: " + pesoMasPesado + " Kg");
        System.out.println("\nPeso del bulto mas liviano: " + pesoMasLiviano + " Kg");
        System.out.println("\nCosto total del equipaje: $" + costoTotal);
        System.out.println("\nIngreso en pesos por concepto de carga: $" + ingresoPesos);
        System.out.println("\nIngreso en dolares por concepto de carga: $" + ingresoDolares);
        System.out.println("\nIngreso en pesos colombianos por concepto de carga: $" + (ingresoPesos * tasaCambioDolar));
    }
}