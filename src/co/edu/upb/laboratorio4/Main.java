package co.edu.upb.laboratorio4;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        GrupoBancos grupo1 = new GrupoBancos("Bancolombia");
        
        Banco Banco1=new Banco("1143");
        Banco Banco2=new Banco("2258");
        Banco Banco3=new Banco("3347");

        Usuario Usuario1=new Usuario(11456,1000000);
        Usuario Usuario2=new Usuario(22232,2000000);
        Usuario Usuario3=new Usuario(33256,3000000);

        Banco1.addUsuario(Usuario1);
        Banco2.addUsuario(Usuario2);
        Banco3.addUsuario(Usuario3);
        grupo1.addBanco(Banco1);
        grupo1.addBanco(Banco2);
        grupo1.addBanco(Banco3);
        
        HashMap<Integer,Integer>billete1= new HashMap<Integer,Integer>();
        billete1.put(100000, 2);
        billete1.put(50000, 2);
        billete1.put(20000, 2);
        billete1.put(10000, 2);
        HashMap<Integer,Integer>billete2= new HashMap<Integer,Integer>();
        billete2.put(100000, 2);
        billete2.put(50000, 2);
        billete2.put(20000, 2);
        billete2.put(10000, 2);
        
        Cajero cajero1= new Cajero("Piso1",billete1);
        Cajero cajero2= new Cajero("Piso2",billete2);
        cajero1.iniciarSesion(grupo1,1143);
        cajero2.iniciarSesion(grupo1,"1143",1143);

        System.out.println("Usuario encontrado:" + grupo1.getUsuario(24523));
        System.out.println("Retiro del cajero 1:"+cajero1.retirarDinero(154000));
        System.out.println("Retiro del cajero 2:"+cajero2.retirarDinero(80000));

    }
}
