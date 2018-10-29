package br.eti.rafaelcouto.model;

import br.eti.rafaelcouto.ai.BaseKMeans;

import java.util.Objects;

public class Iris extends BaseKMeans<Iris> {
    private Double compSepala;
    private Double largSepala;
    private Double compPetala;
    private Double largPetala;
    private String name;

    public Iris() {
    }

    public Iris(Double compSepala, Double largSepala, Double compPetala, Double largPetala) {
        this();
        this.compSepala = compSepala;
        this.largSepala = largSepala;
        this.compPetala = compPetala;
        this.largPetala = largPetala;
    }

    public Iris(Double compSepala, Double largSepala, Double compPetala, Double largPetala, String name) {
        this(compSepala, largSepala, compPetala, largPetala);
        this.name = name;
    }

    public Double getCompSepala() {
        return compSepala;
    }

    public void setCompSepala(Double compSepala) {
        this.compSepala = compSepala;
    }

    public Double getLargSepala() {
        return largSepala;
    }

    public void setLargSepala(Double largSepala) {
        this.largSepala = largSepala;
    }

    public Double getCompPetala() {
        return compPetala;
    }

    public void setCompPetala(Double compPetala) {
        this.compPetala = compPetala;
    }

    public Double getLargPetala() {
        return largPetala;
    }

    public void setLargPetala(Double largPetala) {
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
    public Double calculateDistance(Iris other) {
        Double variance = Math.pow(this.compSepala - other.compSepala, 2) +
                Math.pow(this.largSepala - other.largSepala, 2) +
                Math.pow(this.compPetala - other.compPetala, 2) +
                Math.pow(this.largPetala - other.largPetala, 2);

        return Math.sqrt(variance);
    }

    @Override
    public Double[] getAverages() {
        if (averages == null) {
            this.averages = new Double[]{
                    compSepala, largSepala, compPetala, largPetala
            };
        }

        return averages;
    }

    @Override
    public void setAverages(Double[] averages) {
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
