import java.util.ArrayDeque;
import java.util.ArrayList;

public class Bfs {
    static class Pair {
        int v;
        String psf;

        public Pair(int s, String p) {
            v = s;
            psf = p;
        }
    }

    static void bfs(ArrayList<Edge>[] graph, boolean[] isVisited, int src) {
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(src, src + ""));

        while (!queue.isEmpty()) {
            Pair ele = queue.removeFirst();

            if (isVisited[ele.v])
                continue;
            isVisited[ele.v] = true;

            System.out.println(ele.v + " @ " + ele.psf);

            for (Edge e : graph[ele.v])
                if (!isVisited[e.dest])
                    queue.add(new Pair(e.dest, ele.psf + e.dest));
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Edge>[] graph = GraphImplementation.createGraph();

        boolean[] isVisited = new boolean[graph.length];
        bfs(graph, isVisited, 2);
    }
}
