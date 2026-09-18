public class Pizza {

    private String nombre;
    private String[] ingredientes;

    public Pizza(String nombre, String[] ingredientes) {
        this.nombre = nombre;
        this.ingredientes = new String[3];

        for (int i = 0; i < 3; i++) {
            this.ingredientes[i] = ingredientes[i];
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void mostrarPizza() {
        System.out.println("Pizza: " + nombre);
        System.out.println("Ingredientes:");

        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + ingredientes[i]);
        }
    }
}