import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    7
    5
    0 1
    2 3
    4 5
    5 6
    4 6

    here 0, 1 are in same club similarly 2, 3 and so on so forth 
    what are no. of ways to make friends of some different clubs
 */

public class PerfectFriend {
    static void connectedClubs(ArrayList<Edge>[] graph, boolean[] isVisited, ArrayList<Integer> comp, int src) {
        isVisited[src] = true;
        comp.add(src);

        for (Edge e : graph[src]) {
            if (!isVisited[e.dest]) {
                connectedClubs(graph, isVisited, comp, e.dest);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vertices = Integer.parseInt(br.readLine());
        int edges = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] graph = new ArrayList[vertices];

        for (int i = 0; i < graph.length; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < edges; i++) {
            String[] ipt = br.readLine().split(" ");
            int src = Integer.parseInt(ipt[0]);
            int dest = Integer.parseInt(ipt[1]);
            int wt = Integer.parseInt(ipt[2]);
            graph[src].add(new Edge(src, dest, wt));
            graph[dest].add(new Edge(dest, src, wt));
        }

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] isVisited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!isVisited[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                connectedClubs(graph, isVisited, comp, i);
                comps.add(comp);
            }
        }

        int ans = 0;
        for (int i = 0; i < comps.size(); i++)
            for (int j = i + 1; j < comps.size(); j++)
                ans += comps.get(i).size() * comps.get(j).size();

        System.out.println(ans);
    }
}
