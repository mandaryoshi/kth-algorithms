

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import se.kth.id1020.*;


public class ShortestPath {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  // marked[v] = is there an s-v path
    private int[] edgeTo;      // edgeTo[v] = previous edge on shortest s-v path
    private int[] distTo;      // distTo[v] = number of edges shortest s-v path

    public ShortestPath(Graph g, int s) {
        marked = new boolean[g.numberOfVertices()];
        distTo = new int[g.numberOfVertices()];
        edgeTo = new int[g.numberOfVertices()];
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int v = 0; v < g.numberOfVertices(); v++)
            distTo[v] = INFINITY;
        
        distTo[s] = 0;
        marked[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int v = q.remove();
            for (Edge w : g.adj(v)) {
                if (!marked[w.to]) {
                    //edgeTo[w.to] = v;
                    distTo[w.to] = distTo[v] + 1;
                    marked[w.to] = true;
                    q.add(w.to);
                }
            }
        }        
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public int distTo(int v) {
        return distTo[v];
    }

    /*public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }*/
    
    public void printResults(Graph g, int s, int t){
        /*for (int v = 0; v < g.numberOfVertices(); v++) {
            if (hasPathTo(v)) {
                System.out.printf("%d to %d (%d):  ", s, v, distTo(v));
                for (int x : pathTo(v)) {
                    if (x == s) System.out.print(x);
                    else        System.out.print("-" + x);
                }
                System.out.println();
            }

            else {
                System.out.printf("%d to %d (-):  not connected\n", s, v);
            }
        }*/
        if (hasPathTo(t)) {
                System.out.printf("%d to %d (%d)  ", s, t, distTo(t));
                System.out.println("");
        }
    }    

}
