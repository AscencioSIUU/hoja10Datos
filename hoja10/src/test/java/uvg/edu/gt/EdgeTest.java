package uvg.edu.gt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EdgeTest {

     @Test
     public void testEdgeCreation() {
          Vertex<String> source = new Vertex<>(1, "A");
          Vertex<String> destination = new Vertex<>(2, "B");
          Edge<String> edge = new Edge<>(source, destination, 10);

          assertEquals(source, edge.getSource());
          assertEquals(destination, edge.getDestination());
          assertEquals(10, edge.getWeight());
     }

     @Test
     public void testEdgeCreationWithNegativeWeight() {
          Vertex<String> source = new Vertex<>(1, "A");
          Vertex<String> destination = new Vertex<>(2, "B");

          assertThrows(IllegalArgumentException.class, () -> new Edge<>(source, destination, -1));
     }

     @Test
     public void testEdgeCreationWithNullSource() {
          Vertex<String> destination = new Vertex<>(2, "B");

          assertThrows(IllegalArgumentException.class, () -> new Edge<>(null, destination, 10));
     }

     @Test
     public void testEdgeCreationWithNullDestination() {
          Vertex<String> source = new Vertex<>(1, "A");

          assertThrows(IllegalArgumentException.class, () -> new Edge<>(source, null, 10));
     }
}
