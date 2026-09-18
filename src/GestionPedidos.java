import java.util.Scanner;

public class GestionPedidos {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Pila pilaPrincipal = new Pila();
        Pila pilaSecundaria = new Pila();

        int opcion;

        do {

            System.out.println("\n==============================");
            System.out.println("        PIZZA-TRACK");
            System.out.println("==============================");
            System.out.println("1. Registrar Pizza");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar Pedido Actual");
            System.out.println("0. Salir");
            System.out.println("==============================");

            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("\nIngrese el nombre de la pizza: ");
                    String nombre = scanner.nextLine();

                    String[] ingredientes = new String[3];

                    for (int i = 0; i < 3; i++) {

                        System.out.print(
                            "Ingrese el ingrediente "
                            + (i + 1) + ": "
                        );

                        ingredientes[i] = scanner.nextLine();
                    }

                    Pizza nuevaPizza =
                            new Pizza(nombre, ingredientes);

                    pilaPrincipal.push(nuevaPizza);

                    pilaSecundaria = new Pila();

                    System.out.println(
                        "\nPizza registrada correctamente."
                    );

                    break;

                case 2:

                    if (pilaPrincipal.isEmpty()) {

                        System.out.println(
                            "\nNo hay pedidos para deshacer."
                        );

                    } else {

                        Pizza pizzaDeshecha =
                                pilaPrincipal.pop();

                        pilaSecundaria.push(pizzaDeshecha);

                        System.out.println(
                            "\nSe deshizo la pizza: "
                            + pizzaDeshecha.getNombre()
                        );
                    }

                    break;

                case 3:

                    if (pilaSecundaria.isEmpty()) {

                        System.out.println(
                            "\nNo hay pedidos para rehacer."
                        );

                    } else {

                        Pizza pizzaRehecha =
                                pilaSecundaria.pop();

                        pilaPrincipal.push(pizzaRehecha);

                        System.out.println(
                            "\nSe rehizo la pizza: "
                            + pizzaRehecha.getNombre()
                        );
                    }

                    break;

                case 4:

                    if (pilaPrincipal.isEmpty()) {

                        System.out.println(
                            "\nNo hay pedidos activos."
                        );

                    } else {

                        System.out.println(
                            "\n===== PEDIDO ACTUAL ====="
                        );

                        Pizza pizzaActual =
                                pilaPrincipal.peek();

                        pizzaActual.mostrarPizza();
                    }

                    break;

                case 0:

                    System.out.println(
                        "\nGracias por utilizar Pizza-Track."
                    );

                    break;

                default:

                    System.out.println(
                        "\nOpcion no valida."
                    );
            }

        } while (opcion != 0);

        scanner.close();
    }
}