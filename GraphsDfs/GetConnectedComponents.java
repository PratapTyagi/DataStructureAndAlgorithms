import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    i/p: 
        7
        5
        0 1 10
        2 3 10
        4 5 10
        5 6 10
        4 6 10
    o/p:
        1 4 4
        | | | \
        2 3 5--6
 */

public class GetConnectedComponents {
    static void drawTreeAndFillComponent(ArrayList<Edge>[] graph, boolean[] isVisited, int vertex,
            ArrayList<Integer> comp) {
        isVisited[vertex] = true;
        comp.add(vertex);
        for (Edge e : graph[vertex])
            if (!isVisited[e.dest])
                drawTreeAndFillComponent(graph, isVisited, e.dest, comp);
    }

    public static void main(String[] args) throws Exception {
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

        boolean[] isVisited = new boolean[vertices];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (!isVisited[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                drawTreeAndFillComponent(graph, isVisited, i, comp);
                comps.add(comp);
            }
        }
        for (ArrayList<Integer> ele : comps) {
            for (Integer i : ele) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
