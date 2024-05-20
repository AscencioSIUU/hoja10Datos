package uvg.edu.gt;

import java.util.*;

public class GraphController {
     private Map<String, Node> nodes;

     public GraphController() {
          this.nodes = new HashMap<>();
     }

     public void addNode(String cityName) {
          nodes.putIfAbsent(cityName, new Node(cityName));
     }

     public void addEdge(String city1, String city2, int distance) {
          Node node1 = nodes.get(city1);
          Node node2 = nodes.get(city2);

          if (node1 == null || node2 == null) {
               System.out.println("One or both cities not found.");
               return;
          }

          node1.addNeighbor(new Route(node2, distance));
          node2.addNeighbor(new Route(node1, distance));
     }

     // Displays all nodes and their connections
     public void displayGraph() {
          for (String cityName : nodes.keySet()) {
               Node node = nodes.get(cityName);
               System.out.print("City " + cityName + " is connected to: ");
               for (Route route : node.getRoutes()) {
                    System.out.print(route.getTarget().getName() + "(" + route.getDistance() + " KM) ");
               }
               System.out.println();
          }
     }

     private static class Node {
          private String name;
          private List<Route> routes;

          public Node(String name) {
               this.name = name;
               this.routes = new ArrayList<>();
          }

          public void addNeighbor(Route route) {
               this.routes.add(route);
          }

          public List<Route> getRoutes() {
               return routes;
          }

          public String getName() {
               return name;
          }
     }

     // Route class
     private static class Route {
          private Node target;
          private int distance;

          public Route(Node target, int distance) {
               this.target = target;
               this.distance = distance;
          }

          public Node getTarget() {
               return target;
          }

          public int getDistance() {
               return distance;
          }
     }
}
