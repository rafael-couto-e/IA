package br.eti.rafaelcouto.model;

import br.eti.rafaelcouto.ai.BaseKMeans;

import java.util.Objects;

public class Color extends BaseKMeans<Color> {
    private Double red;
    private Double green;
    private Double blue;
    private String hex;

    public Color(Double red, Double green, Double blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Color(Double red, Double green, Double blue, String hex) {
        this(red, green, blue);
        this.hex = hex;
    }

    public Double getRed() {
        return red;
    }

    public void setRed(Double red) {
        this.red = red;
    }

    public Double getGreen() {
        return green;
    }

    public void setGreen(Double green) {
        this.green = green;
    }

    public Double getBlue() {
        return blue;
    }

    public void setBlue(Double blue) {
        this.blue = blue;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return Objects.equals(red, color.red) &&
                Objects.equals(green, color.green) &&
                Objects.equals(blue, color.blue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }

    @Override
    public Double calculateDistance(Color other) {
        Double variance = Math.pow(this.red - other.red, 2) +
                Math.pow(this.green - other.green, 2) +
                Math.pow(this.blue - other.blue, 2);

        return Math.sqrt(variance);
    }

    @Override
    public Double[] getAverages() {
        if (averages == null) {
            this.averages = new Double[]{
                red, green, blue
            };
        }

        return averages;
    }

    @Override
    public void setAverages(Double[] averages) {
        this.red = averages[0];
        this.green = averages[1];
        this.blue = averages[2];
    }
}
