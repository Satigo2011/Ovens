package co.edu.upb.algorimofleury;
import java.util.LinkedList;

public class Vertice {
    char nombre;
    LinkedList<Vertice> adyacentes;

    public Vertice(char nombre) {
        this.nombre = nombre;
        adyacentes = new LinkedList<>();
    }

    public void agregarAdyacente(Vertice vertice) {
        adyacentes.add(vertice);
    }

    public void removerAdyacente(Vertice vertice) {
        adyacentes.remove(vertice);
    }

    public LinkedList<Vertice> obtenerAdyacentes() {
        return adyacentes;
    }

    @Override
    public String toString() {
        return String.valueOf(nombre);
    }
}
