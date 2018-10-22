package br.eti.rafaelcouto;

import br.eti.rafaelcouto.ai.KMeans;
import br.eti.rafaelcouto.model.Cluster;
import br.eti.rafaelcouto.model.Iris;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Iris iris1 = new Iris(5.9, 3.0, 5.1, 1.8, "1");
        Iris iris2 = new Iris(5.7, 2.8, 4.1, 1.3, "2");
        Iris iris3 = new Iris(5.0, 3.3, 1.4, 0.2, "3");
        Iris iris4 = new Iris(6.2, 3.4, 5.4, 2.3, "4");
        Iris iris5 = new Iris(5.1, 2.5, 3.0, 1.1, "5");

        Cluster<Iris> first = new Cluster<>(new Iris(5.0, 2.0, 5.0, 1.0));
        Cluster<Iris> second = new Cluster<>(new Iris(6.0, 4.0, 0.0, 3.0));
        Cluster<Iris> third = new Cluster<>(new Iris(5.0, 3.0, 6.0, 3.0));

        List<Iris> elements = new ArrayList<Iris>(){{
            add(iris1);
            add(iris2);
            add(iris3);
            add(iris4);
            add(iris5);
        }};

        List<Cluster<Iris>> clusters = new ArrayList<Cluster<Iris>>(){{
            add(first);
            add(second);
            add(third);
        }};

        /*KMeans.init(elements, 3);

        for (Iris i: elements) {
            System.out.println("Cluster for "+i.getName()+": "+i.getCluster());
        }*/

        KMeans.init(elements, clusters);

        int i = 1;

        for (Cluster<Iris> c: clusters) {
            System.out.print("Média "+i+": [");
            for(double d: c.getInitial().getAverages()) {
                System.out.print(d+", ");
            }
            System.out.println("]");
            System.out.println("Elementos "+i+": "+c.getElements());
            i++;
        }
    }
}
