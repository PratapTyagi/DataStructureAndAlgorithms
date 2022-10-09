import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

// Smallest Path, Largest Path
// Just smaller path, Just larger path
// kth largest path

public class Dfs {
    static class Pair {
        String psf;
        int wsf;

        public Pair(String p, int w) {
            psf = p;
            wsf = w;
        }
    }

    static int num = 40;
    static int smallestWeight = Integer.MAX_VALUE, largestWeight = Integer.MIN_VALUE;
    static String smallestPath = "", largestPath = "";
    static int justSmallerWeight = Integer.MAX_VALUE, justLargerWeight = Integer.MIN_VALUE;
    static String justSmallerPath = "", justLargerPath = "";
    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    static void dfs(ArrayList<Edge>[] graph, boolean[] isVisited, String psf,
            int src, int dest, int wt, int k) {
        if (src == dest) {
            if (wt < smallestWeight) {
                smallestWeight = wt;
                smallestPath = psf;
            }
            if (wt > largestWeight) {
                largestWeight = wt;
                largestPath = psf;
            }
            if (wt < num && wt > justSmallerWeight) {
                justSmallerWeight = wt;
                justSmallerPath = psf;
            }
            if (wt > num && wt < justLargerWeight) {
                justLargerWeight = wt;
                justLargerPath = psf;
            }
            if (pq.size() < k)
                pq.add(new Pair(psf, wt));
            else {
                if (wt > pq.peek().wsf) {
                    pq.remove();
                    pq.add(new Pair(psf, wt));
                }
            }

            return;
        }

        isVisited[src] = true;
        for (Edge edge : graph[src]) {
            if (!isVisited[edge.dest])
                dfs(graph, isVisited, psf + edge.dest, edge.dest, dest, wt + edge.wt, k);
        }
        isVisited[src] = false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        ArrayList<Edge>[] graph = GraphImplementation.createGraph();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isVisited = new boolean[graph.length];
        dfs(graph, isVisited, "0", Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), 0,
                Integer.parseInt(br.readLine()));
        System.out.println("Smallest Path: " + smallestWeight + " @ " + smallestPath);
        System.out.println("Largest Path: " + largestWeight + " @ " + largestPath);
        System.out.println("Just Smaller Path: " + justSmallerWeight + " @ " + justSmallerPath);
        System.out.println("Just Larger Path: " + justLargerWeight + " @ " + justLargerPath);
        System.out.println("3rd Larger Path: " + pq.peek().wsf + " @ " + pq.peek().psf);
    }
}
