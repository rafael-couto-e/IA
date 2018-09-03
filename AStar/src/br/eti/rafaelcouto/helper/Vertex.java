package br.eti.rafaelcouto.helper;

import java.util.*;

public class Vertex {
    private Collection<Node> nodes;
    private Integer cost;
    private int index;

    public Vertex(Node start, Node end) {
        this.cost = 0;

        this.nodes = Collections.unmodifiableCollection(new ArrayList<Node>(){{
            add(start);
            add(end);
        }});

        start.addVertex(this);
        end.addVertex(this);
    }

    public Vertex(Node start, Node end, Integer cost) {
        this(start, end);
        this.cost = cost;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
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
