import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static ArrayList<Edge>[] createGraph() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<Edge>();

        for (int i = 0; i < e; i++) {
            String[] temp = br.readLine().split(" ");
            int src = Integer.parseInt(temp[0]);
            int dest = Integer.parseInt(temp[1]);
            int wt = Integer.parseInt(temp[2]);
            graph[src].add(new Edge(src, dest, wt));
        }

        return graph;
    }

    static void topologicalSort(ArrayList<Edge>[] graph, Stack<Integer> stack, boolean[] isVisited, int src) {
        isVisited[src] = true;
        for (Edge e : graph[src])
            if (!isVisited[e.dest])
                topologicalSort(graph, stack, isVisited, e.dest);
        stack.push(src);
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Edge>[] graph = createGraph();
        Stack<Integer> stack = new Stack<>();
        boolean[] isVisited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++)
            if (!isVisited[i])
                topologicalSort(graph, stack, isVisited, i);

        while (stack.size() > 0)
            System.out.print(stack.pop() + " ");
    }
}
