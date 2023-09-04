package co.edu.upb.Operador;

import java.util.Stack;

public class PilaPedidos {
    private Stack<Pedido> pila;

    public PilaPedidos() {
        this.pila = new Stack<>();
    }

    public Stack<Pedido> getPila() {
		return pila;
	}

	public void setPila(Stack<Pedido> pila) {
		this.pila = pila;
	}
    public void apilarPedido(Pedido pedido) {
        pila.push(pedido);
    }
    public Pedido desapilarPedido() {
        if (!pila.isEmpty()) {
            return pila.pop();
        } else {
            throw new IllegalStateException("La pila de pedidos está vacía.");
        }
    }
    public boolean estaVacia() {
        return pila.isEmpty();
    }
}
