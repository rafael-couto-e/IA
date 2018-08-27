package br.eti.rafaelcouto;

import br.eti.rafaelcouto.helper.Graph;
import br.eti.rafaelcouto.helper.Node;
import br.eti.rafaelcouto.helper.Vertex;

public class Main {

    public static void main(String[] args) {
        Node a = new Node("A", 5.0);
        Node b = new Node("B", 6.0);
        Node c = new Node("C", 4.0);

        Vertex v1 = new Vertex(a, b);
        Vertex v2 = new Vertex(b, c);
        a.addVertex(v1);
        b.addVertex(v1);
        b.addVertex(v2);
        c.addVertex(v2);

        Graph g = new Graph();
        g.addNode(a);
        g.addNode(b);
        g.addNode(c);
    }
}
