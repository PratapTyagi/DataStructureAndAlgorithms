import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/*
    bipartite = no two adjacent node have same color if we could fill graph with two colors
    bipartite = non cyclic + cyclic with even edges is bipartite graph
*/
public class IsBipartite {
    static class Pair {
        int value;
        int level;

        Pair(int v, int l) {
            value = v;
            level = l;
        }
    }

    static boolean isBipartite(ArrayList<Edge>[] graph, int[] isVisited, int src) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, 0));
        while (!queue.isEmpty()) {
            Pair rem = queue.removeFirst();
            if (isVisited[rem.value] != -1) {
                if (isVisited[rem.value] != rem.level) {
                    return false;
                }
            } else
                isVisited[rem.value] = rem.level;

            for (Edge e : graph[rem.value]) {
                if (isVisited[e.dest] == -1) {
                    queue.add(new Pair(e.dest, rem.level + 1));
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        GraphImplementation graphClass = new GraphImplementation();
        ArrayList<Edge>[] graph = graphClass.createGraph();

        int[] isVisited = new int[graph.length];
        Arrays.fill(isVisited, -1);
        for (int i = 0; i < graph.length; i++) {
            if (isVisited[i] == -1) {
                boolean isTrue = isBipartite(graph, isVisited, i);
                if (!isTrue) {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);
    }
}
