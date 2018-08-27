package br.eti.rafaelcouto.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
    private String name;
    private Double heuristic;
    private List<Vertex> vertices;

    public Node(String name, Double heuristic) {
        this.name = name;
        this.heuristic = heuristic;
        this.vertices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
