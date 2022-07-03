import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

/*
    7
    9
    0 1 10
    1 2 10
    2 3 10
    3 4 10
    4 5 10
    5 6 10
    4 6 10
    2 5 10
    0
 */

public class HamiltonianCycleOrPath {
    static void checkHamiltonian(ArrayList<Edge>[] graph, HashSet<Integer> isVisited, int src, String psf, int osrc) {
        // System.out.println("visited size -> " + isVisited.size() + " graph size -> "
        // + graph.length);
        if (isVisited.size() == graph.length - 1) {
            System.out.print(psf);

            boolean checkHamiltonianCycle = false;
            for (Edge ele : graph[src])
                if (ele.dest == osrc) {
                    checkHamiltonianCycle = true;
                    break;
                }

            if (checkHamiltonianCycle)
                System.out.println(" *");
            else
                System.out.println(" .");

            return;
        }

        isVisited.add(src);
        for (Edge ele : graph[src])
            if (!isVisited.contains(ele.dest))
                checkHamiltonian(graph, isVisited, ele.dest, psf + ele.dest, osrc);
        isVisited.remove(src);
    }

    public static void main(String[] args) throws Exception {
        GraphImplementation graphClass = new GraphImplementation();
        ArrayList<Edge>[] graph = graphClass.createGraph();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> isVisited = new HashSet<Integer>();
        int src = Integer.parseInt(br.readLine());
        checkHamiltonian(graph, isVisited, src, src + "", src);
    }
}
