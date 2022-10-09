import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;;

@SuppressWarnings("unchecked")

/**
 * Dijkstra
 */
public class Dijkstra {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            src = s;
            dest = d;
            wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int src;
        int wt;

        Pair(int s, int w) {
            src = s;
            wt = w;
        }

        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    static int[] dijkstra(ArrayList<Edge>[] graph, int src, int v) {
        int[] ans = new int[v];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[src] = 0;
        boolean[] isVisited = new boolean[v];
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(src, 0));

        while (!q.isEmpty()) {
            Pair rem = q.remove();

            if (isVisited[rem.src])
                continue;
            isVisited[rem.src] = true;

            for (Edge e : graph[rem.src]) {
                if (isVisited[e.dest] == false) {
                    q.add(new Pair(e.dest, rem.wt + e.wt));
                    ans[e.dest] = Math.min(ans[e.dest], rem.wt + e.wt);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++)
            graph[i] = new ArrayList<Edge>();

        for (int i = 0; i < e; i++) {
            String[] temp = br.readLine().split(" ");
            int src = Integer.parseInt(temp[0]);
            int dest = Integer.parseInt(temp[1]);
            int wt = Integer.parseInt(temp[2]);
            graph[src].add(new Edge(src, dest, wt));
            graph[dest].add(new Edge(dest, src, wt));
        }

        int[] ans = dijkstra(graph, 2, v);
        for (int i : ans)
            System.out.print(i + " ");
    }
}