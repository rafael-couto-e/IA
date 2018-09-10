package br.eti.rafaelcouto;

import br.eti.rafaelcouto.helper.Graph;
import br.eti.rafaelcouto.helper.Node;
import br.eti.rafaelcouto.helper.SearchAlgorithms;
import br.eti.rafaelcouto.helper.Vertex;

public class Main {

    public static void main(String[] args) {
        //Construindo a estrutura vista no exercício
        Node arad = new Node("Arad", 366);
        Node bucharest = new Node("Bucharest", 0);
        Node craiova = new Node("Craiova", 160);
        Node dobreta = new Node("Dobreta", 242);
        Node eforie = new Node("Eforie", 161);
        Node fagaras = new Node("Fagaras", 178);
        Node giurgiu = new Node("Giurgiu", 77);
        Node hirsova = new Node("Hirsova", 151);
        Node iasi = new Node("Iasi", 226);
        Node lugoj = new Node("Lugoj", 244);
        Node mehadia = new Node("Mehadia", 241);
        Node neamt = new Node("Neamt", 234);
        Node oradea = new Node("Oradea", 380);
        Node pitesti = new Node("Pitesti", 98);
        Node rimnicuVilcea = new Node("Rimnicu Vilcea", 193);
        Node sibiu = new Node("Sibiu", 253);
        Node timisoara = new Node("Timisoara", 329);
        Node urziceni = new Node("Urziceni", 80);
        Node vaslui = new Node("Vaslui", 199);
        Node zerind = new Node("Zerind", 374);

        Vertex v1 = new Vertex(arad, zerind, 75);
        Vertex v2 = new Vertex(zerind, oradea, 71);
        Vertex v3 = new Vertex(oradea, sibiu, 151);
        Vertex v4 = new Vertex(sibiu, fagaras, 99);
        Vertex v5 = new Vertex(fagaras, bucharest, 211);
        Vertex v6 = new Vertex(bucharest, urziceni, 85);
        Vertex v7 = new Vertex(bucharest, giurgiu, 90);
        Vertex v8 = new Vertex(urziceni, hirsova, 98);
        Vertex v9 = new Vertex(hirsova, eforie, 86);
        Vertex v10 = new Vertex(urziceni, vaslui, 142);
        Vertex v11 = new Vertex(vaslui, iasi, 92);
        Vertex v12 = new Vertex(iasi, neamt, 87);
        Vertex v13 = new Vertex(arad, sibiu, 140);
        Vertex v14 = new Vertex(sibiu, rimnicuVilcea, 80);
        Vertex v15 = new Vertex(rimnicuVilcea, pitesti, 97);
        Vertex v16 = new Vertex(pitesti, bucharest, 101);
        Vertex v17 = new Vertex(rimnicuVilcea, craiova, 146);
        Vertex v18 = new Vertex(craiova, pitesti, 138);
        Vertex v19 = new Vertex(arad, timisoara, 118);
        Vertex v20 = new Vertex(timisoara, lugoj, 111);
        Vertex v21 = new Vertex(lugoj, mehadia, 70);
        Vertex v22 = new Vertex(mehadia, dobreta, 75);
        Vertex v23 = new Vertex(dobreta, craiova, 120);

        Graph graph = new Graph();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);
        graph.addVertex(v8);
        graph.addVertex(v9);
        graph.addVertex(v10);
        graph.addVertex(v11);
        graph.addVertex(v12);
        graph.addVertex(v13);
        graph.addVertex(v14);
        graph.addVertex(v15);
        graph.addVertex(v16);
        graph.addVertex(v17);
        graph.addVertex(v18);
        graph.addVertex(v19);
        graph.addVertex(v20);
        graph.addVertex(v21);
        graph.addVertex(v22);
        graph.addVertex(v23);

        //Realizando busca por A*
        System.out.println(SearchAlgorithms.aStar(graph, "Arad", "Bucharest"));

        /*
        UCS: 418
        [Arad (366), Sibiu (253), Rimnicu Vilcea (193), Pitesti (98), Bucharest (0)]

        GREEDY: 450
        [Arad (366), Sibiu (253), Fagaras (178), Bucharest (0)]

        A*: 418
        [Arad (366), Sibiu (253), Rimnicu Vilcea (193), Pitesti (98), Bucharest (0)]
        */
    }
}
