package uvg.edu.gt;

/**
 * Represents a graph using an adjacency matrix.
 */
public class Graph {
     private static final int NO_EDGE = 0;
     private final int[][] adjacencyMatrix;
     private final int numVertices;

     /**
      * Initializes the graph with a specified number of vertices.
      *
      * @param numVertices the number of vertices in the graph
      */
     public Graph(int numVertices) {
          this.numVertices = numVertices;
          adjacencyMatrix = new int[numVertices][numVertices];
          for (int i = 0; i < numVertices; i++) {
               for (int j = 0; j < numVertices; j++) {
                    adjacencyMatrix[i][j] = NO_EDGE;
               }
          }
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
}
