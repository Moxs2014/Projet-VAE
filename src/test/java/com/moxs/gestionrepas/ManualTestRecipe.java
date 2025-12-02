package com.moxs.gestionrepas;

import com.moxs.gestionrepas.domain.*;

public class ManualTestRecipe {

    public static void main(String[] args) {
        // Creating ingredients
    Ingredient apples = new Ingredient("Apples", 3, "pieces", "2025-11-30");
    Ingredient flour  = new Ingredient("Flour", 200, "g", "2026-01-01");
    Ingredient butter = new Ingredient("Butter", 100, "g", "2025-12-10");

    // Creating the recipe
    Recipe applePie = new Recipe("Apple Pie", 45, RecipeType.DESSERT, false, false);

    // Adding ingredients
    applePie.addIngredient(apples);
    applePie.addIngredient(flour);
    applePie.addIngredient(butter);


    // Increment usage count
    applePie.incrementUsageCount();

    // Final display
    System.out.println(applePie.toString());
    System.out.println(flour.toString());
    }   
}
