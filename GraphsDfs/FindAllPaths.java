import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FindAllPaths {
    static void printPaths(boolean[] isVisited, ArrayList<Edge>[] graph, int src, int dest, String psf) {
        if (src == dest) {
            System.out.println(psf);
            return;
        }

        isVisited[src] = true;
        for (Edge edge : graph[src])
            if (!isVisited[edge.dest])
                printPaths(isVisited, graph, edge.dest, dest, psf + edge.dest);
        isVisited[src] = false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        GraphImplementation graphClass = new GraphImplementation();
        ArrayList<Edge>[] graph = graphClass.createGraph();
        graphClass.printGraph(graph);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isVisited = new boolean[graph.length];
        int src = Integer.parseInt(br.readLine());
        int dest = Integer.parseInt(br.readLine());
        printPaths(isVisited, graph, src, dest, src + "");
    }
}
