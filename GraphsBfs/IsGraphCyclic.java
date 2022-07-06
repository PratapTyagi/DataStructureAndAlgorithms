import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class IsGraphCyclic {
    static class Pair {
        int val;
        int par;

        Pair(int s, int p) {
            val = s;
            par = p;
        }
    }

    static boolean isCyclic(ArrayList<Edge>[] graph, boolean[] isVisited, int src) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, -1));
        while (!queue.isEmpty()) {
            Pair rem = queue.removeFirst();
            int val = rem.val;
            int par = rem.par;

            for (Edge e : graph[val]) {
                if (!isVisited[e.dest]) {
                    queue.add(new Pair(e.dest, par));
                    isVisited[e.dest] = true;
                } else if (par != e.dest)
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        GraphImplementation graphClass = new GraphImplementation();
        ArrayList<Edge>[] graph = graphClass.createGraph();

        boolean[] isVisited = new boolean[graph.length];
        System.out.println(isCyclic(graph, isVisited, 0));
    }
}
