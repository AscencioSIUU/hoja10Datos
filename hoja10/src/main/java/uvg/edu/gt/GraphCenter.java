package uvg.edu.gt;

import java.util.*;

public class GraphCenter {
     private List<Node> nodes; // List of nodes in the graph

     public GraphCenter(List<Node> nodes) {
          this.nodes = nodes;
     }

     public List<Node> findCenter() {
          int radius = calculateRadius();
          List<Node> centerNodes = new ArrayList<>();
          for (Node node : nodes) {
               if (calculateEccentricity(node) == radius) {
                    centerNodes.add(node);
               }
          }
          return centerNodes;
     }

     private int calculateRadius() {
          int radius = Integer.MAX_VALUE;
          for (Node node : nodes) {
               int eccentricity = calculateEccentricity(node);
               radius = Math.min(radius, eccentricity);
          }
          return radius;
     }

     private int calculateEccentricity(Node node) { // implements BFS fastest node
          Map<Node, Integer> distance = new HashMap<>();
          Queue<Node> queue = new LinkedList<>();

          for (Node n : nodes) {
               distance.put(n, -1); // Initialize distances as -1 (unvisited)
          }

          distance.put(node, 0); // Distance to itself is 0
          queue.add(node);

          while (!queue.isEmpty()) {
               Node current = queue.poll();
               for (Node neighbor : current.getNeighbors()) {
                    if (distance.get(neighbor) == -1) { // If unvisited
                         distance.put(neighbor, distance.get(current) + 1);
                         queue.add(neighbor);
                    }
               }
          }
          return Collections.max(distance.values());
     }

     // Node class definition
     public static class Node {
          private int id;
          private List<Node> neighbors;

          public Node(int id) {
               this.id = id;
               this.neighbors = new ArrayList<>();
          }

          public void addNeighbor(Node neighbor) {
               this.neighbors.add(neighbor);
          }

          public List<Node> getNeighbors() {
               return neighbors;
          }

          public int getId() {
               return id;
          }
     }
}