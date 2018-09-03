package br.eti.rafaelcouto.helper;

import java.util.*;

public class SearchAlgorithms {
    private static List<String> visited = new ArrayList<>();

    /*public static List<Node> dfs(Graph g, int v, int f) {
        List<Node> path = new ArrayList<>();

        if (v == f) {
            return new ArrayList<Node>(){{
                add(g.get(f));
            }};
        }

        visited.add(g.get(v).getNode());

        System.out.println("Diving into "+g.get(v).getNode()+"...");

        for(Node n: getAlphabeticNeighbours(g.get(v))) {
            if (!visited.contains(n.getNode())) {
                System.out.println(g.get(v).getNode()+"'s child: "+n.getNode()+"...");
                path = dfs(g, n.getIndex(), f);
            }

            if (path.contains(g.get(f))) {
                path.add(0, g.get(v));
                visited.clear();
                return path;
            }
        }

        visited.clear();
        return new ArrayList<>();
    }

    public static List<Node> ldfs(Graph g, int v, int f, int l) {
        List<Node> path = new ArrayList<>();

        if (l == 0) {
            visited.clear();
            return new ArrayList<>();
        }

        if (v == f) {
            visited.clear();
            return new ArrayList<Node>(){{
                add(g.get(f));
            }};
        }

        visited.add(g.get(v).getNode());

        System.out.println("Diving into "+g.get(v).getNode()+"...");

        for(Node n: getAlphabeticNeighbours(g.get(v))) {
            if (!visited.contains(n.getNode())) {
                System.out.println(g.get(v).getNode()+"'s child: "+n.getNode()+"...");

                if (n.getIndex() == f) {
                    path.add(g.get(v));
                    path.add(n);
                    visited.clear();
                    return path;
                }

                path = ldfs(g, n.getIndex(), f, l-1);

                if (path.contains(g.get(f))) {
                    path.add(0, g.get(v));
                    visited.clear();
                    return path;
                }
            }
        }

        visited.clear();
        return new ArrayList<>();
    }

    public static List<Node> iddfs(Graph g, int v, int f) {
        List<Node> path = new ArrayList<>();

        int l = 1;

        while (!path.contains(g.get(f))) {
            visited.clear();
            System.out.println("\nIDDFS where L = "+l);

            path = ldfs(g, v, f, l);
            l+=1;
        }

        visited.clear();
        return path;
    }

    public static List<Node> bfs(Graph g, int s, int f) {
        LinkedList<Node> F = new LinkedList<>();

        visited.add(g.get(s).getNode());
        F.add(g.get(s));
        int[] origin = new int[g.size()];

        while(!F.isEmpty() && !F.contains(g.get(f))) {
            Node v = F.getFirst();
            System.out.println("Diving into "+v.getNode()+"...");

            for (Node n: getAlphabeticNeighbours(v)) {
                if(!visited.contains(n.getNode())) {
                    System.out.println(v.getNode()+"'s child: "+n.getNode()+"...");

                    visited.add(n.getNode());
                    F.add(n);
                    origin[n.getIndex()] = v.getIndex();
                }
            }

            F.remove(v);
        }

        List<Node> path = new ArrayList<>();

        if (F.contains(g.get(f))) {
            path.add(g.get(f));

            int v = f;

            while (v != s) {
                v = origin[v];
                path.add(0, g.get(v));
            }
        }

        visited.clear();
        return path;
    }

    private static List<Node> getAlphabeticNeighbours(Node node) {
        Set<Node> nodes = new HashSet<>();

        for(Vertex v: node.getVertices())
            nodes.addAll(v.getNodes());

        List<Node> nodesList = new ArrayList<>(nodes);

        nodesList.sort(Comparator.comparing(Node::getNode));

        return nodesList;
    }*/

    public static List<Node> aStar(Graph g, int s, int f) {
        /*
        marque s com custo 0

        insira s em F (F é uma fila de prioridade)
        origem = []

        enquanto F não está vazia e não contém f no início da fila faça
            seja v o primeiro vértice de F
            para cada vizinho de v faça
                se custo até vizinho vindo por v < custo marcado no vizinho então
                    marque vizinho com custo vindo por v

                    insira vizinho em F
                    origem[vizinho] = v
                fim se
            fim para
            retira v de F
        fim enquanto

        caminho = []

        se fila contém f
            caminho = [f]
            v = f
            enquanto v != s
                v = origem[v]
                caminho = [v caminho]
            fim enquanto
        fim se

        retorne caminho
        */

        return null;
    }
}
