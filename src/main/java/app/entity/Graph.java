package app.entity;

import java.util.Arrays;

public class Graph {
    private int v; // number of vertices in Graph
    private int e; // number of edges in Graph
    private int[][] adjMatrix;

    public Graph(int nodes) {
        this.v = nodes;
        this.e = 0;
        this.adjMatrix = new int[nodes+1][nodes+1];
    }

    public void addEdge(int u, int v) {

        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1; // because it is an undirected graph
        e++;

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(v + " vertices, " + e + " edges " + "\n");
        for (int v = 0; v < this.v; v++) {
            sb.append(v + ": ");
            for (int w : adjMatrix[v]) {
                sb.append(w + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public int getV() {
        return v;
    }

    public int getE() {
        return e;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }
}
