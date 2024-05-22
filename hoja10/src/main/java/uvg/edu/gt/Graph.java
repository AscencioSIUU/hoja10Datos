package uvg.edu.gt;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Represents a graph using an adjacency matrix.
 */
public class Graph {
     private static final int NO_EDGE = 0;
     private final int[][] adjacencyMatrix;
     private final int numVertices;
     private FloydAlgorithm floyd;
     private Map<String, Integer> cityToVertexId;
     private Map<Integer, String> vertexIdToCity;

     /**
      * Initializes the graph with a specified number of vertices.
      *
      * @param numVertices the number of vertices in the graph
      */
     public Graph(int numVertices) {
          this.numVertices = numVertices;
          this.cityToVertexId = new HashMap<>();
          this.vertexIdToCity = new HashMap<>();
          adjacencyMatrix = new int[numVertices][numVertices];
          for (int i = 0; i < numVertices; i++) {
               for (int j = 0; j < numVertices; j++) {
                    adjacencyMatrix[i][j] = NO_EDGE;
               }
          }
          floyd = new FloydAlgorithm(numVertices);
     }

     /**
      * Adds an edge to the graph with a specified weight.
      *
      * @param source      the source vertex
      * @param destination the destination vertex
      * @param weight      the weight of the edge
      */
     public void addEdge(int source, int destination, int weight) {
          validateVertex(source);
          validateVertex(destination);
          adjacencyMatrix[source][destination] = weight;
          floyd.addEdge(source, destination, weight);
          floyd.floydWarshall();
     }

     /**
      * Adds an edge to the graph with a specified weight by city names.
      *
      * @param city1  the source city
      * @param city2  the destination city
      * @param weight the weight of the edge
      */
     public void addEdge(String city1, String city2, int weight) {
          int source = cityToVertexId.get(city1);
          int destination = cityToVertexId.get(city2);
          addEdge(source, destination, weight);
     }

     /**
      * Removes an edge from the graph.
      *
      * @param source      the source vertex
      * @param destination the destination vertex
      */
     public void removeEdge(int source, int destination) {
          validateVertex(source);
          validateVertex(destination);
          adjacencyMatrix[source][destination] = NO_EDGE;
          floyd.addEdge(source, destination, Integer.MAX_VALUE); // Effectively removing the edge
          floyd.floydWarshall();
     }

     /**
      * Removes an edge from the graph by city names.
      *
      * @param city1 the source city
      * @param city2 the destination city
      */
     public void removeEdge(String city1, String city2) {
          int source = cityToVertexId.get(city1);
          int destination = cityToVertexId.get(city2);
          removeEdge(source, destination);
     }

     /**
      * Prints the adjacency matrix of the graph.
      */
     public void printGraph() {
          for (int i = 0; i < numVertices; i++) {
               for (int j = 0; j < numVertices; j++) {
                    System.out.print(adjacencyMatrix[i][j] + " ");
               }
               System.out.println();
          }
     }

     /**
      * Returns the adjacency matrix of the graph.
      *
      * @return the adjacency matrix
      */
     public int[][] getAdjacencyMatrix() {
          return adjacencyMatrix;
     }

     /**
      * Returns the number of vertices in the graph.
      *
      * @return the number of vertices
      */
     public int getNumVertices() {
          return numVertices;
     }

     private void validateVertex(int v) {
          if (v < 0 || v >= numVertices) {
               throw new IllegalArgumentException("Vertex index out of bounds: " + v);
          }
     }

     public void initializeGraphFromFile(String filePath) throws IOException {
          FileParser fileParser = new FileParser(filePath);
          List<FileParser.Route> routes = fileParser.parse();
          int vertexCount = 0;

          for (FileParser.Route route : routes) {
               if (!cityToVertexId.containsKey(route.getCity1())) {
                    cityToVertexId.put(route.getCity1(), vertexCount);
                    vertexIdToCity.put(vertexCount, route.getCity1());
                    vertexCount++;
               }
               if (!cityToVertexId.containsKey(route.getCity2())) {
                    cityToVertexId.put(route.getCity2(), vertexCount);
                    vertexIdToCity.put(vertexCount, route.getCity2());
                    vertexCount++;
               }
          }

          for (FileParser.Route route : routes) {
               int from = cityToVertexId.get(route.getCity1());
               int to = cityToVertexId.get(route.getCity2());
               addEdge(from, to, route.getDistance());
          }
     }

     public double getShortestPathDistance(String from, String to) {
          int fromId = cityToVertexId.get(from);
          int toId = cityToVertexId.get(to);
          return floyd.getDistance(fromId, toId);
     }

     public List<Integer> getShortestPath(String from, String to) {
          int fromId = cityToVertexId.get(from);
          int toId = cityToVertexId.get(to);
          return floyd.getPath(fromId, toId);
     }

     public String getGraphCenter() {
          int centerId = GraphCenter.findGraphCenter(floyd);
          return vertexIdToCity.get(centerId);
     }

     public Map<Integer, String> getVertexIdToCity() {
          return vertexIdToCity;
     }
}
