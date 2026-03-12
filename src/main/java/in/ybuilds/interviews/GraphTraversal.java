package in.ybuilds.interviews;

import java.util.*;

public class GraphTraversal {
    private Map<Integer, List<Integer>> adj;

    public void bfs(int start, Map<Integer, List<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();

        queue.add(start);
        visit.add(start);
        System.out.print(start + " ");

        while(!queue.isEmpty()) {
            List<Integer> neighbors = adj.get(queue.remove());

            if (neighbors == null)
                continue;

            for(Integer i: neighbors) {
                if (!visit.contains(i)) {
                    System.out.print(i + " ");
                    visit.add(i);
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start, Map<Integer, List<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visit = new HashSet<>();

        stack.push(start);

        while(!stack.isEmpty()) {
            int node = stack.pop();

            if(visit.contains(node))
                continue;

            visit.add(node);
            System.out.print(node + " ");

            List<Integer> neighbors = adj.get(node);

            if (neighbors == null)
                continue;

            for(int i=neighbors.size()-1; i>=0; i--) {
                int n = neighbors.get(i);

                if (!visit.contains(n))
                    stack.push(n);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphTraversal object = new GraphTraversal();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        object.adj = new HashMap<>();

        for(int i=0; i<n; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            List<Integer> list = object.adj.get(u);

            if (list == null)
                object.adj.put(u, new ArrayList<>(List.of(v)));
            else {
                list.add(v);
                object.adj.put(u, list);
            }
        }

        int start = 1;
        object.bfs(start, object.adj);
        object.dfs(start, object.adj);
    }
}
