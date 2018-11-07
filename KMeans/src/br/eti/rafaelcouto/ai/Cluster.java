package br.eti.rafaelcouto.ai;

import java.util.ArrayList;
import java.util.List;

public class Cluster<T extends BaseKMeans> {
    private T initial;
    private String name;
    private List<T> elements;

    public Cluster(T initial) {
        this.initial = initial;
        this.elements = new ArrayList<>();
    }

    public Cluster(T initial, String name) {
        this(initial);
        this.name = name;
    }

    public T getInitial() {
        return initial;
    }

    public void setInitial(T initial) {
        this.initial = initial;
    }

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }

    public void addElement(T element) {
        if (element.getCluster() != null) {
            element.getCluster().removeElement(element);
        }

        element.setCluster(this);
        this.elements.add(element);
    }

    public void removeElement(T element) {
        this.elements.remove(element);
    }

    public void clearElements() {
        this.elements.clear();
    }

    public String getAverages() {
        StringBuilder stringBuilder = new StringBuilder("[");

        for (Double d: initial.getAverages()) {
            if (stringBuilder.toString().equals("[")) {
                stringBuilder.append(d);
                continue;
            }

            stringBuilder.append(", ").append(d);
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
