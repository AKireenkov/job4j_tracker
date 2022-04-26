package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("kireenkov@yandex.ru", "Kireenkov Andrey Alekseevich");
        map.put("kireenkov@yandex.ru", "Ivanov Sergey Petrovich");
        map.put("Mosin@yandex.ru", "Mosin Dmitry Olegovich");
        map.put("Mosin@yandex.ru", "Petrov Ivan Denisovich");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}
