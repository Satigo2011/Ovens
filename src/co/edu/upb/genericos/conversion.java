package co.edu.upb.genericos;
import java.util.Scanner;

public class conversion {
    private static int binaryToDecimal(int numBin) {
        int i = 0;
        int decimal = 0;
        while (numBin != 0) {
            int digit = numBin % 10;
            decimal += digit * pow(2, i);
            numBin = numBin / 10;
            i++;
        }
        return decimal;
    }
    
    private static void toHex(int numDec) {
        String numHex = "";
        while (numDec != 0) {
            int rem = numDec % 16;

            char ch;
            if (rem < 10) {
                ch = (char) (rem + 48);
            } else {
                ch = (char) (rem + 55);
            }
            numHex = ch + numHex;
            numDec = numDec / 16;
        }
        System.out.println("Hexadecimal: " + numHex);
    }
    
    private static void toOctal(int numDec) {
        String numOctal = "";
        while (numDec != 0) {
            int rem = numDec % 8;

            char ch = (char) (rem + 48);
            numOctal = ch + numOctal;
            numDec = numDec / 8;
        }

        System.out.println("Octal:" + numOctal);
    }
    
    private static int pow(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
    
    public static void main(String[] args) {
        int binaryNum1 = 11111111; 
        int binaryNum2 = 11111000; 
        int decimalNum1 = binaryToDecimal(binaryNum1);
        int decimalNum2 = binaryToDecimal(binaryNum2);
        System.out.println("===MENU===");
        System.out.println("Primer numero binario: " + binaryNum1);
        System.out.println("Segundo numero binario: " + binaryNum2);
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("1.Sumar numeros.");
            System.out.println("2.Restar numeros.");
            System.out.println("3.Salir.");
            System.out.print("Seleccione una opcion:");
            int option = 0;
            try {
                option = scanner.nextInt();

                switch (option) {
                    case 1:
                        int sum = decimalNum1 + decimalNum2;
                        toHex(sum);
                        toOctal(sum);
                        break;
                    case 2:
                        int difference = Math.abs(decimalNum1 - decimalNum2);
                        toHex(difference);
                        toOctal(difference);
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Seleccione 1, 2 o 3.");
                }
            } catch (Exception e) {
                System.out.println("Seleccione 1, 2 o 3.");
                scanner.nextLine(); 
            }
        }
        scanner.close();
    }
}