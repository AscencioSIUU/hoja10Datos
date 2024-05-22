package uvg.edu.gt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class FileParserTest {

     @Test
     public void testParseValidFile() throws IOException {
          FileParser parser = new FileParser("testGraph.txt"); // Make sure this file exists for the test
          List<FileParser.Route> routes = parser.parse();

          assertEquals(3, routes.size());
          assertEquals("Mixco", routes.get(0).getCity1());
          assertEquals("Antigua", routes.get(0).getCity2());
          assertEquals(30, routes.get(0).getDistance());
     }

     @Test
     public void testParseInvalidFile() {
          FileParser parser = new FileParser("nonExistentFile.txt");

          assertThrows(IOException.class, parser::parse);
     }
}
