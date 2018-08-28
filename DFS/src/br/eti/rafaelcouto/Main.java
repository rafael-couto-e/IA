package br.eti.rafaelcouto;

import br.eti.rafaelcouto.helper.Graph;
import br.eti.rafaelcouto.helper.Node;
import br.eti.rafaelcouto.helper.SearchAlgorithms;
import br.eti.rafaelcouto.helper.Vertex;

public class Main {

    public static void main(String[] args) {
        //Construindo a estrutura vista no exercício
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");

        new Vertex(a, d, 2.0);
        new Vertex(a, b, 3.0);
        new Vertex(a, c, 5.0);
        new Vertex(a, h, 10.0);

        new Vertex(b, e, 4.0);
        new Vertex(b, c, 5.0);
        new Vertex(b, g, 6.0);
        new Vertex(b, h, 6.0);
        new Vertex(b, d, 8.0);

        new Vertex(c, e, 1.0);
        new Vertex(c, f, 7.0);
        new Vertex(c, g, 9.0);

        new Vertex(d, e, 12.0);
        new Vertex(d, h, 14.0);

        new Vertex(e, g, 15.0);

        new Vertex(f, h, 9.0);

        new Vertex(g, h, 3.0);

        Graph graph = new Graph();
        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);
        graph.addNode(g);
        graph.addNode(h);

        //Defina as iterações do LDFS
        int n = 2;

        System.out.println("Optimized path for DFS: " + SearchAlgorithms.dfs(graph, 0, 4));
        //Esse possui resultados diferentes para n = 2 e n >= 3, devido à profundidade e à estrutura do grafo
        System.out.println(
                "Optimized path for LDFS with "+n+" iterations: " + SearchAlgorithms.ldfs(graph, 0, 4, n)
        );
        System.out.println("Optimized path for IDDFS: " + SearchAlgorithms.iddfs(graph, 0, 4));
        System.out.println("Optimized path for BFS: " + SearchAlgorithms.bfs(graph, 0, 4));
    }
}
