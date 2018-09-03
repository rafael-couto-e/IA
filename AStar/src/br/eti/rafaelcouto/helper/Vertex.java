package br.eti.rafaelcouto.helper;

import java.util.*;

public class Vertex {
    private Collection<Node> nodes;
    private Double heuristic;
    private int index;

    public Vertex(Node start, Node end) {
        this.heuristic = 0.0;

        this.nodes = Collections.unmodifiableCollection(new ArrayList<Node>(){{
            add(start);
            add(end);
        }});

        start.addVertex(this);
        end.addVertex(this);
    }

    public Vertex(Node start, Node end, Double heuristic) {
        this(start, end);
        this.heuristic = heuristic;
    }

    public Double getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(Double heuristic) {
        this.heuristic = heuristic;
    }

    public Collection<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Collection<Node> nodes) {
        this.nodes = nodes;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
