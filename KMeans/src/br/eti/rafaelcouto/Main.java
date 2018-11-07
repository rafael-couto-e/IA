package br.eti.rafaelcouto;

import br.eti.rafaelcouto.ai.KMeans;
import br.eti.rafaelcouto.ai.Cluster;
import br.eti.rafaelcouto.model.Color;
import br.eti.rafaelcouto.model.Iris;
import br.eti.rafaelcouto.model.Person;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*Iris iris1 = new Iris(5.9, 3.0, 5.1, 1.8, "1");
        Iris iris2 = new Iris(5.7, 2.8, 4.1, 1.3, "2");
        Iris iris3 = new Iris(5.0, 3.3, 1.4, 0.2, "3");
        Iris iris4 = new Iris(6.2, 3.4, 5.4, 2.3, "4");
        Iris iris5 = new Iris(5.1, 2.5, 3.0, 1.1, "5");

        Cluster<Iris> first = new Cluster<>(new Iris(5.0, 2.0, 5.0, 1.0));
        Cluster<Iris> second = new Cluster<>(new Iris(6.0, 4.0, 0.0, 3.0));
        Cluster<Iris> third = new Cluster<>(new Iris(5.0, 3.0, 6.0, 3.0));

        List<Iris> elements = new ArrayList<Iris>(){{
            add(iris1);
            add(iris2);
            add(iris3);
            add(iris4);
            add(iris5);
        }};

        List<Cluster<Iris>> clusters = new ArrayList<Cluster<Iris>>(){{
            add(first);
            add(second);
            add(third);
        }};

        KMeans.init(elements, 3);

        for (Iris i: elements) {
            System.out.println("Cluster for "+i.getName()+": "+i.getCluster());
        }

        KMeans.init(elements, clusters, 5);

        int i = 1;

        for (Cluster<Iris> c: clusters) {
            StringBuilder stringBuilder = new StringBuilder("Média ").append(i).append(": [");

            for(double d: c.getInitial().getAverages()) {
                if (stringBuilder.toString().equals("Média "+i+": [")) {
                    stringBuilder.append(d);
                    continue;
                }

                stringBuilder.append(", ").append(d);
            }

            stringBuilder.append("]");

            stringBuilder.append("\nElementos ").append(i).append(": ").append(c.getElements());

            i++;

            System.out.println(stringBuilder.toString());
        }*/

        //BIDIMENSIONAL
        Person person1 = new Person(1.5, 37.5, "Alanis");
        Person person2 = new Person(1.55, 55.4, "Ben");
        Person person3 = new Person(1.6, 94.7, "Carl");
        Person person4 = new Person(1.65, 78.9, "Denise");
        Person person5 = new Person(1.7, 47.7, "Elisa");
        Person person6 = new Person(1.75, 55.3, "Franklin");
        Person person7 = new Person(1.8, 103.7, "Gary");
        Person person8 = new Person(1.85, 92.4, "Helen");
        Person person9 = new Person(1.9, 69.5, "Irene");
        Person person10 = new Person(1.95, 80.3, "Jake");
        Person person11 = new Person(2.0, 100.0, "Kacey");
        Person person12 = new Person(2.05, 172.3, "Lucas");

        Cluster<Person> firstPerson = new Cluster<>(new Person(1.65, 46.3, "Underweight"));
        Cluster<Person> secondPerson = new Cluster<>(new Person(1.8, 69.6, "Regular weight"));
        Cluster<Person> thirdPerson = new Cluster<>(new Person(1.9, 98.3, "Overweight"));
        Cluster<Person> fourthPerson = new Cluster<>(new Person(1.75, 110.3, "Obesity"));

        List<Person> people = new ArrayList<Person>(){{
            add(person1); add(person2); add(person3);
            add(person4); add(person5); add(person6);
            add(person7); add(person8); add(person9);
            add(person10); add(person11); add(person12);
        }};

        List<Cluster<Person>> personClusters = new ArrayList<Cluster<Person>>(){{
            add(firstPerson); add(secondPerson);
            add(thirdPerson); add(fourthPerson);
        }};

        /*
        Person person1 = new Person(150.0, 3.0, "Alanis");
        Person person6 = new Person(175.0, 3.0, "Franklin");
        Person person5 = new Person(170.0, 3.0, "Elisa");
        Person person9 = new Person(190.0, 3.0, "Irene");
        Person person10 = new Person(195.0, 3.0, "Jake");
        Person person2 = new Person(155.0, 3.0, "Ben");
        Person person11 = new Person(200.0, 3.0, "Kacey");
        Person person8 = new Person(185.0, 3.0, "Helen");
        Person person4 = new Person(165.0, 3.0, "Denise");
        Person person7 = new Person(180.0, 3.0, "Gary");
        Person person3 = new Person(160.0, 3.0, "Carl");
        Person person12 = new Person(205.0, 3.0, "Lucas");
        */

        //TRIDIMENSIONAL
        Color color1 = new Color(57.0, 202.0, 2.0, "39ca02");
        Color color2 = new Color(184.0, 158.0, 1.0, "b89e01");
        Color color3 = new Color(157.0, 217.0, 115.0, "9dd973");
        Color color4 = new Color(97.0, 201.0, 161.0, "61c9a1");
        Color color5 = new Color(194.0, 213.0, 7.0, "c2d507");
        Color color6 = new Color(2.0, 150.0, 42.0, "02962a");
        Color color7 = new Color(223.0, 116.0, 132.0, "df7484");
        Color color8 = new Color(154.0, 7.0, 156.0, "9a079c");
        Color color9 = new Color(243.0, 182.0, 234.0, "f3b6ea");
        Color color10 = new Color(42.0, 26.0, 245.0, "2a1af5");
        Color color11 = new Color(254.0, 156.0, 56.0, "fe9c38");
        Color color12 = new Color(144.0, 133.0, 244.0, "9085f4");

        Cluster<Color> firstColor = new Cluster<>(new Color(255.0, 0.0, 0.0, "Red"));
        Cluster<Color> secondColor = new Cluster<>(new Color(0.0, 255.0, 0.0, "Green"));
        Cluster<Color> thirdColor = new Cluster<>(new Color(0.0, 0.0, 255.0, "Blue"));

        List<Color> colors = new ArrayList<Color>(){{
            add(color1); add(color2); add(color3);
            add(color4); add(color5); add(color6);
            add(color7); add(color8); add(color9);
            add(color10); add(color11); add(color12);
        }};

        List<Cluster<Color>> colorClusters = new ArrayList<Cluster<Color>>(){{
            add(firstColor); add(secondColor); add(thirdColor);
        }};

        //TETRADIMENSIONAL
        Iris iris1 = new Iris(6.3, 2.7, 4.9, 1.8, "1");
        Iris iris2 = new Iris(6.4, 2.7, 5.3, 1.9, "2");
        Iris iris3 = new Iris(6.8, 3.2, 5.9, 2.3, "3");
        Iris iris4 = new Iris(6.6, 2.9, 4.6, 1.3, "4");
        Iris iris5 = new Iris(6.5, 2.8, 4.6, 1.5, "5");
        Iris iris6 = new Iris(4.8, 3.4, 1.6, 0.2, "6");
        Iris iris7 = new Iris(6.3, 3.4, 5.6, 2.4, "7");
        Iris iris8 = new Iris(5.4, 3.0, 4.5, 1.5, "8");
        Iris iris9 = new Iris(5.5, 2.3, 4.0, 1.3, "9");
        Iris iris10 = new Iris(4.8, 3.4, 1.9, 0.2, "10");
        Iris iris11 = new Iris(7.7, 2.6, 6.9, 2.3, "11");
        Iris iris12 = new Iris(5.1, 2.5, 3.0, 1.1, "12");
        Iris iris13 = new Iris(6.5, 3.2, 5.1, 2.0, "13");
        Iris iris14 = new Iris(5.1, 3.8, 1.9, 0.4, "14");
        Iris iris15 = new Iris(4.8, 3.1, 1.6, 0.2, "15");

        Cluster<Iris> firstIris = new Cluster<>(
                new Iris(5.5, 2.4, 3.8, 1.1, "Versicolor"));
        Cluster<Iris> secondIris = new Cluster<>(
                new Iris(5.9, 3.0, 5.1, 1.8, "Virginica"));
        Cluster<Iris> thirdIris = new Cluster<>(
                new Iris(5.0, 3.6, 1.4, 0.2, "Setosa"));

        List<Iris> irises = new ArrayList<Iris>(){{
            add(iris1); add(iris2); add(iris3);
            add(iris4); add(iris5); add(iris6);
            add(iris7); add(iris8); add(iris9);
            add(iris10); add(iris11); add(iris12);
            add(iris13); add(iris14); add(iris15);
        }};

        List<Cluster<Iris>> irisClusters = new ArrayList<Cluster<Iris>>(){{
            add(firstIris); add(secondIris); add(thirdIris);
        }};

        /*
        6.3,2.7,4.9,1.8,Iris-virginica
        6.4,2.7,5.3,1.9,Iris-virginica
        6.8,3.2,5.9,2.3,Iris-virginica
        6.6,2.9,4.6,1.3,Iris-versicolor
        6.5,2.8,4.6,1.5,Iris-versicolor
        4.8,3.4,1.6,0.2,Iris-setosa
        6.3,3.4,5.6,2.4,Iris-virginica
        5.4,3.0,4.5,1.5,Iris-versicolor
        5.5,2.3,4.0,1.3,Iris-versicolor
        4.8,3.4,1.9,0.2,Iris-setosa
        7.7,2.6,6.9,2.3,Iris-virginica
        5.1,2.5,3.0,1.1,Iris-versicolor
        6.5,3.2,5.1,2.0,Iris-virginica
        5.1,3.8,1.9,0.4,Iris-setosa
        4.8,3.1,1.6,0.2,Iris-setosa
        */

        /*//First run - People
        KMeans.init(people, personClusters, 1000);

        for (Cluster<Person> c: personClusters) {
            String stringBuilder = "Grupo " +
                    c.getInitial().getName() +
                    ": [" +
                    c.getAverages() +
                    "]" +
                    "\nElementos: " +
                    c.getElements();

            System.out.println(stringBuilder);
        }

        System.out.println("****************************\n\n\n****************************");

        //Second run - Colors
        KMeans.init(colors, colorClusters, 1000);

        for (Cluster<Color> c: colorClusters) {
            String stringBuilder = "Grupo " +
                    c.getInitial().getHex() +
                    ": [" +
                    c.getAverages() +
                    "]" +
                    "\nElementos: " +
                    c.getElements();

            System.out.println(stringBuilder);
        }

        System.out.println("****************************\n\n\n****************************");

        //Third run - Irises
        KMeans.init(irises, irisClusters, 1000);

        for (Cluster<Iris> c: irisClusters) {
            String stringBuilder = "Grupo " +
                    c.getInitial().getName() +
                    ": [" +
                    c.getAverages() +
                    "]" +
                    "\nElementos: " +
                    c.getElements();

            System.out.println(stringBuilder);
        }*/

        //First run - People
        KMeans.init(people, 4, 1000);

        for (Person p: people) {
            String stringBuilder = "Grupo base: "+
                    p.getCluster().getInitial().toString()+
                    "\nValores: "+
                    p.toString();

            System.out.println(stringBuilder);
        }

        System.out.println("****************************\n\n\n****************************");

        //Second run - Colors
        KMeans.init(colors, 3, 1000);

        for (Color c: colors) {
            String stringBuilder = "Grupo base: "+
                    c.getCluster().getInitial().toString()+
                    "\nValores: "+
                    c.toString();

            System.out.println(stringBuilder);
        }

        System.out.println("****************************\n\n\n****************************");

        //Third run - Irises
        KMeans.init(irises, 3, 1000);

        for (Iris i: irises) {
            String stringBuilder = "Grupo base: "+
                    i.getCluster().getInitial().toString()+
                    "\nValores: "+
                    i.toString();

            System.out.println(stringBuilder);
        }
    }
}
