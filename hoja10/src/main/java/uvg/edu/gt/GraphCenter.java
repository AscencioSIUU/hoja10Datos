package uvg.edu.gt;

public class GraphCenter {
     public static int findGraphCenter(FloydAlgorithm floyd) {
          int numVertices = floyd.getNumberOfVertices();
          double[][] distances = floyd.getDistances();
          int centerVertex = -1;
          double minMaxDist = Double.POSITIVE_INFINITY;

          for (int i = 0; i < numVertices; i++) {
               double maxDist = 0;
               for (int j = 0; j < numVertices; j++) {
                    if (i != j) {
                         maxDist = Math.max(maxDist, distances[i][j]);
                    }
               }
               if (maxDist < minMaxDist) {
                    minMaxDist = maxDist;
                    centerVertex = i;
               }
          }

          return centerVertex;
     }
}
