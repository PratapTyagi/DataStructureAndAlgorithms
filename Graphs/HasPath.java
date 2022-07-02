import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
7
8
0 1 10
1 2 10
2 3 10
0 3 10
2 4 10
4 5 10
5 6 10
4 6 10
*/

public class HasPath {
    static boolean hasPath(boolean[] isVisited, ArrayList<Edge>[] graph, int src, int dest) {
        if (src == dest)
            return true;

        isVisited[src] = true;
        for (Edge edge : graph[src]) {
            if (!isVisited[edge.dest]) {
                boolean isTrue = hasPath(isVisited, graph, edge.dest, dest);
                if (isTrue)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        GraphImplementation graphClass = new GraphImplementation();
        ArrayList<Edge>[] graph = graphClass.createGraph();
        graphClass.printGraph(graph);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isVisited = new boolean[graph.length];
        boolean ans = hasPath(isVisited, graph, Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()));
        System.out.println(ans);
    }
}
