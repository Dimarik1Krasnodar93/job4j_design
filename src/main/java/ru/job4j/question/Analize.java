package ru.job4j.question;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int deleteCount = 0;
        int changeCount = 0;
        int addCount = 0;
        Map<Integer, User>  hashMap = new HashMap<>(previous.size() + current.size());
        for(User temp : previous) {
            hashMap.put(temp.hashCode(), temp);
        }
        for(User temp : current) {
            User user = hashMap.get(temp.hashCode());
            if (user == null) {
                addCount++;
            } else {
                if (!user.equals(temp)) {
                    changeCount++;
                }
                hashMap.remove(temp.hashCode());
            }
        }
        deleteCount = hashMap.size();
        return new Info(addCount, changeCount, deleteCount);
    }

}