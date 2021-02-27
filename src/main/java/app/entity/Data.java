package app.entity;

public class Data {
    Graph graph;
    int colors;

    public Data(Graph graph, int colors) {
        this.graph = graph;
        this.colors = colors;
    }

    public Graph getGraph() {
        return graph;
    }

    public int getColors() {
        return colors;
    }
}
