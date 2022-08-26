package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Dog {

    private boolean isMale;
    private String name;
    private int yearBorn;
    private Dog[] pets;

    public Dog(boolean isMale, String name, int yearBorn, Dog[] pets) {
        this.isMale = isMale;
        this.name = name;
        this.yearBorn = yearBorn;
        this.pets = pets;
    }

    public Dog(boolean isMale, String name, int yearBorn) {
        this.isMale = isMale;
        this.name = name;
        this.yearBorn = yearBorn;
    }

    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder("IsMale = ");
        strBuild.append(isMale);
        strBuild.append("\nname = ");
        strBuild.append(name);
        strBuild.append("\nyearBorn = ");
        strBuild.append(yearBorn);
        strBuild.append("\nPets = ");
        for (Dog pet : pets) {
            strBuild.append(pet.name);
            strBuild.append(";");
        }
        return strBuild.toString();
    }

    public static void main(String[] args) {
        Dog[] mainPets = new Dog[2];
        mainPets[0] = new Dog(false, "Berta", 2010);
        mainPets[1] = new Dog(true, "Rex", 2010);
        Dog dana = new Dog(false, "Dana", 2004, mainPets);
        final Gson gson = new GsonBuilder().create();
        String stringGson = gson.toJson(dana);
        Dog fromGson = gson.fromJson(stringGson, Dog.class);
        System.out.println(fromGson);
    }


}
