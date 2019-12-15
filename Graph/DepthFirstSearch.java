
import se.kth.id1020.*;


public class DepthFirstSearch {

    private boolean [] marked;
    private int counter;
    
    public DepthFirstSearch(Graph graph){
        marked = new boolean[graph.numberOfVertices()];
        int counter = 0;
        
        for (int i = 0; i < graph.numberOfVertices(); i++) {
            if (marked[i] == false) {
                dfs(graph, i);
                this.counter++;
            }
        }
    }
    
    private void dfs(Graph graph, int v){
        marked[v] = true;
        for (Edge w : graph.adj(v)) {
            if (!marked[w.to]) {
                dfs(graph, w.to);
            }
        }
    }
    
    public boolean marked(int v) {
        return marked[v];
    }

    
    public int returnCount() {
        return counter;
    }
    
    public void printResults(Graph g){
        /*for (int v = 0; v < g.numberOfVertices(); v++) {
            if (marked(v))
                System.out.println(v + " ");
        }*/
        
        System.out.println("\n" + "The graph consists of: " + returnCount() + " subgraphs." + "\n");
        
        if (returnCount() != 1) 
            System.out.println("\"NOT connected\"");
        else                         
            System.out.println("connected");
    }

}
