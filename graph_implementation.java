import java.util.*;

public class graph_implementation {
    static class node{
        int src;
        int dest;
        node(int src,int dest){
            this.src=src;
            this.dest=dest;
        }
    }
    static class creategraph{
        ArrayList<node> graph[]=new ArrayList[5];
        creategraph(){
            for(int i=0;i<5;i++){
                graph[i]=new ArrayList<>();
            }
        }
        void addEdge(int src,int dest){
            node newnode=new node(src,dest);
            graph[src].add(newnode);
        }
        void printgraph(int n){
            for(int i=0;i<graph[n].size();i++){
                node e=graph[n].get(i);
                System.out.println(e.src+" "+e.dest);
            }
        }
        void bfs(int n){
            boolean[] visited=new boolean[5];
            Queue<Integer> queue=new LinkedList<>();
            queue.add(n);
            visited[n]=true;
            while(!queue.isEmpty()){
                int currnode=queue.remove();
                System.out.println(currnode);
                for(int i=0;i<graph[currnode].size();i++){
                    node e=graph[currnode].get(i);
                    if(!visited[e.dest]){
                        queue.add(e.dest);
                        visited[e.dest]=true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        creategraph mygraph=new creategraph();
        mygraph.addEdge(0, 1);
        mygraph.addEdge(0, 4);
        mygraph.addEdge(1, 2);
        mygraph.addEdge(1, 3);
        mygraph.addEdge(1, 4);
        mygraph.addEdge(2, 3);
        mygraph.addEdge(3, 4);
        mygraph.addEdge(4, 0);
        mygraph.addEdge(4, 1);
        mygraph.printgraph(1);
        mygraph.bfs(1);
    }
}
