package br.eti.rafaelcouto.helper;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public boolean addNode(Node node) {
        return this.nodes.add(node);
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
