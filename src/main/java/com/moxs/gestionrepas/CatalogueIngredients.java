package com.moxs.gestionrepas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogueIngredients {

    // Liste d'ingrédients "de base" : pas de quantité, pas de DLUO
    private static final List<String> NOMS_INGREDIENTS = new ArrayList<>();

    static {
        // Tu complèteras / modifieras comme tu veux
        NOMS_INGREDIENTS.add("Tomate");
        NOMS_INGREDIENTS.add("Mozzarella");
        NOMS_INGREDIENTS.add("Basilic");
        NOMS_INGREDIENTS.add("Pain");
        NOMS_INGREDIENTS.add("Beurre");
        NOMS_INGREDIENTS.add("Œuf");
        NOMS_INGREDIENTS.add("Poulet");
        NOMS_INGREDIENTS.add("Riz");
        NOMS_INGREDIENTS.add("Pâtes");
        NOMS_INGREDIENTS.add("Crème fraîche");
        NOMS_INGREDIENTS.add("Champignon");
        NOMS_INGREDIENTS.add("Fromage râpé");
        NOMS_INGREDIENTS.add("Farine");
        NOMS_INGREDIENTS.add("Sucre");
        NOMS_INGREDIENTS.add("Chocolat noir");
        NOMS_INGREDIENTS.add("Lait");
        NOMS_INGREDIENTS.add("Vanille");
    }

    // Récupérer tous les noms d'ingrédients disponibles
    public static List<String> getTousLesNoms() {
        return Collections.unmodifiableList(NOMS_INGREDIENTS);
    }

    // Vérifier si un nom existe dans le catalogue
    public static boolean existe(String nom) {
        if (nom == null) return false;
        for (String n : NOMS_INGREDIENTS) {
            if (n.equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Fabrique un Ingredient "concret" à partir du catalogue,
     * en lui ajoutant une quantité, une unité et une date limite.
     */
    public static Ingredient creerIngredient(String nom, int quantite, String unite, String dateLimite) {
        if (!existe(nom)) {
            throw new IllegalArgumentException("Ingrédient inconnu dans le catalogue : " + nom);
        }
        return new Ingredient(nom, quantite, unite, dateLimite);
    }
}
