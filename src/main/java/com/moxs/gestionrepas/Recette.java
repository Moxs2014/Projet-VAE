package com.moxs.gestionrepas;

import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

public class Recette {
    private String nom;
    private Set<Ingredient> ingredients;
    private int tempsPreparation;
    private int nombreDeFoisUtilisee;


    public Recette(String nom, int tempsPreparation, int nombreDeFoisUtilisee) {
        this.nom = nom;
        this.tempsPreparation = tempsPreparation;
        this.nombreDeFoisUtilisee = nombreDeFoisUtilisee;
        this.ingredients = new HashSet<>();
    }
    
    // Getters et setters (facultatifs pour l'instant)
    public String getNom() {
        return nom;
    }

    public Set<Ingredient> getIngredients() {
        return new HashSet<>(ingredients);
    }

    public int getTempsPreparation() {
        return tempsPreparation;
    }

    public int getNombreDeFoisUtilisee() {
        return nombreDeFoisUtilisee;
    }

    public void ajouterIngredient(Ingredient ingredient) {
            if (ingredient != null) {
        ingredients.add(ingredient);
        }
    }

    public void supprimerIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }   

    // equals() : définit quand deux recettes sont considérés égaux
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                         // Même objet en mémoire
        if (!(o instanceof Recette)) return false;        // Pas un Recette → pas égal
        Recette that = (Recette) o;                   // Cast vers Recette
        return this.nom != null && this.nom.equalsIgnoreCase(that.nom);         // Comparaison logique : nom identique (sans casse)
    }

    // hashCode() : doit être cohérent avec equals()
    @Override
    public int hashCode() {
        return nom == null ? 0 : nom.toLowerCase().hashCode();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Recette : ").append(nom).append(" ===\n");
        sb.append("Temps de préparation : ").append(tempsPreparation).append(" min\n");
        sb.append("Ingrédients :\n");

        for (Ingredient ing : ingredients) {
            sb.append(" - ").append(ing).append("\n");
        }

        sb.append("Utilisée ").append(nombreDeFoisUtilisee).append(" fois\n");

        return sb.toString();
    }

}