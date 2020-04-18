package graphs;

public class Main {

    public static void main(String[] args){
        Graph graph = new Graph(5, false, true);
        graph.addEdge(0, 2, 19);
        graph.addEdge(0, 3, -2);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);


        graph.printMatrix();


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        graph.printEdges();



        System.out.println();
        System.out.println("Does an edge from 1 to 0 exist?");
        if (graph.hasEdges(0,1)) {
            System.out.println("Yes");
        }
        else System.out.println("No");


/**
 * --------------------Adjacency list-------------------------------/
 */

        Graphs graphs = new Graphs(true);
        Node a = new Node(0, "A");
        Node b = new Node(1, "B");
        Node c = new Node(2, "C");
        Node d = new Node(3, "D");
        Node e = new Node(4, "E");

        graphs.addEdge(a,b);
        graphs.addEdge(b,c);
        graphs.addEdge(b,d);
        graphs.addEdge(c,e);
        graphs.addEdge(b,a);
        graphs.addEdge(d,e);
        graphs.addEdge(e,a);

        graphs.printEdgess();

//        System.out.println(graphs.hasEdge(a,b));
//        System.out.println(graphs.hasEdge(d,a));
    }


}
