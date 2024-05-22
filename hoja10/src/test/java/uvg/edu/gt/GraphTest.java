package uvg.edu.gt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class GraphTest {

     @Test
     public void testInitializeGraphFromFile() throws IOException {
          Graph graph = new Graph(5);
          graph.initializeGraphFromFile("testGraph.txt"); // Make sure this file exists for the test

          assertEquals(30, graph.getShortestPathDistance("Mixco", "Antigua"));
     }

     @Test
     public void testAddEdge() {
          Graph graph = new Graph(5);
          graph.addEdge("Mixco", "Antigua", 30);

          assertEquals(30, graph.getShortestPathDistance("Mixco", "Antigua"));
     }

     @Test
     public void testRemoveEdge() {
          Graph graph = new Graph(5);
          graph.addEdge("Mixco", "Antigua", 30);
          graph.removeEdge("Mixco", "Antigua");

          assertEquals(Double.POSITIVE_INFINITY, graph.getShortestPathDistance("Mixco", "Antigua"));
     }

     @Test
     public void testGetGraphCenter() throws IOException {
          Graph graph = new Graph(5);
          graph.initializeGraphFromFile("testGraph.txt"); // Make sure this file exists for the test

          String center = graph.getGraphCenter();

          assertNotNull(center);
     }
}
