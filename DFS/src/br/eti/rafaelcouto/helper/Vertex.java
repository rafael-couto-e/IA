package br.eti.rafaelcouto.helper;

import java.util.Objects;

public class Vertex<T> {
    private Node<T> start;
    private Node<T> end;
    private Double cost;

    public Vertex(Node<T> start, Node<T> end) {
        this.start = start;
        this.end = end;
        this.cost = 0.0;
    }

    public Vertex(Node<T> start, Node<T> end, Double cost) {
        this(start, end);
        this.cost = cost;
    }

    public Node<T> getStart() {
        return start;
    }

    public void setStart(Node<T> start) {
        this.start = start;
    }

    public Node<T> getEnd() {
        return end;
    }

    public void setEnd(Node<T> end) {
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

    @Override
    public String toString() {
        return start.toString() + " -> "
                + end.toString() + " | (" + cost + ")";
    }
}
