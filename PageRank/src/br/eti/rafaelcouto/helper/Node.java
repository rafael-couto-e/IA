package br.eti.rafaelcouto.helper;

import java.util.*;

public class Node {
    private String node;
    private Double rank;
    private List<Vertex> vertices;
    private int index;

    public Node(String node) {
        this.node = node;
        this.rank = 1.0;
        this.vertices = new ArrayList<>();
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Double getRank() {
        return rank;
    }

    public void setRank(Double rank) {
        this.rank = rank;
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

    public List<Node> getReferencingNeighbours() {
        return getNeighbours(0);
    }

    public List<Node> getReferencedNeighbours() {
        return getNeighbours(1);
    }

    private List<Node> getNeighbours(int iteration) {
        List<Node> neighbours = new ArrayList<>();

        for(Vertex v: this.getVertices()) {
            int iterations = 0;

            for (Node n : v.getNodes()) {
                if (!n.equals(this) && (iterations == iteration || v.isBidirectional())) {
                    neighbours.add(n);
                }

                iterations++;
            }
        }

        return neighbours;
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
        return node.toString() + " (" + rank + ")";
    }
}
