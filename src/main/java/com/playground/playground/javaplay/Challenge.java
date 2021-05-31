package com.playground.playground.javaplay;

import java.util.*;
import java.util.stream.Collectors;

public class Challenge {
    public static void main(String[] args) {

    }

    public static String ingredients(String orderString) {
        if (orderString == null || orderString.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Map<String, Set<String>> menuSet = initMenu();
        List<String> orders = Arrays.asList(orderString.split(","));

        //check existing menu
        String menu = orders.stream()
                .findFirst()
                .map(String::toLowerCase)
                .filter(menuSet::containsKey)
                .orElseThrow(IllegalArgumentException::new);

        Set<String> menuIngredients = new HashSet<>(menuSet.get(menu));

        //order menu with ingredient
        if (orders.size() > 1) {
            // skip menu and remove ingredient
            orders.stream()
                    .skip(1)
                    .forEach(orderIngredient -> {
                        if (orderIngredient.startsWith("-") || !orderIngredient.isEmpty()) {
                            menuIngredients.remove(orderIngredient.substring(1));
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

    private static Map<String, Set<String>> initMenu() {
        Map<String, Set<String>> ingredients = new HashMap<>();
        ingredients.put("classic", new HashSet<>(Arrays.asList("strawberry", "banana", "pineapple", "mango", "peach", "honey")));
        ingredients.put("freezie", new HashSet<>(Arrays.asList("blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt")));
        ingredients.put("greenie", new HashSet<>(Arrays.asList("green apple", "lime", "avocado", "spinach", "ice", "apple juice")));
        ingredients.put("just desserts", new HashSet<>(Arrays.asList("banana", "ice cream", "chocolate", "peanut", "cherry")));
        return ingredients;
    }
}
