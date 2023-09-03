package co.edu.upb.algorimofleury;
import java.util.*;

import java.util.*;

public class GrafoEuleriano {
    private HashMap<Character, Vertice> vertices;

    public GrafoEuleriano() {
        vertices = new HashMap<>();
    }

    public void agregarVertice(char nombre) {
        if (!vertices.containsKey(nombre)) {
            vertices.put(nombre, new Vertice(nombre));
        }
    }

    public void agregarArista(char origen, char destino) {
        if (vertices.containsKey(origen) && vertices.containsKey(destino)) {
            Vertice vOrigen = vertices.get(origen);
            Vertice vDestino = vertices.get(destino);
            vOrigen.agregarAdyacente(vDestino);
            vDestino.agregarAdyacente(vOrigen);
        }
    }

    public void removerArista(char origen, char destino) {
        if (vertices.containsKey(origen) && vertices.containsKey(destino)) {
            Vertice vOrigen = vertices.get(origen);
            Vertice vDestino = vertices.get(destino);
            vOrigen.removerAdyacente(vDestino);
            vDestino.removerAdyacente(vOrigen);
        }
    }

    private boolean esConexo() {
        if (vertices.isEmpty()) {
            return false;
        }

        HashSet<Vertice> visitados = new HashSet<>();
        Queue<Vertice> cola = new LinkedList<>();

        Vertice inicio = vertices.values().iterator().next();
        cola.add(inicio);
        visitados.add(inicio);

        while (!cola.isEmpty()) {
            Vertice actual = cola.poll();
            for (Vertice adyacente : actual.obtenerAdyacentes()) {
                if (!visitados.contains(adyacente)) {
                    cola.add(adyacente);
                    visitados.add(adyacente);
                }
            }
        }

        return visitados.size() == vertices.size();
    }

    private boolean esGradoPar(Vertice vertice) {
        return vertice.obtenerAdyacentes().size() % 2 == 0;
    }

    private Vertice obtenerSiguienteVertice(Vertice vertice) {
        for (Vertice adyacente : vertice.obtenerAdyacentes()) {
            if (vertice.obtenerAdyacentes().size() == 1 || !esGradoPar(adyacente)) {
                return adyacente;
            }
        }
        return null;
    }

    public List<Vertice> rutaEuleriana(Vertice inicio) {
        if (!esConexo()) {
            System.out.println("El grafo no es conexo.");
            return null;
        }

        Stack<Vertice> stack = new Stack<>();
        List<Vertice> ruta = new ArrayList<>();
        Vertice actual = inicio;

        while (!stack.isEmpty() || actual.obtenerAdyacentes().size() > 0) {
            if (actual.obtenerAdyacentes().size() == 0) {
                ruta.add(actual);
                actual = stack.pop();
            } else {
                stack.push(actual);
                Vertice siguiente = obtenerSiguienteVertice(actual);
                if (siguiente != null) {
                    removerArista(actual.nombre, siguiente.nombre);
                }
                actual = siguiente;
            }
        }

        ruta.add(actual);

        return ruta;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GrafoEuleriano grafo = new GrafoEuleriano();
        grafo.agregarVertice('a');
        grafo.agregarVertice('b');
        grafo.agregarVertice('c');
        grafo.agregarVertice('d');
        grafo.agregarVertice('e');
        grafo.agregarVertice('f');
        grafo.agregarVertice('g');

        grafo.agregarArista('a', 'b');
        grafo.agregarArista('a', 'f');
        grafo.agregarArista('b', 'c');
        grafo.agregarArista('b', 'f');
        grafo.agregarArista('b', 'g');
        grafo.agregarArista('c', 'd');
        grafo.agregarArista('c', 'e');
        grafo.agregarArista('c', 'g');
        grafo.agregarArista('d', 'e');
        grafo.agregarArista('e', 'f');
        grafo.agregarArista('e', 'g');
        grafo.agregarArista('f', 'g');

        System.out.print("Ingrese el vértice de inicio (a-g): ");
        char inicio = scanner.next().charAt(0);

        if (grafo.vertices.containsKey(inicio)) {
            Vertice inicioVertice = grafo.vertices.get(inicio);
            List<Vertice> ruta = grafo.rutaEuleriana(inicioVertice);

            if (ruta != null) {
                System.out.println("Ruta Euleriana:");
                for (Vertice nodo : ruta) {
                    System.out.print(nodo + " ");
                }
            }
        } else {
            System.out.println("El vértice ingresado no existe en el grafo.");
        }

        scanner.close();
    }
}
