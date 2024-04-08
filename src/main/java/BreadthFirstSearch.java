import java.util.Queue;

public class BreadthFirstSearch {


    /** bfs will take an Adjacency List as input and return an array containing the order of nodes traversed.
     *
     * @param graph - an Adjacency List
     * @return - an array containing the order of nodes traversed
     */
    public static int[] bfs(int[][] graph) {

        // Create a Queue and add the first node (0) to it.
        // Use your Queue class that you just created!
        CISQueue<Integer> q = new CISQueue<>(0);

        // Create a visited array.
        // This array will track whether we have visited a specific node.
        boolean[] visited = new boolean[10000];

        // Create a bfs array and a bfs index.
        // This array will track the order that the nodes were visited.
        int[] bfs = new int[10000];
        int bfs_idx = 0;

        // Add the first node (0) to the bfs array.
        bfs[bfs_idx++] = 0;

        // Record the first node as having been visited.
        visited[0] = true;

        // Time to traverse the graph!
        // While the queue is not empty ...
        while (!q.isEmpty()) {
            // Dequeue (poll) the queue and store this value in a variable called currentNode.
            int currentNode = q.dequeue();
            // Record this node as visited.
            visited[currentNode] = true;

            // Explore the current nodes neighbouring nodes.
            // For each neighbouring node ...
            for (int neighbour : graph[currentNode]) {
                // If neighbour hasn't been visited before ...
                if (visited[neighbour]) continue;
                // Mark neighbour as visited.
                visited[neighbour] = true;
                // Add neighbour to the queue.
                q.enqueue(neighbour);
                // Add neighbour to bfs.
                bfs[bfs_idx++] = neighbour;
            }
        }

        // Return bfs.
        return bfs;
    }
}
