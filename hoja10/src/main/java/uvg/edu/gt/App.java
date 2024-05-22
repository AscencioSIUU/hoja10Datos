package uvg.edu.gt;

import java.util.*;
import java.io.File;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Graph graph = new Graph(0);

        try {
            graph.initializeGraphFromFile("guategrafo.txt");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        boolean running = true;
        while (running) {
            System.out.println("WAZE");
            System.out.println("1. Calcular ruta mas corta entre dos ciudades");
            System.out.println("2. Cuidad del centro del grafo");
            System.out.println("3. Modificar el grafo");
            System.out.println("4. Salir de Waze");

            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    calculateShortestPath(graph);
                    break;
                case 2:
                    findGraphCenter(graph);
                    break;
                case 3:
                    modifyGraph(graph);
                    break;
                case 4:
                    running = false;
                    break;

                default:
                    break;
            }
        }
    }

    private static void calculateShortestPath(Graph graph) {
        System.out.println("Ingrese la cuidad de origen");
        String origin = scanner.nextLine();
        System.out.println("Ingrese la cuidad de destino");
        String destination = scanner.nextLine();

        double distance = graph.getShortestPathDistance(origin, destination);
        if (distance == Double.POSITIVE_INFINITY) {
            System.out.println("No hay rutas disponibles entre estas dos cuidades: " + origin + "y " + destination);
        } else {
            List<Integer> path = graph.getShortestPath(origin, destination);
            System.out.println("la distancia mas corta entre: " + origin + " y " + destination);
            System.out.println("Ruta: ");
            for (int i = 0; i < path.size(); i++) {
                System.out.print(graph.getVertexIdToCity().get(path.get(i)));
                if (i < path.size() - 1) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    private static void findGraphCenter(Graph graph) {
        String centerCity = graph.getGraphCenter();
        System.out.println("La ciudad que queda en el centro del grafo es: " + centerCity);
    }

    private static void modifyGraph(Graph graph) {
        System.out.println("Ingrese 1 para establecer una conexión o 2 para indicar interrupción de tráfico:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Ingrese la primera ciudad:");
            String city1 = scanner.nextLine();
            System.out.println("Ingrese la segunda ciudad:");
            String city2 = scanner.nextLine();
            System.out.println("Ingrese la distancia en km:");
            int distance = scanner.nextInt();
            scanner.nextLine();

            graph.addEdge(city1, city2, distance);
        } else if (choice == 2) {
            System.out.println("Ingrese la primera ciudad:");
            String city1 = scanner.nextLine();
            System.out.println("Ingrese la segunda ciudad:");
            String city2 = scanner.nextLine();

            graph.removeEdge(city1, city2);
        } else {
            System.out.println("Opción no válida.");
        }
    }

}
