/**
 * GRAPH
 */
import java.util.*;
class graphLinkedList{
    Map<Integer,HashSet<Integer>> graph;
    graphLinkedList(){
        this.graph = new HashMap<>();
    }
    static void add(graphLinkedList G,int node1,int node2){ // complexity O(1)
        G.graph.putIfAbsent(node1,new HashSet<>());
        G.graph.get(node1).add(node2);
        G.graph.putIfAbsent(node2,new HashSet<>());
        G.graph.get(node2).add(node1);
    }
    static void print(graphLinkedList G){
        for(Integer i:G.graph.keySet()) {
            System.out.print(i+"|");
            for (Integer j : G.graph.get(i))
                System.out.print("---->" + j);
            System.out.println("");
        }
    }

    static void bfs(graphLinkedList G,int source){  // complexity  :  O(V+E)
        Set<Integer> visited = new HashSet<>();//[G.graph.size()];
//        Arrays.fill(visited,0);
        List<Integer> queue = new ArrayList<>();
        queue.add(source);
        int temp;
        visited.add(source);
        while(queue.size()>0){
            temp = queue.remove(0);
            for(Integer i:G.graph.get(temp))
                if(!visited.contains(i)) {
                    queue.add(i);
                    visited.add(i);
                }
            System.out.print(temp+"---->");
        }
    }

    static void dfs(graphLinkedList G,int source){
        Set<Integer> visited = new HashSet<>();
        List<Integer> stack = new ArrayList<>();
        visited.add(source);
        stack.add(source);
        int prev=0;
        System.out.print(stack.get(stack.size()-1)+"---->");
        while(stack.size()>0){
            if(prev == visited.size()) stack.remove(stack.size()-1);
            prev = visited.size();
            if(!stack.isEmpty())
            for(Integer i:G.graph.get(stack.get(stack.size()-1))){
                if(!visited.contains(i)){
                    visited.add(i);
                    stack.add(i);
                    System.out.print(stack.get(stack.size()-1)+"---->");
                    break;
                }
            }

        }

    }

    static boolean isEdge(graphLinkedList G,int node1,int node2){  // O(1)
        // undirected
        if(G.graph.containsKey(node1)){
            return G.graph.get(node1).contains(node2);
        }else if(G.graph.containsKey(node2)){
            return G.graph.containsKey(node1);
        }
        return false;
    }

}

class Main{
    public static void main(String[] args){
        graphLinkedList graph = new graphLinkedList();
        graphLinkedList.add(graph,1,2);
        graphLinkedList.add(graph,1,3);
        graphLinkedList.add(graph,2,4);
        graphLinkedList.add(graph,2,5);
        graphLinkedList.add(graph,3,5);
        graphLinkedList.add(graph,4,5);
        graphLinkedList.add(graph,4,6);
//        graphLinkedList.add(graph,3,3);
        graphLinkedList.print(graph);
        graphLinkedList.bfs(graph,1);
        System.out.println("");
        graphLinkedList.dfs(graph,1);
        System.out.println(graphLinkedList.isEdge(graph,0,0));

    }
}