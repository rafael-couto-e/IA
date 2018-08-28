package br.eti.rafaelcouto.helper;

import java.util.*;

public class Vertex {
    private Collection<Node> nodes;
    private Double cost;

    public Vertex(Node start, Node end) {
        this.cost = 0.0;

        this.nodes = Collections.unmodifiableCollection(new ArrayList<Node>(){{
            add(start);
            add(end);
        }});

        start.addVertex(this);
        end.addVertex(this);
    }

    public Vertex(Node start, Node end, Double cost) {
        this(start, end);
        this.cost = cost;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Collection<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Collection<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
