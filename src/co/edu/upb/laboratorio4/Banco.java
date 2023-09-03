package co.edu.upb.laboratorio4;

import java.util.HashMap;

public class Banco {
    private String codBanco;
    private HashMap <Integer,Usuario> hmUsuarios = new HashMap< Integer,Usuario>();
    
    public Banco ( String codBanco){
        this.codBanco = codBanco;
    }

    public String getCodBanco() {
        return codBanco;
    }
    public void addUsuario(Usuario usuario){
       hmUsuarios.put(usuario.getIdentificacion(), usuario);
    }
     public Usuario getUsuario(int identificacion){
         return hmUsuarios.get(identificacion);
              }
}
