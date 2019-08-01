import java.util.*;


class Main{
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



        static int dfsMax(graphLinkedList G,int source){
            if(G.graph.get(source).size() == 0) return 1;
            Set<Integer> visited = new HashSet<>();
            List<Integer> stack = new ArrayList<>();
            visited.add(source);
            stack.add(source);
            int prev=0;
//        System.out.print(stack.get(stack.size()-1)+"---->");
            int max = 0;
            while(stack.size()>0){
                if(stack.size() > max) max = stack.size();
                if(prev == visited.size()) stack.remove(stack.size()-1);
                prev = visited.size();
                if(!stack.isEmpty())
                    for(Integer i:G.graph.get(stack.get(stack.size()-1))){
                        if(!visited.contains(i)){
                            visited.add(i);
                            stack.add(i);
//                        System.out.print(stack.get(stack.size()-1)+"---->");
                            break;
                        }
                    }

            }
            return max;

        }


    }

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] P = new int[N];
        graphLinkedList graph = new graphLinkedList();
        List<Integer> PM = new LinkedList<>();
//        int val;
        for(int i = 0;i<N;i++){ // O(N)
            P[i] = s.nextInt();
            if(P[i] == -1) PM.add(i);
        }
        for(int i = 0;i<N;i++){
            if(P[i]!=-1) {
                graphLinkedList.add(graph, i + 1, P[i]);
            } else{
                graph.graph.putIfAbsent(i+1,new HashSet<>());
            }
        }
//        graphLinkedList.dfs(graph,1);
//        graphLinkedList.print(graph);
        int max = 0;
        for(int i = 0;i<PM.size();i++){
            int curr = graphLinkedList.dfsMax(graph,PM.get(i)+1);
            if(curr > max) max = curr;
        }
        System.out.println(max);



    }
}