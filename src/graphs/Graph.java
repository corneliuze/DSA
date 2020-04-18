package graphs;

/**
 * 18th April, 2020.
 * Basic implementation of a graph class from scratch
 * PS : adjacency matrix
 */

public class Graph {
    private int numberOfNodes;
    private boolean isDirected;
    private boolean isWeighted;
    private float[][] matrix;

    /**
     * This allows us know the edges that exist which makes it safe to add weights when needed
     */

    private boolean[][] isSetMatrix;

    public Graph(int numberOfNodes, boolean isDirected, boolean isWeighted) {
        this.numberOfNodes = numberOfNodes;
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;

        matrix = new float[numberOfNodes][numberOfNodes];
        isSetMatrix = new boolean[numberOfNodes][numberOfNodes];
    }

    public void addEdge(int source, int destination) {
        int weightedValueToAdd = 1;

        if (isWeighted) weightedValueToAdd = 0;

        matrix[source][destination] = weightedValueToAdd;
        isSetMatrix[source][destination] = true;

        if (!isDirected) {
            matrix[destination][source] = weightedValueToAdd;
            isSetMatrix[destination][source] = true;
        }
    }


    //has edge if weighted

    public void addEdge(int source, int destination, float weight) {
        float weightedValueToAdd = weight;

        if (!isWeighted) weightedValueToAdd = 1;

        matrix[source][destination] = weightedValueToAdd;
        isSetMatrix[source][destination] = true;

        if (!isDirected) {
            matrix[destination][source] = weightedValueToAdd;
            isSetMatrix[destination][source] = true;
        }
    }

    //print Matrix
    public void printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (isSetMatrix[i][j]) {
                    System.out.format(" %s", matrix[i][j]);
                } else {
                    System.out.format("%s", "/    ");
                }
            }
            System.out.println();
        }
    }

    //print edges
    public void printEdges() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(" Node " + i);
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(" is connected to " + j);
            }
        }
        System.out.println();
    }

    //has edge
    public boolean hasEdges(int source, int destination) {
        return isSetMatrix[source][destination];
    }

    //get edge value
    public Float getEdgeValue(int source, int destination) {
        if (!isWeighted || !isSetMatrix[source][destination]) {
            return null;
        }
        return matrix[source][destination];
    }


}



