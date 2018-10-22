package br.eti.rafaelcouto.ai;

import br.eti.rafaelcouto.model.Cluster;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KMeans {
    public static <T extends BaseKMeans> void init(List<T> elements, List<Cluster<T>> clusters) {
        init(elements, clusters, 1);
    }

    public static <T extends BaseKMeans> void init(List<T> elements, List<Cluster<T>> clusters, int runs) {
        for(int i = runs; i >= 0; i--) {
            for(T element: elements) {
                findNearestCluster(element, clusters);
            }

            updateClusters(clusters, i);
        }
    }

    public static <T extends BaseKMeans> void init(List<T> elements, int k, int runs) {
        init(elements, randomClusters(elements, k), runs);
    }

    public static <T extends BaseKMeans> void init(List<T> elements, int k) {
        init(elements, k, 1);
    }

    private static <T extends BaseKMeans> void findNearestCluster(T element, List<Cluster<T>> clusters) {
        for(Cluster<T> c: clusters) {
            if (element.getCluster() == null) {
                element.setCluster(c);
                c.addElement(element);
                continue;
            }

            if (c.getInitial().calculateVariance(element) < element.calculateCurrentVariance()) {
                element.getCluster().removeElement(element);
                element.setCluster(c);
                c.addElement(element);
            }
        }
    }

    private static <T extends BaseKMeans> void updateClusters(List<Cluster<T>> clusters, int times) {
        for (Cluster<T> c : clusters) {
            double[] averages = null;

            for (T element : c.getElements()) {
                if (averages == null) {
                    averages = element.getAverages();
                    continue;
                }

                for (int i = 0; i < element.getAverages().length; i++) {
                    averages[i] += element.getAverages()[i];
                }
            }

            for (int i = 0; i < averages.length; i++) {
                averages[i] /= c.getElements().size();
            }

            c.getInitial().setAverages(averages);

            if (times != 0) {
                for (T element: c.getElements()) {
                    element.setCluster(null);
                }

                c.getElements().clear();
            }
        }
    }

    private static <T extends BaseKMeans> List<Cluster<T>> randomClusters(List<T> elements, int k) {
        List<Cluster<T>> clusters = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            int rand;

            do {
                Random random = new Random();
                rand = random.nextInt(elements.size());
            } while (indexes.contains(rand));

            indexes.add(rand);
            clusters.add(new Cluster<>(elements.get(rand)));
        }

        return clusters;
    }
}
