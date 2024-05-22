package uvg.edu.gt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

public class FloydAlgorithmTest {

     @Test
     public void testFloydWarshall() {
          int vertices = 4;
          FloydAlgorithm floyd = new FloydAlgorithm(vertices);

          floyd.addEdge(0, 1, 1);
          floyd.addEdge(1, 2, 1);
          floyd.addEdge(2, 3, 1);
          floyd.addEdge(0, 3, 10);

          floyd.floydWarshall();

          assertEquals(3, floyd.getDistance(0, 3));
     }

     @Test
     public void testGetPath() {
          int vertices = 4;
          FloydAlgorithm floyd = new FloydAlgorithm(vertices);

          floyd.addEdge(0, 1, 1);
          floyd.addEdge(1, 2, 1);
          floyd.addEdge(2, 3, 1);
          floyd.addEdge(0, 3, 10);

          floyd.floydWarshall();

          List<Integer> path = floyd.getPath(0, 3);

          assertEquals(List.of(0, 1, 2, 3), path);
     }
}
