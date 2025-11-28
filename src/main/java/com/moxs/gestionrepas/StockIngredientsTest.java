package com.moxs.gestionrepas;

import java.util.ArrayList;
import java.util.List;

public class StockIngredientsTest {

    private static final List<Ingredient> ingredients = new ArrayList<>();

    static {
        
        ingredients.add(CatalogueIngredients.creerIngredient("Tomate", 3, "pièces", "2025-08-01"));
        ingredients.add(CatalogueIngredients.creerIngredient("Mozzarella", 1, "boule", "2025-06-15"));
        ingredients.add(CatalogueIngredients.creerIngredient("Basilic", 5, "feuilles", "2025-07-10"));
        ingredients.add(CatalogueIngredients.creerIngredient("Pain", 4, "tranches", "2025-04-20"));
        ingredients.add(CatalogueIngredients.creerIngredient("Beurre", 50, "g", "2025-05-12"));
        ingredients.add(CatalogueIngredients.creerIngredient("Œuf", 2, "pièces", "2025-11-20"));

       
        ingredients.add(CatalogueIngredients.creerIngredient("Poulet", 300, "g", "2025-11-12"));
        ingredients.add(CatalogueIngredients.creerIngredient("Riz", 200, "g", "2026-01-01"));
        ingredients.add(CatalogueIngredients.creerIngredient("Pâtes", 250, "g", "2026-02-01"));
        ingredients.add(CatalogueIngredients.creerIngredient("Crème fraîche", 20, "cl", "2025-12-05"));
        ingredients.add(CatalogueIngredients.creerIngredient("Champignon", 150, "g", "2025-11-15"));
        ingredients.add(CatalogueIngredients.creerIngredient("Fromage râpé", 100, "g", "2025-12-10"));

        
        ingredients.add(CatalogueIngredients.creerIngredient("Farine", 200, "g", "2026-03-01"));
        ingredients.add(CatalogueIngredients.creerIngredient("Sucre", 100, "g", "2026-04-01"));
        ingredients.add(CatalogueIngredients.creerIngredient("Chocolat noir", 120, "g", "2026-02-15"));
        ingredients.add(CatalogueIngredients.creerIngredient("Beurre", 80, "g", "2025-12-01"));
        ingredients.add(CatalogueIngredients.creerIngredient("Lait", 25, "cl", "2025-11-18"));
        ingredients.add(CatalogueIngredients.creerIngredient("Vanille", 1, "gousse", "2026-05-10"));
    }

    public static List<Ingredient> getAll() {
        return new ArrayList<>(ingredients); // copie défensive
    }

    public static Ingredient getByName(String nom) {
        for (Ingredient i : ingredients) {
            if (i.getNom().equalsIgnoreCase(nom)) {
                return i;
            }
        }
        return null;
    }
}