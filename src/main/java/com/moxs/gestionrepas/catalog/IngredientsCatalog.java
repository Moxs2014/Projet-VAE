package com.moxs.gestionrepas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IngredientsCatalog {

    /** List of "basic" ingredients: no quantity, no best-before date */
    private static final List<String> INGREDIENT_NAMES = new ArrayList<>();

    static {
        INGREDIENT_NAMES.add("Tomato");
        INGREDIENT_NAMES.add("Mozzarella");
        INGREDIENT_NAMES.add("Basil");
        INGREDIENT_NAMES.add("Bread");
        INGREDIENT_NAMES.add("Butter");
        INGREDIENT_NAMES.add("Egg");
        INGREDIENT_NAMES.add("Chicken");
        INGREDIENT_NAMES.add("Rice");
        INGREDIENT_NAMES.add("Pasta");
        INGREDIENT_NAMES.add("Fresh Cream");
        INGREDIENT_NAMES.add("Mushroom");
        INGREDIENT_NAMES.add("Grated Cheese");
        INGREDIENT_NAMES.add("Flour");
        INGREDIENT_NAMES.add("Sugar");
        INGREDIENT_NAMES.add("Dark Chocolate");
        INGREDIENT_NAMES.add("Milk");
        INGREDIENT_NAMES.add("Vanilla");
    }

    /** Returns all available ingredient names. */
    public static List<String> getAllNames() {
        return Collections.unmodifiableList(INGREDIENT_NAMES);
    }

    /** Checks whether a name exists in the catalog. */
    public static boolean exists(String name) {
        if (name == null) return false;
        for (String n : INGREDIENT_NAMES) {
            if (n.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a concrete Ingredient using the catalog entry,
     * adding a quantity, unit and best-before date.
     */
    public static Ingredient createIngredient(String name, int quantity, String unit, String bestBeforeDate) {
        if (!exists(name)) {
            throw new IllegalArgumentException("Unknown ingredient in catalog: " + name);
        }
        return new Ingredient(name, quantity, unit, bestBeforeDate);
    }
}
