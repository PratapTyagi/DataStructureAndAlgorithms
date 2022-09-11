import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

// Kahn's Algorithm
class TopologicalSortBfs {
    private static int[] sort(ArrayList<ArrayList<Integer>> graph, int N) {
        int[] topos = new int[N]; // ans array
        int[] inDegree = new int[N]; // all the incoming edges to a vertex

        // indegree calculations
        for (int i = 0; i < N; i++)
            for (Integer ele : graph.get(i))
                inDegree[ele]++;

        /*
         * adding indegree 0 ele because they can be first elements in toposort without
         * dependencies
         */
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++)
            if (inDegree[i] == 0)
                q.add(i);

        int idx = 0;
        while (!q.isEmpty()) {
            Integer top = q.poll();
            topos[idx++] = top;

            for (Integer ele : graph.get(top)) {
                inDegree[ele]--;
                if (inDegree[ele] == 0)
                    q.add(ele);
            }
        }

        return topos;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++)
            graph.add(i, new ArrayList<>());

        s = null;
        for (int i = 0; i < E; i++) {
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            graph.get(u).add(v);
        }

        int[] ans = sort(graph, graph.size());
        for (int ele : ans)
            System.out.print(ele + " ");
        System.out.println();
    }
}