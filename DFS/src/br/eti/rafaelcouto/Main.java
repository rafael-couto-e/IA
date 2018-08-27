package br.eti.rafaelcouto;

import br.eti.rafaelcouto.helper.Graph;
import br.eti.rafaelcouto.helper.Node;
import br.eti.rafaelcouto.helper.Vertex;

public class Main {

    public static void main(String[] args) {
        Node<String> a = new Node<>("A", 5.0);
        Node<String> b = new Node<>("B", 6.0);
        Node<String> c = new Node<>("C", 4.0);

        Vertex<String> v1 = new Vertex<>(a, b);
        Vertex<String> v2 = new Vertex<>(b, c);
        a.addVertex(v1);
        b.addVertex(v1);
        b.addVertex(v2);
        c.addVertex(v2);

        Graph<String> g = new Graph<>();
        g.addNode(a);
        g.addNode(b);
        g.addNode(c);
    }
}
