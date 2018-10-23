package br.eti.rafaelcouto.ai;

public abstract class BaseKMeans<T extends BaseKMeans> {
    protected Cluster<T> cluster;
    protected Double[] averages;

    public Cluster<T> getCluster() {
        return cluster;
    }

    public void setCluster(Cluster<T> cluster) {
        this.cluster = cluster;
    }

    public abstract Double calculateVariance(T other);

    public Double calculateCurrentVariance() {
        T other = cluster.getInitial();

        return calculateVariance(other);
    }

    public abstract Double[] getAverages();
    public abstract void setAverages(Double[] averages);
}
