import java.util.*;
class Main{
    static class graphLinkedList{
        Map<Integer,HashSet<Integer>> graph;
        graphLinkedList(){
            this.graph = new HashMap<>();
            this.graph.put(1,new HashSet<>());
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

        static int dfs(graphLinkedList G,int source,int[] cat,int m){
            Set<Integer> visited = new HashSet<>();
            List<Integer> stack = new ArrayList<>();
            visited.add(source);
            stack.add(source);
            int cat2[] = cat.clone();
            int prev=0;
            int path = 0;
//            System.out.print(stack.get(stack.size()-1)+"---->");
            while(stack.size()>0){
                if(prev == visited.size()){
                    if(cat2[stack.get(stack.size()-1)-1] <=m && G.graph.get(stack.get(stack.size()-1)).size()==1 && stack.get(stack.size()-1) != 1 ) path++;
//                    System.out.println(Arrays.toString(cat2));
                    stack.remove(stack.size()-1);

                }
                prev = visited.size();
                if(!stack.isEmpty())
                    for(Integer i:G.graph.get(stack.get(stack.size()-1))){
                        if(!visited.contains(i)){
                            if(cat[stack.get(stack.size()-1)-1] == 1){
                                cat2[i-1]+=cat2[stack.get(stack.size()-1)-1];
                            }
                            visited.add(i);
                            stack.add(i);
//                            System.out.print(stack.get(stack.size()-1)+"---->");
                            break;
                        }
                    }

            }
            return path;
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
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int[] Ai = new int[N];
        for(int i = 0;i<N;i++) Ai[i] = s.nextInt();
        graphLinkedList graph = new graphLinkedList();
        for(int i = 1;i<N;i++){
            graphLinkedList.add(graph,s.nextInt(),s.nextInt());
        }
//        graphLinkedList.print(graph);
        System.out.print(graphLinkedList.dfs(graph,1,Ai,M));
//        System.out.print(tree.dfs(M));
    }
}