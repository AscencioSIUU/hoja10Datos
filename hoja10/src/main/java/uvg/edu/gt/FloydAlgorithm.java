package uvg.edu.gt;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the Floyd-Warshall algorithm to find the shortest paths between
 * all pairs of vertices.
 */
public class FloydAlgorithm {
    private static final double INF = Double.POSITIVE_INFINITY;
    private double[][] distances;
    private int numberOfVertices;
    private int[][] next;

    /**
     * Constructs a FloydAlgorithm instance with the specified number of vertices.
     *
     * @param numberOfVertices the number of vertices in the graph
     */
    public FloydAlgorithm(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        distances = new double[numberOfVertices][numberOfVertices];
        next = new int[numberOfVertices][numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                if (i != j) {
                    distances[i][j] = INF;
                }
                next[i][j] = -1;
            }
        }
    }

    /**
     * Adds an edge to the graph with the specified weight.
     *
     * @param from   the starting vertex of the edge
     * @param to     the ending vertex of the edge
     * @param weight the weight of the edge
     */
    public void addEdge(int from, int to, int weight) {
        validateVertex(from);
        validateVertex(to);
        distances[from][to] = weight;
        next[from][to] = to;
    }

    /**
     * Runs the Floyd-Warshall algorithm to compute shortest paths between all pairs
     * of vertices.
     */
    public void floydWarshall() {
        for (int k = 0; k < numberOfVertices; k++) {
            for (int i = 0; i < numberOfVertices; i++) {
                for (int j = 0; j < numberOfVertices; j++) {
                    if (distances[i][k] + distances[k][j] < distances[i][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
    }

    /**
     * Returns the shortest distance between two vertices.
     *
     * @param from the starting vertex
     * @param to   the ending vertex
     * @return the shortest distance between the vertices
     */
    public double getDistance(int from, int to) {
        validateVertex(from);
        validateVertex(to);
        return distances[from][to];
    }

    /**
     * Returns the path between two vertices.
     *
     * @param from the starting vertex
     * @param to   the ending vertex
     * @return the path between the vertices
     */
    public List<Integer> getPath(int from, int to) {
        validateVertex(from);
        validateVertex(to);
        List<Integer> path = new ArrayList<>();
        if (next[from][to] == -1) {
            return path;
        }
        int at = from;
        while (at != to) {
            path.add(at);
            at = next[at][to];
        }
        path.add(to);
        return path;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= numberOfVertices) {
            throw new IllegalArgumentException("Vertex index out of bounds: " + v);
        }
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public double[][] getDistances() {
        return distances;
    }
}
