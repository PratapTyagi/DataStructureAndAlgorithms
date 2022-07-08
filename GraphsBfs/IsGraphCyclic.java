import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class IsGraphCyclic {
    static boolean isCyclic(ArrayList<Edge>[] graph, boolean[] isVisited, int src) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            Integer val = queue.removeFirst();

            if (isVisited[val])
                return true;
            isVisited[val] = true;

            for (Edge e : graph[val])
                if (!isVisited[e.dest])
                    queue.add(e.dest);
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        GraphImplementation graphClass = new GraphImplementation();
        ArrayList<Edge>[] graph = graphClass.createGraph();

        int v = graph.length;
        boolean[] isVisited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!isVisited[i])
                if (isCyclic(graph, isVisited, i)) {
                    System.out.println(true);
                    return;
                }
        }
        System.out.println(false);
    }
}
