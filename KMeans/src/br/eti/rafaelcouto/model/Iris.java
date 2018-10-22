package br.eti.rafaelcouto.model;

import br.eti.rafaelcouto.ai.BaseKMeans;

import java.util.Objects;

public class Iris extends BaseKMeans<Iris> {
    private double compSepala;
    private double largSepala;
    private double compPetala;
    private double largPetala;
    private String name;

    public Iris() {
    }

    public Iris(double compSepala, double largSepala, double compPetala, double largPetala) {
        this();
        this.compSepala = compSepala;
        this.largSepala = largSepala;
        this.compPetala = compPetala;
        this.largPetala = largPetala;
    }

    public Iris(double compSepala, double largSepala, double compPetala, double largPetala, String name) {
        this(compSepala, largSepala, compPetala, largPetala);
        this.name = name;
    }

    public double getCompSepala() {
        return compSepala;
    }

    public void setCompSepala(double compSepala) {
        this.compSepala = compSepala;
    }

    public double getLargSepala() {
        return largSepala;
    }

    public void setLargSepala(double largSepala) {
        this.largSepala = largSepala;
    }

    public double getCompPetala() {
        return compPetala;
    }

    public void setCompPetala(double compPetala) {
        this.compPetala = compPetala;
    }

    public double getLargPetala() {
        return largPetala;
    }

    public void setLargPetala(double largPetala) {
        this.largPetala = largPetala;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Iris iris = (Iris) o;
        return Double.compare(iris.compSepala, compSepala) == 0 &&
                Double.compare(iris.largSepala, largSepala) == 0 &&
                Double.compare(iris.compPetala, compPetala) == 0 &&
                Double.compare(iris.largPetala, largPetala) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(compSepala, largSepala, compPetala, largPetala);
    }

    @Override
    public double calculateVariance(Iris other) {
        return Math.pow(this.compSepala - other.compSepala, 2) +
                Math.pow(this.largSepala - other.largSepala, 2) +
                Math.pow(this.compPetala - other.compPetala, 2) +
                Math.pow(this.largPetala - other.largPetala, 2);
    }

    @Override
    public double calculateCurrentVariance() {
        Iris other = this.getCluster().getInitial();

        return calculateVariance(other);
    }

    @Override
    public double[] getAverages() {
        return new double[]{
            compSepala, largSepala, compPetala, largPetala
        };
    }

    @Override
    public void setAverages(double[] averages) {
        this.compSepala = averages[0];
        this.largSepala = averages[1];
        this.compPetala = averages[2];
        this.largPetala = averages[3];
    }

    @Override
    public String toString() {
        return "\n[name: "+name+", largSepala: "+largSepala+", compSepala: "+compSepala
                +", largPetala: "+largPetala+", compPetala: "+compPetala+"]\n";
    }
}
