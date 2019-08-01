import java.util.*; // *****
class Main{
    public static void main(String[] args){  // N+
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        graphLinkedList graph = new graphLinkedList();
        int b1 = s.nextInt();
        int b2 = s.nextInt();
        graphLinkedList.add(graph,b1,b2);
        for(int i = 1;i<N-1;i++)  // O(N)
            graphLinkedList.add(graph, s.nextInt(), s.nextInt());
        System.out.println(graphLinkedList.dfsProduct(graph,b2)-N+1); //O(V+E)
        graphLinkedList.print(graph);
    }
    static class graphLinkedList{
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

        static int dfsProduct(graphLinkedList G,int source){
            Set<Integer> visited = new HashSet<>();
            List<Integer> stack = new ArrayList<>();
            visited.add(source);
            stack.add(source);
            int prev=0;
            Set<Integer> b1 = new HashSet<>();
            Set<Integer> b2 = new HashSet<>();
            b1.add(source);
            boolean flag = true;
//            System.out.print(stack.get(stack.size()-1)+"---->");
            while(stack.size()>0){
                if(prev == visited.size()){
                    stack.remove(stack.size()-1);
                    if(flag){
                        b2.add(stack.size()-1);
                        flag=!flag;
                    }else{
                        b1.add(i);
                        flag=!flag;
                    }

                }
                prev = visited.size();
                if(!stack.isEmpty())
                    for(Integer i:G.graph.get(stack.get(stack.size()-1))){
                        if(!visited.contains(i)){
                            visited.add(i);
                            stack.add(i);

//                            System.out.print(stack.get(stack.size()-1)+"---->");
                            break;
                        }
                    }

            }
            System.out.println(b1+" "+b2);
            return b1.size()*b2.size();

        }
//        static dfsRecursive(graphLinkedList G,)
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
}