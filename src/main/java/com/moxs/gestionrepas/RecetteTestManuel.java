package com.moxs.gestionrepas;

public class RecetteTestManuel {

    public static void main(String[] args) {

        // 1) Création d'une recette de base (sans ingrédients)
        Recette recette = new Recette(
                "Pâtes carbonara",
                20,
                TypeRecette.PLAT,   // adapte selon ton enum
                false,              // batchCookable
                true                // préférée
        );

        System.out.println("=== Étape 1 : recette après création (sans ingrédients) ===");
        System.out.println(recette);
        System.out.println();

        // 2) Création de quelques ingrédients
        Ingredient pates = new Ingredient("Pâtes", 200, "g", "2026-01-01");
        Ingredient lardons = new Ingredient("Lardons", 150, "g", "2025-06-01");
        Ingredient creme = new Ingredient("Crème fraîche", 20, "cl", "2025-03-01");
        Ingredient parmesan = new Ingredient("Parmesan", 50, "g", "2025-12-31");

        // 3) Ajout des ingrédients dans la recette
        recette.ajouterIngredient(pates);
        recette.ajouterIngredient(lardons);
        recette.ajouterIngredient(creme);
        recette.ajouterIngredient(parmesan);

        System.out.println("=== Étape 2 : après ajout des ingrédients ===");
        System.out.println(recette);
        System.out.println();

        // 4) Suppression d'un ingrédient
        recette.supprimerIngredient(parmesan);

        System.out.println("=== Étape 3 : après suppression du parmesan ===");
        System.out.println(recette);
        System.out.println();

        // 5) Incrément du nombre de fois utilisée
        recette.addNombreDeFoisUtilisee();
        recette.addNombreDeFoisUtilisee();

        System.out.println("=== Étape 4 : après avoir utilisé la recette 2 fois ===");
        System.out.println(recette);
        System.out.println();

        // 6) Test visuel du Set : tentative de doublon
        System.out.println("=== Étape 5 : tentative d'ajout d'un ingrédient en doublon ===");
        Ingredient patesEnDoublon = new Ingredient("PÂTES", 500, "g", "2027-01-01");
        recette.ajouterIngredient(patesEnDoublon); // ne devrait pas créer de doublon si equals/hashCode sont OK
        System.out.println(recette);
        System.out.println();

        // 7) Test manuel de la copie défensive
        System.out.println("=== Étape 6 : test de la copie défensive sur getIngredients() ===");
        System.out.println("Taille du Set avant clear() externe : " + recette.getIngredients().size());

        var copie = recette.getIngredients();
        copie.clear(); // on vide la COPIE, pas le Set interne

        System.out.println("Taille du Set interne après clear() sur la copie : "
                + recette.getIngredients().size());
        System.out.println("Si la taille est restée > 0, la copie défensive fonctionne.");
    }
}
