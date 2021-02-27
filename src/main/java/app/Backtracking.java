package app;

import app.entity.Graph;

public class Backtracking {
    int V;
    int[] color;

    private boolean isSafe(
            int v, int[][] graph, int[] color,
            int c) {
        for (int i = 0; i < V; i++)
            if (
                    graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }

    private boolean graphColoringUtil(
            int[][] graph, int m,
            int[] color, int v) {

        if (v == V)
            return true;


        for (int c = 1; c <= m; c++) {

            if (isSafe(v, graph, color, c)) {
                color[v] = c;

                if (
                        graphColoringUtil(
                                graph, m,
                                color, v + 1))
                    return true;

                color[v] = 0;
            }
        }

        return false;
    }

    boolean graphColoring(Graph g, int m) {
        this.V = g.getV();
        int[][] graph = g.getAdjMatrix();
        color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;

        if (
                !graphColoringUtil(
                        graph, m, color, 0)) {
            System.out.println(
                    "Solution does not exist");
            return false;
        }

        printSolution(color);
        return true;
    }

    private void printSolution(int[] color) {
        System.out.println(
                "Solution Exists: Following"
                        + " are the assigned colors");
        for (int i = 0; i < V; i++)
            System.out.print(" " + color[i] + " ");
        System.out.println();
    }
}