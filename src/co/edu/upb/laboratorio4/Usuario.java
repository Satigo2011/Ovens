package co.edu.upb.laboratorio4;

public class Usuario {
	
    private int identificacion;
    private int balance;
    
    public Usuario(int identificaion, int balance){
        this.identificacion = identificaion;
        this.balance = balance;
    }


	public Usuario(String nuevoUsuario, String correoOtelefono1, String contrasena1) {
		// TODO Auto-generated constructor stub
	}

	public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getIdentificacion() {
        return identificacion;
    }

}
