package br.eti.rafaelcouto.model;

import br.eti.rafaelcouto.ai.BaseKMeans;

import java.util.ArrayList;
import java.util.List;

public class Cluster<T extends BaseKMeans> {
    private T initial;
    private List<T> elements;

    public Cluster(T initial) {
        this.initial = initial;
        this.elements = new ArrayList<>();
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
        this.elements.add(element);
    }

    public void removeElement(T element) {
        this.elements.remove(element);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        for (double d: initial.getAverages()) {
            if (stringBuilder.toString().equals("[")) {
                stringBuilder.append(d);
                continue;
            }

            stringBuilder.append(", "+d);
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
