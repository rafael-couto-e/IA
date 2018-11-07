package br.eti.rafaelcouto.model;

import br.eti.rafaelcouto.ai.BaseKMeans;

import java.util.Objects;

public class Person extends BaseKMeans<Person> {
    private Double weight;
    private Double height;
    private String name;

    public Person(Double height, Double weight) {
        this.weight = weight;
        this.height = height;
    }

    public Person(Double weight, Double height, String name) {
        this(weight, height);
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
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
        Person person = (Person) o;
        return Objects.equals(weight, person.weight) &&
                Objects.equals(height, person.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, height);
    }

    @Override
    public Double calculateDistance(Person other) {
        Double variance = Math.pow(this.weight - other.weight, 2) +
                Math.pow(this.height - other.height, 2);

        return Math.sqrt(variance);
    }

    @Override
    public Double[] getAverages() {
        if (averages == null) {
            this.averages = new Double[]{
                    weight, height
            };
        }

        return averages;
    }

    @Override
    public void setAverages(Double[] averages) {
        this.weight = averages[0];
        this.height = averages[1];
    }

    @Override
    public String toString() {
        return "\n[name: "+name+", weight: "+weight+", height: "+height+"]\n";
    }
}
