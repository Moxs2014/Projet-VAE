package com.moxs.gestionrepas;

import java.util.ArrayList;
import java.util.List;

public class StockIngredientsTest {

    private static final List<Ingredient> ingredients = new ArrayList<>();

    static {

        ingredients.add(IngredientsCatalog.createIngredient("Tomato", 3, "pieces", "2025-08-01"));
        ingredients.add(IngredientsCatalog.createIngredient("Mozzarella", 1, "ball", "2025-06-15"));
        ingredients.add(IngredientsCatalog.createIngredient("Basil", 5, "leaves", "2025-07-10"));
        ingredients.add(IngredientsCatalog.createIngredient("Bread", 4, "slices", "2025-04-20"));
        ingredients.add(IngredientsCatalog.createIngredient("Butter", 50, "g", "2025-05-12"));
        ingredients.add(IngredientsCatalog.createIngredient("Egg", 2, "pieces", "2025-11-20"));

        ingredients.add(IngredientsCatalog.createIngredient("Chicken", 300, "g", "2025-11-12"));
        ingredients.add(IngredientsCatalog.createIngredient("Rice", 200, "g", "2026-01-01"));
        ingredients.add(IngredientsCatalog.createIngredient("Pasta", 250, "g", "2026-02-01"));
        ingredients.add(IngredientsCatalog.createIngredient("Fresh Cream", 20, "cl", "2025-12-05"));
        ingredients.add(IngredientsCatalog.createIngredient("Mushroom", 150, "g", "2025-11-15"));
        ingredients.add(IngredientsCatalog.createIngredient("Grated Cheese", 100, "g", "2025-12-10"));

        ingredients.add(IngredientsCatalog.createIngredient("Flour", 200, "g", "2026-03-01"));
        ingredients.add(IngredientsCatalog.createIngredient("Sugar", 100, "g", "2026-04-01"));
        ingredients.add(IngredientsCatalog.createIngredient("Dark Chocolate", 120, "g", "2026-02-15"));
        ingredients.add(IngredientsCatalog.createIngredient("Butter", 80, "g", "2025-12-01"));
        ingredients.add(IngredientsCatalog.createIngredient("Milk", 25, "cl", "2025-11-18"));
        ingredients.add(IngredientsCatalog.createIngredient("Vanilla", 1, "pod", "2026-05-10"));
    }

    /** Returns a defensive copy of all stored ingredients. */
    public static List<Ingredient> getAll() {
        return new ArrayList<>(ingredients);
    }

    /** Returns an ingredient by name, or null if not found. */
    public static Ingredient getByName(String name) {
        for (Ingredient i : ingredients) {
            if (i.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return null;
    }
}
