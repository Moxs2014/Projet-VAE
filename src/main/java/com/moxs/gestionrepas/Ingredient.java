package com.moxs.gestionrepas;

import java.util.Objects;

public class Ingredient {
    private String nom;
    private int quantite;
    private String unite;
    private String dateLimite;

    public Ingredient( String nom, int quantite, String unite, String dateLimite)  {
        this.nom = nom;
        this.quantite = quantite;
        this.unite = unite;
        this.dateLimite = dateLimite;
    }

    // Getters et setters (facultatifs pour l'instant)
    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getDateLimite() {
        return dateLimite;
    }

    public String unite() {
        return unite;
    }

    // equals() : définit quand deux ingrédients sont considérés égaux
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                         // Même objet en mémoire
        if (!(o instanceof Ingredient)) return false;        // Pas un Ingredient → pas égal
        Ingredient that = (Ingredient) o;                   // Cast vers Ingredient
        return this.nom != null && this.nom.equalsIgnoreCase(that.nom);          // Comparaison logique : nom identique (sans casse)
    }

    // hashCode() : doit être cohérent avec equals()
    @Override
    public int hashCode() {
        return Objects.hash(nom.toLowerCase());
    }

    // toString() : pour un affichage lisible dans la console
    @Override
    public String toString() {
        return nom + " : " + quantite + " " + unite + " (DLUO : " + dateLimite + ")";
    }
}
