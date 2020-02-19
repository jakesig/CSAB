import java.util.HashSet;
import java.util.Set;

public class Graph {
    private boolean[][] graph;
    public Graph(int verticies) {
        graph = new boolean[verticies][verticies];
    }
    public void addEdge(int from, int to) {
        graph[from][to]=true;
        graph[to][from]=true;
    }
    public void mis(Graph g) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int i = 0; i < graph[0].length; i++) {
            set1.add(i);
        }
    }
}
