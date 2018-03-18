import org.jgraph.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.graph.SimpleGraph;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.util.Pair;

public class CellularGraphGenerator {
    
    private void addNeighbors(UndirectedGraph<Pair<Integer, Integer>, DefaultEdge> cellularGraph, Pair<Integer, Integer> node, Queue<Pair<Integer, Integer>> generatedNodes) {
        Integer x = node.getKey();
        Integer y = node.getValue();
        ArrayList<Pair<Integer, Integer>> neighbors = new ArrayList<Pair<Integer, Integer>>(
                Arrays.asList(new Pair<>(x, y + 1),
                              new Pair<>(x - 1, y),
                              new Pair<>(x - 1, y - 1),
                              new Pair<>(x, y - 1),
                              new Pair<>(x + 1, y),
                              new Pair<>(x + 1, y + 1))
        );
        for (Pair<Integer, Integer> neighbor : neighbors) {
            // We might add duplicate nodes (and edges), but this is not an issue as the underlying graph
            // data structure ignores duplicate nodes.
            if (cellularGraph.addVertex(neighbor))
                generatedNodes.add(neighbor);
            cellularGraph.addEdge(node, neighbor);
        }
    }
    
    /*
     * This function returns the cellular graph that represents the
     * the hexagonal cell topology of a given plane (cf. Definition 2.1)
     * 
     */
    public UndirectedGraph<Pair<Integer, Integer>, DefaultEdge> generateGraph(Integer n) {
        UndirectedGraph<Pair<Integer, Integer>, DefaultEdge> cellularGraph = new SimpleGraph<Pair<Integer, Integer>, DefaultEdge>(DefaultEdge.class);
        Queue<Pair<Integer, Integer>> generatedNodes = new LinkedList<Pair<Integer, Integer>>();
        Pair<Integer, Integer> firstNode = new Pair<>(0, 0); 
        generatedNodes.add(firstNode);
        cellularGraph.addVertex(firstNode);
        while (cellularGraph.vertexSet().size() <= n)
            addNeighbors(cellularGraph, generatedNodes.remove(), generatedNodes);
        return cellularGraph;
    }
}
