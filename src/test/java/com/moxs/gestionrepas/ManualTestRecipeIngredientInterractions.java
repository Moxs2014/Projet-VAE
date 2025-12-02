package com.moxs.gestionrepas;

import com.moxs.gestionrepas.domain.*;

public class ManualTestRecipeIngredientInterractions {

    public static void main(String[] args) {

        /** Creating ingredients */
        Ingredient apples = new Ingredient("Apples", 3, "pieces", "2025-11-30");
        Ingredient flour  = new Ingredient("Flour", 200, "g", "2026-01-01");
        Ingredient butter = new Ingredient("Butter", 100, "g", "2025-12-10");

        /** Creating the recipe */ 
        Recipe applePie = new Recipe("Apple Pie", 45, RecipeType.DESSERT, false, false);

        /** Adding ingredients */ 
        applePie.addIngredient(apples);
        applePie.addIngredient(flour);
        applePie.addIngredient(butter);

        /** Incrementing usage counter */
        applePie.incrementUsageCount();

        /** Display before removal */
        System.out.println("=== Recipe before removing ingredient ===");
        System.out.println(applePie);

        /** Removing one ingredient (flour) */ 
        applePie.removeIngredient(flour);

        /** Verifications after removal */ 
        boolean containsFlour = applePie.getIngredients().contains(flour);
        int ingredientsCount  = applePie.getIngredients().size();

        System.out.println("\n=== Checks after removing Flour ===");
        System.out.println("Contains Flour after removal? " + containsFlour);
        System.out.println("Number of ingredients after removal: " + ingredientsCount);

        /** Display after removal */ 
        System.out.println("\n=== Recipe after removing ingredient ===");
        System.out.println(applePie);
    }
}
