package br.eti.rafaelcouto.helper;

import java.util.*;

public class Node {
    private String node;
    private Double heuristic;
    private List<Vertex> vertices;
    private int index;

    public Node(String node) {
        this.node = node;
        this.heuristic = 0.0;
        this.vertices = new ArrayList<>();
    }

    public Node(String node, Double heuristic) {
        this(node);
        this.heuristic = heuristic;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
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

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
