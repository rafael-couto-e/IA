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
        node.setIndex(nodes.size());
        return this.nodes.add(node);
    }

    public Node get(int index) {
        return nodes.get(index);
    }

    public int size() {
        return this.nodes.size();
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
