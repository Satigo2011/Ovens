package co.edu.upb.enunciado2;

class Proveedor {
    private String nombre;
    private String ciudad;
    private int numArticulos;

    public Proveedor(String nombre, String ciudad, int numArticulos) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.numArticulos = numArticulos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getNumArticulos() {
        return numArticulos;
    }

    public void setNumArticulos(int numArticulos) {
        this.numArticulos = numArticulos;
    }
}