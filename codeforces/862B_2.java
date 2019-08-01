import java.util.*;
class Main {
    public static void main(String[] args) {  // N+
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        Graph graph = new Graph(100);
        int b1 = s.nextInt();
        int b2 = s.nextInt();
        graph.addEdge( b1, b2);
        for (int i = 1; i < N - 1; i++)  // O(N)
            graph.addEdge(s.nextInt(), s.nextInt());
        System.out.println(graph.DFS(b1)-N+1); //O(V+E)
//        graphLinkedList.print(graph);
    }

    static class Graph {
        private int V;   // No. of vertices

        // Array  of lists for Adjacency List Representation
        private LinkedList<Integer> adj[];

        // Constructor
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        //Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);  // Add w to v's list.
        }

        // A function used by DFS
        void DFSUtil(int v, boolean visited[],Integer b1,Integer b2,boolean color) {
            // Mark the current node as visited and print it
            if(color){
                b1++;
            }else{
                b2++;
            }
            visited[v] = true;
//            System.out.print(v + " ");

            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i = adj[v].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    DFSUtil(n, visited,b1,b2,!color);
            }
        }

        // The function to do DFS traversal. It uses recursive DFSUtil()
        int DFS(int v) {
            // Mark all the vertices as not visited(set as
            // false by default in java)
            boolean visited[] = new boolean[V];
            Integer b1 = new Integer(0);
            Integer b2 = new Integer(0);
            // Call the recursive helper function to print DFS traversal
            DFSUtil(v, visited,b1,b2,false);
            return b1*b2;
        }
    }
}