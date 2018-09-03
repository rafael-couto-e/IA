package br.eti.rafaelcouto.helper;

import java.util.*;

public class Node {
    private String node;
    private Double weight;
    private List<Vertex> vertices;

    public Node(String node) {
        this.node = node;
        this.weight = 0.0;
        this.vertices = new ArrayList<>();
    }

    public Node(String node, Double weight) {
        this(node);
        this.weight = weight;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
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
        return node.toString() + " (" + weight + ")";
    }
}
