package br.eti.rafaelcouto.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node<T> {
    private T node;
    private Double heuristic;
    private List<Vertex> vertices;

    public Node(T node, Double heuristic) {
        this.node = node;
        this.heuristic = heuristic;
        this.vertices = new ArrayList<>();
    }

    public T getNode() {
        return node;
    }

    public void setNode(T node) {
        this.node = node;
    }

    public Double getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(Double heuristic) {
        this.heuristic = heuristic;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public boolean addVertex(Vertex vertex) {
        return this.vertices.add(vertex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(this.node, node.node);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }

    @Override
    public String toString() {
        return node.toString() + " (" + heuristic + ")";
    }
}
