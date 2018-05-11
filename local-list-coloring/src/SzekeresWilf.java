import java.util.Set;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.UndirectedGraph;
import org.jgrapht.alg.shortestpath.FloydWarshallShortestPaths;

import javafx.util.Pair;

public class SzekeresWilf {
    
    public UndirectedGraph<Pair<Integer, Integer>, DefaultEdge> powerGraph(UndirectedGraph<Pair<Integer, Integer>, DefaultEdge> g, int k) {
        FloydWarshallShortestPaths<Pair<Integer, Integer>, DefaultEdge> shortestPath = new FloydWarshallShortestPaths<Pair<Integer, Integer>, DefaultEdge>(g);
        Set<Pair<Integer, Integer>> vertexSet = g.vertexSet();
        for (Pair<Integer, Integer> v : vertexSet) {
            for (Pair<Integer, Integer> u : vertexSet) {
                if (u.equals(v))
                    continue;
                if (shortestPath.getPath(u, v).getLength() <= k)
                    g.addEdge(u, v);
            }
        }
        return g;
    }
    
    public int calculateSzekeresWilfNumber(UndirectedGraph<Pair<Integer, Integer>, DefaultEdge> graph) {
        Set<Pair<Integer, Integer>> vertexSet = graph.vertexSet();
        int szw = 0;
        while (!vertexSet.isEmpty()) {
            int minDegree = graph.vertexSet().size() + 1;
            Pair<Integer, Integer> minDegreeVertex = null;
            for (Pair<Integer, Integer> v : vertexSet) {
                int degreeOfV = graph.degreeOf(v);
                if (minDegree > degreeOfV) {
                    minDegree = degreeOfV;
                    minDegreeVertex = v;
                }
            }
            if (minDegreeVertex != null)
                graph.removeVertex(minDegreeVertex);
            if (minDegree > szw)
                szw = minDegree;
        }
        return szw;
    }
}
