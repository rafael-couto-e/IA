package br.eti.rafaelcouto.ai;

import br.eti.rafaelcouto.model.Cluster;

public abstract class BaseKMeans<T extends BaseKMeans> {
    protected Cluster<T> cluster;

    public Cluster<T> getCluster() {
        return cluster;
    }

    public void setCluster(Cluster<T> cluster) {
        this.cluster = cluster;
    }

    public abstract double calculateVariance(T other);

    public abstract double calculateCurrentVariance();

    public abstract double[] getAverages();

    public abstract void setAverages(double[] averages);
}
