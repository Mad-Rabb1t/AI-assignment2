package io;

import app.entity.Data;
import app.entity.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Input {

    public static int getVertexCount(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        int maxNum = 0;
        while (sc.hasNextLine()) {
            String trimmed = sc.nextLine().trim();
            if (!trimmed.isEmpty() && !trimmed.contains("#") && !trimmed.contains("colors")) {
                    String[] split = trimmed.split(",");
                    maxNum = Math.max(maxNum, Math.max(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim())));
            }
        }
        return maxNum;
    }

    public static Data getData(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        int colors = 1;
        Graph graph = new Graph(getVertexCount(file));
        while (sc.hasNextLine()) {
            String trimmed = sc.nextLine().trim();
            if (!trimmed.isEmpty() && !trimmed.contains("#")) {
                if (trimmed.contains("colors")) {
                     colors = Integer.parseInt(trimmed.split("=")[1].trim());
                } else {
                    String[] split = trimmed.split(",");
                    graph.addEdge(Integer.parseInt(split[0].trim()), Integer.parseInt(split[1].trim()));
                }
            }
        }
        return new Data(graph, colors);
    }
}
