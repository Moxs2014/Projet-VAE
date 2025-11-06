package com.moxs.gestionrepas;

public class App {

    public static void main(String[] args) {
        System.out.println("=== TEST DE LA CLASSE RECETTE ===\n");

        // Création d'une recette
        Recette recette = new Recette("Tarte aux pommes", 45, 3);

        // Ajout d'ingrédients
        recette.ajouterIngredient(new Ingredient("Pommes", 3, "pièces", "2025-11-30"));
        recette.ajouterIngredient(new Ingredient("Farine", 200, "g", "2026-01-01"));
        recette.ajouterIngredient(new Ingredient("Beurre", 100, "g", "2025-12-10"));
        recette.ajouterIngredient(new Ingredient("farine", 250, "g", "2026-01-01")); // doublon logique

        // Affichage de la recette
        System.out.println("Recette initiale :");
        System.out.println(recette);

        // Suppression d’un ingrédient
        recette.supprimerIngredient(new Ingredient("Beurre", 0, "", ""));
        System.out.println("\nAprès suppression du beurre :");
        System.out.println(recette);

        // Test de la copie défensive sur getIngredients()
        System.out.println("\nTest copie défensive :");
        var copieIngredients = recette.getIngredients();
        copieIngredients.clear(); // On vide la copie
        System.out.println("Taille du Set original après clear sur la copie : " + recette.getIngredients().size());

        System.out.println("\n=== TEST TERMINÉ AVEC SUCCÈS ===");
    }
}