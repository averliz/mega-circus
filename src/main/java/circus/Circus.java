package circus;

import circus.animal.*;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {
//        makeAnimalsTalk();
//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));

        System.out.println("Number of animals: " + animals.length); // len of animals array

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
            // to convert array to arrayList - need to first convert to list

        // add new animal
        animalArrayList.add(new Tiger("Tigger"));
        System.out.println("Number of animals: " + animalArrayList.size()); // len of animals array

        // add duck and elephant
        Duck louie = new Duck("Louie");
        animalArrayList.add(louie);

        Elephant Dumbo = new Elephant("Dumbo");
        animalArrayList.add(Dumbo);
        System.out.println("Number of animals: " + animalArrayList.size()); // len of animals array

        printAllAnimals(animalArrayList);

        // find the position of the object in arraylist - indexof
        System.out.println("Louie's postion is: " + animalArrayList.indexOf(louie));

        // sort the animals - using a comparator; this is used to compare the elements for sorting
        // comparator added in Animal class
        animalArrayList.sort(Animal.AnimalNameComparator);

        // after sorting
        printAllAnimals(animalArrayList);

        // find the position of the object in arraylist - indexof
        System.out.println("Louie's postion is after sorting is: " + animalArrayList.indexOf(louie));

    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }
}
