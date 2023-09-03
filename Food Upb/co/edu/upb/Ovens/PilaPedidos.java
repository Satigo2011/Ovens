package co.edu.upb.Ovens;

import java.util.Stack;

public class PilaPedidos {
    private Stack<Pedido> pila;

    // Constructor
    public PilaPedidos() {
        this.pila = new Stack<>();
    }

    public Stack<Pedido> getPila() {
		return pila;
	}



	public void setPila(Stack<Pedido> pila) {
		this.pila = pila;
	}



	// Método para apilar un pedido
    public void apilarPedido(Pedido pedido) {
        pila.push(pedido);
    }

    // Método para desapilar un pedido
    public Pedido desapilarPedido() {
        if (!pila.isEmpty()) {
            return pila.pop();
        } else {
            // Manejar el caso en que la pila esté vacía, por ejemplo, lanzar una excepción
            throw new IllegalStateException("La pila de pedidos está vacía.");
        }
    }

    // Método para verificar si la pila de pedidos está vacía
    public boolean estaVacia() {
        return pila.isEmpty();
    }

    // Otros métodos según tus necesidades
    // ...
}
