package co.edu.upb.laboratorio4;

import java.util.HashMap;

public class GrupoBancos {

    private String grupo;
    private HashMap<String, Banco> hmBancos = new HashMap<String, Banco>();

    public GrupoBancos(String grupo) {
        this.grupo = grupo;
    }

    public void addBanco(Banco banco) {
        hmBancos.put(banco.getCodBanco(), banco);
    }

    public Usuario getUsuario(int identificacion) {
        Usuario resultado = null;
        for (String i : hmBancos.keySet()) {
            if (hmBancos.get(i).getUsuario(identificacion) != null) {
                resultado = hmBancos.get(i).getUsuario(identificacion);
            }
        }
        return resultado;
    }

    public Usuario getUsuario(String codBanco, int identificacion) {
        return hmBancos.get(codBanco).getUsuario(identificacion);
    }
}