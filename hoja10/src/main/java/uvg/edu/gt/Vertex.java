package uvg.edu.gt;

public class Vertex<T> {
     private int id;
     private T data; // generic

     public Vertex(int id, T data) { // constructor
          this.id = id;
          this.data = data;
     }

     public int getId() {
          return id;
     }

     public T getData() {
          return data;
     }

     public void setId(int id) {
          this.id = id;
     }

     public void setData(T data) {
          this.data = data;
     }

     @Override
     public String toString() {
          return "Vertex [id=" + id + ", data=" + data + "]";
     }
}
