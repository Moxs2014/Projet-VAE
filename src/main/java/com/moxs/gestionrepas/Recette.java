package com.moxs.gestionrepas;

import java.util.Set;
import java.util.HashSet;
// import java.util.Objects; Pour plus tard

public class Recette {
    private String nom;
    private Set<Ingredient> ingredients;
    private int tempsPreparation;
    private int nombreDeFoisUtilisee;
    private TypeRecette type;
    private boolean preferee;
    private boolean batchCookable; 


    public Recette(String nom, int tempsPreparation, TypeRecette type, boolean batchCookable, boolean preferee) {
        this.nom = nom;
        this.type = type;
        this.tempsPreparation = tempsPreparation;
        this.nombreDeFoisUtilisee = 0;
        this.ingredients = new HashSet<>();
        this.preferee = preferee;
        this.batchCookable = batchCookable;
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

    public int addNombreDeFoisUtilisee() {
        return ++ nombreDeFoisUtilisee;
    }

    public String getType() {
        return type.toString();
    }   
    
    public TypeRecette getTypeRecette() {
        return type;
    }


    public void ajouterIngredient(Ingredient ingredient) {
            if (ingredient != null) {
        ingredients.add(ingredient);
        }
    }

    public void supprimerIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }  
    
    public boolean isBatchCookable() {
        return batchCookable;
    }

    public String getBatchCookableString() {
        return batchCookable ? "Yes" : "No";
    }

    public void setPreferee(boolean preferee) {
        this.preferee = preferee;
    }

    public boolean isPreferee() {
        return preferee;
    }

    public String getPrefereeToString() {
        return preferee ? "Yes" : "No";
    }

    public void setBatchCookable(boolean preferee) {
        this.preferee = preferee;
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
        sb.append("Batchcookable : ").append(getBatchCookableString()).append("\n");
        sb.append("Préférée : ").append(getPrefereeToString()).append("\n");
        sb.append("Ingrédients :\n");

        for (Ingredient ing : ingredients) {
            sb.append(" - ").append(ing).append("\n");
        }

        sb.append("Utilisée ").append(nombreDeFoisUtilisee).append(" fois\n");

        return sb.toString();
    }

}