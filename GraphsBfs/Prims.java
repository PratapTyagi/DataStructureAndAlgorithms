import java.util.ArrayList;
import java.util.PriorityQueue;

/*
    Dijkstra: SSSP(single source shortest path)
    Prims: MSP(minimum spanning tree) setting up wire in LAN connection
 */
public class Prims {
    static class Pair implements Comparable<Pair> {
        int src;
        int par;
        int wt;

        Pair(int s, int p, int w) {
            src = s;
            par = p;
            wt = w;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    static void dijkstra(ArrayList<Edge>[] graph, boolean[] isVisited, int v) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0, -1, 0));
        int ans = 0;
        while (!q.isEmpty()) {
            Pair rem = q.remove();

            if (isVisited[rem.src])
                continue;
            isVisited[rem.src] = true;

            if (rem.par != -1) {
                ans += rem.wt;
                System.out.println("[" + rem.src + " from " + rem.par + " @ " + rem.wt);
            }

            for (Edge e : graph[rem.src])
                if (!isVisited[e.dest])
                    q.add(new Pair(e.dest, rem.src, e.wt));
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        GraphImplementation graphClass = new GraphImplementation();
        ArrayList<Edge>[] graph = graphClass.createGraph();

        int v = graph.length;
        boolean[] isVisited = new boolean[v];
        dijkstra(graph, isVisited, v);
    }
}
