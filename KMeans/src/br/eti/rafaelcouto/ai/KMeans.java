package br.eti.rafaelcouto.ai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KMeans {
    public static <T extends BaseKMeans<T>> void init(List<T> elements, List<Cluster<T>> clusters, int runs) {
        validate(elements, clusters, runs);

        run(elements, clusters, runs);
    }

    private static <T extends BaseKMeans<T>> void run(List<T> elements, List<Cluster<T>> clusters, int run) {
        for(T element: elements) {
            findNearestCluster(element, clusters);
        }

        if (run > 0) {
            updateClusters(clusters, run);
            run(elements, clusters, run - 1);
        }
    }

    private static <T extends BaseKMeans<T>> void validate(List<T> elements, List<Cluster<T>> clusters, int runs) {
        if (elements == null)
            throw new NullPointerException("The elements list must not be null.");

        if (elements.size() == 0)
            throw new IllegalArgumentException("There must be at least one element.");

        if (clusters == null)
            throw new NullPointerException("The clusters list must not be null.");

        if (clusters.size() == 0)
            throw new IllegalArgumentException("There must be at least one cluster.");

        if (runs == 0)
            throw new IllegalArgumentException("There must be at least one run.");
    }

    public static <T extends BaseKMeans<T>> void init(List<T> elements, List<Cluster<T>> clusters) {
        init(elements, clusters, 1);
    }

    public static <T extends BaseKMeans<T>> void init(List<T> elements, int k, int runs) {
        init(elements, randomClusters(elements, k), runs);
    }

    public static <T extends BaseKMeans<T>> void init(List<T> elements, int k) {
        init(elements, k, 1);
    }

    private static <T extends BaseKMeans<T>> void findNearestCluster(T element, List<Cluster<T>> clusters) {
        for(Cluster<T> c: clusters) {
            if (element.getCluster() == null) {
                c.addElement(element);
                continue;
            }

            if (c.getInitial().calculateDistance(element) < element.calculateCurrentVariance()) {
                c.addElement(element);
            }
        }
    }

    private static <T extends BaseKMeans<T>> void updateClusters(List<Cluster<T>> clusters, int run) {
        for (Cluster<T> c : clusters) {
            Double[] averages = null;

            for (T element : c.getElements()) {
                if (averages == null) {
                    averages = element.getAverages();
                    continue;
                }

                for (int i = 0; i < element.getAverages().length; i++) {
                    averages[i] += element.getAverages()[i];
                }
            }

            if (c.getElements().size() != 0) {
                for (int i = 0; i < averages.length; i++) {
                    averages[i] /= c.getElements().size();
                }

                c.getInitial().setAverages(averages);
            }

            for (T element: c.getElements()) {
                element.setCluster(null);
            }

            c.clearElements();
        }
    }

    private static <T extends BaseKMeans<T>> List<Cluster<T>> randomClusters(List<T> elements, int k) {
        List<Cluster<T>> clusters = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            int rand;

            do {
                Random random = new Random();
                rand = random.nextInt(elements.size());
            } while (indexes.contains(rand));

            indexes.add(rand);

            try {
                clusters.add(new Cluster<>((T) elements.get(rand).clone()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return clusters;
    }
}
