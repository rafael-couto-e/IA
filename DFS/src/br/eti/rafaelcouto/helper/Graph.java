package br.eti.rafaelcouto.helper;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {
    private List<Node<T>> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public List<Node<T>> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node<T>> nodes) {
        this.nodes = nodes;
    }

    public boolean addNode(Node<T> node) {
        return this.nodes.add(node);
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
