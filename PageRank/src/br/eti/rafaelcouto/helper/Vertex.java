package br.eti.rafaelcouto.helper;

import java.util.*;

public class Vertex {
    private Collection<Node> nodes;
    private Boolean isBidirectional;

    public Vertex(Node start, Node end) {
        this.nodes = Collections.unmodifiableCollection(new ArrayList<Node>(){{
            add(start);
            add(end);
        }});

        start.addVertex(this);
        end.addVertex(this);
        this.isBidirectional = false;
    }

    public Vertex(Node start, Node end, Boolean isBidirectional) {
        this.nodes = Collections.unmodifiableCollection(new ArrayList<Node>(){{
            add(start);
            add(end);
        }});

        start.addVertex(this);
        end.addVertex(this);
        this.isBidirectional = isBidirectional;
    }

    public Collection<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Collection<Node> nodes) {
        this.nodes = nodes;
    }

    public Boolean isBidirectional() {
        return isBidirectional;
    }

    public void setBidirectional(Boolean bidirectional) {
        isBidirectional = bidirectional;
    }

    @Override
    public String toString() {
        return nodes.toString();
    }
}
