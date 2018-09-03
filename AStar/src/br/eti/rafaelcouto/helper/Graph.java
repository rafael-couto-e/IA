package br.eti.rafaelcouto.helper;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<Vertex> vertices;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public boolean addVertex(Vertex vertex) {
        vertex.setIndex(vertices.size());
        return this.vertices.add(vertex);
    }

    public Vertex get(int index) {
        return vertices.get(index);
    }

    public int size() {
        return this.vertices.size();
    }

    @Override
    public String toString() {
        return vertices.toString();
    }
}
