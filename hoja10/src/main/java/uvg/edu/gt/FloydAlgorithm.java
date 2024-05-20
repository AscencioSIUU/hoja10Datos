package uvg.edu.gt;

public class FloydAlgorithm {
     private double[][] distances;
     private int numberOfVertices;

     public FloydAlgorithm(int numberOfVertices) { // constructor
          this.numberOfVertices = numberOfVertices;
          distances = new double[numberOfVertices][numberOfVertices];
          for (int i = 0; i < numberOfVertices; i++) {
               for (int j = 0; j < numberOfVertices; j++) {
                    if (i != j) {
                         distances[i][j] = Double.POSITIVE_INFINITY;
                    }
               }
          }
     }

     public void addEdge(int from, int to, int weight) {
          distances[from][to] = weight;
     }

     public void floydWarshall() {
          for (int k = 0; k < numberOfVertices; k++) {
               for (int i = 0; i < numberOfVertices; i++) {
                    for (int j = 0; j < numberOfVertices; j++) {
                         if (distances[i][k] + distances[k][j] < distances[i][j]) {
                              distances[i][j] = distances[i][k] + distances[k][j];
                         }
                    }
               }
          }
     }

     // shortest distance between twho vertices
     public double getDistance(int from, int to) {
          return distances[from][to];
     }
}
