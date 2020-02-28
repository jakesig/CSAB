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
    public Set<Integer> mis(Graph g) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int i = 0; i < graph[0].length; i++) {
            set1.add(i);
        }
        int var = set1.get();
        set1.remove(var);
        set2.add(var);
        for (int i = 0;  < set1.size(); ++) {
            if (graph[var][i]==false) {
                set2.add(graph[var][i]);
                var = set2.remove(graph[var][i]);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,3);
        g.addEdge(0,1);
        g.addEdge(0,2);
        System.out.println(mis(g));
    }
}
