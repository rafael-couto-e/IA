package br.eti.rafaelcouto.helper;

import java.util.*;

public class Node{
    private String node;
    private Integer heuristics;
    private List<Vertex> vertices;
    private Integer tracedCost;
    private Integer estimatedCost;

    public Node(String node) {
        this.node = node;
        this.heuristics = 0;
        this.tracedCost = 0;
        this.estimatedCost = 0;
        this.vertices = new ArrayList<>();
    }

    public Node(String node, Integer heuristics) {
        this(node);
        this.heuristics = heuristics;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Integer getHeuristics() {
        return heuristics;
    }

    public void setHeuristics(Integer heuristics) {
        this.heuristics = heuristics;
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

    public Integer getTracedCost() {
        return tracedCost;
    }

    public void setTracedCost(Integer tracedCost) {
        this.tracedCost = tracedCost;
    }

    public Integer getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(Integer estimatedCost) {
        this.estimatedCost = estimatedCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(this.node, node.node);
    }

    public Integer getEstimate() {
        return heuristics + tracedCost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(node);
    }

    @Override
    public String toString() {
        return node + " (" + heuristics + ")";
    }
}
