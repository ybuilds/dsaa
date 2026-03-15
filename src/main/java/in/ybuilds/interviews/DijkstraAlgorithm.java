package in.ybuilds.interviews;

import java.util.*;

public class DijkstraAlgorithm {
    static class Node {
        int to, weight;
        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return to + ":" + weight;
        }
    }

    private void dijkstra(int source, int node, Map<Integer, List<Node>> adj) {
        boolean[] visit = new boolean[node];
        int[] distance = new int[node];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));

        distance[source] = 0;
        queue.add(new Node(source, 0));

        while(!queue.isEmpty()) {
            Node curr = queue.remove();
            int u = curr.to;

            if(visit[u])
                continue;
            visit[u] = true;

            List<Node> neighbor = adj.get(u);
            if (neighbor == null)
                continue;

            for(Node n: neighbor) {
                int v = n.to;
                int w = n.weight;

                if (!visit[v] && distance[v] > distance[u] + w) {
                    distance[v] = distance[u] + w;
                    queue.add(new Node(v, distance[v]));
                }
            }
        }

        for(int i=0; i<node; i++)
            System.out.println("Distance from " + source + " to " + i + " = " + distance[i]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DijkstraAlgorithm object = new DijkstraAlgorithm();

        int nodes = scanner.nextInt();
        int n = scanner.nextInt();
        Map<Integer, List<Node>> adj = new HashMap<>();
        for(int i=0; i<n; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();

            List<Node> list = adj.get(from);
            if (list == null) {
                adj.put(from, new ArrayList<>(List.of(new Node(to, weight))));
            } else {
                list.add(new Node(to, weight));
                adj.put(from, list);
            }
        }

        int source = 0;
        object.dijkstra(source, nodes, adj);
    }
}
