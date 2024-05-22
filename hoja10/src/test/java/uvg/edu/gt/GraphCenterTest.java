package uvg.edu.gt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GraphCenterTest {

     @Test
     public void testFindGraphCenter() {
          int vertices = 4;
          FloydAlgorithm floyd = new FloydAlgorithm(vertices);

          floyd.addEdge(0, 1, 1);
          floyd.addEdge(1, 2, 1);
          floyd.addEdge(2, 3, 1);
          floyd.addEdge(0, 3, 10);

          floyd.floydWarshall();

          int center = GraphCenter.findGraphCenter(floyd);

          assertEquals(1, center);
     }
}
