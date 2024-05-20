package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Parses a file containing routes between cities.
 */
public class FileParser {
     private String filePath;

     /**
      * Constructs a FileParser with the specified file path.
      *
      * @param filePath the path to the file to be parsed
      */
     public FileParser(String filePath) {
          this.filePath = filePath;
     }

     /**
      * Parses the file and returns a list of routes.
      *
      * @return a list of routes parsed from the file
      * @throws IOException if an I/O error occurs
      */
     public List<Route> parse() throws IOException {
          List<Route> routes = new ArrayList<>();
          try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
               String line;
               while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(" ");
                    if (parts.length == 3) {
                         String city1 = parts[0];
                         String city2 = parts[1];
                         int distance = Integer.parseInt(parts[2]);
                         routes.add(new Route(city1, city2, distance));
                    }
               }
          }
          return routes;
     }

     /**
      * Represents a route between two cities.
      */
     public static class Route {
          private final String city1;
          private final String city2;
          private final int distance;

          /**
           * Constructs a Route with the specified cities and distance.
           *
           * @param city1    the first city
           * @param city2    the second city
           * @param distance the distance between the cities
           */
          public Route(String city1, String city2, int distance) {
               this.city1 = city1;
               this.city2 = city2;
               this.distance = distance;
          }

          public String getCity1() {
               return city1;
          }

          public String getCity2() {
               return city2;
          }

          public int getDistance() {
               return distance;
          }
     }
}
