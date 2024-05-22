package uvg.edu.gt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class VertexTest {

     @Test
     public void testVertexCreation() {
          Vertex<String> vertex = new Vertex<>(1, "A");

          assertEquals(1, vertex.getId());
          assertEquals("A", vertex.getData());
     }

     @Test
     public void testSetId() {
          Vertex<String> vertex = new Vertex<>(1, "A");
          vertex.setId(2);

          assertEquals(2, vertex.getId());
     }

     @Test
     public void testSetData() {
          Vertex<String> vertex = new Vertex<>(1, "A");
          vertex.setData("B");

          assertEquals("B", vertex.getData());
     }
}
