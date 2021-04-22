package app;

import app.entity.Graph;

public class Backtracking {
    int vertexCount;
    int[] color;

    private boolean isSafe( int v, int[][] graph, int[] color, int c) {
        for (int i = 0; i <= vertexCount; i++)
            if (graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }

    private boolean graphColoringUtil( int[][] graph, int colors,  int[] color, int v) {

        if (v > vertexCount) {
//            System.out.println("little v: " + v);
//            System.out.println("bigV: " + vertexCount);
            return true;
        }

//        System.out.println("checking vertex: " + v + " with color: " + color[v]);
//        System.out.println("going to check this vertex: " + !(color[v] == -1));


        if (color[v] == -1) {
            return graphColoringUtil(graph, colors, color, v + 1);
        }

        for (int c = 1; c <= colors; c++) {

            if (isSafe(v, graph, color, c)) {
                color[v] = c;
                if (graphColoringUtil(graph, colors, color, v + 1))
                    return true;
                color[v] = 0;
            }
        }

        return false;
    }

    boolean graphColoring(Graph g, int colors) {
        this.vertexCount = g.getV();
        int[][] graph = g.getAdjMatrix();
        color = new int[vertexCount + 1];

        // making vertices that are not declared -1
        for (int i = 0; i < vertexCount; i++) {
            color[i] = -1;
            for (int j = 0; j <= vertexCount; j++) {
                if (graph[i][j] == 1) {
                    color[i] = 0;
                    break;
                }
            }
        }

        if (!graphColoringUtil(graph, colors, color, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(color);
        return true;
    }

    private void printSolution(int[] color) {
        System.out.println("Solution Exists: Following are the assigned colors");
        for (int i = 0; i <= vertexCount; i++){
            if (color[i] != -1) {
                System.out.print( i+ ": " + color[i] + "\n");
            }
        }
        System.out.println();
    }

//    private void printDemo(int[] color) {
//        for (int i = 0; i <= vertexCount; i++){
//            if (color[i] != -1) {
//                System.out.print( i+ ": " + color[i] + "\n");
//            }
//        }
//
//        System.out.println();
//    }
}