package com.playground.playground.javaplay;

import java.util.*;
import java.util.stream.Collectors;

public class Challenge {

    public static Map<String, Set<String>> ingredients = new HashMap<>();

    public Challenge() {
        initMenu();
    }

    public String ingredients(String orderString) {
        if (orderString == null || orderString.isEmpty()) {
            throw new IllegalArgumentException();
        }
//        Map<String, Set<String>> menuSet = initMenu();
        //separate order with Menu and ingredients
        List<String> orders = Arrays.asList(orderString.split(","));

        //check existing menu
        String menu = orders.stream()
                .findFirst()
                .map(String::toLowerCase)
                .filter(ingredients::containsKey)
                .orElseThrow(IllegalArgumentException::new);

        Set<String> menuIngredients = new HashSet<>(ingredients.get(menu));

        //order menu with ingredient
        if (orders.size() > 1) {
            // skip menu and remove ingredient
            orders.stream()
                    .skip(1)
                    .forEach(orderIngredient -> {
                        if (orderIngredient.startsWith("-") || !orderIngredient.isEmpty()) {
                            // remove ingredient if existing
                            menuIngredients.remove(orderIngredient.substring(1));
                            // remove all ingredients should throw error
                            if (menuIngredients.isEmpty()) {
                                throw new IllegalArgumentException();
                            }
                        } else if (!menuIngredients.contains(orderIngredient)) {
                            // add not exist ingredient
                            throw new IllegalArgumentException();
                        }
                    });
        }

        //order only menu
        return menuIngredients
                .stream()
                .sorted()
                .collect(Collectors.joining(","));

    }

    private void initMenu() {
        ingredients.put("classic", new HashSet<>(Arrays.asList("strawberry", "banana", "pineapple", "mango", "peach", "honey")));
        ingredients.put("freezie", new HashSet<>(Arrays.asList("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt")));
        ingredients.put("greenie", new HashSet<>(Arrays.asList("green apple", "lime", "avocado", "spinach", "ice", "apple juice")));
        ingredients.put("just desserts", new HashSet<>(Arrays.asList("banana", "ice cream", "chocolate", "peanut", "cherry")));

    }

    public HashSet<Integer> uniqNumber() {
        List<Integer> initialData = Arrays.asList(1,1,1,1,1,1,2,2,2,2,2);

        return new HashSet<>(initialData);
    }

    public List<Integer> streamPlay() {

        Set<Integer> test = new HashSet<>(Arrays.asList(1, 10, 5 , 8, 2));

        Integer max = test.stream().max(Integer::compareTo).get();
        Integer min = test.stream().min(Integer::compareTo).get();

        List<Integer> result = test.stream().sorted().collect(Collectors.toList());

        return result;
    }



}
