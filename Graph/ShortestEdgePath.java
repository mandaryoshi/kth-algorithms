
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import se.kth.id1020.*;


public class ShortestEdgePath {
    
    private double[] distTo;          // distTo[v] = distance  of shortest s->v path
    private Edge[] edgeTo;            // edgeTo[v] = last edge on shortest s->v path
    private int counter;

    public ShortestEdgePath(Graph G, int s) {

        distTo = new double[G.numberOfVertices()];
        edgeTo = new Edge[G.numberOfVertices()];

        for (int v = 0; v < G.numberOfVertices(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        
        distTo[s] = 0.0;

        Queue<Integer> q = new LinkedList<>();
        
        q.add(s);
        while (!q.isEmpty()) {
            double v = q.remove();
            for (Edge e : G.adj((int) v))
                if (distTo[e.to] > distTo[e.from] + e.weight) {
                distTo[e.to] = distTo[e.from] + e.weight;
                edgeTo[e.to] = e;
                if (q.contains(e.to)) q.remove(e.to);           
                else                q.add(e.to);
                
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

     public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<Edge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Edge> path = new Stack<>();
        for (Edge e = edgeTo[v]; e != null; e = edgeTo[e.from]) {
            path.push(e);
        }
        return path;
    }

    public void printResults(Graph g, int s, int t){

            if (hasPathTo(t)) {
                System.out.printf("%d to %d (%.2f)  ", s, t, distTo(t));
                for (Edge e : pathTo(t)) {
                    System.out.print(e + "   ");
                    this.counter++;
                }
                System.out.println();
            }
            else {
                System.out.printf("%d to %d         no path\n", s, t);
            }
        System.out.println("Number of components when taking edge weights into account: " + this.counter);
    }
 
}
