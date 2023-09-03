package co.edu.upb.laboratorio4;

import java.util.HashMap;

public class Cajero {

    private String codCajero;
    private HashMap<Integer, Integer> nBilletes = new HashMap<Integer, Integer>();
    private boolean txProgreso;
    private Usuario usuarioTx;

    public Cajero(String codCajero, HashMap<Integer, Integer> nEntrada) {
        this.codCajero = codCajero;
        this.nBilletes = nEntrada;
    }

    public boolean iniciarSesion(GrupoBancos grupoBancos, int identificacionUsuario) {
        Usuario intento = grupoBancos.getUsuario(identificacionUsuario);
        if (intento == null) {
            txProgreso = false;
        } else {
            usuarioTx = intento;
            txProgreso = true;
        }
        return txProgreso;
    }

    public boolean iniciarSesion(GrupoBancos grupoBancos, String codBanco, int identificacionUsuarios) {
        Usuario intento = grupoBancos.getUsuario(codBanco, identificacionUsuarios);
        if (intento == null) {
            txProgreso = false;
        } else {
            usuarioTx = intento;
            txProgreso = true;
        }
        return txProgreso;
    }

    public boolean retirarDinero(int valorARetirar) {
        boolean Devol = false;
        int dineroDisponible = getdineroDisponible();
        if ((dineroDisponible >= valorARetirar) && (valorARetirar % 10 == 0) && (valorARetirar >= 10000)) {
            if (usuarioTx != null) {
                descontarBilletes(valorARetirar);
                int balanceDisponible=usuarioTx.getBalance();
                if (balanceDisponible>=valorARetirar) {
                    int nuevoBalance=balanceDisponible-valorARetirar;
                    usuarioTx.setBalance(nuevoBalance);
                    terminarSesion();
                    Devol=true;
                    return Devol;
                }
            } else {
            	Devol = false;
                return Devol;
            }
        }
        return Devol;
    }

    private int getdineroDisponible() {
        int retiro=0;
        for (int i:nBilletes.keySet()) {
        	
            retiro+=(nBilletes.get(i)*i);
            
        }
        return retiro;
    }

    private void descontarBilletes(int valorRetiro) {
        int Billetes=0;
        int valor=valorRetiro;
        for (int i:nBilletes.keySet()) {
            if (valor>= i) {
                Billetes= valor/i;
                valor=valor%i;
                if ((nBilletes.get(i)>=Billetes)) {
                    nBilletes.put(i,(nBilletes.get(i)-Billetes));
                }
            }
        }
    }

    private void terminarSesion() {
        this.usuarioTx = null;
        txProgreso = false;
    }
}
