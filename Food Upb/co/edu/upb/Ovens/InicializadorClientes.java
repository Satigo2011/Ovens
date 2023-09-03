package co.edu.upb.Ovens;

public class InicializadorClientes {
    public static void inicializarClientes(Operador operador) {
        // Registrar tres clientes de prueba en la base de datos
        Usuario cliente1 = new Usuario("Juan", "Perez", "Calle A 123", "Premium", "111-111-1111");
        Usuario cliente2 = new Usuario("Maria", "Gomez", "Calle B 456", "Común", "222-222-2222");
        Usuario cliente3 = new Usuario("Pedro", "Lopez", "Calle C 789", "Premium", "333-333-3333");

        operador.agregarUsuario(cliente1);
        operador.agregarUsuario(cliente2);
        operador.agregarUsuario(cliente3);
    }
}