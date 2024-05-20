package uvg.edu.gt;

/**
 * Represents an edge in a graph.
 *
 * @param <T> the type of the vertex
 */
public final class Edge<T> {
     private final Vertex<T> source;
     private final Vertex<T> destination;
     private final int weight;

     /**
      * Constructs an Edge with the specified source, destination, and weight.
      *
      * @param source      the source vertex
      * @param destination the destination vertex
      * @param weight      the weight of the edge
      * @throws IllegalArgumentException if source or destination is null, or if
      *                                  weight is negative
      */
     public Edge(Vertex<T> source, Vertex<T> destination, int weight) {
          if (source == null || destination == null) {
               throw new IllegalArgumentException("Source and destination vertices cannot be null");
          }
          if (weight < 0) {
               throw new IllegalArgumentException("Weight cannot be negative");
          }
          this.source = source;
          this.destination = destination;
          this.weight = weight;
     }

     public Vertex<T> getSource() {
          return source;
     }

     public Vertex<T> getDestination() {
          return destination;
     }

     public int getWeight() {
          return weight;
     }

     @Override
     public String toString() {
          return "Edge [source=" + source + ", destination=" + destination + ", weight=" + weight + "]";
     }
}
