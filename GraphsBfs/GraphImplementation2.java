import java.util.ArrayList;

public class GraphImplementation2 {
    private ArrayList<ArrayList<Integer>> graph;

    GraphImplementation2(int v) {
        graph = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            graph.add(i, new ArrayList<Integer>());
        }
    }

    private void addEdge(int v, int w) {
        graph.get(v).add(w);
    }

    public void createGraph() {
        addEdge(0, 1);
        addEdge(0, 2);
        addEdge(1, 2);
        addEdge(2, 0);
        addEdge(2, 3);
        addEdge(3, 3);
    }

    public void printGraph() {
        for (ArrayList<Integer> al : graph) {
            for (Integer ele : al)
                System.out.print(ele + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GraphImplementation2 graph = new GraphImplementation2(4);
        graph.createGraph();
        graph.printGraph();
    }

}
