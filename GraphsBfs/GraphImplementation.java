import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * GraphImplementation
 */
class Edge {
    int src;
    int dest;
    int wt;

    public Edge(int s, int d, int w) {
        src = s;
        dest = d;
        wt = w;
    }
}

public class GraphImplementation {

    static ArrayList<Edge>[] createGraph() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String input[] = br.readLine().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            int wt = Integer.parseInt(input[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        return graph;
    }

    static void printGraph(ArrayList<Edge>[] ans) {
        for (ArrayList<Edge> ele : ans)
            for (Edge edge : ele)
                System.out.println(edge.src + " -> " + edge.dest + " with weight = " + edge.wt);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        ArrayList<Edge>[] ans = createGraph();
        printGraph(ans);
    }
}