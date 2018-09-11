package br.eti.rafaelcouto;

import br.eti.rafaelcouto.helper.Graph;
import br.eti.rafaelcouto.helper.Node;
import br.eti.rafaelcouto.helper.Vertex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");

        new Vertex(n1, n2);
        new Vertex(n1, n3);
        new Vertex(n1, n4);
        new Vertex(n1, n5);

        new Vertex(n3, n2);
        new Vertex(n3, n4);

        new Vertex(n4, n2);

        new Vertex(n5, n4);

        Graph g = new Graph();
        g.addNode(n1);
        g.addNode(n2);
        g.addNode(n3);
        g.addNode(n4);
        g.addNode(n5);

        pageRank(g, 100, 0.85);

        for(Node n: g.getNodes()) {
            System.out.println(String.format("PageRank for %s: %.3f", n.getNode(), n.getRank()));
        }

        System.out.println("\n********************\n");

        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");

        new Vertex(a, b);
        new Vertex(a, c);

        new Vertex(b, c);

        new Vertex(c, a);

        new Vertex(d, c);

        Graph g1 = new Graph();
        g1.addNode(a);
        g1.addNode(b);
        g1.addNode(c);
        g1.addNode(d);

        pageRank(g1, 100, 0.85);

        for(Node n: g1.getNodes()) {
            System.out.println(String.format("PageRank for %s: %.3f", n.getNode(), n.getRank()));
        }
    }

    public static void pageRank(Graph g, int k, double d) {
        if (k == 0) return;

        List<Node> nodes = g.getNodes();
        Map<Node, Double> ranks = new HashMap<>();

        for(Node n: nodes) {
            ranks.put(n, 0.0);

            List<Node> neighbours = n.getReferencingNeighbours();

            for(Node n1: neighbours) {
                List<Node> neighbours1 = n1.getReferencedNeighbours();
                double rank = neighbours1.size() == 0 ? 0 : n1.getRank() / neighbours1.size();
                ranks.put(n, ranks.get(n)+rank);
            }

            n.setRank(ranks.get(n)*d+(1-d));
        }

        pageRank(g, k-1, d);
    }
}
