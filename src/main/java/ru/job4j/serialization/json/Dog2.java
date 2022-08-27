package ru.job4j.serialization.json;

import org.json.*;

public class Dog2 {
    public static void main(String[] args) {
        Dog dogLooping = new Dog(false, "Dana", 2005);
        Dog pet1 = new Dog(false, "Berta", 2010);
        Dog[] pets = new Dog[2];
        pets[0] = pet1;
        pets[1] = dogLooping;
        dogLooping.setPets(pets);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isMale", dogLooping.getMale());
        jsonObject.put("name", dogLooping.getName());
        jsonObject.put("yearBorn", dogLooping.getYearBorn());
        jsonObject.put("pets", dogLooping.getPets());
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(dogLooping).toString());
    }
}
