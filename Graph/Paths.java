

import se.kth.id1020.*;


public class Paths {
    
    public static int search(Graph g, String first){
        int counter = 0;        
        for (int i = 0; i <g.numberOfVertices(); i++){
            String string = g.vertex(i).label;
            if (string.equals(first)){
                counter = i;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Graph g = DataSource.load();
         // work on g
        DepthFirstSearch search = new DepthFirstSearch(g);
        
        search.printResults(g);
        
        System.out.println(g.vertex(1).label);
        
        System.out.println(g.vertex(0).distance(g.vertex(500)) + "\n");
        
        
        int s = search(g, "Renyn");
        int v = search(g, "Parses");
        System.out.println("The strings have value: " + search(g, "Renyn") + ", " + search(g, "Parses"));
        System.out.println("Number of components when not taking edge weights into account: ");
        
        
        ShortestPath bfs = new ShortestPath(g, s);
        bfs.printResults(g, s, v);
        
        System.out.println("");
        
        ShortestEdgePath djk = new ShortestEdgePath(g, s);
        djk.printResults(g, s, v);
        
    }

}








