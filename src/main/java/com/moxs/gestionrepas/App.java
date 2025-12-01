package com.moxs.gestionrepas;


public class App {
public static void main(String[] args) {

        // Création des ingrédients
        Ingredient pommes = new Ingredient("Pommes", 3, "pièces", "2025-11-30");
        Ingredient farine = new Ingredient("Farine", 200, "g", "2026-01-01");
        Ingredient beurre = new Ingredient("Beurre", 100, "g", "2025-12-10");

        // Création de la recette
        Recette tarte = new Recette("Tarte aux pommes", 45);

        // Ajout des ingrédients
        tarte.ajouterIngredient(pommes);
        tarte.ajouterIngredient(farine);
        tarte.ajouterIngredient(beurre);
        tarte.addNombreDeFoisUtilisee();

        // Affichage final
        System.out.println(tarte.toString());

        }
}