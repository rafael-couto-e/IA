package br.eti.rafaelcouto.helper;

import java.util.Objects;

public class Vertex {
    private Node start;
    private Node end;
    private Double cost;

    public Vertex(Node start, Node end) {
        this.start = start;
        this.end = end;
    }

    public Vertex(Node start, Node end, Double cost) {
        this(start, end);
        this.cost = cost;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getEnd() {
        return end;
    }

    public void setEnd(Node end) {
        this.end = end;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(start, vertex.start) &&
                Objects.equals(end, vertex.end);
    }

    @Override
    public int hashCode() {

        return Objects.hash(start, end);
    }
}
