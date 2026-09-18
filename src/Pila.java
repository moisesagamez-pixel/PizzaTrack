public class Pila {

    private Nodo tope;

    public Pila() {
        tope = null;
    }

    public void push(Pizza pizza) {

        Nodo nuevo = new Nodo(pizza);

        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public Pizza pop() {

        if (isEmpty()) {
            return null;
        }

        Pizza pizza = tope.pizza;

        tope = tope.siguiente;

        return pizza;
    }

    public Pizza peek() {

        if (isEmpty()) {
            return null;
        }

        return tope.pizza;
    }

    public boolean isEmpty() {

        return tope == null;
    }
}
    