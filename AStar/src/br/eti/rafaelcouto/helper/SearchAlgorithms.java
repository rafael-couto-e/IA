package br.eti.rafaelcouto.helper;

import java.util.*;

public class SearchAlgorithms {
    private static List<String> visited = new ArrayList<>();

    public static List<Node> ucs(Graph g, String s, String f) {
        g.get(s).setTracedCost(0);//marque s com custo 0
        PriorityQueue<Node> F = new PriorityQueue<>(
                (o1, o2) -> o1.getTracedCost() > o2.getTracedCost() ? 1 :
                o1.getTracedCost().equals(o2.getTracedCost()) ? 0 : -1
        );

        F.add(g.get(s));//insira s em F (F é uma fila de prioridade)

        return process(g, s, f, F);
    }

    public static List<Node> greedy(Graph g, String s, String f) {
        g.get(s).setTracedCost(0);//marque s com custo 0
        PriorityQueue<Node> F = new PriorityQueue<>(
                (o1, o2) -> o1.getHeuristics() > o2.getHeuristics() ? 1 :
                        o1.getHeuristics().equals(o2.getHeuristics()) ? 0 : -1
        );

        F.add(g.get(s));//insira s em F (F é uma fila de prioridade)

        return process(g, s, f, F);
    }

    public static List<Node> aStar(Graph g, String s, String f) {
        g.get(s).setTracedCost(0);//marque s com custo 0
        PriorityQueue<Node> F = new PriorityQueue<>(
                (o1, o2) -> o1.getEstimate() > o2.getEstimate() ? 1 :
                        o1.getEstimate().equals(o2.getEstimate()) ? 0 : -1
        );

        F.add(g.get(s));//insira s em F (F é uma fila de prioridade)

        return process(g, s, f, F);
    }

    private static List<Node> process(Graph g, String s, String f, PriorityQueue<Node> F) {
        Map<String, Node> origem = new HashMap<>();//origem = []

        while(!F.isEmpty() && !F.peek().equals(g.get(f))) {//enquanto F não está vazia e não contém f no início da fila faça
            Node v = F.poll();//seja v o primeiro vértice de F; retira v de F
            visited.add(v.getNode());

            for(Vertex vertex: v.getVertices()) {//para cada vizinho de v faça
                Node[] neighbours = new Node[2];
                vertex.getNodes().toArray(neighbours);
                Node neighbour = neighbours[0];

                if (neighbours[0].equals(v)) {
                    neighbour = neighbours[1];
                }

                Integer cost = vertex.getCost();

                //se custo até vizinho vindo por v < custo marcado no vizinho então
                if (!visited.contains(neighbour.getNode()) && !F.contains(neighbour)) {
                    origem.put(neighbour.getNode(), v);
                    neighbour.setTracedCost(cost+v.getTracedCost());
                    F.add(neighbour);
                }else if(F.contains(neighbour) && neighbour.getTracedCost() > v.getTracedCost()+cost) {
                    origem.remove(neighbour.getNode());
                    origem.put(neighbour.getNode(), v);
                    neighbour.setTracedCost(cost+v.getTracedCost());
                    F.remove(neighbour);
                    F.add(neighbour);
                }
            }
        }

        System.out.println(F.peek().getTracedCost());

        return build(g, s, f, F, origem);
    }

    private static List<Node> build(Graph g, String s, String f, PriorityQueue<Node> F, Map<String, Node> origem) {
        List<Node> caminho = new ArrayList<>();//caminho = []

        if (F.contains(g.get(f))) {//se fila contém f
            caminho.add(g.get(f));//caminho = [f]
            Node v = g.get(f);//v = f

            while(v != g.get(s)) {//enquanto v != s
                v = origem.get(v.getNode());//v = origem[v]
                caminho.add(0, v);//caminho = [v caminho]
            }
        }

        return caminho;
    }
}
